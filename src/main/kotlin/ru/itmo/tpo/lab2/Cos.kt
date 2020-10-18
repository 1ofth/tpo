package ru.itmo.tpo.lab2

import kotlin.jvm.Throws
import kotlin.math.PI
import kotlin.math.abs

class Cos(private val precision: Double = DEFAULT_PRECISION) {

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double): Double {
        var prevValue = Double.MIN_VALUE
        var currentValue = 1.0
        var iteration = 0
        var prevFraction = 1.0

        require(param.isFinite())

        val x = param.rem(2 * PI)

        while (iteration < MIN_ITERATIONS ||
            (abs(currentValue - prevValue) > precision && iteration < MAX_ITERATIONS)
        ) {
            iteration += 1
            prevValue = currentValue
            prevFraction *= -1 * x * x / (iteration * 2 - 1) / (iteration * 2)
            currentValue += prevFraction
        }

        return currentValue
    }
}
