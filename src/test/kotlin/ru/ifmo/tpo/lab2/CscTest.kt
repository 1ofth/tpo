package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import ru.itmo.tpo.lab2.*
import java.util.stream.Stream


class CscTest {

    private lateinit var function: Csc

    @ParameterizedTest(name = "csc expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `sin stubbed`(param: Double, expectedResult: Double) {
        function = Csc(sinStub)
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "csc expr({0}) = {1}")
    @MethodSource("getTestValues")
    fun `without stub`(param: Double, expectedResult: Double) {
        function = Csc(Sin(cosStub))
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "IEA csc({0})")
    @CsvSource("0.0", "3.14159265359", "-31.4159265359")
    fun `test IAE`(param: Double) {
        function = Csc(Sin(cosStub))
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            function.calc(param)
        }
    }

    companion object {
        @JvmStatic
        fun getTestValues(): Stream<Arguments> {
            return cscTestData.mapNotNull { Arguments.of(it.key, it.value) }.stream()
        }
    }
}
