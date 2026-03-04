fun main() {
    print("Enter username: ")
    val username = readLine()!!
    print("Enter password: ")
    val password = readLine()!!

    if (username == "Admin") {
        if (password == "1234") {
            println("Access Granted")
        } else {
            println("Wrong Password")
        }
    } else {
        println("Unknown User")
    }
}
