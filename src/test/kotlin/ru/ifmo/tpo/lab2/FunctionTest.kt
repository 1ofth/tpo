package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab2.ComplexExpr
import ru.itmo.tpo.lab2.LogExpr
import ru.itmo.tpo.lab2.TrigonometricExpr

class FunctionTest {
    private lateinit var function: ComplexExpr

    @Test
    fun t1() {
        function = ComplexExpr(trigExprStub, logExprStub)
        assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t2() {
        function = ComplexExpr(TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub), logExprStub)
        assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t3() {
        function = ComplexExpr(trigExprStub, LogExpr(log3Stub, log5Stub, log10Stub))
        assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t4() {
        function = ComplexExpr(TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub), LogExpr(log3Stub, log5Stub, log10Stub))
        assertEquals(-0.03838195, function.calc(2.0))
    }

}
