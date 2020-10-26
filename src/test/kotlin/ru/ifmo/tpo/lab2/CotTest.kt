package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab2.Cos
import ru.itmo.tpo.lab2.Cot
import ru.itmo.tpo.lab2.Sin

class CotTest {

    private lateinit var function: Cot

    @Test
    fun t1() {
        function = Cot(cosStub, sinStub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t2() {
        function = Cot(Cos(), sinStub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t3() {
        function = Cot(cosStub, Sin(cosStub))
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t4() {
        function = Cot(Cos(), Sin(cosStub))
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }
}