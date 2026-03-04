fun main(){
    print("Enter a number of n: ")
    val n = readLine()!!.toInt()
    if(n<0) println("$n is Negative number")
    else if(n>0) println("$n is positive number")
    else println("the number is zero $n")


}
