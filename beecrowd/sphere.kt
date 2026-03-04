fun main(args: Array<String>){
    val r = readLine()!!.toDouble()
    val pi = 3.14159
    val ans = (4/3.0)*(pi*(r*r*r))
    println("VOLUME = ${"%.3f".format(ans)}")
}