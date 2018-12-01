package advent01

import java.lang.Long.parseLong
import java.lang.RuntimeException

class FrequencyCalibrator(var input: String) {

    fun getFrequency(): Long {
        return parseInput(input).sum()
    }

    fun getFirstRepeatingFrequency(): Long {
        val set = HashSet<Long>()
        val parsedInput = parseInput(input);

        var current = 0L;
        set.add(current)

        var i = 0;
        while (true) {
            current += getChange(i, parsedInput);
            if (set.contains(current)) {
                return current;
            }
            set.add(current);
            i++
        }
    }

    private fun getChange(i: Int, parsedInput: List<Long>): Long {
        return parsedInput.get(i % parsedInput.size)
    }

    private fun parseInput(expressions: String): List<Long> {
        val expressions = input.split("\n");
        return expressions.map { parseLong(it) }
    }
}
