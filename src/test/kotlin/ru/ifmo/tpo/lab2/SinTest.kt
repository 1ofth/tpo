package ru.ifmo.tpo.lab2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyDouble
import org.mockito.InjectMocks
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension
import ru.itmo.tpo.lab2.*
import kotlin.math.cos
import kotlin.math.sin

@ExtendWith(MockitoExtension::class)
class SinTest {
    private val myCosMock: Cos = mock(Cos::class.java)

    @InjectMocks
    val mySin: Sin = Sin(myCosMock, DEFAULT_PRECISION)

    @Test
    fun testSuccess() {
        `when`(myCosMock.calc(anyDouble())).thenReturn(cos(1.0))
        assertEquals(sin(1.0), mySin.calc(1.0), DEFAULT_PRECISION)
    }
}
