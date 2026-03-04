fun main(){
    print("Enter number of x: ")
    val x= readln().toInt()
    print("Enter number of y: ")
    val y = readln().toInt()

    if(x==0 || y==0) println("Origi")
    else if(x>0 && y>0) println("1st")
    else if(x<0 && y>0) println("2nd")
    else if(x<0 && y<0) println("3rd")
    else println("4th")

}