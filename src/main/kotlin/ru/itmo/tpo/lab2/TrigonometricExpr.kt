package ru.itmo.tpo.lab2

import kotlin.math.pow

class TrigonometricExpr(
    private val cot: Cot,
    private val csc: Csc,
    private val cos: Cos,
    private val sin: Sin,
    private val sec: Sec
) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        require(param <= 0)

        val firstPart = ((cot.calc(param) * csc.calc(param)).pow(2)).pow(2) + cot.calc(param)
        val secondPartNumerator = sin.calc(param) / ((sec.calc(param) + cos.calc(param)) - sec.calc(param))
        val secondPartDenominator = (cos.calc(param) + sin.calc(param)) * cot.calc(param) - csc.calc(param)

        return firstPart - secondPartNumerator / secondPartDenominator
    }
}
