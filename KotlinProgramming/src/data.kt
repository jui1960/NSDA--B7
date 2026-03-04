data class User(val name: String, val age: Int)

fun main() {
    val user1 = User("Jui", 25)
    val user2 = User("Jui", 25)

    println(user1)
    println(user1 == user2)

    val user3 = user1.copy(age = 26)
    println(user3)

    val (name, age) = user1
    println("Name: $name, Age: $age")
}
