package ru.ifmo.tpo.lab1.task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab1.task1.cos
import kotlin.math.abs

class CosTests {

    @ParameterizedTest(name = "cos({0}) = 0.0")
    @CsvSource(
        "pi/2, 1.57079632679", "-pi/2, -1.57079632679",
        "pi/2 + 10pi, 32.9867228627", "pi/2 - 10pi, -29.8451302091"
    )
    fun `test cos x = 0 when x eq (pi div 2 + pi*k)`(paramReadable: String, param: Double) {
        template(paramReadable, param, 0.0)
    }

    @ParameterizedTest(name = "cos({0}) = 1.0")
    @CsvSource(
        "0, 0.0",
        "2pi, 6.28318530718", "-2pi, -6.28318530718",
        "10pi, 31.4159265359", "-10pi, -31.4159265359"
    )
    fun `test cos x = 1 when x eq (2pi*k)`(paramReadable: String, param: Double) {
        template(paramReadable, param, 1.0)
    }

    @ParameterizedTest(name = "cos({0}) = -1.0")
    @CsvSource(
        "pi, 3.14159265359", "-pi, -3.14159265359",
        "10pi/2, 15.7079632679", "-10pi/2, -15.7079632679"
    )
    fun `test cos x = -1 when x eq (pi + 2pi*k)`(paramReadable: String, param: Double) {
        template(paramReadable, param, -1.0)
    }

    @ParameterizedTest(name = "cos({0}) = {2}")
    @CsvSource(
        "-pi + 0.002, -3.13959265359, -0.999998",
        "-0.002, -0.002, 0.999998",
        "9pi + 0.002, 28.2763338823, -0.999998",
        "10pi - 0.002, 31.4139265359, 0.999998",
    )
    fun `test cos rising values`(paramReadable: String, param: Double, expectedResult: Double) {
        template(paramReadable, param, expectedResult)
    }

    @ParameterizedTest(name = "cos({0}) = {2}")
    @CsvSource(
        "0.002, 0.002, 0.999998",
        "pi - 0.002, 3.13959265359, -0.999998",
        "-10pi + 0.002, -31.4139265359, 0.999998",
        "-9pi - 0.002, -28.2763338823, -0.999998",
    )
    fun `test cos decreasing values`(paramReadable: String, param: Double, expectedResult: Double) {
        template(paramReadable, param, expectedResult)
    }

    @Test
    fun `test positive infinity`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            cos(Double.POSITIVE_INFINITY, DEFAULT_PRECISION)
        }
    }

    @Test
    fun `test negative infinity`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            cos(Double.NEGATIVE_INFINITY, DEFAULT_PRECISION)
        }
    }

    private fun template(paramReadable: String, param: Double, expectedResult: Double) {
        val actual = cos(param, DEFAULT_PRECISION)
        assert(abs(actual - expectedResult) <= DEFAULT_PRECISION) {
            "cos($paramReadable) should be equal $expectedResult, but was $actual"
        }
    }

    companion object {
        const val DEFAULT_PRECISION = 0.000001
    }
}