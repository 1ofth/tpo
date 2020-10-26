package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.itmo.tpo.lab2.*

class LnTest {

    private var function: Ln = Ln()

    @ParameterizedTest(name = "ln expr({0}) = {1}")
    @CsvSource(
            "0.01, -4.605170",
            "0.13, -2.040221",
            "1.0, 0.0000000",
            "3.0, 1.098612",
            "0.07, -2.659260",
            "0.565, -0.570930",
            "2.0, 0.693147",
            "50.0, 3.912023")
    fun successValidation(param: Double, expectedResult: Double) {
        Assertions.assertEquals(expectedResult, function.calc(param), DEFAULT_PRECISION)
    }

    @ParameterizedTest(name = "IEA cot({0})")
    @CsvSource("0.0", "-1.0")
    fun `test IAE`(param: Double) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            function.calc(param)
        }
    }
}
