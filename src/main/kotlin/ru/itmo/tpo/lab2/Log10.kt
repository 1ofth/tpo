package ru.itmo.tpo.lab2

import kotlin.math.PI

class Log10(private val ln: Ln) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        require(param % PI != 0.0)
        return ln.calc(param) / ln.calc(10.0)
    }
}
