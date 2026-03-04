fun main() {
    print("Enter your BMI value: ")
    val bmi = readLine()!!.toDouble()
    if (bmi <= 18.5) println("Underweight")
    else if (bmi >= 18.5 && bmi <= 24.5) println("Normal")
    else if (bmi >= 25 && bmi <= 29.9) println("Overweight")
    else println("Obese")
}
