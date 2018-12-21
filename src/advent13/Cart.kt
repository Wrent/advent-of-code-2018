package advent13


class Cart(val x: Int, val y: Int, val direction: Direction, val crossroadCnt: Int) : Comparable<Cart> {
    override fun compareTo(other: Cart): Int {
        return COMPARATOR.compare(other, this)
    }

    companion object {
        private val COMPARATOR =
            Comparator.comparingInt<Cart> { it.y }
                .thenComparingInt { it.x }
    }

    fun crossroadDirection(): CrossroadDirection {
        if (crossroadCnt % 3 == 0) {
            return CrossroadDirection.LEFT
        } else if (crossroadCnt % 3 == 1) {
            return CrossroadDirection.STRAIGHT
        } else {
            return CrossroadDirection.RIGHT
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cart

        if (y != other.y) return false
        if (x != other.x) return false

        return true
    }

    override fun hashCode(): Int {
        var result = y
        result = 31 * result + x
        return result
    }


}