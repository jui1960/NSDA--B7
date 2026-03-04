fun main(){
    println("Enter your Number : ")
    var number = readln().toInt()
    var i = 1
    while (i <= 10) {
        var ans = i*number
        println("$number * $i = $ans ")
        i++
    }

}