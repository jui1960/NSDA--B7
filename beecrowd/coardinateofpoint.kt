import java.util.*

fun main(args: Array<String>) {

    val (x1, y1) = readLine()!!.split(" ").map { it.toDouble() }
    if (x1 == 0.0 && y1 == 0.0) println("Origem")
    else if (x1 == 0.0) println("Eixo Y")
    else if (y1 == 0.0) println("Eixo X")
    else if (x1 > 0 && y1 > 0) println("Q1")
    else if (x1 < 0 && y1 > 0) println("Q2")
    else if (x1 < 0 && y1 < 0) println("Q3")
    else println("Q4")

}