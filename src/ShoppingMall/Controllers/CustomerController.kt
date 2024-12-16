package ShoppingMall.Controllers

import ShoppingMall.Repository.Customer
import ShoppingMall.Services.CustomerService
import java.util.UUID

class CustomerController(private val customerService: CustomerService) {
    fun createCustomer(name: String): Customer {
        val customer = customerService.createCustomer(name)
        println("Created Customer: $customer")
        return customer
    }

    fun listCustomers() {
        val customers = customerService.getAllCustomers()
        println("Customer List:")
        customers.forEach { println(it) }
    }

    fun updateCustomer(uuid: UUID, name: String) {
        val updatedCustomer = customerService.updateCustomer(uuid, name)
        updatedCustomer?.let { println("Updated Customer: $it") }
    }

    fun deleteCustomer(uuid: UUID) {
        customerService.deleteCustomer(uuid)
        println("Deleted Customer with UUID: $uuid")
    }
}