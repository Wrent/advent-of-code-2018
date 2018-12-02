package advent02

class ChecksumSet(line: String) {
    val occurences: MutableMap<Char, Int> = HashMap()

    init {
        line.forEach {
            occurences.putIfAbsent(it, 0)
            occurences.computeIfPresent(it) { _, value -> value + 1 }
        }
    }

    fun hasTwo(): Boolean {
        return hasInt(2)
    }

    fun hasThree(): Boolean {
        return hasInt(3)
    }

    private fun hasInt(value: Int) = occurences.values.contains(value)
}