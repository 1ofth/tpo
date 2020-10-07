package ru.itmo.tpo.lab1.task3

interface Destructible {
    var health: Double
    var temperature: Double
    var noise: Double
    var isBombard: Boolean
    var isMelted: Boolean
    fun destroy() {}
}
