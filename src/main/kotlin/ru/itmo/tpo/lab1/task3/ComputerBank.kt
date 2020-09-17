package ru.itmo.tpo.lab1.task3

class ComputerBank(
    val frontPart: BankPart,
    val endPart: BankPart,
    var personGroup: PersonGroup? = null
) : Destructible {

    override var health: Double = frontPart.health + endPart.health
        set(value) {
            frontPart.health = value
            endPart.health = value / 2
            field = frontPart.health + endPart.health
        }

    override var temperature: Double = (frontPart.temperature + frontPart.temperature) / 2
        set(value) {
            frontPart.temperature = value
            endPart.temperature = value / 2
            field = (frontPart.temperature + frontPart.temperature) / 2
        }
}