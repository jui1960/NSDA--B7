fun main(){
    val a = readLine()!!.toDouble()
    if(a<0 || a>100) println("Fora de intervalo")
    else if(a>=0 && a<=25) println("Intervalo [0,25]")
    else if(a>25 && a<=50) println("Intervalo (25,50]")
    else println("Intervalo (75,100]")
}