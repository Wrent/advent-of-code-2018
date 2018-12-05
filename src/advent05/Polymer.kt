package advent05

class Polymer(input: String) {
    val units: ArrayList<PolymerUnit> = ArrayList()
    var current = 0
    val sizes = mutableListOf<Int>(count())

    class PolymerUnit(val value: Char) {

        var isPresent = true

    }

    init {
        input.forEach { units.add(PolymerUnit(it)) }
    }

    fun getNextIndex(): Int {
        if (current >= units.size - 2) {
            current = 0
            sizes.add(count())
        }
        while (!units.get(current).isPresent) {
            current++
            if (current >= units.size - 2) {
                current = 0
                sizes.add(count())
            }
        }

        return current++
    }

    fun shouldBeRemoved(index: Int): Boolean {
        if (index >= units.size - 2) {
            return false
        }
        if (!units[index].isPresent) {
            return false
        }
        val next = next(index)
        if (next < 0) {
            return false
        }
        return hasDifferentPolarity(units[index].value, units[next].value)
    }

    fun remove(index: Int) {
        units[index].isPresent = false
        units[next(index)].isPresent = false
    }

    private fun hasDifferentPolarity(first: Char, second: Char): Boolean {

        return Math.abs(first.toInt() - second.toInt()) == 32
    }

    fun count(): Int {
        return units.filter { it.isPresent }.count()
    }

    private fun next(index: Int): Int {
        var start = index + 1
        if (start >= units.size - 1) {
            return -1
        }
        while (!units[start].isPresent) {
            if (start >= units.size - 1) {
                return -1
            }
            start++
        }
        return start
    }

    fun shouldStop(): Boolean {
        if (sizes.size < 2) return false
        return sizes[sizes.size - 1] == sizes[sizes.size - 2]
    }


}
