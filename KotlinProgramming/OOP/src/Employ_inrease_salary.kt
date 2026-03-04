/*
class Employ(val name : String,val id : Int,val department : String,var salary : Double) {

    fun sowdetails(){
        println("Name : $name id : $id Department : $department " +
                "Salary : $salary")

    }

    fun add(a:Double){
        salary += a
        println("Incressted Salary : $salary")

    }
}
fun main() {
    print("Enter your Details : ")
    val (name,id,department,salary) = readLine()!!.split(" ")
    val employ = Employ(name,id.toInt(),department,salary.toDouble())
    employ.sowdetails()
    print("Increment salary : ")
    val a = readLine()!!.toDouble()
    employ.add(a)


}*/

fun addd(a: Double, b: Double): Double {
    return a + b
}
class Employ(val name: String, val id: Int, val department: String, var salary: Double) {

    fun sowdetails(ans: Double) {
        println(
            "Name : $name id : $id Department : $department " +
                    "Salary : $salary   Incressed salary : ${addd(ans, salary)}"
        )


    }

}

fun main() {
    print("Enter your Details : ")
    val (name, id, department, salary) = readLine()!!.split(" ")
    val employ = Employ(name, id.toInt(), department, salary.toDouble())

    print("Increment salary : ")
    val a = readLine()!!.toDouble()
    addd(a, employ.salary)
    employ.sowdetails(a)


}