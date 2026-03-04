fun main() {
    print("Enter your number of a : ")
    val a = readln().toInt()
    print("Enter your number of a : ")
    val b = readln().toInt()

    val isequal = (a == b)
    println("$a == $b both equal: $isequal")
    val isnotequal = (a != b)
    println("$a != $b notequal: $isnotequal")
    val Greater = (a > b)
    println("$a > $b Greater than : $Greater")
    val less = (a < b)
    println("$a < $b Less than : $less")
    val greaterEqual = (a >= b)
    println("$a >= $b Greater than or equal: $greaterEqual")
    val lessEqual = (a <= b)
    println("$a <= $b Less than or equal: $lessEqual")
}