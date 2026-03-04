fun main(){
    val sum =calculateNeww(10,5,::add)
    val ans =calculateNeww(10,5,::sub)
    println(sum)
    println(ans)

}
fun add(a: Int, b: Int): Int {
    return a + b
}
fun sub(a: Int, b: Int): Int {
    return a - b
}

fun calculateNeww(x: Int, y: Int,operationNew:(Int,Int)->Int): Int {
    return operationNew(x,y)
}