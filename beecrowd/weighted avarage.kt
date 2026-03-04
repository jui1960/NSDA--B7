import java.util.*

fun main(args: Array<String>) {

	 val a = readLine()!!.toInt()
    for (i in 1..a){
        val (b,c,d) = readLine()!!.split(" ").map{it.toFloat()}

        println("%.1f".format(((b*2)+(c*3)+(d*5))/10))
    }
	
}