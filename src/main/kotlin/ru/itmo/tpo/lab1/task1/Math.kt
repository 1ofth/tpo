package ru.itmo.tpo.lab1.task1

import kotlin.math.abs
import kotlin.math.pow

fun main() {
    println(Math().cos(-.1, 0.000001))
}

class Math {
    fun Int.sign(): Int = (-1).toDouble().pow(this).toInt()

    fun cos(param: Double, precision: Double): Double {
        var prevValue = Double.MIN_VALUE
        var currentValue = 1.0
        var iteration = 0
        var factor = 1L

        while (iteration < MIN_ITERATIONS ||
            (abs(currentValue - prevValue) > precision && iteration < MAX_ITERATIONS)
        ) {
            iteration += 1
            factor *= (iteration * 2 - 1) * (iteration * 2)
            prevValue = currentValue
            val a = iteration.sign() * param.pow(2 * iteration)
            currentValue += (a / factor)
        }

        return currentValue
    }

    companion object {
        const val MIN_ITERATIONS = 5
        const val MAX_ITERATIONS = 10
    }
}
