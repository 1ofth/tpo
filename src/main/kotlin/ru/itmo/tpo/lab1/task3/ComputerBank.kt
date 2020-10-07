package ru.itmo.tpo.lab1.task3

open class ComputerBank(
    val frontPart: BankPart,
    val endPart: BankPart,
    var personGroup: PersonGroup? = null,
) : Destructible {
    val brooks = mutableListOf<MetalBrook>()

    override var isMelted: Boolean = false

    override var isBombard: Boolean = false
        set(value) {
            frontPart.isBombard = value
            endPart.isBombard = value
            field = value
        }

    override var noise: Double = (frontPart.noise + endPart.noise) / 2
        set(value) {
            frontPart.noise -= (field - value)
            endPart.noise -= (field - value) / 2
            field = (frontPart.noise + endPart.noise) / 2
        }

    override var health: Double = (frontPart.health + frontPart.health) / 2
        set(value) {
            frontPart.health -= (field - value)
            endPart.health -= (field - value) / 2
            field = (frontPart.health + endPart.health) / 2
        }

    override var temperature: Double = (frontPart.temperature + frontPart.temperature) / 2
        set(value) {
            frontPart.temperature -= (field - value)
            endPart.temperature -= (field - value) / 2
            field = (frontPart.temperature + frontPart.temperature) / 2
        }

    override fun destroy() {
        isMelted = true
        Corner.values().forEach {
            brooks += MetalBrook(it, MetalBrook.Consistency.THICK)
        }
        personGroup?.waitForEnd()
    }
}