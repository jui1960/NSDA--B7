/* public access modifire

public class name1{
    fun display(){
        println("hello")
    }
}

fun main(){
    val obj = name1()
    obj.display()

}*/




/*private access modifire
private open class Namee1{
    val name = "jui"
    fun display(){
        println("my name is $name")
    }
}
*/
/*class name22 : Namee1(){
     namee1 class ta private thakar karone ami name22 theke inherit korte prsi na
}*//*


fun main(args: Array<String>){
    val ans = Namee1()
    ans.display()

}
*/


open  class Prot {
    protected fun display(){
        println("protected")
    }
}
class Oop:Prot(){
    fun Show(){
        display()
    }

}

fun main() {
    val a = Oop()
    a.Show()
}

