package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.Ln
import ru.itmo.tpo.lab2.Log10

class Log10Test {
    private lateinit var function: Log10

    @ParameterizedTest(name = "log10 expr({0}) = {1}")
    @CsvSource()
    fun `ln stubbed`(param: Double, expectedResult: Double) {
        function = Log10(lnStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "log10 expr({0}) = {1}")
    @CsvSource()
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = Log10(Ln())
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }
}