fun main(){
    val (a, a1,b,b1) = readLine()!!.split(" ").map { it.toInt() }
    if(a==b && a1==b1)
    {
        println("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)")
    }
    else if(a<b && b1>a1 ){
        println("O JOGO DUROU ${b-a} HORA(S) E ${b1-a1} MINUTO(S)")
    }
    else {
        val ans = a1-b1
        println("O JOGO DUROU 0 HORA(S) E ${60-ans} MINUTO(S)")
    }
}