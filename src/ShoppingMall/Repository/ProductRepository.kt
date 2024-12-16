package ShoppingMall.Repository

import java.util.UUID

data class Product(
    val uuid: UUID = UUID.randomUUID(),
    var name: String,
    var price: Double,
    var quantityAvailable: Int
)

class ProductRepository {
    private val products = mutableListOf<Product>()

    fun addProduct(product: Product): Product {
        products.add(product)
        return product
    }

    fun getAllProducts(): List<Product> = products.toList()

    fun getProductById(uuid: UUID): Product? =
        products.find { it.uuid == uuid }

    fun updateProduct(product: Product) {
        val index = products.indexOfFirst { it.uuid == product.uuid }
        if (index != -1) {
            products[index] = product
        }
    }

    fun deleteProduct(uuid: UUID) {
        products.removeIf { it.uuid == uuid }
    }
}