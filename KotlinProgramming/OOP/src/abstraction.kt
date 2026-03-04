abstract class ATM {
    abstract fun withdraw(amount: Double)
    abstract fun checkBalance()
}
class MyATM : ATM() {
    private var balance = 1000.0 // Encapsulation -- eta hidden
    override fun withdraw(amount: Double) {
        if (amount <= balance) {
            balance -= amount
            println("Withdrawal balance: $amount")
        } else println("Insufficient balance")
    }
    override fun checkBalance() {
        println("Current balance: $balance")
    }
}
fun main(){
    val atm = MyATM()
    atm.withdraw(200.0) //abstraction-- ami jani 200 tk withdraw korte prbo
    atm.checkBalance()

//    atm.balance() eivabe direct balance access kora jai na,,etai encapsulation
}