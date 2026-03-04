fun main() {
    val x = readLine()!!.toInt()
    val y = readLine()!!.toInt()

    val start = minOf(x, y)
    val end = maxOf(x, y)

    var sum = 0

    for (i in (start + 1) until end) {
        if (i % 2 != 0) {
            sum += i
        }
    }

    println(sum)
}
