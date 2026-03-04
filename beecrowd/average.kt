fun main(){
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    println("MEDIA = ${"%.5f".format(((a*3.5)+(b*7.5))/11)}")
}