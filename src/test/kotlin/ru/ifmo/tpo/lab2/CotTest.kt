package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.itmo.tpo.lab2.Cos
import ru.itmo.tpo.lab2.Cot
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.Sin
import java.util.stream.Stream

class CotTest {

    private lateinit var function: Cot

    @ParameterizedTest(name = "cot expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `all stubbed`(param: Double, expectedResult: Double) {
        function = Cot(cosStub, sinStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "cot expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `cos not stubbed`(param: Double, expectedResult: Double) {
        function = Cot(Cos(), sinStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "cot expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `sin not stubbed`(param: Double, expectedResult: Double) {
        function = Cot(cosStub, Sin(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "cot expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = Cot(Cos(), Sin(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    companion object {
        @JvmStatic
        fun getTestValues(): Stream<Arguments> {
            return cotTestData.mapNotNull { Arguments.of(it.key, it.value) }.stream()
        }
    }
}
