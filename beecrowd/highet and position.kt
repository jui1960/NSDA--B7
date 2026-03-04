import java.util.*

fun main(args: Array<String>) {

 var maxvalue = 0
    var  position = 0
    for (i in 1..100){
        val num = readLine()!!.toInt()
        if(num > maxvalue){
            maxvalue = num
            position = i
        }
    }
    println(maxvalue)
    println(position)
}