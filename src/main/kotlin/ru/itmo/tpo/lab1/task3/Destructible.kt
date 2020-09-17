package ru.itmo.tpo.lab1.task3
import  ru.itmo.tpo.lab1.task3.MetalBrook.Consistency.*

interface Destructible {
    var health: Double
    var temperature: Double

    fun destroy() {
        MetalBrook(Corner.LEFT, THICK)
        MetalBrook(Corner.RIGHT, THICK)
        MetalBrook(Corner.TOP, THICK)
        MetalBrook(Corner.BOTTOM, THICK)
    }
}
