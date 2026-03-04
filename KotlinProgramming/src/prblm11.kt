fun main(){
    print("Enter your Year : ")
    var year = readLine()!!.toInt()
    if (year % 4 == 0) {
        if(year%100==0){
            if(year%400==0){
                print("$year is a leap year")
            }
            else println("$year is not a leap year")
        }
        else println("$year is a leap year")

    }
    else println("$year is not a leap year")
}