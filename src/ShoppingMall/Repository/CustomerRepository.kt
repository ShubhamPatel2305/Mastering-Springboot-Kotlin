package ShoppingMall.Repository

import java.util.UUID

data class Customer(
    val uuid: UUID = UUID.randomUUID(),
    var name: String
)

class CustomerRepository {
    private val customers = mutableListOf<Customer>()

    fun addCustomer(customer: Customer): Customer {
        customers.add(customer)
        return customer
    }

    fun getAllCustomers(): List<Customer> = customers.toList()

    fun getCustomerById(uuid: UUID): Customer? =
        customers.find { it.uuid == uuid }

    fun getCustomerByName(name: String): Customer? =
        customers.find { it.name.equals(name, ignoreCase = true) }

    fun updateCustomer(customer: Customer) {
        val index = customers.indexOfFirst { it.uuid == customer.uuid }
        if (index != -1) {
            customers[index] = customer
        }
    }

    fun deleteCustomer(uuid: UUID) {
        customers.removeIf { it.uuid == uuid }
    }
}