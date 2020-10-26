package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.ComplexExpr
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.LogExpr
import ru.itmo.tpo.lab2.TrigonometricExpr

class FunctionTest {
    private lateinit var function: ComplexExpr

    @ParameterizedTest(name = "full system({0}) = {1}")
    @CsvSource(
        "-1.0, 0.82404225", "-2.0, -3.9089476"
    )
    fun `all stubbed`(paramReadable: String, param: Double, expectedResult: Double) {
        function = ComplexExpr(trigExprStub, logExprStub)
        testTemplate(paramReadable, param, expectedResult)
    }

    @ParameterizedTest(name = "full system({0}) = {1}")
    @CsvSource(
        "-1.0, 0.82404225", "-2.0, -3.9089476"
    )
    fun `log expr stubbed`(paramReadable: String, param: Double, expectedResult: Double) {
        function = ComplexExpr(TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub), logExprStub)
        testTemplate(paramReadable, param, expectedResult)
    }

    @ParameterizedTest(name = "full system({0}) = {1}")
    @CsvSource(
        "-1.0, 0.82404225", "-2.0, -3.9089476"
    )
    fun `trigonometry expr stubbed`(paramReadable: String, param: Double, expectedResult: Double) {
        function = ComplexExpr(trigExprStub, LogExpr(log3Stub, log5Stub, log10Stub))
        testTemplate(paramReadable, param, expectedResult)
    }

    @ParameterizedTest(name = "full system({0}) = {1}")
    @CsvSource(
        "-1.0, 0.82404225", "-2.0, -3.9089476"
    )
    fun `without stubs`(paramReadable: String, param: Double, expectedResult: Double) {
        function = ComplexExpr(
            TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub),
            LogExpr(log3Stub, log5Stub, log10Stub)
        )
        testTemplate(paramReadable, param, expectedResult)
    }

    private fun testTemplate(paramReadable: String, param: Double, expectedResult: Double) {
        val actual = function.calc(param)
        assertEquals(
            actual - expectedResult, DEFAULT_PRECISION,
            "function with argument $paramReadable should be equal $expectedResult, but was $actual"
        )
    }

}
