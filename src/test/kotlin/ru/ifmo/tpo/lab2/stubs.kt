package ru.ifmo.tpo.lab2

import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import ru.itmo.tpo.lab2.*


val logExprStub: LogExpr = mock(LogExpr::class.java).apply {
    `when`(this.calc(2.0)).thenReturn(-0.03838195)
    // ....
}

val trigExprStub: TrigonometricExpr = mock(TrigonometricExpr::class.java).apply {

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
    `when`(this.calc(0.02)).thenReturn(-3.5608767950073115)
    `when`(this.calc(0.1)).thenReturn(-2.0959032742893844)
    `when`(this.calc(0.2)).thenReturn(-1.4649735207179269)
    `when`(this.calc(0.3)).thenReturn(-1.0959032742893846)
    `when`(this.calc(0.4)).thenReturn(-0.8340437671464696)
    `when`(this.calc(0.5)).thenReturn(-0.6309297535714574)
    `when`(this.calc(0.55)).thenReturn(-0.5441746892167039)
    `when`(this.calc(0.6)).thenReturn(-0.4649735207179272)
    `when`(this.calc(0.7)).thenReturn(-0.32465952512796237)
    `when`(this.calc(0.8)).thenReturn(-0.20311401357501224)
    `when`(this.calc(0.9)).thenReturn(-0.09590327428938458)
    `when`(this.calc(1.0)).thenReturn(0.0)
    `when`(this.calc(1.05)).thenReturn(0.04441072130058025)
    `when`(this.calc(1.1)).thenReturn(0.08675506435475354)
    `when`(this.calc(1.15)).thenReturn(0.127216802339429)
    `when`(this.calc(1.2)).thenReturn(0.16595623285353023)
    `when`(this.calc(1.3)).thenReturn(0.23881424518340807)
    `when`(this.calc(1.5)).thenReturn(0.3690702464285425)
    `when`(this.calc(1.75)).thenReturn(0.5093842420185073)
    `when`(this.calc(1.8)).thenReturn(0.5350264792820728)
    `when`(this.calc(1.9)).thenReturn(0.5842405849569906)
    `when`(this.calc(2.0)).thenReturn(0.6309297535714574)
    `when`(this.calc(2.0884971449233825358269495952366013421428061969691576000370777169)).thenReturn(0.6703408886864701)
    `when`(this.calc(2.1)).thenReturn(0.6753404748720376)
    `when`(this.calc(2.5)).thenReturn(0.8340437671464697)
    `when`(this.calc(3.0)).thenReturn(1.0)
    `when`(this.calc(5.0)).thenReturn(1.4649735207179269)
    `when`(this.calc(10.0)).thenReturn(2.095903274289385)
    `when`(this.calc(20.0)).thenReturn(2.7268330278608417)
    `when`(this.calc(100.0)).thenReturn(4.19180654857877)
}

val log5Stub: Log5 = mock(Log5::class.java).apply {
    `when`(this.calc(0.02)).thenReturn(-2.4306765580733933)
    `when`(this.calc(100.0)).thenReturn(2.8613531161467867)
    `when`(this.calc(20.0)).thenReturn(1.8613531161467862)
    `when`(this.calc(10.0)).thenReturn(1.4306765580733933)
    `when`(this.calc(5.0)).thenReturn(1.0)
    `when`(this.calc(3.0)).thenReturn(0.6826061944859854)
    `when`(this.calc(2.5)).thenReturn(0.569323441926607)
    `when`(this.calc(2.1)).thenReturn(0.4609915915347598)
    `when`(this.calc(2.0884971449233825358269495952366013421428061969691576000370777169)).thenReturn(0.45757884303462487)
    `when`(this.calc(2.0)).thenReturn(0.43067655807339306)
    `when`(this.calc(1.9)).thenReturn(0.39880624236175743)
    `when`(this.calc(1.8)).thenReturn(0.36521238897197067)
    `when`(this.calc(1.75)).thenReturn(0.34770883897538146)
    `when`(this.calc(1.5)).thenReturn(0.25192963641259225)
    `when`(this.calc(1.3)).thenReturn(0.16301608309368926)
    `when`(this.calc(1.2)).thenReturn(0.11328275255937834)
    `when`(this.calc(1.15)).thenReturn(0.08683897731959343)
    `when`(this.calc(1.1)).thenReturn(0.05921954433158507)
    `when`(this.calc(1.05)).thenReturn(0.030315033461366776)
    `when`(this.calc(1.0)).thenReturn(0.0)
    `when`(this.calc(0.9)).thenReturn(-0.06546416910142246)
    `when`(this.calc(0.8)).thenReturn(-0.1386468838532139)
    `when`(this.calc(0.7)).thenReturn(-0.22161460295122554)
    `when`(this.calc(0.6)).thenReturn(-0.31739380551401475)
    `when`(this.calc(0.55)).thenReturn(-0.371457013741808)
    `when`(this.calc(0.5)).thenReturn(-0.43067655807339306)
    `when`(this.calc(0.4)).thenReturn(-0.5693234419266069)
    `when`(this.calc(0.3)).thenReturn(-0.7480703635874079)
    `when`(this.calc(0.2)).thenReturn(-1.0)
    `when`(this.calc(0.1)).thenReturn(-1.430676558073393)
}

val log10Stub: Log10 = mock(Log10::class.java).apply {
    `when`(this.calc(0.02)).thenReturn(-1.6989700043360185)
    `when`(this.calc(100.0)).thenReturn(2.0)
    `when`(this.calc(20.0)).thenReturn(1.301029995663981)
    `when`(this.calc(10.0)).thenReturn(1.0)
    `when`(this.calc(5.0)).thenReturn(0.6989700043360187)
    `when`(this.calc(3.0)).thenReturn(0.47712125471966244)
    `when`(this.calc(2.5)).thenReturn(0.3979400086720376)
    `when`(this.calc(2.1)).thenReturn(0.32221929473391925)
    `when`(this.calc(2.0884971449233825358269495952366013421428061969691576000370777169)).thenReturn(0.3198338858999822)
    `when`(this.calc(2.0)).thenReturn(0.30102999566398114)
    `when`(this.calc(1.9)).thenReturn(0.2787536009528289)
    `when`(this.calc(1.8)).thenReturn(0.25527250510330607)
    `when`(this.calc(1.75)).thenReturn(0.24303804868629442)
    `when`(this.calc(1.5)).thenReturn(0.17609125905568124)
    `when`(this.calc(1.3)).thenReturn(0.11394335230683676)
    `when`(this.calc(1.2)).thenReturn(0.0791812460476248)
    `when`(this.calc(1.15)).thenReturn(0.06069784035361165)
    `when`(this.calc(1.1)).thenReturn(0.04139268515822507)
    `when`(this.calc(1.05)).thenReturn(0.02118929906993809)
    `when`(this.calc(1.0)).thenReturn(0.0)
    `when`(this.calc(0.9)).thenReturn(-0.045757490560675115)
    `when`(this.calc(0.8)).thenReturn(-0.09691001300805638)
    `when`(this.calc(0.7)).thenReturn(-0.1549019599857432)
    `when`(this.calc(0.6)).thenReturn(-0.22184874961635637)
    `when`(this.calc(0.55)).thenReturn(-0.2596373105057561)
    `when`(this.calc(0.5)).thenReturn(-0.30102999566398114)
    `when`(this.calc(0.4)).thenReturn(-0.39794000867203755)
    `when`(this.calc(0.3)).thenReturn(-0.5228787452803376)
    `when`(this.calc(0.2)).thenReturn(-0.6989700043360187)
    `when`(this.calc(0.1)).thenReturn(-0.9999999999999998)
}

val lnStub: Ln = mock(Ln::class.java).apply {
    `when`(this.calc(0.02)).thenReturn(-3.912023005428146)
    `when`(this.calc(0.1)).thenReturn(-2.3025850929940455)
    `when`(this.calc(0.2)).thenReturn(-1.6094379124341003)
    `when`(this.calc(0.3)).thenReturn(-1.2039728043259361)
    `when`(this.calc(0.4)).thenReturn(-0.916290731874155)
    `when`(this.calc(0.5)).thenReturn(-0.6931471805599453)
    `when`(this.calc(0.55)).thenReturn(-0.5978370007556204)
    `when`(this.calc(0.6)).thenReturn(-0.5108256237659907)
    `when`(this.calc(0.7)).thenReturn(-0.35667494393873245)
    `when`(this.calc(0.8)).thenReturn(-0.2231435513142097)
    `when`(this.calc(0.9)).thenReturn(-0.10536051565782628)
    `when`(this.calc(1.0)).thenReturn(0.0)
    `when`(this.calc(1.05)).thenReturn(0.04879016416943204)
    `when`(this.calc(1.1)).thenReturn(0.09531017980432493)
    `when`(this.calc(1.15)).thenReturn(0.13976194237515863)
    `when`(this.calc(1.2)).thenReturn(0.1823215567939546)
    `when`(this.calc(1.3)).thenReturn(0.26236426446749106)
    `when`(this.calc(1.5)).thenReturn(0.4054651081081644)
    `when`(this.calc(1.75)).thenReturn(0.5596157879354227)
    `when`(this.calc(1.8)).thenReturn(0.5877866649021191)
    `when`(this.calc(1.9)).thenReturn(0.6418538861723947)
    `when`(this.calc(2.0)).thenReturn(0.6931471805599453)
    `when`(this.calc(2.0884971449233825358269495952366013421428061969691576000370777169)).thenReturn(0.7364447379076575)
    `when`(this.calc(2.1)).thenReturn(0.7419373447293773)
    `when`(this.calc(2.5)).thenReturn(0.9162907318741551)
    `when`(this.calc(3.0)).thenReturn(1.0986122886681098)
    `when`(this.calc(5.0)).thenReturn(1.6094379124341003)
    `when`(this.calc(10.0)).thenReturn(2.302585092994046)
    `when`(this.calc(20.0)).thenReturn(2.995732273553991)
    `when`(this.calc(100.0)).thenReturn(4.605170185988092)
}


