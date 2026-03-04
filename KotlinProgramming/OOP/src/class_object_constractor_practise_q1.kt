/*
class Student(var name: String, var roll: Int, var mark: Double) {
    fun display() {
        println("name : $name , roll :  $roll ,mark : $mark")
    }
}
fun main() {
    */
/*  var student = Student("John", 35,80.0)
      student.display()*//*

    print("Enter your name : ")
    val name = readLine()!!
    print("Enter your roll : ")
    val roll = readLine()!!.toInt()
    print("Enter mark : ")
    val mark = readLine()!!.toDouble()
    val student = Student(name, roll, mark)
    student.display()

}

*/




//secondary constructor
/*

class Student {
    var name = ""
    var roll = 0
    var mark = 0.0
    constructor(name: String, roll: Int, mark: Double) {
        this.name = name
        this.roll = roll
        this.mark = mark
    }
    fun Display() {
        println("name : $name , roll :  $roll ,mark : $mark")
    }
}
fun main() {
    print("Enter your name : ")
    val name = readLine()!!
    print("Enter your roll : ")
    val roll = readLine()!!.toInt()
    print("Enter mark : ")
    val mark = readLine()!!.toDouble()
    val obj = Student(name, roll, mark)
    obj.Display()
}
*/

/*

class Rectangle(val width: Int, val height: Int){
    val area = width * height
    fun display(){
        println("area is : $area")
    }
}

fun main() {
    val(a,b) = readLine()!!.split(" ").map { it.toInt() }
    val q1 = Rectangle(a,b)
    q1.display()
}*/


class Rectangle{
    var height = 0
    var width = 0
    constructor(height: Int, width: Int) {
        this.height = height
        this.width = width
    }
    fun draw() {
        println("Rectangle Area : ${height*width}")
    }
}
fun main() {
    val(a,b) = readLine()!!.split(" ").map { it.toInt() }
    val q1 = Rectangle(a,b)
    q1.draw()
}
