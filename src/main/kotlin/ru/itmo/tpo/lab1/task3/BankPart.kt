package ru.itmo.tpo.lab1.task3

class BankPart(private val name: String) : Destructible{
    override var health: Double = 100.0
        set(value) {
            field = value
            println("$field")
            if (field < 30) {
                println("$name is almost destroyed")
                destroy()
            }
            Double.POSITIVE_INFINITY
        }

    override var temperature: Double = 20.0
        set(value) {
            field = value
            if (field > 120) {
                println("$name temperature incredibly increased!")
            }
        }
}
