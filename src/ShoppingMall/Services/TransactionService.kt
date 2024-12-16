package ShoppingMall.Services


import ShoppingMall.Repository.*
import java.util.UUID

class TransactionService(
    private val productRepository: ProductRepository,
    private val customerRepository: CustomerRepository,
    private val transactionRepository: TransactionRepository
) {
    fun processPurchase(
        customerId: UUID,
        purchases: List<Pair<UUID, Int>>
    ): List<Transaction> {
        val customer = customerRepository.getCustomerById(customerId)
            ?: throw IllegalArgumentException("Customer not found")

        val transactions = purchases.map { (productId, quantity) ->
            val product = productRepository.getProductById(productId)
                ?: throw IllegalArgumentException("Product not found")

            // Validate quantity
            if (product.quantityAvailable < quantity) {
                throw IllegalArgumentException("Insufficient stock for product ${product.name}")
            }

            val updatedProduct = product.copy(quantityAvailable = product.quantityAvailable - quantity)
            productRepository.updateProduct(updatedProduct)

            val total = product.price * quantity
            val transaction = Transaction(
                productId = productId,
                customerId = customerId,
                quantity = quantity,
                rate = product.price,
                total = total
            )

            transactionRepository.addTransaction(transaction)
        }

        return transactions
    }

    fun processPurchaseForGuest(
        customerName: String,
        purchases: List<Pair<UUID, Int>>
    ): List<Transaction> {
        val customer = customerRepository.getCustomerByName(customerName)
            ?: customerRepository.addCustomer(Customer(name = customerName))

        return processPurchase(customer.uuid, purchases)
    }

    fun getTotalTransactionAmount(): Double {
        return transactionRepository.getAllTransactions().sumOf { it.total }
    }
}