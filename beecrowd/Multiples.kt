import java.util.*

fun main(args: Array<String>) {

  val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    if (b % a == 0 || a%b == 0) println("Sao Multiplos")
    else println("Nao sao Multiplos")
}