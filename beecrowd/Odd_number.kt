import java.util.*

fun main(args: Array<String>) {

 val n = readLine()!!.toInt()
    for (i in 1..n) {
        if(i%2 != 0){
            println(i)
        }
    }
}