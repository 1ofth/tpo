package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.*

class SinTest {
    private lateinit var function: Sin

    @ParameterizedTest(name = "sin expr({0}) = {1}")
    @CsvSource()
    fun `cos stubbed`(param: Double, expectedResult: Double) {
        function = Sin(cosStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "sin expr({0}) = {1}")
    @CsvSource()
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = Sin(Cos())
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }
}
