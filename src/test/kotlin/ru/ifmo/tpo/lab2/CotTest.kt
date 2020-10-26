package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.Cos
import ru.itmo.tpo.lab2.Cot
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.Sin

class CotTest {

    private lateinit var function: Cot

    @ParameterizedTest(name = "cot expr({0}) = {1}")
    @CsvSource()
    fun `all stubbed`(param: Double, expectedResult: Double) {
        function = Cot(cosStub, sinStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "cot expr({0}) = {1}")
    @CsvSource()
    fun `cos not stubbed`(param: Double, expectedResult: Double) {
        function = Cot(Cos(), sinStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "cot expr({0}) = {1}")
    @CsvSource()
    fun `sin not stubbed`(param: Double, expectedResult: Double) {
        function = Cot(cosStub, Sin(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "cot expr({0}) = {1}")
    @CsvSource()
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = Cot(Cos(), Sin(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }
}