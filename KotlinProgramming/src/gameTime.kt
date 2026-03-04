fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    if (a == b) println("O JOGO DUROU 24 HORA(S)")
    else if (a > b) {
        val ans = 24 - a
        println("O JOGO DUROU ${ans + b} HORA(S)")
    } else {
        println("O JOGO DUROU ${b - a} HORA(S)")
    }

}