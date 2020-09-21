package ru.ifmo.tpo.lab1.task3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab1.task3.*

class ModelTest {
    private lateinit var bomber: Bomber
    private lateinit var personGroup: PersonGroup
    private lateinit var computerBank: ComputerBank

    @BeforeEach
    fun init() {
        bomber = Bomber(Bullet(20.0, 60.0, 20.0))
        personGroup = PersonGroup(Corner.LEFT, GroupState.RELAXED, 3)
        val frontPart = BankPart(null, "Front side", 100.0, 20.0, 50.0)
        val endPart = BankPart(null, "Back side", 100.0, 20.0, 50.0)
        computerBank = ComputerBank(frontPart, endPart, personGroup)
        frontPart.computerBank = computerBank
        endPart.computerBank = computerBank
    }

    @Test
    fun `test temp increases after bombard`() {
        val temperatureBefore = computerBank.temperature
        val healthBefore = computerBank.health
        val noiseBefore = computerBank.noise
        val eps = 0.000001
        val bombsCount = 4

        bomber.bombard(computerBank, bombsCount)
        assert((computerBank.temperature - temperatureBefore -
                bombsCount * bomber.bullet.temperatureIncrease) < eps) {
            "Temperature before: $temperatureBefore, after: ${computerBank.temperature}, " +
                    "expected: ${temperatureBefore + bombsCount * bomber.bullet.temperatureIncrease}"
        }
        assert((healthBefore - computerBank.health - bombsCount * bomber.bullet.damage) < eps) {
            "Health points before: $healthBefore, after: ${computerBank.health}, " +
                    "expected: ${healthBefore - bombsCount * bomber.bullet.damage}"
        }
        assert((computerBank.noise - noiseBefore - bombsCount * bomber.bullet.noiseLevel) < eps) {
            "Noise level before: $noiseBefore, after: ${computerBank.noise}, " +
                    "expected: ${noiseBefore + bombsCount * bomber.bullet.noiseLevel}"
        }
        assert(computerBank.frontPart.health < 30.0) {
            "FrontPart health is ${computerBank.frontPart.health}, expected less than 30.0"
        }
    }

    @Test
    fun `test metal crawl when cb is almost destroyed`() {
        bomber.bombard(computerBank, 4)
        assert(computerBank.brooks.isNotEmpty()) {
            "Brooks should exist after bombard!"
        }
        val actualBrookDirections = computerBank.brooks.map { it.direction }
        Corner.values().forEach { corner ->
            assert(corner in actualBrookDirections) {
                "There is missing brook in the $corner corner!"
            }
        }
        computerBank.brooks.forEach { brook ->
            assertEquals(brook.state, MetalBrook.Consistency.THICK)
        }
    }

    @Test
    fun `test group state changed after metal crawls`() {
        assertEquals(personGroup.state, GroupState.RELAXED)
        bomber.bombard(computerBank, 4)
        assertEquals(personGroup.state, GroupState.TENSE_AND_WAITING)
    }
}
