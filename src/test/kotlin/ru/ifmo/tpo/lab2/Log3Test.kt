package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.Ln
import ru.itmo.tpo.lab2.Log3

class Log3Test {

    private lateinit var function: Log3

    @ParameterizedTest(name = "log3 expr({0}) = {1}")
    @CsvSource()
    fun `ln stubbed`(param: Double, expectedResult: Double) {
        function = Log3(lnStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "log3 expr({0}) = {1}")
    @CsvSource()
    fun `without stub`(param: Double, expectedResult: Double) {
        function = Log3(Ln())
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

}