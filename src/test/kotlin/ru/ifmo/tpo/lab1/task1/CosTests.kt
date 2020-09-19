package ru.ifmo.tpo.lab1.task1

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab1.task1.cos
import kotlin.math.abs


class CosTests {

    @Test
    @DisplayName("cos(0) = 1.0")
    fun cos0() {
        assert(abs(cos(0.0, DEFAULT_PRECISION) - 1.0) <= DEFAULT_PRECISION) {
            "cos(0) should be equal 1.0"
        }
    }

    @ParameterizedTest(name = "cos({0}) = {2}")
    @CsvSource("pi/3, 1.0471975512,  0.5", "pi, 3.14159265359, -1")
    fun `test values from table of cos `(paramReadable: String, param: Double, expectedResult: Double) {
        assert(abs(cos(param, DEFAULT_PRECISION) - expectedResult) <= DEFAULT_PRECISION) {
            "cos($paramReadable) should be equal $expectedResult"
        }
    }

    companion object {
        const val DEFAULT_PRECISION = 0.000001
    }

}