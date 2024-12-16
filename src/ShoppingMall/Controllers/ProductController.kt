package ShoppingMall.Controllers

import ShoppingMall.Repository.Product
import ShoppingMall.Services.ProductService
import java.util.UUID

class ProductController(private val productService: ProductService) {
    fun createProduct(name: String, price: Double, quantity: Int): Product {
        val product = productService.createProduct(name, price, quantity)
        println("Created Product: $product")
        return product
    }

    fun listProducts() {
        val products = productService.getAllProducts()
        println("Product List:")
        products.forEach { println(it) }
    }

    fun updateProduct(uuid: UUID, name: String? = null, price: Double? = null, quantity: Int? = null) {
        val updatedProduct = productService.updateProduct(uuid, name, price, quantity)
        updatedProduct?.let { println("Updated Product: $it") }
    }

    fun deleteProduct(uuid: UUID) {
        productService.deleteProduct(uuid)
        println("Deleted Product with UUID: $uuid")
    }
}