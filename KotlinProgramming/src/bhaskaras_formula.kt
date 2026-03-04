import kotlin.math.sqrt

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toDouble() }
    val ans1 = b * b - 4 * a * c
    val ans2 = sqrt(b * b - 4 * a * c)

    val R1 = (-b + ans2) / (2 * a)
    val R2 = (-b - ans2) / (2 * a)

    if (a == 0.0 || ans1 < 0) {
        println("Impossivel calcular")
    } else {
        println("R1 = %.5f".format(R1))
        println("R2 = %.5f".format(R2))
    }


}
