import java.util.*

fun main(args: Array<String>) {


    val (a,b,c) = readLine()!!.split(" ").map { it.toInt() }

    val sort =  listOf(a, b, c).sorted()
    for (num in sort) {
        println(num)
    }
    println()
    println(a)
    println(b)
    println(c)

}