import java.util.*

fun main(args: Array<String>) {

	  val n = readLine()!!.toInt()
    val hour = n / 3600
    val remain = n % 3600
    val minute = remain / 60
    val second = remain % 60
    println("$hour:$minute:$second")
	
}