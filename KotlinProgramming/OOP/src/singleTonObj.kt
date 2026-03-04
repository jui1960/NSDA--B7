object Phonee {
    var namee = " "
    var battery = 0
    var color = " "

    fun display() {
        println("phone name is $namee& battery is $battery health & color is $color")
    }

    fun show() {
        println("singleton object")
    }
}
object Phoneee {
    var name = " "
    var battery = 0
    var color = " "
}
fun main() {
    Phonee.namee = "redmi y3 "
    Phonee.battery = 20
    Phonee.color = "blue"

    Phonee.display()
    Phonee.show()
}


//singleton obj holo program a sudu ektai obj thakbe and Object keyword use hbe