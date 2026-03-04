/*
// Interface
interface Vehicle {
    fun start()
    fun stop()
}

// Class implements Interface
class Car : Vehicle {
    override fun start() {
        println("Car started")
    }
    override fun stop() {
        println("Car stopped")
    }
}

class Bike : Vehicle {
    override fun start() {
        println("Bike started")
    }
    override fun stop() {
        println("Bike stopped")
    }
}

fun main() {
    val car = Car()
    val bike = Bike()

    car.start()  // Car started
    bike.start() // Bike started
}
*/

interface Engine {
    fun startEngine()
}

interface MusicSystem {
    fun playMusic()
}

class BigCar : Engine, MusicSystem {
    override fun startEngine() {
        println("Start Engin")
    }

    override fun playMusic() {
        println("Play Music")
    }
}

fun main() {
    val car = BigCar()
    car.startEngine()
    car.playMusic()
}