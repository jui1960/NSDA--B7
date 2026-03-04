import java.util.*

fun main(args: Array<String>) {

  var even = 0
    var odd = 0
    var positive = 0
    var negative = 0

    for (i in 1..5) {
        var a = readLine()!!.toInt()
        if (a > 0) {
            positive++
        } else if (a < 0) {
            negative++
        }
        if (a % 2 == 0) {
            even++
        } else {
            odd++
        }
    }
    println("$even valor(es) par(es)")
    println("$odd valor(es) impar(es)")
    println("$positive valor(es) positivo(s)")
    println("$negative valor(es) negativo(s)")
	
}

