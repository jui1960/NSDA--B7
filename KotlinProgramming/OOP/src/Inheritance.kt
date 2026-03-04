  //simple single inheritance


open class Fruit{
    val name = "mango"
    fun display(){
        println("Single inheritance")
    }

}
class Mango : Fruit(){
    fun inherit(){
        println("Inheritance")
    }
}

fun main() {
    val obj = Mango()
    println(obj.name)
    obj.display()
    obj.inherit()


}
 // single inheritance a aktu super class thake and akta subclass thake

