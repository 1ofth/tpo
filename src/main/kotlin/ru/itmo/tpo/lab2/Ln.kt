package ru.itmo.tpo.lab2

import kotlin.math.abs
import kotlin.math.ln

class Ln(private val precision: Double = DEFAULT_PRECISION) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        require(param.isFinite())
        require(param > 0)

        val x = (param - 1) / (param + 1)

        var prevValue = Double.MIN_VALUE
        var currentValue = x
        var iteration = 1
        var prevNominator = x

        while (iteration < MIN_ITERATIONS ||
            (abs(currentValue - prevValue) > precision && iteration < MAX_ITERATIONS)
        ) {
            iteration += 1
            prevValue = currentValue
            prevNominator *= x * x
            currentValue += prevNominator  / (iteration * 2 - 1)
        }

        return currentValue * 2
    }
}
