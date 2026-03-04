fun main() {
    val n = readLine()!!.toInt()
    for(i in 2..n step 2){
        val ans = i*i
        println("$i^2 = $ans")
    }
}
