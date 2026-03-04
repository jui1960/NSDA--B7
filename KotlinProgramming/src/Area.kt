fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toDouble() }
    println("TRIANGULO: ${"%.3f".format((a * c) / 2)}")
    println("CIRCULO: ${"%.3f".format(3.14159 * (c * c))}")
    val trapezium = (a + b) / 2
    println("TRAPEZIO: ${"%.3f".format(trapezium*c)}")
    println("QUADRADO: ${"%.3f".format(b*b)}")
    println("RETANGULO: ${"%.3f".format(a*b)}")

}