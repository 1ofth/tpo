package ru.itmo.tpo.lab1.task1

import java.math.BigDecimal
import java.math.BigInteger
import kotlin.math.abs

fun cos(param: BigDecimal, precision: BigDecimal): Double {
    var prevValue: BigDecimal
    var currentValue = BigDecimal.ONE
    var iteration = 0
    var factor: BigInteger
    var diff = BigDecimal.valueOf(1)
    var prevFraction = BigDecimal.ONE
    val paramSquared = param.pow(2)

    while (iteration < MIN_ITERATIONS ||
        (diff.abs() > precision) && iteration < MAX_BIG_ITERATIONS
    ) {
        iteration += 1
        factor = BigInteger.valueOf(iteration * 2L - 1) * BigInteger.valueOf(iteration * 2L)
        prevFraction = -prevFraction * paramSquared / factor.toBigDecimal()
        prevValue = currentValue
        currentValue += prevFraction
        diff = currentValue - prevValue
    }

    return currentValue.toDouble()
}

fun cos(param: Double, precision: Double): Double {
    var prevValue = Double.MIN_VALUE
    var currentValue = 1.0
    var iteration = 0
    var prevFraction = 1.0

    if (!param.isFinite())
        throw IllegalArgumentException("Cos argument should be finite!")

    val x = param.rem(2 * Math.PI)

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

const val MIN_ITERATIONS = 1000
const val MAX_ITERATIONS = 150000
const val MAX_BIG_ITERATIONS = 15000


