package Day_1_exercises

fun main() {
    println(filterAndSquareNumbers(listOf(1, 2, 3, 6, 7)))
    println(findMaxAndMin(listOf(5, 3, 8, 2, 9)))
    println(processFruits(listOf("apple", "banana", "cherry")))
    println(shuffleNumbers(listOf(1, 2, 3, 4, 5)))
    println(squareList(listOf(1, 2, 3, 4)))
    println(stringsToLengths(listOf("apple", "banana", "cherry")))
    printEachString(listOf("apple", "banana", "cherry"))
    printSquaresUsingForEach(listOf(1, 2, 3, 4))
    println(filterOddNumbers(listOf(1, 2, 3, 4, 5)))
    println(filterStringsByLength(listOf("apple", "banana", "cherry", "kiwi")))
    println(sumUsingReduce(listOf(1, 2, 3, 4)))
    println(findMaxUsingReduce(listOf(3, 5, 7, 2)))
    println(flattenListOfIntegers(listOf(listOf(1, 2), listOf(3, 4), listOf(5))))
    println(flattenListOfStrings(listOf(listOf("apple", "banana"), listOf("cherry", "kiwi"))))
    println(zipToPairs(listOf(1, 2, 3), listOf("a", "b", "c")))
    println(zipToMap(listOf(1, 2, 3), listOf("apple", "banana", "cherry")))
    println(removeDuplicates(listOf(1, 2, 2, 3, 4, 4, 5)))
    println(removeDuplicateStrings(listOf("apple", "banana", "apple", "cherry")))
    println(findSetDifference(setOf(1, 2, 3), setOf(2, 3, 4)))
    println(isSubset(setOf(1, 2), setOf(1, 2, 3)))
    println(verifyRollNumber(setOf(101, 102, 103), 102))
    println(processCountryMap(mapOf("India" to "New Delhi", "USA" to "Washington", "Australia" to "Canberra")))
    println(totalPriceAbove500(mapOf("Book1" to 400, "Book2" to 600, "Book3" to 800)))
    println(filterNamesByLength(listOf("John", "Alexandra", "Kate", "Michael")))
    println(checkDivisibilityAndOddness(listOf(7, 15, 21, 2, 5)))
    println(mapNamesToLengths(listOf("John", "Kate", "Michael")))
    println(groupTransactionsByType(listOf("Deposit" to 100, "Withdrawal" to 50, "Deposit" to 200)))
    println(flatMapStudentScores(listOf(Student("A", listOf(90, 85)), Student("B", listOf(70, 80)))))
    println(partitionNames(listOf("Alice", "Bob", "Eve", "Oscar", "Charlie")))
    println(sortEmployeesByLength(listOf("John", "Alexandra", "Kate")))
    println(sortProductsByPrice(listOf(Product("A", 300), Product("B", 600), Product("C", 100))))
}

data class Student(val name: String, val scores: List<Int>)
data class Product(val name: String, val price: Int)

fun filterAndSquareNumbers(numbers: List<Int>): List<Int> = numbers.filter { it > 5 }.map { it * it }

fun findMaxAndMin(numbers: List<Int>): Pair<Int, Int> = Pair(numbers.maxOrNull() ?: 0, numbers.minOrNull() ?: 0)

fun processFruits(fruits: List<String>): Pair<List<String>, String?> {
    val upperCaseFruits = fruits.map { it.uppercase() }
    val longestFruit = fruits.maxByOrNull { it.length }
    return Pair(upperCaseFruits, longestFruit)
}

fun shuffleNumbers(numbers: List<Int>): List<Int> = numbers.shuffled()

fun squareList(numbers: List<Int>): List<Int> = numbers.map { it * it }

fun stringsToLengths(strings: List<String>): List<Int> = strings.map { it.length }

fun printEachString(strings: List<String>) = strings.forEach { println(it) }

fun printSquaresUsingForEach(numbers: List<Int>) = numbers.forEach { println(it * it) }

fun filterOddNumbers(numbers: List<Int>): List<Int> = numbers.filter { it % 2 == 0 }

fun filterStringsByLength(strings: List<String>): List<String> = strings.filter { it.length > 5 }

fun sumUsingReduce(numbers: List<Int>): Int = numbers.reduce { acc, num -> acc + num }

fun findMaxUsingReduce(numbers: List<Int>): Int = numbers.reduce { acc, num -> maxOf(acc, num) }

fun flattenListOfIntegers(listOfLists: List<List<Int>>): List<Int> = listOfLists.flatten()

fun flattenListOfStrings(listOfLists: List<List<String>>): List<String> = listOfLists.flatten()

fun zipToPairs(numbers: List<Int>, strings: List<String>): List<Pair<Int, String>> = numbers.zip(strings)

fun zipToMap(numbers: List<Int>, strings: List<String>): Map<Int, String> = numbers.zip(strings).toMap()

fun removeDuplicates(numbers: List<Int>): List<Int> = numbers.distinct()

fun removeDuplicateStrings(strings: List<String>): List<String> = strings.distinct()

fun findSetDifference(set1: Set<Int>, set2: Set<Int>): Set<Int> = set1.subtract(set2)

fun isSubset(set1: Set<Int>, set2: Set<Int>): Boolean = set1.subtract(set2).isEmpty()

fun verifyRollNumber(rollNumbers: Set<Int>, rollNumber: Int): Boolean = rollNumber in rollNumbers

fun processCountryMap(countries: Map<String, String>): Pair<List<String>, List<String>> {
    val sortedCountries = countries.keys.sorted()
    val capitalsStartingWithA = countries.values.filter { it.startsWith("A", ignoreCase = true) }
    return Pair(sortedCountries, capitalsStartingWithA)
}

fun totalPriceAbove500(books: Map<String, Int>): Int = books.filter { it.value > 500 }.values.sum()

fun filterNamesByLength(names: List<String>): List<String> = names.filter { it.length > 5 }

fun checkDivisibilityAndOddness(numbers: List<Int>): Pair<Boolean, Boolean> = Pair(
    numbers.any { it % 7 == 0 },
    numbers.all { it % 2 != 0 }
)

fun mapNamesToLengths(names: List<String>): Map<String, Int> = names.associateWith { it.length }

fun groupTransactionsByType(transactions: List<Pair<String, Int>>): Map<String, List<Pair<String, Int>>> = transactions.groupBy { it.first }

fun flatMapStudentScores(students: List<Student>): Double {
    val allScores = students.flatMap { it.scores }
    return allScores.average()
}

fun partitionNames(names: List<String>): Pair<List<String>, List<String>> = names.partition { it.first().lowercaseChar() in "aeiou" }

fun sortEmployeesByLength(employees: List<String>): List<String> = employees.sortedBy { it.length }

fun sortProductsByPrice(products: List<Product>): Pair<List<Product>, List<Product>> = Pair(
    products.sortedBy { it.price },
    products.sortedByDescending { it.price }
)
