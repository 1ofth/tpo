package ru.itmo.tpo.lab2

import kotlin.math.PI

class Log5(private val ln: Ln) {

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double): Double {
        require(param % PI != 0.0)
        return ln.calc(param) / ln.calc(5.0)
    }
}
