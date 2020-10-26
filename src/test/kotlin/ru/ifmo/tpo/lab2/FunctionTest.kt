package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import ru.itmo.tpo.lab2.ComplexExpr
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.LogExpr
import ru.itmo.tpo.lab2.TrigonometricExpr
import java.util.stream.Stream

class FunctionTest {
    private lateinit var function: ComplexExpr

    @ParameterizedTest(name = "full system({0}) = {1}")
    @MethodSource("getTestValues")
    fun `all stubbed`(param: Double, expectedResult: Double) {
        function = ComplexExpr(trigExprStub, logExprStub)
        assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "full system({0}) = {1}")
    @MethodSource("getTestValues")
    fun `log expr stubbed`(param: Double, expectedResult: Double) {
        function = ComplexExpr(TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub), logExprStub)
        assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "full system({0}) = {1}")
    @MethodSource("getTestValues")
    fun `trigonometry expr stubbed`(param: Double, expectedResult: Double) {
        function = ComplexExpr(trigExprStub, LogExpr(log3Stub, log5Stub, log10Stub))
        assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "full system({0}) = {1}")
    @MethodSource("getTestValues")
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = ComplexExpr(
            TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub),
            LogExpr(log3Stub, log5Stub, log10Stub)
        )
        assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    companion object {
        @JvmStatic
        private val systemTestData = mapOf(11110.0 to 1.0)

        @JvmStatic
        fun getTestValues(): Stream<Arguments> {
            return systemTestData.mapNotNull { of(it.key, it.value) }.stream()
        }
    }
}
