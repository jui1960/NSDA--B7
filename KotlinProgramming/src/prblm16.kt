fun main() {
    print("Enter your Bill : ")
    var bill = readln().toIntOrNull()
    if (bill == null) {
        print("Invalid")
        return
    } else {
        if (bill <= 100) print(bill * 5)
        else if (bill <= 200) print((100 * 5) + ((bill - 100) * 7))
        else
            print((100 * 5) + (100 * 7) + (bill - 200) * 10)
    }
}