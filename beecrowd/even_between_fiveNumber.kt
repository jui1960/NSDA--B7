fun main() {
    var cnt = 0
    for (i in 1..5) {
        val a = readLine()!!.toInt()

        if(a%2==0) cnt++
    }
    println("$cnt valores pares")
}