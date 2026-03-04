/*
class Fruit {

    companion object {
        var name = " "
        var color = " "
        var buy = 0
        fun display() {

            println("this ia a $name and its color is $color and buy is $buy")
        }
    }
}


fun main() {

    Fruit.name = "Mango"
    Fruit.color = "Yellow"
    Fruit.buy = 4
    Fruit.display()


  */
/*  Fruit()  kisui print kore na
    Fruit.display("mango")*//*


}
*/


class Summ {
    companion object {
        fun add(a: Int, b: Int): Int {
            return a + b

        }
        fun sub(a: Int, b: Int): Int {
            return a - b

        }

        fun mul(a: Int, b: Int): Int {
            return a * b

        }

        fun div(a: Int, b: Int): Int {
            return a / b

        }
    }


}

fun main() {

    println(
        "sum : ${Summ.add(2, 3)} , " + "Sub : ${Summ.sub(2, 3)} ," +
                " Mul : ${Summ.mul(5, 6)} ," + " Div : ${Summ.div(50, 6)}"
    )

}