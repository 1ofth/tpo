package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.itmo.tpo.lab2.Cos
import ru.itmo.tpo.lab2.DEFAULT_PRECISION
import ru.itmo.tpo.lab2.Sec
import java.util.stream.Stream

class SecTest {
    private lateinit var function: Sec

    @ParameterizedTest(name = "sec expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `cos stubbed`(param: Double, expectedResult: Double) {
        function = Sec(cosStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "sec expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `without stubs`(param: Double, expectedResult: Double) {
        function = Sec(Cos())
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    companion object {
        @JvmStatic
        fun getTestValues(): Stream<Arguments> {
            return secTestData.mapNotNull { Arguments.of(it.key, it.value) }.stream()
        }
    }
}
