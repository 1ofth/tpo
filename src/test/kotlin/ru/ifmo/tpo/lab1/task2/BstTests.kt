package ru.ifmo.tpo.lab1.task2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
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
        val bst = BSTNode(1)
        bst.insert(4)
        bst.insert(6)
        bst.insert(-3)
        bst.insert(2)
        bst.insert(5)
        val expected = listOf(
            "INFO: insert 4 , this node key 1",
            "INFO: insert 4 , go to right node null",
            "INFO: insert 6 , this node key 1",
            "INFO: insert 6 , go to right node 4",
            "INFO: insert 6 , this node key 4",
            "INFO: insert 6 , go to right node null",
            "INFO: insert -3 , this node key 1",
            "INFO: insert -3 , go to left node null",
            "INFO: insert 2 , this node key 1",
            "INFO: insert 2 , go to right node 4",
            "INFO: insert 2 , this node key 4",
            "INFO: insert 2 , go to left node null",
            "INFO: insert 5 , this node key 1",
            "INFO: insert 5 , go to right node 4",
            "INFO: insert 5 , this node key 4",
            "INFO: insert 5 , go to right node 6",
            "INFO: insert 5 , this node key 6",
            "INFO: insert 5 , go to left node null"
        )
        val actual = File(LOG_FILE_NAME).readLines().filter { it.startsWith("INFO: insert") }
        assertEquals(expected, actual) {
            "Expected $expected, was $actual"
        }
    }

    @Test
    fun `test find`() {
        val bst = BSTNode(1)
        bst.insert(4)
        bst.insert(6)
        bst.insert(-3)
        bst.find(4)
        bst.find(10)
        val expected = listOf(
            "INFO: find 4 , this node key 1",
            "INFO: find 4 , this node key 4",
            "INFO: find 10 , this node key 1",
            "INFO: find 10 , this node key 4",
            "INFO: find 10 , this node key 6"
        )
        val actual = File(LOG_FILE_NAME).readLines().filter { it.startsWith("INFO: find") }
        assertEquals(expected, actual) {
            "Expected $expected, was $actual"
        }
    }

    @Test
    fun `test delete`() {
        val bst = BSTNode(1)
        bst.insert(4)
        bst.insert(6)
        bst.insert(-3)
        bst.insert(-1)
        bst.insert(2)
        bst.insert(5)
        bst.delete(4)
        bst.delete(6)
        bst.delete(-3)
        bst.delete(5)
        bst.delete(1)
        val expected = listOf(
            "INFO: delete 4 , this node key 1",
            "INFO: delete 4 , this node key 4",
            "INFO: delete 4 , both child nodes are not null, left child 2, right child 6",
            "INFO: delete node which had two child nodes, found max child node 2 in left subtree, null, 6",
            "INFO: delete 6 , this node key 1",
            "INFO: delete 6 , this node key 2",
            "INFO: delete 6 , this node key 6",
            "INFO: delete 6 , right child node is null, left child node 5",
            "INFO: delete node which had single child, new values 5, null, null",
            "INFO: delete -3 , this node key 1",
            "INFO: delete -3 , this node key -3",
            "INFO: delete -3 , left child node is null, right child node -1",
            "INFO: delete node which had single child, new values -1, null, null",
            "INFO: delete 5 , this node key 1",
            "INFO: delete 5 , this node key 2",
            "INFO: delete 5 , this node key 5",
            "INFO: delete 5 , both child nodes are null",
            "INFO: delete node without child nodes, null, null",
            "INFO: delete 1 , this node key 1",
            "INFO: delete 1 , both child nodes are not null, left child -1, right child 2",
            "INFO: delete node which had two child nodes, found max child node -1 in left subtree, null, 2"
        )
        val actual = File(LOG_FILE_NAME).readLines().filter { it.startsWith("INFO: delete") }
        assertEquals(expected, actual) {
            "Expected $expected, was $actual"
        }
    }

    @Test
    fun `test delete root`() {
        val bst = BSTNode(1)
        Assertions.assertThrows(IllegalStateException::class.java) {
            bst.delete(1)
        }
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