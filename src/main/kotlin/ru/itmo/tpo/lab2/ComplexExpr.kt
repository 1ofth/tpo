package ru.itmo.tpo.lab2

class ComplexExpr {
    val firstExpr = TrigonometricExpr()
    val secondExpr = LogExpr()

    @Throws(IllegalArgumentException::class)
    fun compute(x: Double, eps: Double): Double {
        return if (x <= 0) {
            firstExpr.compute(x, eps)
        } else {
            secondExpr.compute(x, eps)
        }
    }
}
