package ru.itmo.tpo.lab2

class ComplexExpr(precision: Double) {
    val firstExpr = TrigonometricExpr(precision)
    val secondExpr = LogExpr(precision)

    @Throws(IllegalArgumentException::class)
    fun calc(x: Double): Double {
        return if (x <= 0) {
            firstExpr.calc(x)
        } else {
            secondExpr.calc(x)
        }
    }
}
