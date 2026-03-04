fun main(){
    print("Enter a number of a: ")
    val a = readLine()!!.toInt()
    print("Enter a number of b: ")
    val b = readLine()!!.toInt()

    if(a==b) println("a and b are equal")
    else if(a>b) println("$a a is largest number")
    else println("$b b is largest number")

}
