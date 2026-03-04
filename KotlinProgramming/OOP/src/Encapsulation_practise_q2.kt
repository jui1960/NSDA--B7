/*
Problem 3: Bank Account

Create a class BankAccount:

    Private variable: balance

Public functions:

deposit(amount)

withdraw(amount)

getBalance()

Rules

Balance cannot go negative

Print "Insufficient Balance" if withdrawal fails

📌 Concepts: Encapsulation, Access Specifiers
*/


class BankAccount {
    private var balance = 0.0
    private var minbalance = 500.0

    fun Deposit(amount: Double) {
        if (amount > 0.0) {
            balance += amount
            println("Deposited amount : $amount and now current balance : $balance")
        } else {
            println("Invalid amount $amount")
        }
    }

    fun Withdraw(amount: Double) {

        if(balance <= minbalance){
            println("Insufficient balance")
            return
        }
        if (amount > 0.0 && amount <= balance - 500) {
            balance -= amount

            println("Withdrawed amount : $amount  currently balance: $balance")

        } else {
            println("Insufficient Balance , you can withdraw ${balance - 500}")
        }
    }

    fun getBalance() {
        println("Current balance is $balance")
    }
}

fun main() {
    print("Enter you deposit amount : ")
    val a = readLine()!!.toDouble()
    print("Enter you withdraw amount : ")
    val b = readLine()!!.toDouble()
    val obj = BankAccount()
    obj.Deposit(a)
    obj.Withdraw(b)
    obj.getBalance()
}