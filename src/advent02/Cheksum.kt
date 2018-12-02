package advent02

class Checksum(line: String) {
    val substrings: MutableSet<String> = HashSet()

    init {
        for (i in 0..line.length) {
            val substring = line.substring(0, i) + line.substring(Math.min(i + 1, line.length), line.length)
            substrings.add(substring)
        }
    }

    fun isSame(input: Checksum): Boolean {
        return same(input) != null
    }

    fun same(sum: Checksum): String? {
        for (substring in sum.substrings) {
            if (substrings.contains(substring)) {
                return substring
            }
        }
        return null
    }
}