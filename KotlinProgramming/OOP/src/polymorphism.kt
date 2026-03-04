/*method overloading --- method er name same bt parameter vinno
class Name{
    fun Name1(name : String){
        println("first name : $name")
    }
    fun Name1(name1 : String,name2 : String){
        println("second name : $name1 and $name2")
    }
    fun Name1(name3 : String, Name4 : String, Name5 : String){
        println("third name : $name3 and  $Name4 and  $Name5")
    }
}
fun main(args : Array<String>){
    val obj = Name()
    obj.Name1("John")
    obj.Name1("John","Smith")
    obj.Name1("John","Smith","jui")
}*/

//method override
open class Animal {
    open fun sound() {
        println("Animal makes a sound")
    }
}
class Dog : Animal() {
    override fun sound() {
        println("Dog barks")
    }
}
class Cat : Animal() {
    override fun sound() {
        println("Cat meows")
    }
}
fun main() {
    val obj1: Animal = Dog()
    val obj2: Animal = Cat()
    obj1.sound()
    obj2.sound()
}

