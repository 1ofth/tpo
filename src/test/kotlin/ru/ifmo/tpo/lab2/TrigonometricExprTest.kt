package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.*

class TrigonometricExprTest {

    private lateinit var function: TrigonometricExpr

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @CsvSource()
    fun `all stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @CsvSource()
    fun `cot not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(Cot(cosStub, sinStub), cscStub, cosStub, sinStub, secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @CsvSource()
    fun `csc not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, Csc(sinStub), cosStub, sinStub, secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @CsvSource()
    fun `cos not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, cscStub, Cos(), sinStub, secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @CsvSource()
    fun `sin not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, Sin(cosStub), secStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @CsvSource()
    fun `sec not stubbed`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(cotStub, cscStub, cosStub, sinStub, Sec(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "trigonometric expr({0}) = {1}")
    @CsvSource()
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = TrigonometricExpr(Cot(cosStub, sinStub), Csc(sinStub), Cos(), Sin(cosStub), Sec(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }


}