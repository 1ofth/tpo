package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab2.*

class TrigonometricExprTest {

    private lateinit var function: TrigonometricExpr

    @Test
    fun t1() {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t2() {
        function = TrigonometricExpr(Cot(cosStub, sinStub), cscStub, cosStub, sinStub, secStub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t3() {
        function = TrigonometricExpr(cotStub, Csc(sinStub), cosStub, sinStub, secStub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t4() {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, Sin(cosStub), secStub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t5() {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, Sec(cosStub))
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t6() {
        function = TrigonometricExpr(cotStub, cscStub, Cos(), sinStub, secStub) //   Cos(???)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t7() {
        function = TrigonometricExpr(Cot(cosStub, sinStub), Csc(sinStub), Cos(), Sin(cosStub), Sec(cosStub)) //Cos(???)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }


}