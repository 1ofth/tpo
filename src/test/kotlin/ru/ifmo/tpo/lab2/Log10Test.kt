package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab2.Ln
import ru.itmo.tpo.lab2.Log10

class Log10Test {
    private lateinit var function: Log10

    @Test
    fun t1() {
        function = Log10(lnStub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t2() {
        function = Log10(Ln())
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }
}