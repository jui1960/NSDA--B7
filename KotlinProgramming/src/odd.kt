fun main(){
    print("Enter your number of n : ")
    val n = readln().toInt()
    var i = 0
    while (i <= n) {
        if (i%2!=0) println(i)
        i++
    }
}