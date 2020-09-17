package ru.itmo.tpo.lab1.task3

fun main() {
    val bomber = Bomber()
    val persons = PersonGroup(Corner.LEFT, GroupState.RELAXED, 3)
    val comp = ComputerBank(BankPart("Front side"), BankPart("Back side"))
    comp.personGroup = persons
    bomber.bombard(comp, 4)

    persons.state = GroupState.TENSE
    persons.waitForEnd()
}
