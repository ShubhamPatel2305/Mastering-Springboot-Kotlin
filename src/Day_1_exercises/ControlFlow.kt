package Day_1_exercises

fun main() {
    println(compareThreeNumbers(12, 25, 9))
    println(isLeapYear(2024))
    println(assignGrade(85))
    println(checkNumberSign(-5))
    println(evenOddAndRange(24))
    println(isEligibleToVote(16))
    println(getSeason(3))
    println(checkOddEvenZero(0))
    println(weekdayOrWeekend("Saturday"))
    println(checkCharacterType('A'))
    printTable(3)
    printPrimesBetween1And50()
    println(calculateFactorial(5))
    printSquaresFrom1To10()
    println(checkNumberInRange(15, 10, 100))
}

fun compareThreeNumbers(a: Int, b: Int, c: Int): Int = if (a > b && a > c) a else if (b > c) b else c

fun isLeapYear(year: Int): String = if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) "Leap Year" else "Not a Leap Year"

fun assignGrade(score: Int): String = when {
    score >= 90 -> "A"
    score in 80..89 -> "B"
    score in 70..79 -> "C"
    score in 60..69 -> "D"
    else -> "F"
}

fun checkNumberSign(num: Int): String = if (num > 0) "Positive" else if (num < 0) "Negative" else "Zero"

fun evenOddAndRange(num: Int): String = if (num % 2 == 0 && num in 1..100) "Even and within range" else if (num % 2 == 0) "Even and out of range" else if (num in 1..100) "Odd and within range" else "Odd and out of range"

fun isEligibleToVote(age: Int): String = if (age >= 18) "Eligible to vote" else "Not eligible to vote"

fun getSeason(month: Int): String = when (month) {
    12, 1, 2 -> "Winter"
    in 3..5 -> "Spring"
    in 6..8 -> "Summer"
    in 9..11 -> "Fall"
    else -> "Invalid month"
}

fun checkOddEvenZero(num: Int): String = when {
    num == 0 -> "Zero"
    num % 2 == 0 -> "Even"
    else -> "Odd"
}

fun weekdayOrWeekend(day: String): String = when (day.lowercase()) {
    "saturday", "sunday" -> "Weekend"
    "monday", "tuesday", "wednesday", "thursday", "friday" -> "Weekday"
    else -> "Invalid day"
}

fun checkCharacterType(ch: Char): String = when {
    ch.isDigit() -> "Digit"
    ch.lowercaseChar() in listOf('a', 'e', 'i', 'o', 'u') -> "Vowel"
    ch.isLetter() -> "Consonant"
    else -> "Special character"
}

fun printTable(n: Int) {
    for (i in 1..10) println("$n x $i = ${n * i}")
}

fun printPrimesBetween1And50() {
    for (num in 2..50) {
        if ((2 until num).none { num % it == 0 }) println(num)
    }
}

fun calculateFactorial(num: Int): Int {
    var factorial = 1
    var n = num
    while (n > 0) {
        factorial *= n
        n--
    }
    return factorial
}

fun printSquaresFrom1To10() {
    for (i in 1..10) println("$i^2 = ${i * i}")
}

fun checkNumberInRange(num: Int, start: Int, end: Int): String = if (num in start..end) "Within range" else "Out of range"
