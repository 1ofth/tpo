package ru.itmo.tpo.lab2

import kotlin.math.pow

class TrigonometricExpr(
    private val cot: Cot,
    private val csc: Csc,
    private val cos: Cos,
    private val sin: Sin,
    private val sec: Sec
) {

    @Throws(IllegalArgumentException::class)
    fun calc(x: Double): Double {
        require(x <= 0)

        val firstPart = ((cot.calc(x) * csc.calc(x)).pow(2)).pow(2) + cot.calc(x)
        val secondPartNumerator = sin.calc(x) / ((sec.calc(x) + cos.calc(x)) - sec.calc(x))
        val secondPartDenominator = (cos.calc(x) + sin.calc(x)) * cot.calc(x) - csc.calc(x)

        return firstPart - secondPartNumerator / secondPartDenominator
    }
}