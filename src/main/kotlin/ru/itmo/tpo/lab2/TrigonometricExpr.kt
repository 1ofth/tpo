package ru.itmo.tpo.lab2

import kotlin.math.pow

class TrigonometricExpr(precision: Double) {
    val cot = Cot(precision)
    val csc = Csc(precision)
    val sin = Sin(precision)
    val sec = Sec(precision)
    val cos = Cos(precision)

    @Throws(IllegalArgumentException::class)
    fun calc(x: Double): Double {
        require(x <= 0)

        val firstPart = ((cot.calc(x) * csc.calc(x)).pow(2)).pow(2) + cot.calc(x)
        val secondPartNumerator = sin.calc(x) / ((sec.calc(x) + cos.calc(x)) - sec.calc(x))
        val secondPartDenominator = (cos.calc(x) + sin.calc(x)) * cot.calc(x) - csc.calc(x)

        return firstPart - secondPartNumerator / secondPartDenominator
    }
}