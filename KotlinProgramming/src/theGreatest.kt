fun main(){
    val (a,b,c) = readLine()!!.split(" ").map {it.toInt()}
    if(a>=b && a>=c){
        println("$a eh o maior")
    }
    else if(b>=a && b>=c){
        println("$b eh o maior")
    }
    else println("$c eh o maior")
}