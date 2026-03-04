fun main(){
    val a = readLine()!!.toInt()
    val b = readLine()!!.toDouble()
    println("${"%.3f".format(a/b)} km/l")
}