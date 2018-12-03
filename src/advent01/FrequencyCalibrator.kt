package advent01

import common.IteratorUtils.Companion.endlessIterator
import java.lang.Long.parseLong

class FrequencyCalibrator(var input: String) {

    fun getFrequency(): Long {
        return parseInput().sum()
    }

    fun getFirstRepeatingFrequency(): Long {
        val set = HashSet<Long>()
        val parsedInput = parseInput()

        var current = 0L
        set.add(current)

        val endlessIterator = endlessIterator(parsedInput)

        while (endlessIterator.hasNext()) {
            val next = endlessIterator.next()
            current += next
            if (set.contains(current)) {
                return current
            }
            set.add(current)
        }
        throw RuntimeException("Endless iterator ended unexpectedly.")
    }

    private fun parseInput(): List<Long> {
        val expressions = input.split("\n")
        return expressions.map { parseLong(it) }
    }
}
