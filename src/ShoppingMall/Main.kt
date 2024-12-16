package ShoppingMall


import ShoppingMall.Controllers.*
import ShoppingMall.Repository.*
import ShoppingMall.Services.*
import java.util.UUID

fun main() {
    val productRepository = ProductRepository()
    val customerRepository = CustomerRepository()
    val transactionRepository = TransactionRepository()

    val productService = ProductService(productRepository)
    val customerService = CustomerService(customerRepository)
    val transactionService = TransactionService(
        productRepository,
        customerRepository,
        transactionRepository
    )

    val productController = ProductController(productService)
    val customerController = CustomerController(customerService)
    val transactionController = TransactionController(transactionService)

    println("1. Creating 5 Products:")
    val laptop = productController.createProduct("Laptop", 1000.0, 10)
    val smartphone = productController.createProduct("Smartphone", 500.0, 20)
    val headphones = productController.createProduct("Headphones", 100.0, 30)
    val tablet = productController.createProduct("Tablet", 300.0, 15)
    val smartwatch = productController.createProduct("Smartwatch", 200.0, 25)
    productController.listProducts()

    println("\n2. Creating 2 Customers:")
    val johnDoe = customerController.createCustomer("John Doe")
    val janeSmith = customerController.createCustomer("Jane Smith")
    customerController.listCustomers()

    println("\n3. Editing Products and Customers:")
    productController.updateProduct(laptop.uuid, name = "Gaming Laptop", price = 1200.0)
    customerController.updateCustomer(johnDoe.uuid, name = "John Updated")

    println("\nUpdated Products:")
    productController.listProducts()
    println("\nUpdated Customers:")
    customerController.listCustomers()

    println("\n4. Deleting a Product and a Customer:")
    productController.deleteProduct(smartwatch.uuid)
    customerController.deleteCustomer(janeSmith.uuid)

    println("\nUpdated Products:")
    productController.listProducts()
    println("\nUpdated Customers:")
    customerController.listCustomers()

    println("\n5. Processing Purchase for Registered Customer:")
    val purchaseList = listOf(
        Pair(laptop.uuid, 2),
        Pair(smartphone.uuid, 1),
        Pair(headphones.uuid, 3)
    )
    transactionController.processPurchase(johnDoe.uuid, purchaseList)

    println("\n6. Processing Purchase for Guest Customer:")
    val guestPurchaseList = listOf(
        Pair(tablet.uuid, 1),
        Pair(smartphone.uuid, 2)
    )
    transactionController.processPurchaseForGuest("Guest User", guestPurchaseList)
}
