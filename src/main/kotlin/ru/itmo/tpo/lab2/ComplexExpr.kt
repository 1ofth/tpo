package ru.itmo.tpo.lab2

class ComplexExpr(
    private val tExpr: TrigonometricExpr,
    private val lExpr: LogExpr,
) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        return if (param <= 0) {
            tExpr.calc(param)
        } else {
            lExpr.calc(param)
        }
    }
}
