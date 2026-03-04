import java.util.*

fun main(args: Array<String>) {

    val a = readLine()!!.toDouble()
    var ans = 0.0
    if(a>=0 && a<=400){
        ans = a * 0.15

        println("Novo salario: ${"%.2f".format(a+ans)}")
        println("Reajuste ganho: ${"%.2f".format( ans)}")
        println("Em percentual: 15 %")
    }
    else if(a<=800){
        ans = a * 0.12
        println("Novo salario: ${"%.2f".format(a+ans)}")
        println("Reajuste ganho: ${"%.2f".format( ans)}")
        println("Em percentual: 12 %")
    }

    else if(a<=1200){
        ans = a * 0.10
        println("Novo salario: ${"%.2f".format(a+ans)}")
        println("Reajuste ganho: ${"%.2f".format( ans)}")
        println("Em percentual: 10 %")
    }

    else if(a<=2000){
        ans = a * 0.07
        println("Novo salario: ${"%.2f".format(a+ans)}")
        println("Reajuste ganho: ${"%.2f".format( ans)}")
        println("Em percentual: 7 %")
    }
    else{
        ans = a * 0.04
        println("Novo salario: ${"%.2f".format(a+ans)}")
        println("Reajuste ganho: ${"%.2f".format( ans)}")
        println("Em percentual: 4 %")
    }

}