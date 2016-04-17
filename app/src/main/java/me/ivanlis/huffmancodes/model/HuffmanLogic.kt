package me.ivanlis.huffmancodes.model

import java.util.*

/**
 * Created by ivan on 17/04/16.
 * Project: Huffman.codes
 */

interface HuffmanLogic {

    fun getEncodedText() : String

    fun getDecodedText(encodedText : String, huffmanCodes: HashMap<Char, String>) : String



}