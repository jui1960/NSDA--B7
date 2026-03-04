fun main() {
    val add = { a: Int, b: Int -> a + b }
    val sub = { a: Int, b: Int -> a - b }

    print("Enter your 1st number : ")
    val number1 = readLine()!!.toInt()
    print("Enter your 2nd number : ")
    val number2 = readLine()!!.toInt()
    println(calculate(number1, number2, add))
    println(calculate(number1, number2, sub))

}

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)

}

