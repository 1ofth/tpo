package ru.itmo.tpo.lab1.task3

class BankPart(
    var computerBank: ComputerBank?,
    val name: String,
    health: Double,
    override var temperature: Double,
    override var noise: Double
) : Destructible {
    override var health: Double = health
        set(value) {
            field = value
            if (field < 30) {
                computerBank?.destroy() ?: destroy()
            }
            Double.POSITIVE_INFINITY
        }
}
