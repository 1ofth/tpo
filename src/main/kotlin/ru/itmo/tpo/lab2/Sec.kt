package ru.itmo.tpo.lab2

import kotlin.math.PI
import kotlin.math.abs

class Sec {
    private val cos = Cos()

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double, precision: Double): Double {
        require(abs(param - PI / 2) % PI != 0.0)
        return 1 / cos.calc(param, precision)
    }
}

fun main() {
    println(Sec().calc(PI + PI / 2, 0.00001))
}