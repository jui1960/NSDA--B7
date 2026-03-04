/* primary constructor
class Car(var brand: String, var model: String, var year: Int)

fun main() {
    val c1 = Car("Ford", "Mustang", 1969)
    val c2 = Car("BMW", "X5", 1999)
    val c3 = Car("Tesla", "Model S", 2020)

}

class Carr(var brand: String, var model: String, var year: Int)


    val c11 = Carr("Ford", "Mustang", 1969)
    val c21 = Carr("BMW", "X5", 1999)
    val c31 = Carr("Tesla", "Model S", 2020)


*/

//secondary constructor


class Secondaryconst{
    var  Namee : String
    var roll : Int
    constructor(a: String,roll : Int){
        this.Namee = a
        this.roll = roll

    }
    constructor(name: String){
        this.Namee = name
        this.roll = 0
    }
}
fun main(args:Array<String>){
    val s1 = Secondaryconst("jannati",1)
    val s2 = Secondaryconst("mahmuda")
    println("${s1.Namee} ${s1.roll}")
    println(s2.Namee)
}

