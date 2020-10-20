package ru.itmo.tpo.lab2

import kotlin.math.PI

class Log3(private val ln: Ln) {

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double): Double {
        require(param % PI != 0.0)
        return ln.calc(param) / ln.calc(3.0)
    }
}

fun main() {
    val ln = Ln(0.000001)
    val l = Log3(ln)
    print(l.calc(1.0))
}