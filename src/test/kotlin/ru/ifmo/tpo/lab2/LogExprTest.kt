package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.itmo.tpo.lab2.*
import java.util.stream.Stream

class LogExprTest {
    private lateinit var function: LogExpr

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `all stubbed`(param: Double, expectedResult: Double) {
        function = LogExpr(log3Stub, log5Stub, log10Stub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `log3 not stubbed`(param: Double, expectedResult: Double) {
        function = LogExpr(Log3(lnStub), log5Stub, log10Stub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `log5 not stubbed`(param: Double, expectedResult: Double) {
        function = LogExpr(log3Stub, Log5(lnStub), log10Stub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `log10 not stubbed`(param: Double, expectedResult: Double) {
        function = LogExpr(log3Stub, log5Stub, Log10(lnStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "logarithmic expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = LogExpr(Log3(lnStub), Log5(lnStub), Log10(lnStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    companion object {
        @JvmStatic
        fun getTestValues(): Stream<Arguments> {
            return logExprTestData.mapNotNull { Arguments.of(it.key, it.value) }.stream()
        }
    }
}
