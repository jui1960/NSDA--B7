import java.util.*

fun main(args: Array<String>) {

    var st = 7
    var en =5

    for(i in 1..9 step 2){

        for(j in st downTo en step 1){
            println("I=$i J=$j")
        }
        st+=2
        en+=2
    }

}