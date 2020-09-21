package ru.itmo.tpo.lab1.task3

data class MetalBrook(val direction: Corner, val state: Consistency) {
    enum class Consistency {
        FLUID, THICK
    }
}
