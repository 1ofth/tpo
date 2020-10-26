package ru.itmo.tpo.lab2

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class Sin(private val cos: Cos) : Calculator {

    private fun prepare(x: Double): Double {
        require(x.isFinite())
        val temp = abs(x) % (2 * PI)
        return if (x >= 0) temp else -temp
    }

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        val x = prepare(param)
        val result = sqrt(abs(1 - cos.calc(param).pow(2)))
        return if (x >= PI && x <= 2 * PI || x >= -PI && x <= 0) -result else result
    }
}
