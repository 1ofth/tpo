package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.Cos
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.Sec

class SecTest {
    private lateinit var function: Sec

    @ParameterizedTest(name = "sec expr({0}) = {1}")
    @CsvSource()
    fun `cos stubbed`(param: Double, expectedResult: Double) {
        function = Sec(cosStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "sec expr({0}) = {1}")
    @CsvSource()
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = Sec(Cos())
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }
}