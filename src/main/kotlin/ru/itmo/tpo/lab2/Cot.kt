package ru.itmo.tpo.lab2

import kotlin.math.PI

class Cot(
    private val cos: Cos,
    private val sin: Sin
) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        require(param % PI != 0.0)
        return cos.calc(param) / sin.calc(param)
    }
}

fun main() {
    val cot = Cot(Cos(), Sin(Cos()))
    println(cot.calc(0.0))
//    println(cot.calc(2 * PI / 3))
//    println(cot.calc(PI / 3))
//    println(cot.calc(5 * PI / 6))
//    println(cot.calc(PI / 6))
}
