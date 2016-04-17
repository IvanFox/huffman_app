package me.ivanlis.huffmancodes

import me.ivanlis.huffmancodes.model.HuffmanLogicImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test fun encodeSimpleText() {
        val huffmanLogic = HuffmanLogicImpl("abbccc")
        assertEquals("0001011", huffmanLogic.getEncodedText())
    }
}