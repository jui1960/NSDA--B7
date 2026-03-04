fun main() {
    val a = readLine()!!.toInt()
    for(i in 1..10){
        var ans = i*a
        println("$i x $a = $ans")
    }
}