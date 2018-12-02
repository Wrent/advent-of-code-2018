package advent02

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
        val lines = input.split("\n")
        val sums = ArrayList<Checksum>()

        for (line in lines) {
            val checksum = Checksum(line)

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