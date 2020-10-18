package ru.itmo.tpo.lab2

import kotlin.math.pow

class LogExpr {
    val log = Log()

    @Throws(IllegalArgumentException::class)
    fun compute(x: Double, eps: Double): Double {
        require(x > 0)
        val firstPart = (((log.calc(5.0, x, eps) * log.calc(5.0, x, eps)) / log.calc(3.0, x, eps)).pow(2)).pow(3)
        val secondPart =  (log.calc(10.0, x, eps).pow(2)) * log.calc(5.0, x, eps)

        return firstPart - secondPart
    }
}