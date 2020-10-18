package ru.itmo.tpo.lab2

import kotlin.math.PI

class Csc(precision: Double) {
    private val sin = Sin(Cos(), precision)

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double): Double {
        require(param % PI != 0.0)
        return 1 / sin.calc(param)
    }
}
