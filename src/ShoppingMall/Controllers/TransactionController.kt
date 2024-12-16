package ShoppingMall.Controllers

import ShoppingMall.Services.TransactionService
import java.util.UUID

class TransactionController(private val transactionService: TransactionService) {
    fun processPurchase(customerId: UUID, purchases: List<Pair<UUID, Int>>) {
        val transactions = transactionService.processPurchase(customerId, purchases)
        println("Transactions Processed:")
        transactions.forEach { println(it) }
        println("Total Transaction Amount: ${transactionService.getTotalTransactionAmount()}")
    }

    fun processPurchaseForGuest(customerName: String, purchases: List<Pair<UUID, Int>>) {
        val transactions = transactionService.processPurchaseForGuest(customerName, purchases)
        println("Guest Transactions Processed:")
        transactions.forEach { println(it) }
        println("Total Transaction Amount: ${transactionService.getTotalTransactionAmount()}")
    }
}