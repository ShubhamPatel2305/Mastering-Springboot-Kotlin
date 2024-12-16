package ShoppingMall.Services

import ShoppingMall.Repository.Customer
import ShoppingMall.Repository.CustomerRepository
import java.util.UUID

class CustomerService(private val customerRepository: CustomerRepository) {
    fun createCustomer(name: String): Customer {
        val customer = Customer(name = name)
        return customerRepository.addCustomer(customer)
    }

    fun getAllCustomers(): List<Customer> = customerRepository.getAllCustomers()

    fun updateCustomer(uuid: UUID, name: String): Customer? {
        val existingCustomer = customerRepository.getCustomerById(uuid)
        existingCustomer?.let {
            val updatedCustomer = it.copy(name = name)
            customerRepository.updateCustomer(updatedCustomer)
            return updatedCustomer
        }
        return null
    }

    fun deleteCustomer(uuid: UUID) {
        customerRepository.deleteCustomer(uuid)
    }

    fun getOrCreateCustomerByName(name: String): Customer {
        return customerRepository.getCustomerByName(name)
            ?: createCustomer(name)
    }
}