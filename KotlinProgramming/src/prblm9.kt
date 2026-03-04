fun main() {
    print("Enter your temp value: ")
    val temp = readLine()!!.toDouble()
    if (temp <= 0) println("Freezing")
    else if (temp >= 0 && temp <= 15) println("Cold")
    else if (temp >= 16 && temp <= 30) println("Warm")
    else println("Hot")
}
