import kotlin.math.abs
fun main() {
    val eps = 0.000000001
    val (A, B, C) = readLine()!!.split(" ").map { it.toDouble() }
    val list = listOf(A,B,C).sortedDescending()
    val a = list[0]
    val b = list[1]
    val c = list[2]
    if (a >= b + c) println("NAO FORMA TRIANGULO")
    else{
        if (abs(a * a - (b * b + c * c))<eps) println("TRIANGULO RETANGULO")
        else if (a * a > b * b + c * c) println("TRIANGULO OBTUSANGULO")
        else println("TRIANGULO ACUTANGULO")
        if (a == b && b == c) println("TRIANGULO EQUILATERO")
        else if (a == b || b == c || a==c) println("TRIANGULO ISOSCELES")
    }

}