fun main(){
    print("Enter your name: ")
    val number =readln().toInt()
    val res = when(number){
        1 -> "Sunday -> Weekday"
        2 -> "Monday -> Weekday"
        3 -> "Tuesday -> Weekday"
        4 -> "Wednesday -> Weekday"
        5 -> "Thursday -> Weekday"
        6 -> "Friday -> Weekend day"
        7 -> "Saturday -> Weekend day"
        else -> "invalid Input"
    }
    println(res)
}
