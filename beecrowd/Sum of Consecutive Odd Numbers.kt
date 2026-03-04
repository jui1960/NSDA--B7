import java.util.*

fun main(args: Array<String>) {
    val t =readLine()!!.toInt()
    repeat(t){
        var(x,y)=readLine()!!.split(" ").map { it.toInt() }
        if(x>y){
            var temp =x
            x=y
            y=temp


        }
        var sum =0
       for (i in x+1 until y){
           if(i%2!=0)sum+=i
       }
        println(sum)
    }
}