fun main(){
    var a = readLine()!!.toDouble()
    a+=0.00001
    println("NOTAS:")
    println("${(a/100).toInt()} nota(s) de R$ 100.00")
    a%=100
    println("${(a/50).toInt()} nota(s) de R$ 50.00")
    a%=50
    println("${(a/20).toInt()} nota(s) de R$ 20.00")
    a%=20
    println("${(a/10).toInt()} nota(s) de R$ 10.00")
    a%=10
    println("${(a/5).toInt()} nota(s) de R$ 5.00")
    a%=5
    println("${(a/2).toInt()} nota(s) de R$ 2.00")
    a%=2
    println("MOEDAS:")
    println("${(a/1).toInt()} moeda(s) de R$ 1.00")
    a%=1
    println("${(a/0.50).toInt()} moeda(s) de R$ 0.50")
    a%=0.50
    println("${(a/0.25).toInt()} moeda(s) de R$ 0.25")
    a%=0.25
    println("${(a/0.10).toInt()} moeda(s) de R$ 0.10")
    a%=0.10
    println("${(a/0.05).toInt()} moeda(s) de R$ 0.05")
    a%=0.05
    println("${(a/0.01).toInt()} moeda(s) de R$ 0.01")

}