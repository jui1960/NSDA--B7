open class Name1{
    fun display(){
        println("My name is jannati akter jui")
    }
}
open class Name2:Name1(){
    fun display1(){
        println("inherit name1")
    }
}
class name3: Name2(){
    fun display2(){
        println("inherit name2")
    }

}
fun main() {
    val obj = name3()
    obj.display()
    obj.display1()
    obj.display2()

}