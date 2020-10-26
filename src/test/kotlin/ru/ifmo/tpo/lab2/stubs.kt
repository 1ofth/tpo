package ru.ifmo.tpo.lab2

import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import ru.itmo.tpo.lab2.*

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

val cotStub: Cot = mock(Cot::class.java).apply {

}

val cscStub: Csc = mock(Csc::class.java).apply {

}

val sinStub: Sin = mock(Sin::class.java).apply {

}

val secStub: Sec = mock(Sec::class.java).apply {

}

val log3Stub: Log3 = mock(Log3::class.java).apply {

}

val log5Stub: Log5 = mock(Log5::class.java).apply {

}

val log10Stub: Log10 = mock(Log10::class.java).apply {

}

val lnStub: Ln = mock(Ln::class.java).apply {

}

