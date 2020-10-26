package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.*

class LogExprTest {
    private lateinit var function: LogExpr

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @CsvSource()
    fun `all stubbed`(param: Double, expectedResult: Double) {
        function = LogExpr(log3Stub, log5Stub, log10Stub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @CsvSource()
    fun `log3 not stubbed`(param: Double, expectedResult: Double) {
        function = LogExpr(Log3(lnStub), log5Stub, log10Stub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @CsvSource()
    fun `log5 not stubbed`(param: Double, expectedResult: Double) {
        function = LogExpr(log3Stub, Log5(lnStub), log10Stub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @CsvSource()
    fun `log10 not stubbed`(param: Double, expectedResult: Double) {
        function = LogExpr(log3Stub, log5Stub, Log10(lnStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @CsvSource()
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = LogExpr(Log3(lnStub), Log5(lnStub), Log10(lnStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

}