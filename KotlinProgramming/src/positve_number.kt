import java.util.*

fun main(args: Array<String>) {

    var cnt = 0
    for (i in 1..6 ){
        val a = readLine()!!.toDouble()

        if(a>0){
            cnt++;
        }
    }
    println("$cnt valores positivos")

}


//using filter
/*
import java.util.*

fun main(args: Array<String>) {


    val numbers = List(6) { readLine()!!.toDouble() }
    val positiveCount = numbers.filter { it > 0 }.size
    println("$positiveCount valores positivos")

}*/
