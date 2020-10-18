package ru.itmo.tpo.lab2

import kotlin.math.PI
import kotlin.math.abs

class Sec(precision: Double) {
    private val cos = Cos(precision)

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double): Double {
        require(abs(param - PI / 2) % PI != 0.0)
        return 1 / cos.calc(param)
    }
}

fun main() {
    println(Sec(1e-6).calc(PI + PI / 2))
}