package ru.itmo.tpo.lab2

import kotlin.math.PI

class Csc(private val sin: Sin) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        require(param % PI != 0.0)
        return 1 / sin.calc(param)
    }
}
