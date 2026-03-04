fun main(){
    val time = 20
    val greeting = if (time < 18) {
        "Good day."
    } else {
        "Good evening."
    }
    println(greeting)
    if(10>17) println("10 getter then 17")
    else if(10>=17) println("10 getter then or equal to 17")
    else println("10 less than 17")

}