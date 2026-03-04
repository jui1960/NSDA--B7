import kotlin.math.*
fun main(){
    val (x1,y1) = readLine()!!.split(" ").map { it.toDouble() }
    val (x2,y2) = readLine()!!.split(" ").map{ it.toDouble() }
    val ans = (x2-x1)*(x2-x1)
    val ans1 = (y2-y1)*(y2-y1)
    println("${"%.4f".format(sqrt(ans+ans1))}")
}