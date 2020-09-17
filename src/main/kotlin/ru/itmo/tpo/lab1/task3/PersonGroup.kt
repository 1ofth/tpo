package ru.itmo.tpo.lab1.task3

class PersonGroup(var position: Corner, var state: GroupState, var personCount: Int) {
    fun waitForEnd() {
        println("They are waiting for the end at the ")
    }
}
