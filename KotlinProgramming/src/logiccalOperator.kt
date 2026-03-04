fun main(){
    print("Enter your number of a : ")
    val a = readln().toIntOrNull()
    print("Enter your number of a : ")
    val b = readln().toIntOrNull()
    if(a == null || b == null){
        println("invalid input number")
    }
    else{
        if(a%2==0 && b%2==0) println("a and b both even number")
        else println("both not even number")

        if(a%2==0 || b%2==0) println("hello everyone")
        else println("no one even number")
            var num = true
            println(!num)
    }
}