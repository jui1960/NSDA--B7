fun main() {
    print("Enter your number : ")
    val a = readLine()!!.toInt()
    println(ans(a))

}
val ans = {a: Int ->
    if(a>=0) "Positive"
    else "Negative"
}