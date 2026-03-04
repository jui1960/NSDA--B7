fun main() {
    var cnt = 0
    var summm = 0.0
    for (i in 1..6){
        val a = readLine()!!.toDouble()
        if(a>0){
            cnt++
            summm += a
        }
    }
    println("$cnt valores positivos")
    println("%.1f".format(summm/cnt))
}