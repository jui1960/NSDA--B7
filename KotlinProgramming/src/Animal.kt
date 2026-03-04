fun main() {
    val a = readLine()!!.trim()
    val b = readLine()!!.trim()
    val c = readLine()!!.trim()

    if (a == "vertebrado") {
        if (b == "mamifero") {
            if (c == "onivoro") {
                println("homem")
            } else if (c == "herbivoro") {
                println("vaca")
            }
        } else if (b == "ave") {
            if (c == "carnivoro") {
                println("aguia")
            } else if (c == "onivoro") {
                println("pomba")
            }
        }
    } else if (a == "invertebrado") {
        if (b == "inseto") {
            if (c == "hematofago") {
                println("pulga")
            } else if (c == "herbivoro") {
                println("lagarta")
            }
        } else if (b == "anelideo") {
            if (c == "hematofago") {
                println("sanguessuga")
            } else if (c == "onivoro") {
                println("minhoca")
            }
        }
    }
}