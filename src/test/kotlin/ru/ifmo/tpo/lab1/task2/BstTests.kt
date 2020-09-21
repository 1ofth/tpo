package ru.ifmo.tpo.lab1.task2

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.itmo.tpo.lab1.task2.BSTNode
import java.io.File
import java.io.PrintWriter
import java.util.logging.LogManager

class BstTests {

    @Test
    fun `test insert`() {
        val head = BSTNode(1)
        head.insert(2)
        val expected = listOf(
            "INFO: insert 2 , this node key - 1",
            "INFO: insert 2 , go to right node - null"
        )
        val actual = prepareLogs()
        assert(actual == expected) {
            "Expected $expected, was $actual"
        }
    }

    private fun prepareLogs(): List<String> {
        return File(LOG_FILE_NAME).readLines().filter { it.startsWith("INFO") }
    }

    @BeforeEach
    fun cleanLogs() {
        val logFile = File(LOG_FILE_NAME)
        if (logFile.exists()) {
            val writer = PrintWriter(LOG_FILE_NAME)
            writer.print("")
            writer.close()
        }
    }

    companion object {
        private const val LOG_FILE_NAME = "log.txt"

        @BeforeAll
        @JvmStatic
        private fun config() {
            val resource = BSTNode::class.java.getResourceAsStream("/logging.properties")
                ?: throw IllegalArgumentException("Resources wasn't found")
            LogManager.getLogManager().readConfiguration(resource)
        }
    }
}