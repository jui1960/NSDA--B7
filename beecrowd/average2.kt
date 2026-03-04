fun main(){
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()
    println("MEDIA = ${"%.1f".format(((a*2)+(b*3)+(c*5))/10)}")
}