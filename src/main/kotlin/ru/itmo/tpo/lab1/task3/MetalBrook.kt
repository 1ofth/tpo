package ru.itmo.tpo.lab1.task3

class MetalBrook(direction: Corner, state: Consistency) {

    init {
        println("$state streams of molten metal began to crawl into the $direction corner")
    }

    enum class Consistency {
        FLUID, THICK
    }
}
