fun main() {
    print("Enter your first number : ")
    val a = readln().toIntOrNull()
    print("Enter your second number : ")
    val b = readln().toIntOrNull()
    print("Enter your third number : ")
    val c = readln().toIntOrNull()



    if (a == null || b == null || c == null) {
        println("unvalid input")
        return


    } else {
        if (a == b && b == c) println("a b c are equal")
        else if (a == b && a > c) println("A & B same , largest number is $a")
        else if (a == c && a > b) println("A & c same , largest number is $a")
        else if (b == c && b > a) println("A & c same , largest number is $b")
        else if (a == b && c > a) println("A & B same , largest number is $c")
        else if (a == c && b > a) println("A & c same , largest number is $b")
        else if (b == c && a > b) println("A & c same , largest number is $a")
        else if (a > b && a > c) println("A is largest number")
        else if (b > a && b > c) println("B is largest number")
        else if (c > a && c > b) println("C is largest number")
    }


}
