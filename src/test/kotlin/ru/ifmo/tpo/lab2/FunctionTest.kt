package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab2.ComplexExpr
import ru.itmo.tpo.lab2.TrigonometricExpr

class FunctionTest {
    private lateinit var function: ComplexExpr

    @Test
    fun t1() {
        // all modules stubbed
        // here should be parametrized test
        function = ComplexExpr(trigExprStub, logExprStub)
        assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t2() {
        // logExpr module stubbed
        // here should be parametrized test
        function = ComplexExpr(TrigonometricExpr(), logExprStub)
        assertEquals(-0.03838195, function.calc(2.0))
    }

}
