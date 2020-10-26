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

fun main() {
    val ln = Ln()
    val log3 = Log3(ln)
    val log5 = Log5(ln)
    val log10 = Log10(ln)
    val cos = Cos()
    val sin = Sin(cos)
    val cot = Cot(cos, sin)
    val csc = Csc(sin)
    val sec = Sec(cos)
    ComplexExpr(
        TrigonometricExpr(cot, csc, cos, sin, sec),
        LogExpr(log3, log5, log10)
    ).printCsv("sys.out", -10.0, 0.1, 10.0)
}