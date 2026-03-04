import java.util.*

fun main(args: Array<String>) {

    for(i in 1..9 step 2){
        for(j in 7 downTo 5 step 1){
            println("I=$i J=$j")
        }
    }

}