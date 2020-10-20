package ru.itmo.tpo.lab2

class ComplexExpr(
    private val tExpr: TrigonometricExpr,
    private val lExpr: LogExpr,
) {

    @Throws(IllegalArgumentException::class)
    fun calc(x: Double): Double {
        return if (x <= 0) {
            tExpr.calc(x)
        } else {
            lExpr.calc(x)
        }
    }
}
