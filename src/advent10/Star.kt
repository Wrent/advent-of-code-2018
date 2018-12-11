package advent10

import java.lang.Integer.parseInt

class Star(input: String) {
    val x: Int
    val y: Int
    val vectorX: Int
    val vectorY: Int

    init {
        val regex = """position=<\s*(-*\d+), \s*(-*\d+)> velocity=<\s*(-*\d+), \s*(-*\d+)""".toRegex()
        val matchResult = regex.find(input)
        val (x, y, vectorX, vectorY) = matchResult!!.destructured

        this.x = parseInt(x)
        this.y = parseInt(y)
        this.vectorX = parseInt(vectorX)
        this.vectorY = parseInt(vectorY)
    }

    fun getPosAt(time: Int): Pair<Int, Int> {
        return Pair(x + vectorX * time, y + vectorY * time)
    }
}