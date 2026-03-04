import java.util.*
import kotlin.math.*
fun main(args: Array<String>) {
    var num = readLine()!!.toInt()
    for (i in 1..num) {

        for (j in 1..3) {
            val ans = i.toDouble().pow(j).toInt()
            if(j<3)  print("$ans ")
            else print(ans)
        }

        println()
    }
}