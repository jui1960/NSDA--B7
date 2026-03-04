class EmployeeAccount(
    private var employeeId: String,
    private var employeeName: String,
    private var basicSalary: Double,
    private var performanceRating: Int,
) {
    fun viewSalaryDetails() {

        println("Current  salary: $basicSalary")
    }

    fun addBonus() {
        if (performanceRating == 5) {
            val bonusSalary = (basicSalary * 0.10)
            basicSalary += bonusSalary
            println("Bonus :$bonusSalary , Now  Bonus salary : $basicSalary")
        } else {
            println("No Bonus added , rating is $performanceRating")
        }
    }

    fun deductTax(percentage: Double) {
        val deduct = (basicSalary * percentage)
        basicSalary -= deduct
        println("Deduct 15% , Deduct salary : $basicSalary")
    }
}

fun main() {
    print("Enter your EmployeeId: ")
    val a = readLine()!!

    print("Enter your EmployeeName: ")
    val b = readLine()!!

    print("Enter your BasicSalary: ")
    val c = readLine()!!.toDouble()

    /*  val employee = EmployeeAccount(
          employeeId = "E101",
          employeeName = "Rahim",
          basicSalary = 10000.0,
          performanceRating = 5
      )
  */
    print("Enter your performance rating(1 to 5): ")
    val rating = readLine()!!.toInt()
    val employeeAccount = EmployeeAccount(a, b, c, rating)

    println("---- Initial Salary ----")
    employeeAccount.viewSalaryDetails()
    println("\n---- Applying Bonus ----")
    employeeAccount.addBonus()
    println("\n---- Deducting Tax ----")
    employeeAccount.deductTax(0.15)
    println("\n---- Final Salary ----")
    employeeAccount.viewSalaryDetails()
}
