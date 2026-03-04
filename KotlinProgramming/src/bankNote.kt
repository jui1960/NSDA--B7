import java.util.*

fun main(args: Array<String>) {
    var a = readLine()!!.toInt()
    println(a)
    println("${a/100} nota(s) de R$ 100,00")
    a%= 100
    println("${a/50} nota(s) de R$ 50,00")
    a%= 50
    println("${a/20} nota(s) de R$ 20,00")
    a%= 20
    println("${a/10} nota(s) de R$ 10,00")
    a%=10
    println("${a/5} nota(s) de R$ 5,00")
    a%=5
    println("${a/2} nota(s) de R$ 2,00")
    a%=2
    println("${a/1} nota(s) de R$ 1,00")

}