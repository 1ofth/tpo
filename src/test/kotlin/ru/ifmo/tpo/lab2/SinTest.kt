package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import ru.itmo.tpo.lab2.*
import java.util.stream.Stream

class SinTest {
    private lateinit var function: Sin

    @ParameterizedTest(name = "sin expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `cos stubbed`(param: Double, expectedResult: Double) {
        function = Sin(cosStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "sin expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = Sin(Cos())
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    companion object {
        @JvmStatic
        fun getTestValues(): Stream<Arguments> {
            return sinTestData.mapNotNull { Arguments.of(it.key, it.value) }.stream()
        }
    }
}
