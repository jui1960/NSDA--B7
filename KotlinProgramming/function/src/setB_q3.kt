fun main(){

    println("Enter your number : ")
    val number = readLine()!!.toInt()
    val ans = bool(number)
    println(ans)
}
fun bool(a: Int): Boolean{
    if(a%2==0) return true
    else return false
}