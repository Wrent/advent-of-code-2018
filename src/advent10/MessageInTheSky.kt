package advent10

class MessageInTheSky(input: String) {
    val stars: MutableList<Star> = mutableListOf()

    init {
        input.split("\n").forEach {
            stars.add(Star(it))
        }
    }

    fun getMinVariance(): Int {
        var min = Double.MAX_VALUE
        var minTime = 0
        for (i in 1..100000) {
            val variance = getVariance(stars.map { it.getPosAt(i).second })
            if (variance < min) {
                min = variance
                minTime = i
            }
        }
        return minTime
    }

    private fun getVariance(coords: List<Int>): Double {
        var variance = 0.0
        val average = coords.average()
        coords.forEach {
            variance += (it - average) * (it - average)
        }
        return variance
    }


    fun printStars(time: Int) {
        val mapped = stars.map { it.getPosAt(time) }

        var maxX = Integer.MIN_VALUE
        var maxY = Integer.MIN_VALUE
        var minX = Integer.MAX_VALUE
        var minY = Integer.MAX_VALUE

        mapped.forEach {
            if (it.first > maxX) {
                maxX = it.first
            }
            if (it.second > maxY) {
                maxY = it.second
            }
            if (it.first < minX) {
                minX = it.first
            }
            if (it.second < minY) {
                minY = it.second
            }
        }

        if (maxX - minX < 1000 && maxY - minY < 1000) {
            val points = Array(maxX - minX + 1, { i -> Array(maxY - minY + 1, { j -> "." }) })

            mapped.forEach { points[it.first - minX][it.second - minY] = "#" }

            for (i in 0..maxX - minX) {
                for (j in 0..maxY - minY) {
                    print(points[i][j])
                }
                println()
            }
        }
        println()
        println()
    }
}