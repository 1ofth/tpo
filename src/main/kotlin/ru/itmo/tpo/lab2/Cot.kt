package ru.itmo.tpo.lab2

import kotlin.math.PI
import kotlin.math.abs

class Cot(precision: Double) {
    private val cos = Cos(precision)
    private val sin = Sin(cos, precision)

    private fun prepare(x: Double): Double {
        require(x.isFinite())
        require(x % PI != 0.0)
        return abs(x) % (PI)
    }

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double): Double {
        val x = prepare(param)
        val result = cos.calc(param) / sin.calc(param)
        return if (abs(x) <= PI / 2) result else -result
    }
}

fun main() {
    val cot = Cot(1e-6)
    println(cot.calc(5*PI))
    println(cot.calc(2*PI/3))
    println(cot.calc(PI/3))
    println(cot.calc(5*PI/6))
    println(cot.calc(PI/6))
}
