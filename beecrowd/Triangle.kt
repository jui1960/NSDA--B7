fun main() {
    val (a,b,c) = readLine()!!.split(" ").map{ it.toDouble() }
    if(a+b>c && b+c>a && a+c>b) println("Perimetro = ${"%.1f".format(a+b+c)}")
    else println("Area = ${"%.1f".format((a+b)*c/2)}")
}