package ru.itmo.tpo.lab1.task3

class Bomber(val bullet: Bullet) {
    fun bombard(target: Destructible, bombsCount: Int) {
        target.isBombard = true
        repeat(bombsCount) {
            target.health -= bullet.damage
            target.temperature += bullet.temperatureIncrease
            target.noise += bullet.noiseLevel
        }
        target.isBombard = false
    }
}
