import java.util.*

fun main(args: Array<String>) {
    var a = 0
    var b = 0
    var c = 0
    while (true) {
        val num = readLine()!!.toInt()
        if (num == 4) {
            break
        }
        when {
            num == 1 -> a++
            num == 2 -> b++
            num == 3 -> c++
        }


    }
    println("MUITO OBRIGADO")

    println("Alcool: $a")
    println("Gasolina: $b")
    println("Diesel: $c")
}