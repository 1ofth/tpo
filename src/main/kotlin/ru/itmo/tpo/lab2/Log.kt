package ru.itmo.tpo.lab2

import kotlin.math.PI

class Log {
    private val ln = Ln()

    @Throws(IllegalArgumentException::class)
    fun calc(base: Double, param: Double, precision: Double): Double {
        require(param % PI != 0.0)
        return ln.calc(param, precision) / ln.calc(base, precision)
    }
}
