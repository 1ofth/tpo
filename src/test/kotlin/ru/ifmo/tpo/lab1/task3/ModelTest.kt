package ru.ifmo.tpo.lab1.task3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
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
    fun `test noise increases after bombard`() {
        val noiseBefore = computerBank.noise
        bomber.bombard(computerBank, BOMB_COUNT)

        assert((computerBank.noise - noiseBefore - BOMB_COUNT * bomber.bullet.noiseLevel) < EPS) {
            "Noise level before: $noiseBefore, after: ${computerBank.noise}, " +
                    "expected: ${noiseBefore + BOMB_COUNT * bomber.bullet.noiseLevel}"
        }
    }

    @Test
    fun `test temperature increases after bombard`() {
        val temperatureBefore = computerBank.temperature

        bomber.bombard(computerBank, BOMB_COUNT)
        assert(
            (computerBank.temperature - temperatureBefore -
                    BOMB_COUNT * bomber.bullet.temperatureIncrease) < EPS
        ) {
            "Temperature before: $temperatureBefore, after: ${computerBank.temperature}, " +
                    "expected: ${temperatureBefore + BOMB_COUNT * bomber.bullet.temperatureIncrease}"
        }
    }

    @Test
    fun `test health decreases after bombard`() {
        val healthBefore = computerBank.health

        bomber.bombard(computerBank, BOMB_COUNT)

        assert((healthBefore - computerBank.health - BOMB_COUNT * bomber.bullet.damage) < EPS) {
            "Health points before: $healthBefore, after: ${computerBank.health}, " +
                    "expected: ${healthBefore - BOMB_COUNT * bomber.bullet.damage}"
        }
        assert(computerBank.frontPart.health < 30.0) {
            "FrontPart health is ${computerBank.frontPart.health}, expected less than 30.0"
        }
    }

    @Test
    fun `test metal crawl exist when cb is almost destroyed`() {
        assert(computerBank.brooks.isEmpty()) {
            "Brooks shouldn't exist after bombard!"
        }

        bomber.bombard(computerBank, BOMB_COUNT)
        assert(computerBank.brooks.isNotEmpty()) {
            "Brooks should exist after bombard!"
        }
    }

    @Test
    fun `test metal crawl directions after cb is almost destroyed`() {
        bomber.bombard(computerBank, BOMB_COUNT)
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
        bomber.bombard(computerBank, BOMB_COUNT)
        assertEquals(personGroup.state, GroupState.TENSE_AND_WAITING)
    }

    @Test
    fun `test bombard is false before bombard`() {
        Assertions.assertAll(
            Executable { assert(!computerBank.isBombard)},
            Executable { assert(!computerBank.frontPart.isBombard)},
            Executable { assert(!computerBank.endPart.isBombard)}
        )
    }

    @Test
    fun `test computer isn't melted before bombard`() {
        Assertions.assertAll(
            Executable { assert(!computerBank.isMelted)},
            Executable { assert(!computerBank.frontPart.isMelted)},
            Executable { assert(!computerBank.endPart.isMelted)}
        )
    }

    @Test
    fun `test computer is melted after bombard`() {
        bomber.bombard(computerBank, BOMB_COUNT)
        Assertions.assertAll(
            Executable { assert(computerBank.isMelted)},
            Executable { assert(computerBank.frontPart.isMelted)},
        )
    }

    companion object {
        private const val EPS = 0.000001
        private const val BOMB_COUNT = 4
    }
}
