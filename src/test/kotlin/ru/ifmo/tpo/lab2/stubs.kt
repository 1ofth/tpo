package ru.ifmo.tpo.lab2

import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import ru.itmo.tpo.lab2.*


val logExprTestData = mapOf(0.1 to 2.298177825, 1.0 to 0.0,
        1.15 to -0.0003198911944, 2.283 to -0.06408018395, 8.664 to -0.5898652502, 15.1 to -0.01482795675,
        15.187 to -0.000005706433244, 15.3 to 0.01949345212)
val logExprStub = mock(LogExpr::class.java).apply {
    logExprTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val trigExprTestData = mapOf(-5.6 to 9.935287128, -5.2 to 5.204563109, -5.107 to 4.915328871, -5.0 to 5.311095369,
        -4.1 to -1.181150345, -4.001 to -0.007715186586, -3.9 to 3.821331351, -2.2 to -4.859889701,
        -2.038 to -3.874125114, -1.8 to -5.504093972, -1.1 to 1.058410083, -0.995 to 0.8232738581,
        -0.8 to 3.116791055, 0.0 to 5.16805E+114)
val trigExprStub = mock(TrigonometricExpr::class.java).apply {
    trigExprTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val cosTestData = mapOf(-5.6 to 0.7755658785, -5.2 to 0.4685166713, -5.107 to 0.3844491321, -5.0 to 0.2836621855,
        -4.1 to -0.5748239465, -4.001 to -0.6528864917, -3.9 to -0.7259323042, -2.2 to -0.5885011173,
        -2.038 to -0.4503914017, -1.8 to -0.2272020947, -1.1 to 0.4535961214, -0.995 to 0.5445028895,
        -0.8 to 0.6967067093, 0.0 to 1.0, 0.1 to 0.9950041653,
        1.15 to 0.4084874409, 2.283 to -0.6535033687, 8.664 to -0.7242998376, 15.1 to -0.8208130945,
        15.187 to -0.8673401484, 15.3 to -0.9179307804)

val cosStub = mock(Cos::class.java).apply {
    cosTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val cotTestData = mapOf(-5.6 to 1.228586832, -5.2 to 0.5303233938, -5.107 to 0.4164553151, -5.0 to 0.2958129155,
        -4.1 to -0.702480784, -4.001 to -0.8619466981, -3.9 to -1.055492909, -2.2 to 0.727895776,
        -2.038 to 0.5044530166, -1.8 to 0.2333035349, -1.1 to -0.5089681052, -0.995 to -0.6491768332,
        -0.8 to -0.9712146007, 0.0 to -218356345569479.0, 0.1 to 9.966644423, 1.15 to 0.4475280222,
        2.283 to -0.8633676669, 8.664 to -1.050493775, 15.1 to -1.43700559, 15.187 to -1.742641206,
        15.3 to -2.313680129)

val cotStub = mock(Cot::class.java).apply {
    cotTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val cscTestData = mapOf(-5.6 to 1.584116663, -5.2 to 1.131920007, -5.107 to 1.083252062, -5.0 to 1.042835213,
        -4.1 to 1.222079888, -4.001 to 1.320209116, -3.9 to 1.453982559, -2.2 to -1.236863881,
        -2.038 to -1.12003252, -1.8 to -1.026854683, -1.1 to -1.122073319, -0.995 to -1.192237628,
        -0.8 to -1.394007819, 0.0 to -218356345569479.0, 0.1 to 10.01668613, 1.15 to 1.095573517,
        2.283 to 1.321137286, 8.664 to 1.450357601, 15.1 to 1.750709875, 15.187 to 2.009178532, 15.3 to 2.52053878)

val cscStub = mock(Csc::class.java).apply {
    cscTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val secTestData = mapOf(-5.6 to 1.289381119, -5.2 to 2.134395767, -5.107 to 2.601124353, -5.0 to 3.525320086,
        -4.1 to -1.739663085, -4.001 to -1.53165981,
        -3.9 to -1.377538917, -2.2 to -1.699232118, -2.038 to -2.220291054, -1.8 to -4.401367872,
        -1.1 to 2.204604389, -0.995 to 1.836537545, -0.8 to 1.4353242, 0.0 to 1.0, 0.1 to 1.005020918,
        1.15 to 2.44805568, 2.283 to -1.530213994, 8.664 to -1.380643689, 15.1 to -1.218304151,
        15.187 to -1.152950203, 15.3 to -1.089406763)

val secStub = mock(Sec::class.java).apply {
    secTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val sinTestData = mapOf(-5.6 to 0.6312666379, -5.2 to 0.8834546557, -5.107 to 0.9231461774, -5.0 to 0.9589242747,
        -4.1 to 0.8182771111, -4.001 to 0.7574557604, -3.9 to 0.6877661592, -2.2 to -0.8084964038,
        -2.038 to -0.8928312188,  -1.8 to -0.9738476309, -1.1 to -0.8912073601 , -0.995 to -0.8387589662,
        -0.8 to -0.7173560909, 0.0 to 0.0, 0.1 to 0.09983341665, 1.15 to 0.9127639403, 2.283 to 0.7569236072,
        8.664 to 0.6894851306, 15.1 to 0.5711968697, 15.187 to 0.4977158496, 15.3 to 0.3967405731)

val sinStub = mock(Sin::class.java).apply {
    sinTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val lnTestData = mapOf(0.1 to -2.302585093, 1.0 to 0.0, 1.15 to 0.1397619424, 2.283 to 0.8254903675,
        8.664 to 2.15917651, 15.1 to 2.714694744, 15.187 to 2.720439799, 15.3 to 2.727852828)

val lnStub = mock(Ln::class.java).apply {
    lnTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val log10TestData = mapOf(0.1 to -1.0, 1.0 to 0.0, 1.15 to 0.06069784035, 2.283 to 0.3585059115,
        8.664 to 0.9377184436, 15.1 to 1.178976947, 15.187 to 1.181471993, 15.3 to 1.184691431)

val log10Stub = mock(Log10::class.java).apply {
    log10TestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val log5TestData = mapOf(0.1 to -1.430676558, 1.0 to 0.0, 1.15 to 0.08683897732, 2.283 to 0.5129060035,
        8.664 to 1.341571795, 15.1 to 1.686734681, 15.187 to 1.690304284, 15.3 to 1.694910259)

val log5Stub = mock(Log5::class.java).apply {
    log5TestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val log3TestData = mapOf(0.1 to -2.095903274, 1.0 to 0.0, 1.15 to 0.1272168023, 2.283 to 0.7513937137,
        8.664 to 1.965367156, 15.1 to 2.471021644, 15.187 to 2.476251018, 15.3 to 2.482998649)

val log3Stub = mock(Log3::class.java).apply {
    log3TestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}