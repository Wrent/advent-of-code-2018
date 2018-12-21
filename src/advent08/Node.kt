package advent08

class Node {
    val children: MutableList<Node> = mutableListOf()

    val metadata: MutableList<Int> = mutableListOf()
    fun sumMetadata(): Long {
        return metadata.sum() + children.map { it.sumMetadata() }.sum()
    }

    fun getValue(): Long {
        if (children.size == 0) {
            return metadata.sum().toLong()
        } else {
            return metadata
                .map { getChildByMetadata(it) }
                .map { it?.getValue() ?: 0L }
                .sum()
        }
    }

    private fun getChildByMetadata(metadata: Int): Node? {
        val index = metadata - 1

        if (index < children.size && index >= 0) {
            return children.get(index)
        } else {
            return null
        }
    }
}