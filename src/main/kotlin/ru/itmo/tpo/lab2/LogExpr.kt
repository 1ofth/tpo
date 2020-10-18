package ru.itmo.tpo.lab2

import kotlin.math.pow

class LogExpr(precision: Double) {
    val log = Log(precision)

    @Throws(IllegalArgumentException::class)
    fun calc(x: Double): Double {
        require(x > 0)
        val firstPart = (((log.calc(5.0, x) * log.calc(5.0, x)) / log.calc(3.0, x)).pow(2)).pow(3)
        val secondPart =  (log.calc(10.0, x).pow(2)) * log.calc(5.0, x)

        return firstPart - secondPart
    }
}