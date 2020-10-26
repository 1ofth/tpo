package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import ru.itmo.tpo.lab2.*
import java.util.stream.Stream

class TrigonometricExprTest {

    private lateinit var function: TrigonometricExpr

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `all stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `cot not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(Cot(cosStub, sinStub), cscStub, cosStub, sinStub, secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `csc not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, Csc(sinStub), cosStub, sinStub, secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `cos not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, cscStub, Cos(), sinStub, secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `sin not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, Sin(cosStub), secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `sec not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, Sec(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(Cot(cosStub, sinStub), Csc(sinStub), Cos(), Sin(cosStub), Sec(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    companion object {
        @JvmStatic
        fun getTestValues(): Stream<Arguments> {
            return trigExprTestData.mapNotNull { Arguments.of(it.key, it.value) }.stream()
        }
    }

}