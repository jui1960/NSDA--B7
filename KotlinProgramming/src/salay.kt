fun main(args: Array<String>){
    val name = readLine()!!
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    println("TOTAL = R$ ${"%.2f".format((b*0.15)+a)}")

}
