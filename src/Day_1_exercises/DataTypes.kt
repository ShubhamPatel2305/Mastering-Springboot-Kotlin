package Day_1_exercises

fun main(){
    var a="Bath"
    println(a)
    a="Sleep"
    println(a)
    a="Workout"
    println(a)
    //no error till here

    val b="Bath"
    println(b)
    // b="sing"   error val cannot be re assigned
    // println(b)

    // val c error : must be assigned a value while decalring

    var d:Int=10
    println("d is $d and its type is ${d::class.simpleName}")


    var variable: Any = 42 // Initially an integer
    println("Value: $variable, Type: ${if (variable is Int) "Int" else "Unknown"}")

    variable = "Kotlin is fun!" // Reassigned as a string
    println("Value: $variable, Type: ${if (variable is String) "String" else "Unknown"}")

    if (variable is String) {
        println("The length of the string is: ${variable.length}")
    }
}