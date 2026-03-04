import java.util.*

fun main(args:Array<String>) {

    val n = readLine()!!.toInt()
    val ar = readLine()!!.split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    var mn = ar[0]
    var indx = 0
    for (i in 1 until n) {
        if (ar[i] < mn) {
            mn = ar[i]
            indx = i

        }

    }
    println("Menor valor: $mn")
    println("Posicao: $indx")
}

