package ShoppingMall.Services

import ShoppingMall.Repository.Product
import ShoppingMall.Repository.ProductRepository
import java.util.UUID

class ProductService(private val productRepository: ProductRepository) {
    fun createProduct(name: String, price: Double, quantity: Int): Product {
        val product = Product(name = name, price = price, quantityAvailable = quantity)
        return productRepository.addProduct(product)
    }

    fun getAllProducts(): List<Product> = productRepository.getAllProducts()

    fun updateProduct(uuid: UUID, name: String? = null, price: Double? = null, quantity: Int? = null): Product? {
        val existingProduct = productRepository.getProductById(uuid)
        existingProduct?.let {
            val updatedProduct = it.copy(
                name = name ?: it.name,
                price = price ?: it.price,
                quantityAvailable = quantity ?: it.quantityAvailable
            )
            productRepository.updateProduct(updatedProduct)
            return updatedProduct
        }
        return null
    }

    fun deleteProduct(uuid: UUID) {
        productRepository.deleteProduct(uuid)
    }
}