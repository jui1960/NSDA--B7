class BankAccount(
    private var AccountNumber : String ,
     private var balance: Double ){

        fun getBalance(){
            println("The current balance is $balance")
        }

    fun deposit(depositamount : Double){
        if(depositamount>0.0){
            balance += depositamount
            println("Deposited $depositamount successfully and current balance is $balance")
        }
        else println("Invalid amount")
    }

    fun withdraw(withdrawamount : Double){
        if(withdrawamount<0.0){
            println("Invalid withdraw amount")
        }
        else if( withdrawamount>balance){
            println("Insufficient balance")
        }
        else {
            balance -= withdrawamount
            println("withdrew $withdrawamount successfully")
        }
    }
}
fun main(){
    val obj = BankAccount("616382",500.0)
    print("Enter your deposit balance : ")
    val a = readLine()!!.toDouble()

    print("Enter your withdraw balance : ")
    val b = readLine()!!.toDouble()

    obj.deposit(a)
    obj.withdraw(b)
//    print("balance after withdraw :  ${obj.getBalance()}")
    obj.getBalance()


}