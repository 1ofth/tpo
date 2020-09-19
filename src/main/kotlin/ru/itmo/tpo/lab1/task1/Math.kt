package ru.itmo.tpo.lab1.task1

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import kotlin.math.abs
import kotlin.math.pow

fun main() {
    println(cos(-.1, 0.000001))

    println(cos((-.1).toBigDecimal(), 0.000001.toBigDecimal()))
    println(cos(1.0.toBigDecimal(), 0.000001.toBigDecimal()))
    println(cos(10.0.toBigDecimal(), 0.000001.toBigDecimal()))
    println(cos(100.0.toBigDecimal(), 0.000001.toBigDecimal()))
    println(cos(1000.0.toBigDecimal(), 0.000001.toBigDecimal()))
    println(cos(10000.0.toBigDecimal(), 0.000001.toBigDecimal()))
}

fun Int.sign(): Int = (-1).toDouble().pow(this).toInt()

fun cos(param: BigDecimal, precision: BigDecimal): Double {
    var prevValue: BigDecimal
    var currentValue = BigDecimal.valueOf(1)
    var iteration = 0
    var factor: BigInteger = BigInteger.ONE
    var diff = BigDecimal.valueOf(1)
    var numerator = BigDecimal.ONE

    while (iteration < MIN_ITERATIONS ||
        (diff.abs() > precision) && iteration < MAX_BIG_ITERATIONS
    ) {
        iteration += 1

        factor *= BigInteger.valueOf(iteration * 2L - 1) * BigInteger.valueOf(iteration * 2L)

        prevValue = currentValue

        numerator *= param * param
        numerator = numerator.negate()

        currentValue = currentValue.add(
            (numerator.divide(factor.toBigDecimal(), 10, RoundingMode.HALF_UP))
        )
        diff = currentValue - prevValue
    }
    return currentValue.toDouble()
}

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

const val MIN_ITERATIONS = 5
const val MAX_ITERATIONS = 10
const val MAX_BIG_ITERATIONS = 15000


