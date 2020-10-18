package ru.itmo.tpo.lab2

import kotlin.math.PI
import kotlin.math.abs

class Cot {
    private val cos = Cos()
    private val sin = Sin()

    private fun prepare(x: Double): Double {
        require(x.isFinite())
        require(x % PI != 0.0)
        return abs(x) % (PI)
    }

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double, precision: Double): Double {
        val x = prepare(param)
        val result = cos.calc(param, precision) / sin.calc(param, precision)
        return if (abs(x) <= PI / 2) result else -result
    }
}

fun main() {
    println(Cot().calc(5*PI, 0.0000001))
    println(Cot().calc(2*PI/3, 0.0000001))
    println(Cot().calc(PI/3, 0.0000001))
    println(Cot().calc(5*PI/6, 0.0000001))
    println(Cot().calc(PI/6, 0.0000001))
}
