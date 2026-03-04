import java.util.*

fun main(args: Array<String>) {

    val n = readLine()!!.toInt()
    for (i in 1..n) {
        val a = readLine()!!.toInt()
        if(a==0){
            println("NULL")
        }
        else if(a>0 && a%2==0){
            println("EVEN POSITIVE")
        }
        else if(a<0 && a%2==0){
            println("EVEN NEGATIVE")
        }
        else if(a<0 && a%2!=0){
            println("ODD NEGATIVE")
        }
        else{
            println("ODD POSITIVE")
        }
    }

}