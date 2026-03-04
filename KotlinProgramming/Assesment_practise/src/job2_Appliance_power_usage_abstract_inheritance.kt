abstract class Appppliance{
    abstract fun calculatePowerUsage()
}
class fan():Appppliance(){
    override fun calculatePowerUsage(){
        val run = 16
        val wat = 75
        val kmh = run * wat /1000.0
        println("Fan = $kmh")
    }
}
class airConditioner():Appppliance(){
    override fun calculatePowerUsage(){
        val run = 11
        val wat = 1500
        val kmh = run * wat /1000.0
        println("AirConditioner = $kmh")
    }
}
class lightBulb():Appppliance(){
    override fun calculatePowerUsage(){
        val run = 13
        val wat = 10
        val kmh = run * wat /1000.0
        println("LightBulb = $kmh")
    }
}
fun main() {
    val obj  = fan()
    val obj1 = airConditioner()
    val obj2 = lightBulb()
    obj.calculatePowerUsage()
    obj1.calculatePowerUsage()
    obj2.calculatePowerUsage()

}


