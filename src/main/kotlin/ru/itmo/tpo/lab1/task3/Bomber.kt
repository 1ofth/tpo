package ru.itmo.tpo.lab1.task3

class Bomber {
    fun bombard(target: Destructible, bombsCount: Int) {
        repeat(bombsCount) {
            target.health -= 20
            target.temperature += 60
            Thread.sleep(1_000)
        }
    }
}