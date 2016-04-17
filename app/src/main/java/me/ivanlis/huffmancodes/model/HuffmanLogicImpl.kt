package me.ivanlis.huffmancodes.model

import java.io.File
import java.util.*

/**
 * Created by ivan on 17/04/16.
 * Project: Huffman.codes
 */
class HuffmanLogicImpl(var plainText: String) : HuffmanLogic {


    override fun getEncodedText() : String {
        var charOccurrence = countCharOccurrence(plainText)
        var root = createBinHuffmanTree(convertOccurrencesIntoNodes(charOccurrence))
        var huffmanCodes : HashMap<Char, String> = HashMap()
        huffmanCodes = generateHuffmanScheme(root, "", huffmanCodes)
        return generateEncodedOutput(plainText, huffmanCodes)
    }

    override fun getDecodedText(encodedText : String, huffmanCodes: HashMap<Char, String>): String {
        val inverseHuffmanCodes = createInverseHuffmanCodes(huffmanCodes)
        var code = ""
        var decodedText = ""

        for (char in encodedText) {
            code += char
            if(inverseHuffmanCodes.containsKey(code)) {
                decodedText += inverseHuffmanCodes[code]
                code = ""
            }
        }
        return decodedText
    }


    private fun countCharOccurrence(text: String): HashMap<Char, Int> {
        var charOccurrences: HashMap<Char, Int> = HashMap()

        for (char in text) {
            if (charOccurrences.containsKey(char)) {
                var occurrence = charOccurrences[char]
                occurrence = occurrence!! + 1
                charOccurrences[char] = occurrence
            } else {
                charOccurrences.put(char, 1)
            }
        }
        return charOccurrences
    }

    private fun convertOccurrencesIntoNodes(charOccurrences: HashMap<Char, Int>): PriorityQueue<Node> {
        val queue = PriorityQueue<Node>(10, { n1, n2 -> n1.occurrence - n2.occurrence })
        charOccurrences.forEach { item -> queue.add(Node(char = item.key, occurrence = item.value)) }
        return queue
    }

    private fun createBinHuffmanTree(queue: PriorityQueue<Node>): Node {
        while (queue.size != 1) {
            val lowest1 = queue.remove()
            val lowest2 = queue.remove()
            queue.add(Node(leftNode = lowest1, rightNode = lowest2))
        }
        return queue.remove()
    }


    private fun generateHuffmanScheme(root: Node, code: String, huffmanCodes: HashMap<Char, String>): HashMap<Char, String> {
        if (root.isLeaf()) {
            huffmanCodes.put(root.char!!, code)
            return huffmanCodes
        }
        generateHuffmanScheme(root.leftNode!!, code + "0", huffmanCodes)
        generateHuffmanScheme(root.rightNode!!, code + "1", huffmanCodes)
        return huffmanCodes
    }

    private fun generateEncodedOutput(plainText: String, huffmanCodes: HashMap<Char, String>): String {
        var encodedText = ""
        plainText.forEach { encodedText += huffmanCodes[it] }
        return encodedText

    }

    private fun createInverseHuffmanCodes(huffmanCodes: HashMap<Char, String>) : HashMap<String, Char> {
        var inverseHuffmanCodes : HashMap<String, Char> = HashMap()
        huffmanCodes.forEach { inverseHuffmanCodes.put(it.value, it.key) }
        return inverseHuffmanCodes
    }



    class Node(val leftNode: Node? = null,
               val rightNode: Node? = null,
               val char: Char? = null,
               var occurrence: Int = 0) {

        init {
            if (leftNode != null && rightNode != null) {
                occurrence = leftNode.occurrence + rightNode.occurrence
            }
        }

        override fun toString(): String {
            return "Char: $char \tOccurrence: $occurrence"
        }

        fun isLeaf(): Boolean = leftNode == null && rightNode == null
    }


}

