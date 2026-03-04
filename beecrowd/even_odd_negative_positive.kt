

import java.util.*

fun main(args: Array<String>) {

    val numbers = mutableListOf<Int>()

    for (i in 1..5) {
        numbers.add(readLine()!!.toInt())
    }

    val even = numbers.filter { it % 2 == 0 }.size
    val odd = numbers.filter { it % 2 != 0 }.size
    val positive = numbers.filter { it > 0 }.size
    val negative = numbers.filter { it < 0 }.size

    println("$even valor(es) par(es)")
    println("$odd valor(es) impar(es)")
    println("$positive valor(es) positivo(s)")
    println("$negative valor(es) negativo(s)")

	
}