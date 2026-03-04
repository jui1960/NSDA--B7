fun main() {
    print("Enter your number : ")
    val number = readLine()!!.toDouble()
    if(number>=0 && number<=9) println("1 digit")
    else if(number>=10 && number<=99) println("2 digits")
    else if(number>=100 && number<=999) println("3 digits")
    else println("More than 3 digits")
}
