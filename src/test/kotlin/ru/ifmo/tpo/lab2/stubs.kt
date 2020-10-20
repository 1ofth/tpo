package ru.ifmo.tpo.lab2

import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import ru.itmo.tpo.lab2.Cos
import ru.itmo.tpo.lab2.LogExpr
import ru.itmo.tpo.lab2.TrigonometricExpr

val logExprStub: LogExpr = mock(LogExpr::class.java).apply {
    `when`(this.calc(2.0)).thenReturn(-0.03838195)
    // ....
}

val trigExprStub: TrigonometricExpr = mock(TrigonometricExpr::class.java).apply {
    // ....
}

val cosStub: Cos = mock(Cos::class.java).apply {
    `when`(this.calc(2.0)).thenReturn(-0.416146)
    // ....
}
