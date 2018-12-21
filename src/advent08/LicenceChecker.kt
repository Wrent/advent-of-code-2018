package advent08

import java.lang.Integer.parseInt
import java.util.*

class LicenceChecker(input: String) {

    val root: Node

    init {
        val deque = LinkedList<Int>()
        input.split(" ")
            .map { parseInt(it) }
            .forEach { deque.addLast(it) }


        root = parseNode(deque)
    }

    private fun parseNode(deque: Deque<Int>): Node {
        val node = Node()
        val children = deque.pop()
        val metadata = deque.pop()

        for (i in 0 until children) {
            node.children.add(parseNode(deque))
        }
        for (i in 0 until metadata) {
            node.metadata.add(deque.pop())
        }

        return node
    }

    fun getMetadataSum(): Long {
        return root.sumMetadata()
    }

    fun getValue(): Long {
        return root.getValue()
    }

}