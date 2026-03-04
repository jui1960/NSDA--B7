fun main() {
//    val day = 4
//    val result = when (day){
//        1 -> "Saturday"
//        2 -> "Sunday"
//        3 -> "Monday"
//        4 -> "Tuesday"
//        6 -> "Wednesday"
//        7 -> "Thursday"
//        8 -> "Friday"
//        else -> "Invalid Input"
//    }
//    println(result)
//
//

    print("Enter your value : ")
    val a = readLine()!!.toDouble()

    print("Enter your value : ")
    val b = readLine()!!.toDouble()

    print("Enter your operator(+,-,*,/) : ")
    val operator = readLine()!!

    val res = when (operator) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> if (b != 0.0) {
            a / b
            return
        }
        else{
            println("can not divide by zero")
        }

        else -> println("invalid operator")

    }
    println(res)

}

