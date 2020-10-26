package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab2.*

class LogExprTest {
    private lateinit var function: LogExpr

    @Test
    fun t1() {
        function = LogExpr(log3Stub, log5Stub, log10Stub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t2() {
        function = LogExpr(Log3(lnStub), log5Stub, log10Stub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t3() {
        function = LogExpr(log3Stub, Log5(lnStub), log10Stub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t4() {
        function = LogExpr(log3Stub, log5Stub, Log10(lnStub))
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t5() {
        function = LogExpr(Log3(lnStub), Log5(lnStub), Log10(lnStub))
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

}