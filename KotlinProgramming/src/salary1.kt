fun main(){
    val  a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toDouble()

    println("NUMBER = $a")
    println("SALARY = U$ ${"%.2f".format(b*c)}")
}