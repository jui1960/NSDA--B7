fun main() {
    val n = readLine()!!.toInt()
    if(n%2==0){
        for (i in n..(12 + n)) {

            if (i % 2 != 0) {
                println(i)
            }
        }
    }
    else{
        for(i in n..(10+n)){
            if (i % 2 != 0) {
                println(i)
            }
        }
    }



/*
    import java.util.*

    fun main(args: Array<String>) {

        val n = readLine()!!.toInt()

        var start = if (n % 2 == 0) n + 1 else n

        for (i in 0 until 6) {
            println(start + i * 2)
        }
    }

*/


}