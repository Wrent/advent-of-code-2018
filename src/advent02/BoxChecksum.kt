package advent02

import advent02.Substrings.Companion.generateSubstrings

class BoxChecksum {
    fun getChecksum(input: String): Int {
        val checksums = input.split("\n")
            .map { ChecksumSet(it) }
        val countTwo = checksums
            .filter { it.hasTwo() }
            .count()
        val countThree = checksums
            .filter { it.hasThree() }
            .count()
        return countThree * countTwo
    }

    fun findTwoSimilarBoxes(input: String): String? {
        val idsSet = HashSet<String>()

        val ids = input.split("\n")
            .map { generateSubstrings(it) }
            .flatten()

        for (id in ids) {
            if (idsSet.contains(id)) {
                return id
            }
            idsSet.add(id)
        }

        throw RuntimeException("Nothing was found")
    }

    fun findTwoSimilarBoxesLessEffective(input: String): String? {
        val lines = input.split("\n")
        val sums = ArrayList<Substrings>()

        for (line in lines) {
            val checksum = Substrings(line)

            for (sum in sums) {
                if (checksum.isSame(sum)) {
                    return checksum.same(sum)
                }
            }

            sums.add(checksum)
        }

        throw RuntimeException("Nothing was found")
    }
}