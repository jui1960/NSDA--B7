class SmartLock(
    private val lockId: String,
    private var securityCode: Int
) {
    private var isLocked: Boolean = true

    fun unlock(code: Int) {
        if (code == securityCode) {
            isLocked = false
            println("Access Granted")
        } else {
            println("Access fail")
        }
    }

    fun lock() {
        isLocked = true
        println("System Locked")
    }

    fun getStatus(): String {
        return if (isLocked) "Locked" else "Unlocked"
    }
}

fun main() {
    val myLock = SmartLock("ROOM-01", 1234)

    println("Status: ${myLock.getStatus()}")

    myLock.unlock(1090)
    println("Status: ${myLock.getStatus()}")

    myLock.unlock(1234)
    println("Status: ${myLock.getStatus()}")

    myLock.lock()
    println("Status: ${myLock.getStatus()}")
}