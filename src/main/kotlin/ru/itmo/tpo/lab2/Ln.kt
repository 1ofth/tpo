package ru.itmo.tpo.lab2

import kotlin.math.abs
import kotlin.math.ln

class Ln(private val precision: Double) {

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double): Double {
        require(param.isFinite())
        require(param >= 0)

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

fun main() {
    val ln = Ln(1e-6)
    println("" + ln.calc(1.0) + " " + ln(1.0))
    println("" + ln.calc(0.5) + " " + ln(0.5))
    println("" + ln.calc(1.5) + " " + ln(1.5))
    println("" + ln.calc(Math.E)+ " " + ln(Math.E))
    println("" + ln.calc(Math.E * Math.E)+ " " + ln(Math.E*Math.E))
}
