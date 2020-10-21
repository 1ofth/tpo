package ru.itmo.tpo.lab2

import kotlin.math.pow

class LogExpr(
    private val log3: Log3,
    private val log5: Log5,
    private val log10: Log10
) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        require(param > 0)
        val firstPart = (((log5.calc(param) * log5.calc(param)) / log3.calc(param)).pow(2)).pow(3)
        val secondPart =  (log10.calc(param).pow(2)) * log5.calc(param)

        return firstPart - secondPart
    }

}

fun main() {
    val ln = Ln(0.000001)
    val l = LogExpr(Log3(ln), Log5(ln), Log10(ln))
    print(l.calc(2.0))
}
