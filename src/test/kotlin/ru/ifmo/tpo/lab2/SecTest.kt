package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab2.Cos
import ru.itmo.tpo.lab2.Sec

class SecTest {
    private lateinit var function: Sec

    @Test
    fun t1() {
        function = Sec(cosStub)
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }

    @Test
    fun t2() {
        function = Sec(Cos())
        Assertions.assertEquals(-0.03838195, function.calc(2.0))
    }
}