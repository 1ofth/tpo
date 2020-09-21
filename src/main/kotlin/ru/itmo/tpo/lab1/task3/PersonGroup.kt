package ru.itmo.tpo.lab1.task3

class PersonGroup(var position: Corner, var state: GroupState, var personCount: Int) {
    fun waitForEnd() {
        state = GroupState.TENSE_AND_WAITING
    }
}
