class Phone{
    var namee=""
    var batteryy = 0
    var camera = 0
    var color = ""

    fun display(){
        println("phone name : $namee , phone battery health : $batteryy," +
                "camera : $camera,color : $color")
    }

}

fun main() {
    val obj = Phone()   //obj create
    obj.namee="Redmi y13"
    obj.batteryy=20
    obj.camera=4
    obj.color="red"
    obj.display()


}