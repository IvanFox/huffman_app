package me.ivanlis.huffmancodes.model

import java.util.*

/**
 * Created by ivan on 17/04/16.
 * Project: Huffman.codes
 */
interface HuffmanDecoder {

    fun getDecodedText() : String
    fun getInverseHuffmanCodes() : HashMap<String, Char>
}