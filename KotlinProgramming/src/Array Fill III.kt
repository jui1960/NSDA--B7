import java.util.*

fun main(args: Array<String>) {
    var a = readLine()!!.toDouble()
    for(i in 0 until 100){
        println("N[$i] = %.4f".format(a))
        a = a/2.0
    }

}