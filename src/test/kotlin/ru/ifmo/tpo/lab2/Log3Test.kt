package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.Ln
import ru.itmo.tpo.lab2.Log3
import java.util.stream.Stream

class Log3Test {

    private lateinit var function: Log3

    @ParameterizedTest(name = "log3 expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `ln stubbed`(param: Double, expectedResult: Double) {
        function = Log3(lnStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "log3 expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `without stub`(param: Double, expectedResult: Double) {
        function = Log3(Ln())
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    companion object {
        @JvmStatic
        fun getTestValues(): Stream<Arguments> {
            return log3TestData.mapNotNull { Arguments.of(it.key, it.value) }.stream()
        }
    }
}