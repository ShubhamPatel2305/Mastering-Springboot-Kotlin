package Day_1_exercises

fun main() {
    println(multiply(6, 7))
    println(isPalindrome("Level"))

    val sum = applyOperation(10, 5) { x, y -> x + y }
    val difference = applyOperation(10, 5) { x, y -> x - y }
    val product = applyOperation(10, 5) { x, y -> x * y }

    println("Sum: $sum")         // Output: Sum: 15
    println("Difference: $difference") // Output: Difference: 5
    println("Product: $product")     // Output: Product: 50
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun isPalindrome(a: String) : Boolean{
    //ignore case and check
    var cleaned=a.toLowerCase().replace("\\s".toRegex(), "")
    return cleaned==cleaned.reversed()
}

fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}
