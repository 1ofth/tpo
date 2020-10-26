package ru.itmo.tpo.lab2

import kotlin.math.PI
import kotlin.math.abs

class Csc(private val sin: Sin) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        require(abs(param % PI) > sin.precision)
        return 1 / sin.calc(param)
    }
}
