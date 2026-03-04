fun main() {
    val v = readLine()!!.split(" ").map { it.toDouble() }

    val n1 = v[0]
    val n2 = v[1]
    val n3 = v[2]
    val n4 = v[3]

    val media = ((n1 * 2 + n2 * 3 + n3 * 4 + n4) / 10.0) + 1e-9
    println("Media: %.1f".format(media))

    if (media >= 7.0) {
        println("Aluno aprovado.")
    } else if (media < 5.0) {
        println("Aluno reprovado.")
    } else {
        println("Aluno em exame.")

        val exame = readLine()!!.toDouble()
        println("Nota do exame: %.1f".format(exame))

        val mediaFinal = ((media + exame) / 2.0) + 1e-9

        if (mediaFinal >= 5.0) {
            println("Aluno aprovado.")
        } else {
            println("Aluno reprovado.")
        }

        println("Media final: %.1f".format(mediaFinal))
    }
}
