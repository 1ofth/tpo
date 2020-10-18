package ru.itmo.tpo.lab2

import kotlin.math.pow

class TrigonometricExpr {
    val cot = Cot()
    val csc = Csc()
    val sin = Sin()
    val sec = Sec()
    val cos = Cos()

    @Throws(IllegalArgumentException::class)
    fun compute(x: Double, eps: Double): Double {
        require(x <= 0)

        val firstPart = ((cot.calc(x, eps) * csc.calc(x, eps)).pow(2)).pow(2) + cot.calc(x, eps)
        val secondPartNumerator = sin.calc(x, eps) / ((sec.calc(x, eps) + cos.calc(x, eps)) - sec.calc(x, eps))
        val secondPartDenominator = (cos.calc(x, eps) + sin.calc(x, eps)) * cot.calc(x, eps) - csc.calc(x, eps)

        return firstPart - secondPartNumerator / secondPartDenominator
    }
}