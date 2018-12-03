package advent03

import java.lang.Integer.parseInt

class CutPlan(line: String) {
    val id: String

    val top: Int
    val left: Int
    val width: Int
    val height: Int

    //#1254 @ 348,63: 27x11
    init {
        val regex = """#(\d+) @ (\d+),(\d+): (\d+)x(\d+)""".toRegex()
        val matchResult = regex.find(line)
        val (id, left, top, width, height) = matchResult!!.destructured

        this.id = id
        this.top = parseInt(top)
        this.left = parseInt(left)
        this.width = parseInt(width)
        this.height = parseInt(height)
    }

    fun fillFabric(fabric: MutableMap<Int, MutableMap<Int, Int>>) {
        for (i in left..left + width - 1) {
            for (j in top..top + height - 1) {
                fabric.putIfAbsent(i, HashMap())
                fabric.get(i)?.putIfAbsent(j, 0)
                fabric.get(i)?.computeIfPresent(j) { key, value -> value + 1 }
            }
        }
    }

    fun overlaps(fabric: Map<Int, Map<Int, Int>>): Boolean {
        for (i in left..left + width - 1) {
            for (j in top..top + height - 1) {
                if (fabric.get(i)?.get(j)!! > 1) {
                    return true
                }
            }
        }
        return false
    }

}

