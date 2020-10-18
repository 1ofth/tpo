package ru.itmo.tpo.lab2

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class Sin {

    private val cos = Cos()

    private fun prepare(x: Double): Double {
        require(x.isFinite())
        val temp = abs(x) % (2 * PI)
        return if (x >= 0) temp else -temp
    }

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double, precision: Double): Double {
        val x = prepare(param)
        val result = sqrt(abs(1 - cos.calc(param, precision * precision).pow(2)))
        return if (abs(x) <= PI / 2 || abs(x) >= 3 * PI / 2) result else -result
    }
}
