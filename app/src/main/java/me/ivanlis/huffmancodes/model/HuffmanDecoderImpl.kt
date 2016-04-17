package me.ivanlis.huffmancodes.model

import java.util.*

/**
 * Created by ivan on 17/04/16.
 * Project: Huffman.codes
 */

class HuffmanDecoderImpl (var encodedText : String, var huffmanCodes : HashMap<Char, String>) : HuffmanDecoder {

    override fun getInverseHuffmanCodes(): HashMap<String, Char> {
        var inverseHuffmanCodes: HashMap<String, Char> = HashMap()
        huffmanCodes.forEach { inverseHuffmanCodes.put(it.value, it.key) }
        return inverseHuffmanCodes
    }

    override fun getDecodedText(): String {
        val inverseHuffmanCodes = getInverseHuffmanCodes()
        var code = ""
        var decodedText = ""

        for (char in encodedText) {
            code += char
            if (inverseHuffmanCodes.containsKey(code)) {
                decodedText += inverseHuffmanCodes[code]
                code = ""
            }
        }
        return decodedText
    }

}