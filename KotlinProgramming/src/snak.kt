fun main() {
/*
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }

    if (a == 1) println("Total: R$ ${"%.2f".format(4.00 * b)}")
    else if (a == 2) println("Total: R$ ${"%.2f".format(4.50 * b)}")
    else if (a == 3) println("Total: R$ ${"%.2f".format(5.00 * b)}")
    else if (a == 4) println("Total: R$ ${"%.2f".format(2.00 * b)}")
    else println("Total: R$ ${"%.2f".format(1.50 * b)}")
*/


    //---when---

    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val ans = when(a){
        1 -> 4.00 * b
        2 -> 4.50 * b
        3 -> 5.00 * b
        4 -> 2.00 * b
        else -> 1.50 * b
    }
    println("Total: R$ ${"%.2f".format(ans)}")


}
