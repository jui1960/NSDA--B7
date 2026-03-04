fun main() {

    print("Enter your 1st number : ")
    val a = readLine()!!.toInt()
    print("Enter your 2nd number : ")
    val b = readLine()!!.toInt()

    val maxx = lambdaa(a, b)
    println("Biggest number $maxx")
}

val lambdaa = { a: Int, b: Int ->
    if (a > b) a else b
}