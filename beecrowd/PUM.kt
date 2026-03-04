import java.util.*

fun main(args: Array<String>) {

    var n = readLine()!!.toInt()
    var st = 1;
    var end = 4;
    for (i in 1..n) {
        for (j in st..end) {
            if(j%4==0) println("PUM")
            else print("$j ")
        }
        st+=4
        end+=4
    }

}