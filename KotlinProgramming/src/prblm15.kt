fun main(){
    print("Enter a number: ")
    val number= readln().toInt()

    if(number%5==0 && number%11==0) println("Divisible by both")
    else if(number%5==0) println("$number Divisible by only 5 ")
    else if(number%11==0) println("$number Divisible by only 11 ")
    else println("$number not divisible by 5 or 11")

}