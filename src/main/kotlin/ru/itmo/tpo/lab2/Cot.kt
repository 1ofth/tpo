package ru.itmo.tpo.lab2

import kotlin.math.PI
import kotlin.math.abs

class Cot(
    private val cos: Cos,
    private val sin: Sin
) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        require(abs(param % PI) > cos.precision)
        return cos.calc(param) / sin.calc(param)
    }
}
