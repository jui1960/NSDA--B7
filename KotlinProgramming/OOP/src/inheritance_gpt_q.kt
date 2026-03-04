/*
open class Person {
    protected var name = ""
    protected var age = 0

    fun setPersonData(n: String, a: Int) {
        name = n
        age = a
    }
}

class Student : Person() {
    private var roll = 0
    private var marks = 0.0

    fun setStudentData(r: Int, m: Double) {
        roll = r
        marks = m
    }


    fun display() {
        println("Name is : $name")
        println("Age is : $age")
        println("Roll is : $roll")
        println("Marks is : $marks")
    }
}

fun main() {
    val obj = Student()

    print("Enter name: ")
    val name = readLine()!!

    print("Enter age: ")
    val age = readLine()!!.toInt()

    print("Enter roll: ")
    val roll = readLine()!!.toInt()

    print("Enter marks: ")
    val marks = readLine()!!.toDouble()

    obj.setPersonData(name, age)
    obj.setStudentData(roll, marks)

    obj.display()
}
*/



open class Person {
    protected var name = ""
    protected var age = 0

    fun setPersonData(n: String, a: Int) {
        name = n
        age = a
    }
}

class Student : Person() {
    private var roll = 0
    private var marks = 0.0

    fun setStudentData(r: Int, m: Double) {
        roll = r
        marks = m
    }

    fun change(){
//        setPersonData(name , age)
        name = "montu"
        age = 21
    }
    fun display() {
        println("Name: $name")
        println("Age: $age")
        println("Roll: $roll")
        println("Marks: $marks")
    }
}

fun main() {
    val obj = Student()

    print("Enter name: ")
    val name = readLine()!!

    print("Enter age: ")
    val age = readLine()!!.toInt()

    print("Enter roll: ")
    val roll = readLine()!!.toInt()

    print("Enter marks: ")
    val marks = readLine()!!.toDouble()

    obj.setPersonData(name, age)
    obj.setStudentData(roll, marks)

    obj.display()
    obj.change()
    obj.display()

}
