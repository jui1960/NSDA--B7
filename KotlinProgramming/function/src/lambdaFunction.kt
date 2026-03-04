//val add = { a: Int, b: Int -> a + b }
//val sub = { a: Int, b: Int -> a - b }
//
//fun main() {
//    println(add(10, 5))
//    println(sub(10, 5))
//}
//val ans = {a:Int,b:Int,c:Int -> a+b+c}
//fun main(){
//    val rs = ans(10,5,2)
//    println(rs)
//}


/*
val ans = { a: Int, b: Int, c: Boolean ->
    if (c) {
        true
    } else {
        false
    }
}

fun main() {
    val rs1 = ans(10, 5, true)
    println("Result 1: $rs1")

    val rs2 = ans(10, 5, false)
    println("Result 2: $rs2")
}*/

//2 ta songha jog

/*
fun main(){
    val a : (Int,Int)->Int = {a,b->a+b}
    println(a(10,5))
}*/


/*

fun main(){
    val lam : (Int)-> Boolean = { lam -> lam%2==0}
    println(lam(4))
}*/


fun main() {
    val square: (Int) -> Int = { n -> n * n }
    println(square(5))
}
