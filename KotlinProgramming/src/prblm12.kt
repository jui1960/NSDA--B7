fun main() {
    print("Enter your number a : ")
    val a = readLine()!!.toInt()

    print("Enter your number b : ")
    val b = readLine()!!.toInt()

    print("Enter your number c : ")
    val c = readLine()!!.toInt()

    if(a+b+c == 180) println("Valid Triangle")
    else println("Invalid triangle")

}
