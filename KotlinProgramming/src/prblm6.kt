fun main() {
    print("Enter your number : ")
    val score = readLine()!!.toInt()

    if (score >= 60 && score<70) println("D")
    else if (score >= 70 && score<80 ) println("C")
    else if (score >= 80 && score<90) println("B")
    else if (score >= 90) println("A")
    else println("F")
}
