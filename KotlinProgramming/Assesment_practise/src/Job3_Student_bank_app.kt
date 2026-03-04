/*
class Student(
    private var StudenId: String,
    private var accountBalance: Double,
    private var studentName: String,
    private var passwordPin: Int
) {
    fun viewBalance() {
        println("balance : $accountBalance")
    }

    fun saveMoney(amount: Double) {
        if (amount > 0.0) {
            accountBalance += amount
            println("saveMoney : $accountBalance")
        } else {
            println("Invalid amount")
        }
    }

    fun spendMoney(spentAmount: Double) {
        if (spentAmount < 0.0) {
            println("invalid spent amount")
        } else if (spentAmount > accountBalance) {
            println("insufficient spent")
        } else {
            accountBalance -= spentAmount
            println("spendMoney : $spentAmount ans current balance is $accountBalance")
        }

    }

}

fun main() {
    print("Enter your student ID : ")
    val studentId = readLine()!!
    print("Enter your accountBalance : ")
    val accountBalance = readLine()!!.toDouble()
    print("Enter your student name : ")
    val studentName = readLine()!!
    print("Enter your student passwordPin : ")
    val passwordPin = readLine()!!.toInt()
    val obj = Student(studentId, accountBalance, studentName, passwordPin)



    obj.saveMoney(200.0)
    obj.spendMoney(90.0)
    obj.viewBalance()


}
*/



class Student(
    private var studentId: String,
    private var accountBalance: Double,
    private var studentName: String,
    private var passwordPin: Int
) {

    fun viewBalance() {
        println("Balance: $accountBalance")
    }

    fun saveMoney(amount: Double) {
        if (amount > 0.0) {
            accountBalance += amount
            println("Money saved: $amount. Current balance: $accountBalance")
        } else {
            println("Invalid amount to save")
        }
    }

    fun spendMoney(spentAmount: Double) {
        if (spentAmount < 0.0) {
            println("invalid spent amount")
        } else if (spentAmount > accountBalance) {
            println("insufficient spent")
        } else {
            accountBalance -= spentAmount
            println("spendMoney : $spentAmount and current balance is $accountBalance")
        }
    }
}

fun main() {
    print("Enter your student ID: ")
    val studentId = readLine()!!

    print("Enter your account balance: ")
    val accountBalance = readLine()!!.toDouble()

    print("Enter your student name: ")
    val studentName = readLine()!!

    print("Enter your student password PIN: ")
    val passwordPin = readLine()!!.toInt()

    val obj = Student(studentId, accountBalance, studentName, passwordPin)

    println("")
    obj.saveMoney(200.0)
    obj.spendMoney(90.0)
    obj.viewBalance()
}

