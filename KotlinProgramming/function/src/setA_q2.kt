fun main(){
    print("Enter your 1st number : ")
    val a = readLine()!!.toInt()
    print("Enter your 2nd number : ")
    val b = readLine()!!.toInt()
    val max = parameterisedReturn(a,b)
    println("Biggest number $max")
}
fun parameterisedReturn(a: Int, b: Int): Int{
    if(a > b){
        return a
    }
    else return b
}