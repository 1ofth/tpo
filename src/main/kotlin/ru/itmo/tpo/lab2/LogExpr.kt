package ru.itmo.tpo.lab2

import kotlin.math.pow

class LogExpr(
    private val log3: Log3,
    private val log5: Log5,
    private val log10: Log10
) {

    @Throws(IllegalArgumentException::class)
    fun calc(x: Double): Double {
        require(x > 0)
        val firstPart = (((log5.calc(x) * log5.calc(x)) / log3.calc(x)).pow(2)).pow(3)
        val secondPart =  (log10.calc(x).pow(2)) * log5.calc(x)

        return firstPart - secondPart
    }

}

fun main() {
    val ln = Ln(0.000001)
    val l = LogExpr(Log3(ln), Log5(ln), Log10(ln))
    print(l.calc(2.0))
}