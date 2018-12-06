package advent06

import java.lang.Integer.parseInt

class CoordinationsCalculator(input: String) {
    val coords: MutableList<Pair<Int, Int>> = mutableListOf()
    val map: MutableMap<Pair<Int, Int>, MutableMap<Int, Int>> = mutableMapOf()

    init {
        input.split("\n")
            .map {
                val split = it.split(",")
                return@map Pair(parseInt(split[0].trim()), parseInt(split[1].trim()))
            }
            .forEach { coords.add(it) }
    }


    private val OFFSET = 120

    fun getLargestArea(): Int? {
        initMap()

        for (i in getMinLeft() - OFFSET..getMaxRight() + OFFSET) {
            var str = ""
            for (j in getMinTop() - OFFSET..getMaxBottom() + OFFSET) {
                val p = Pair(j, i)
                val let = map.get(p)?.let { getClosest(it) }
                if (let != null) {
                    str += (let + 47).toChar()
                } else {
                    str += "."
                }
            }
            println(str)
        }

        val groupBy = map.values.map { getClosest(it) }
            .groupBy { it }
            .filter { it.key != null }
        return groupBy.maxBy { it.value.size }?.value?.size
    }

    private fun initMap() {
        coords.forEachIndexed { index, pair ->
            for (i in getMinLeft() - OFFSET..getMaxRight() + OFFSET) {
                for (j in getMinTop() - OFFSET..getMaxBottom() + OFFSET) {
                    val p = Pair(j, i)
                    map.putIfAbsent(p, mutableMapOf())
                    map.get(p)?.put(index, calculateDistance(pair, p))
                }
            }
        }
    }

    fun getDenseArea(limit: Int): Int {
        initMap()

        return map.values.map { it.values.sum() }
            .filter { it < limit }
            .count()
    }

    fun calculateDistance(x: Pair<Int, Int>, y: Pair<Int, Int>): Int {
        return Math.abs(x.first - y.first) + Math.abs(x.second - y.second)
    }

    private fun getClosest(map: MutableMap<Int, Int>): Int? {
        var min = Integer.MAX_VALUE
        var minKey: Int? = null
        var minCnt = 0;
        for (entry in map.entries) {
            if (entry.value < min) {
                min = entry.value
                minKey = entry.key
                minCnt = 1
            } else if (entry.value == min) {
                minCnt++
            }
        }
        if (minCnt > 1) {
            return null
        } else {
            return minKey
        }
    }

    fun getTopLeft(): Pair<Int, Int> {
        val sorted = coords.sortedWith(compareBy({ it.first }, { it.second }))
        return sorted.first()
    }

    fun getBottomLeft(): Pair<Int, Int> {
        val sorted = coords.sortedWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })

        return sorted.first()
    }

    fun getTopRight(): Pair<Int, Int> {
        val sorted = coords.sortedWith(compareByDescending<Pair<Int, Int>> { it.first }.thenBy { it.second })

        return sorted.first()
    }

    fun getBottomRight(): Pair<Int, Int> {
        val sorted = coords.sortedWith(compareByDescending<Pair<Int, Int>> { it.first }.thenByDescending { it.second })

        return sorted.first()
    }

    fun getMinTop(): Int {
        return Math.min(getTopLeft().second, getTopRight().second);
    }

    fun getMaxBottom(): Int {
        return Math.max(getBottomLeft().second, getBottomRight().second);
    }

    fun getMinLeft(): Int {
        return Math.min(getTopLeft().first, getBottomLeft().first);
    }

    fun getMaxRight(): Int {
        return Math.max(getTopRight().first, getBottomRight().first);
    }
}