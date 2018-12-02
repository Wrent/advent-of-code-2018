package advent02

class Substrings(line: String) {
    val substrings: MutableSet<String>

    init {
        substrings = generateSubstrings(line)
    }

    fun isSame(input: Substrings): Boolean {
        return same(input) != null
    }

    fun same(sub: Substrings): String? {
        for (substring in sub.substrings) {
            if (substrings.contains(substring)) {
                return substring
            }
        }
        return null
    }

    companion object {
        fun generateSubstrings(line: String): MutableSet<String> {
            val substrings = HashSet<String>()

            for (i in 0..line.length) {
                val substring = line.substring(0, i) + line.substring(Math.min(i + 1, line.length), line.length)
                substrings.add(substring)
            }
            return substrings
        }

    }
}