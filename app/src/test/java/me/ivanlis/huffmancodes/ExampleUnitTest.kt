package me.ivanlis.huffmancodes

import me.ivanlis.huffmancodes.model.HuffmanDecoderImpl
import me.ivanlis.huffmancodes.model.HuffmanEncoder
import me.ivanlis.huffmancodes.model.HuffmanEncoderImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
class ExampleUnitTest {




    @Test fun encodeSimpleText() {
        val encoder = HuffmanEncoderImpl("abbccc")
        encoder.getHuffmanCodes().forEach { print("Key: ${it.key} \tValue: ${it.value}\n") }
        assertEquals("101111000", encoder.getEncodedText())

    }

    @Test fun decodeSimpleText() {
        val encoder = HuffmanEncoderImpl("abbccc")
        val decoder = HuffmanDecoderImpl(encoder.getEncodedText(), encoder.getHuffmanCodes())
        assertEquals("abbccc", decoder.getDecodedText())
    }
}