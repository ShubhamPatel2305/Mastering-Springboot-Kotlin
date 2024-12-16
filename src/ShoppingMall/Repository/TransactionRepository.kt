package ShoppingMall.Repository

import java.util.UUID

data class Transaction(
    val uuid: UUID = UUID.randomUUID(),
    val productId: UUID,
    val customerId: UUID,
    val quantity: Int,
    val rate: Double,
    val total: Double
)

class TransactionRepository {
    private val transactions = mutableListOf<Transaction>()

    fun addTransaction(transaction: Transaction): Transaction {
        transactions.add(transaction)
        return transaction
    }

    fun getAllTransactions(): List<Transaction> = transactions.toList()

    fun getTransactionsByCustomerId(customerId: UUID): List<Transaction> =
        transactions.filter { it.customerId == customerId }
}