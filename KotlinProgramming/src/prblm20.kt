fun main(){
    print("Enter your purchase amount : ")
    val amount = readLine()!!.toInt()
    if(amount<100) println("$amount , No discount")
    else if(amount>100 && amount<=500)
        println("Discount amount ${amount-amount*0.10} discount ${amount*0.10} tk ")
    else println("Discount amount ${amount - amount * 0.20} discount ${amount * 0.20} tk")
}

