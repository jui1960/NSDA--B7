fun main() {
    print("Enter your age : ")
    val age = readLine()!!.toInt()
    if (age >= 0 && age <= 12) println("Child")
    else if (age >= 13 && age <= 19) println("Teenager")
    else if (age >= 20 && age <= 59) println("Adult")
    else if (age >= 60) println("Senior")
    else println("Invalid age")

}
