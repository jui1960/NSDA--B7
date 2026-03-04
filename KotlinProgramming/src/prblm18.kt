fun main() {
    print("Player 1 : (rock/paper/scissors): ")
    val player1 = readLine()!!
    print("Player 2 : (rock/paper/scissors): ")
    val player2 = readLine()!!

    if(player1 == player2) {
        println("It's a Tie!")
    }
    else if(player1 == "rock" && player2 == "scissors" ||
        player1 == "scissors" && player2 == "paper" ||
        player1 == "paper" && player2 == "rock") {
        println("Player 1 wins!")
    }
    else if(player2 == "rock" && player1 == "scissors" ||
        player2 == "scissors" && player1 == "paper" ||
        player2 == "paper" && player1 == "rock") {
        println("player 2 wins!")
    }
    else {
        println("Invalid input")
    }
}
