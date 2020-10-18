package ru.itmo.tpo.lab2

import kotlin.math.PI

class Csc {
    private val sin = Sin()

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double, precision: Double): Double {
        require(param % PI != 0.0)
        return 1 / sin.calc(param, precision)
    }
}
