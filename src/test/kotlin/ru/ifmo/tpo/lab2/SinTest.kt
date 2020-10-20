package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import ru.itmo.tpo.lab2.*
import kotlin.math.sin

@ExtendWith(MockitoExtension::class)
class SinTest {

    @InjectMocks
    val mySin: Sin = Sin(cosStub)

    @Test
    fun testSuccess() {
        assertEquals(sin(1.0), mySin.calc(1.0), DEFAULT_PRECISION)
    }
}
