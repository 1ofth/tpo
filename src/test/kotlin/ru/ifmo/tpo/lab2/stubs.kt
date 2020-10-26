package ru.ifmo.tpo.lab2

import org.junit.jupiter.params.provider.Arguments
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import ru.itmo.tpo.lab2.*
import java.util.stream.Stream

class TestUtils {
    companion object {
        @JvmStatic
        fun getTestValues(testData: Map<Double, Double>): Stream<Arguments> {
            return testData.mapNotNull { Arguments.of(it.key, it.value) }.stream()
        }
    }
}
val logExprStub: LogExpr = mock(LogExpr::class.java).apply {
    `when`(this.calc(2.0)).thenReturn(-0.03838195)

}

val trigExprStub: TrigonometricExpr = mock(TrigonometricExpr::class.java).apply {

}
val cosTestData = mapOf(0.0 to 1.0, )

val cosStub2 = mock(Cos::class.java).apply {
    cosTestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}

val cosStub: Cos = mock(Cos::class.java).apply {
    `when`(this.calc(0.0)).thenReturn(1.0)
    `when`(this.calc(-0.4)).thenReturn(0.9210609940028851)
    `when`(this.calc(-0.7)).thenReturn(0.7648421872844885)
    `when`(this.calc(-1.15)).thenReturn(0.4084874408841574)
    `when`(this.calc(-1.2)).thenReturn(0.3623577544766736)
    `when`(this.calc(-1.25)).thenReturn(0.3153223623952687)
    `when`(this.calc(-1.3)).thenReturn(0.26749882862458735)
    `when`(this.calc(-1.4)).thenReturn(0.16996714290024104)
    `when`(this.calc(-1.5)).thenReturn(0.0707372016677029)
    `when`(this.calc(-1.7)).thenReturn(-0.12884449429552464)
    `when`(this.calc(-1.8)).thenReturn(-0.2272020946930871)
    `when`(this.calc(-1.9)).thenReturn(-0.32328956686350335)
    `when`(this.calc(-1.95)).thenReturn(-0.3701808313512869)
    `when`(this.calc(-2.1)).thenReturn(-0.5048461045998576)
    `when`(this.calc(-2.2)).thenReturn(-0.5885011172553458)
    `when`(this.calc(-2.5)).thenReturn(-0.8011436155469337)
    `when`(this.calc(-2.8)).thenReturn(-0.9422223406686581)
    `when`(this.calc(-3.1)).thenReturn(-0.9991351502732795)
    `when`(this.calc(-3.2)).thenReturn(-0.9982947757947531)
    `when`(this.calc(-3.5)).thenReturn(-0.9364566872907963)
    `when`(this.calc(-3.8)).thenReturn(-0.7909677119144168)
    `when`(this.calc(-4.2)).thenReturn(-0.4902608213406994)
    `when`(this.calc(-4.25)).thenReturn(-0.4460874899137928)
    `when`(this.calc(-4.3)).thenReturn(-0.40079917207997545)
    `when`(this.calc(-4.4)).thenReturn(-0.30733286997841935)
    `when`(this.calc(-4.5)).thenReturn(-0.2107957994307797)
    `when`(this.calc(-4.6)).thenReturn(-0.11215252693505487)
    `when`(this.calc(-4.8)).thenReturn(0.0874989834394464)
    `when`(this.calc(-4.9)).thenReturn(0.18651236942257576)
    `when`(this.calc(-5.0)).thenReturn(0.28366218546322625)
    `when`(this.calc(-5.1)).thenReturn(0.37797774271298024)
    `when`(this.calc(-5.15)).thenReturn(0.4237768176794282)
    `when`(this.calc(-5.2)).thenReturn(0.4685166713003771)
    `when`(this.calc(-5.3)).thenReturn(0.5543743361791608)
    `when`(this.calc(-5.4)).thenReturn(0.6346928759426347)
    `when`(this.calc(-5.5)).thenReturn(0.70866977429126)
    `when`(this.calc(-5.6)).thenReturn(0.7755658785102496)
    `when`(this.calc(-5.65)).thenReturn(0.8061468052647157)
    `when`(this.calc(-5.7)).thenReturn(0.8347127848391598)
    `when`(this.calc(-5.8)).thenReturn(0.8855195169413189)
    `when`(this.calc(-6.0)).thenReturn(0.960170286650366)
    `when`(this.calc(-6.2)).thenReturn(0.9965420970232175)
}

val cotStub: Cot = mock(Cot::class.java).apply {
    `when`(this.calc(0.0)).thenReturn(Double.NaN)
    `when`(this.calc(-6.2)).thenReturn(11.993612461171432)
    `when`(this.calc(-6.0)).thenReturn(3.436353004180128)
    `when`(this.calc(-5.8)).thenReturn(1.9059736612916494)
    `when`(this.calc(-5.7)).thenReturn(1.5157702904306112)
    `when`(this.calc(-5.65)).thenReturn(1.3623890119726703)
    `when`(this.calc(-5.6)).thenReturn(1.2285868315871835)
    `when`(this.calc(-5.5)).thenReturn(1.0044355348765333)
    `when`(this.calc(-5.4)).thenReturn(0.8213276957769762)
    `when`(this.calc(-5.3)).thenReturn(0.6661011930225427)
    `when`(this.calc(-5.2)).thenReturn(0.5303233938118341)
    `when`(this.calc(-5.15)).thenReturn(0.46786534000884855)
    `when`(this.calc(-5.1)).thenReturn(0.408265012348528)
    `when`(this.calc(-5.0)).thenReturn(0.2958129155327455)
    `when`(this.calc(-4.9)).thenReturn(0.1898436291236103)
    `when`(this.calc(-4.8)).thenReturn(0.08783586835282307)
    `when`(this.calc(-4.6)).thenReturn(-0.11286458921834393)
    `when`(this.calc(-4.5)).thenReturn(-0.21564123255279444)
    `when`(this.calc(-4.4)).thenReturn(-0.3229636403820003)
    `when`(this.calc(-4.3)).thenReturn(-0.4374744312171284)
    `when`(this.calc(-4.25)).thenReturn(-0.4984277028686865)
    `when`(this.calc(-4.2)).thenReturn(-0.5624993682225213)
    `when`(this.calc(-3.8)).thenReturn(-1.2927310795906135)
    `when`(this.calc(-3.5)).thenReturn(-2.669616484968866)
    `when`(this.calc(-3.2)).thenReturn(-17.101660378678684)
    `when`(this.calc(-3.1)).thenReturn(24.0288415769285)
    `when`(this.calc(-2.8)).thenReturn(2.812703494825543)
    `when`(this.calc(-2.5)).thenReturn(1.3386481283041514)
    `when`(this.calc(-2.2)).thenReturn(0.7278957760047939)
    `when`(this.calc(-2.1)).thenReturn(0.5848478064594647)
    `when`(this.calc(-1.95)).thenReturn(0.3984896496289347)
    `when`(this.calc(-1.9)).thenReturn(0.3416353554965469)
    `when`(this.calc(-1.8)).thenReturn(0.23330353485401106)
    `when`(this.calc(-1.7)).thenReturn(0.12992746433821378)
    `when`(this.calc(-1.5)).thenReturn(-0.07091484430265245)
    `when`(this.calc(-1.4)).thenReturn(-0.17247672583180007)
    `when`(this.calc(-1.3)).thenReturn(-0.27761564654112514)
    `when`(this.calc(-1.25)).thenReturn(-0.3322734172545286)
    `when`(this.calc(-1.2)).thenReturn(-0.38877956936820496)
    `when`(this.calc(-1.15)).thenReturn(-0.4475280221604361)
    `when`(this.calc(-0.7)).thenReturn(-1.1872418321266796)
    `when`(this.calc(-0.4)).thenReturn(-2.3652224200391103)

}

val cscStub: Csc = mock(Csc::class.java).apply {
    `when`(this.calc(0.0)).thenReturn(Double.NaN)
    `when`(this.calc(-6.2)).thenReturn(12.035229115757067)
    `when`(this.calc(-6.0)).thenReturn(3.5788995472544056)
    `when`(this.calc(-5.8)).thenReturn(2.1523790552636157)
    `when`(this.calc(-5.7)).thenReturn(1.815918382899435)
    `when`(this.calc(-5.65)).thenReturn(1.69000113016053)
    `when`(this.calc(-5.6)).thenReturn(1.5841166632383596)
    `when`(this.calc(-5.5)).thenReturn(1.4173534293614658)
    `when`(this.calc(-5.4)).thenReturn(1.2940553248800133)
    `when`(this.calc(-5.3)).thenReturn(1.2015368489339204)
    `when`(this.calc(-5.2)).thenReturn(1.1319200069015927)
    `when`(this.calc(-5.15)).thenReturn(1.104037126360158)
    `when`(this.calc(-5.1)).thenReturn(1.080129770123916)
    `when`(this.calc(-5.0)).thenReturn(1.0428352127714058)
    `when`(this.calc(-4.9)).thenReturn(1.0178607977119576)
    `when`(this.calc(-4.8)).thenReturn(1.0038501580262338)
    `when`(this.calc(-4.6)).thenReturn(1.0063490525157885)
    `when`(this.calc(-4.5)).thenReturn(1.022986383671302)
    `when`(this.calc(-4.4)).thenReturn(1.0508594163867944)
    `when`(this.calc(-4.3)).thenReturn(1.0915053265874382)
    `when`(this.calc(-4.25)).thenReturn(1.1173317211047737)
    `when`(this.calc(-4.2)).thenReturn(1.1473471746819859)
    `when`(this.calc(-3.8)).thenReturn(1.6343664350871603)
    `when`(this.calc(-3.5)).thenReturn(2.850763437540464)
    `when`(this.calc(-3.2)).thenReturn(17.13087235687863)
    `when`(this.calc(-3.1)).thenReturn(-24.049640902290573)
    `when`(this.calc(-2.8)).thenReturn(-2.9851802206573432)
    `when`(this.calc(-2.5)).thenReturn(-1.67092154555868)
    `when`(this.calc(-2.2)).thenReturn(-1.2368638812438584)
    `when`(this.calc(-2.1)).thenReturn(-1.1584675035237058)
    `when`(this.calc(-1.95)).thenReturn(-1.0764729447883914)
    `when`(this.calc(-1.9)).thenReturn(-1.056747233791152)
    `when`(this.calc(-1.8)).thenReturn(-1.026854682696328)
    `when`(this.calc(-1.7)).thenReturn(-1.0084052488902255)
    `when`(this.calc(-1.5)).thenReturn(-1.0025113042467249)
    `when`(this.calc(-1.4)).thenReturn(-1.0147651062948795)
    `when`(this.calc(-1.3)).thenReturn(-1.0378200456748015)
    `when`(this.calc(-1.25)).thenReturn(-1.053757858245433)
    `when`(this.calc(-1.2)).thenReturn(-1.0729163777098973)
    `when`(this.calc(-1.15)).thenReturn(-1.0955735167567862)
    `when`(this.calc(-0.4)).thenReturn(-2.567932455547783)

}

val secStub: Sec = mock(Sec::class.java).apply {
    `when`(this.calc(0.0)).thenReturn(1.0)
    `when`(this.calc(-6.2)).thenReturn(1.003469901559715)
    `when`(this.calc(-6.0)).thenReturn(1.0414819265951076)
    `when`(this.calc(-5.8)).thenReturn(1.1292805871225844)
    `when`(this.calc(-5.7)).thenReturn(1.198016872585328)
    `when`(this.calc(-5.65)).thenReturn(1.2404688494319944)
    `when`(this.calc(-5.6)).thenReturn(1.2893811186238053)
    `when`(this.calc(-5.5)).thenReturn(1.4110944706229345)
    `when`(this.calc(-5.4)).thenReturn(1.575565187359032)
    `when`(this.calc(-5.3)).thenReturn(1.8038353053861849)
    `when`(this.calc(-5.2)).thenReturn(2.1343957670161036)
    `when`(this.calc(-5.15)).thenReturn(2.3597326665387905)
    `when`(this.calc(-5.1)).thenReturn(2.6456584263993457)
    `when`(this.calc(-5.0)).thenReturn(3.5253200858160887)
    `when`(this.calc(-4.9)).thenReturn(5.361574693924608)
    `when`(this.calc(-4.8)).thenReturn(11.428704205369987)
    `when`(this.calc(-4.6)).thenReturn(-8.916428611359587)
    `when`(this.calc(-4.5)).thenReturn(-4.743927548368325)
    `when`(this.calc(-4.4)).thenReturn(-3.253801001078144)
    `when`(this.calc(-4.3)).thenReturn(-2.495015133914648)
    `when`(this.calc(-4.25)).thenReturn(-2.2417127191646906)
    `when`(this.calc(-4.2)).thenReturn(-2.039730601489498)
    `when`(this.calc(-3.8)).thenReturn(-1.2642741099755543)
    `when`(this.calc(-3.5)).thenReturn(-1.0678550471918107)
    `when`(this.calc(-3.2)).thenReturn(-1.00170813696174)
    `when`(this.calc(-3.1)).thenReturn(-1.0008655983392076)
    `when`(this.calc(-2.8)).thenReturn(-1.061320621298726)
    `when`(this.calc(-2.5)).thenReturn(-1.2482156514688179)
    `when`(this.calc(-2.2)).thenReturn(-1.6992321181373529)
    `when`(this.calc(-2.1)).thenReturn(-1.9808016559672235)
    `when`(this.calc(-1.95)).thenReturn(-2.70138244692373)
    `when`(this.calc(-1.9)).thenReturn(-3.0932022016726934)
    `when`(this.calc(-1.8)).thenReturn(-4.4013678718536315)
    `when`(this.calc(-1.7)).thenReturn(-7.761293996050358)
    `when`(this.calc(-1.5)).thenReturn(14.136832902969903)
    `when`(this.calc(-1.4)).thenReturn(5.883490084827342)
    `when`(this.calc(-1.3)).thenReturn(3.738334127075442)
    `when`(this.calc(-1.25)).thenReturn(3.171357693770103)
    `when`(this.calc(-1.2)).thenReturn(2.759703601332406)
    `when`(this.calc(-1.15)).thenReturn(2.44805568033018)
    `when`(this.calc(-0.4)).thenReturn(1.0857044283832387)

}

val sinStub: Sin = mock(Sin::class.java).apply {
    `when`(this.calc(0.0)).thenReturn(0.0)
    `when`(this.calc(-6.2)).thenReturn(0.0830894028174964)
    `when`(this.calc(-6.0)).thenReturn(0.27941549819892586)
    `when`(this.calc(-5.8)).thenReturn(0.46460217941375737)
    `when`(this.calc(-5.7)).thenReturn(0.5506855425976376)
    `when`(this.calc(-5.65)).thenReturn(0.5917155806310094)
    `when`(this.calc(-5.6)).thenReturn(0.6312666378723216)
    `when`(this.calc(-5.5)).thenReturn(0.7055403255703919)
    `when`(this.calc(-5.4)).thenReturn(0.7727644875559871)
    `when`(this.calc(-5.3)).thenReturn(0.8322674422239013)
    `when`(this.calc(-5.2)).thenReturn(0.8834546557201531)
    `when`(this.calc(-5.15)).thenReturn(0.9057666414687044)
    `when`(this.calc(-5.1)).thenReturn(0.9258146823277325)
    `when`(this.calc(-5.0)).thenReturn(0.9589242746631385)
    `when`(this.calc(-4.9)).thenReturn(0.9824526126243325)
    `when`(this.calc(-4.8)).thenReturn(0.9961646088358407)
    `when`(this.calc(-4.6)).thenReturn(0.9936910036334644)
    `when`(this.calc(-4.5)).thenReturn(0.977530117665097)
    `when`(this.calc(-4.4)).thenReturn(0.9516020738895161)
    `when`(this.calc(-4.3)).thenReturn(0.9161659367494549)
    `when`(this.calc(-4.25)).thenReturn(0.8949893582285835)
    `when`(this.calc(-4.2)).thenReturn(0.8715757724135882)
    `when`(this.calc(-3.8)).thenReturn(0.6118578909427189)
    `when`(this.calc(-3.5)).thenReturn(0.35078322768961984)
    `when`(this.calc(-3.2)).thenReturn(0.058374143427580086)
    `when`(this.calc(-3.1)).thenReturn(-0.04158066243329049)
    `when`(this.calc(-2.8)).thenReturn(-0.3349881501559051)
    `when`(this.calc(-2.5)).thenReturn(-0.5984721441039564)
    `when`(this.calc(-2.2)).thenReturn(-0.8084964038195901)
    `when`(this.calc(-2.1)).thenReturn(-0.8632093666488737)
    `when`(this.calc(-1.95)).thenReturn(-0.9289597150038693)
    `when`(this.calc(-1.9)).thenReturn(-0.9463000876874145)
    `when`(this.calc(-1.8)).thenReturn(-0.9738476308781951)
    `when`(this.calc(-1.7)).thenReturn(-0.9916648104524686)
    `when`(this.calc(-1.5)).thenReturn(-0.9974949866040544)
    `when`(this.calc(-1.4)).thenReturn(-0.9854497299884601)
    `when`(this.calc(-1.3)).thenReturn(-0.963558185417193)
    `when`(this.calc(-1.25)).thenReturn(-0.9489846193555862)
    `when`(this.calc(-1.2)).thenReturn(-0.9320390859672263)
    `when`(this.calc(-1.15)).thenReturn(-0.912763940260521)
    `when`(this.calc(-0.7)).thenReturn(-0.644217687237691)
    `when`(this.calc(-0.4)).thenReturn(-0.3894183423086505)
}

val lnTestData = mapOf( 0.1 to -2.302585093, 1 to 0, 1.15 to 0.1397619424, 2.283 to 0.8254903675,
        8.664 to 2.15917651, 15.1 to 2.714694744 , 15.187 to 2.720439799, 15.3 to 2.727852828)

val log10TestData = mapOf(0.1 to -1, 1 to 0,
        1.15 to 0.06069784035, 2.283 to 0.3585059115, 8.664 to 0.9377184436, 15.1 to 1.178976947, 15.187 to 1.181471993, 15.3 to 1.184691431)

val log5TestData = mapOf(0.1 to -1.430676558, 1 to 0,
        1.15 to 0.08683897732, 2.283 to 0.5129060035, 8.664 to 1.341571795, 15.1 to 1.686734681, 15.187 to 1.690304284, 15.3 to 1.694910259)

val log3TestData = mapOf(0.1 to -2.095903274, 1 to 0,
        1.15 to 0.1272168023, 2.283 to 0.7513937137, 8.664 to 1.965367156, 15.1 to 2.471021644, 15.187 to 2.476251018, 15.3 to 2.482998649)

val log3Stub = mock(Log3::class.java).apply {
    log3TestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}
val log5Stub = mock(Log5::class.java).apply {
    log3TestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}
val log10Stub = mock(Log10::class.java).apply {
    log3TestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}
val lnStub = mock(Ln::class.java).apply {
    log3TestData.forEach { (x, y) -> `when`(this.calc(x)).thenReturn(y) }
}



