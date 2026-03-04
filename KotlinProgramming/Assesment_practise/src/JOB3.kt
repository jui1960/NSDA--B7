abstract class Appliance {
    open fun calculatePowerUsage(){

    }
}

class Fan : Appliance() {
    override fun calculatePowerUsage() {
        val hours = 18
        val watt = 88
        val kWh = hours * watt / 1000.0
        println("Fan usage : $kWh")
    }
}
class AirConditioner : Appliance() {
    override fun calculatePowerUsage() {
        val hours = 15
        val watt = 1800
        val kWh = hours * watt / 1000.0
        println("AirConditioner usage : $kWh")


    }
}

class LightBulb : Appliance() {
    override fun calculatePowerUsage() {

        val hours = 18
        val watt = 20
        val kWh = hours * watt / 1000.0
        println("LightBulb usage : $kWh")

    }
}

fun main() {
    val fan = Fan()
    val airConditioner = AirConditioner()
    val lightBulb = LightBulb()

    fan.calculatePowerUsage()
    airConditioner.calculatePowerUsage()
    lightBulb.calculatePowerUsage()


}
