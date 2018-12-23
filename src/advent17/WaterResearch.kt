package advent17

import java.awt.Point
import java.lang.Integer.parseInt
import java.util.concurrent.ConcurrentHashMap

class WaterResearch(input: String) {
    val ground: Array<Array<Ground>>
    val maxX: Int
    val maxY: Int
    val minX: Int
    val minY: Int
    val offset: Int

    init {
        val clayRanges = mutableListOf<ClayRange>()

        input.split("\n").forEach {
            val regex = """(.+)=(\d+), (.+)=(\d+)..(\d+)""".toRegex()
            val matchResult = regex.find(it)
            val (first, firstVal, _, secondFrom, secondTo) = matchResult!!.destructured

            if (first == "x") {
                clayRanges.add(
                    ClayRange(
                        IntRange(parseInt(firstVal), parseInt(firstVal)),
                        IntRange(parseInt(secondFrom), parseInt(secondTo))
                    )
                )
            } else {
                clayRanges.add(
                    ClayRange(
                        IntRange(parseInt(secondFrom), parseInt(secondTo)),
                        IntRange(parseInt(firstVal), parseInt(firstVal))
                    )
                )
            }
        }

        maxX = clayRanges.map { it.xRange.endInclusive }.max() ?: 1000
        maxY = clayRanges.map { it.yRange.endInclusive }.max() ?: 1000
        minX = clayRanges.map { it.xRange.start }.min() ?: 0
        minY = clayRanges.map { it.yRange.start }.min() ?: 0
        offset = minX - 10

        ground = Array(maxY + 10) { Array(maxX + 10 - offset) { Ground.EMPTY } }

        clayRanges.forEach {
            for (i in it.yRange) {
                for (j in it.xRange) {
                    setGroundAt(j, i, Ground.CLAY)
                }
            }
        }
    }

    fun reachableTilesCnt(): Int {
        val spreadFromMap: ConcurrentHashMap<Point, String> = ConcurrentHashMap()
        val spreadFrom = spreadFromMap.keySet("")
        setGroundAt(500, 0, Ground.WET)
        spreadFrom.add(Point(500, 0))

        while (true) {
            try {
                spreadFrom.forEach {
                    spread(it, spreadFrom)
                }
                if (countResult() == 50823) {

                    printGround()
                    println()
                    println()
                    println()
//                    return countResult()
                }

                println(countResult())
                println(countResultWater())
            } catch (e: ArrayIndexOutOfBoundsException) {
                break
            }
        }
        return countResult()
    }

    private fun countResultWater(): Int {
        var cnt = 0

        for (i in minY..maxY) {
            ground[i].forEach {
                if (it == Ground.WATER) {
                    cnt++
                }
            }
        }

        return cnt
    }

    private fun countResult(): Int {
        var cnt = 0

        for (i in minY..maxY) {
            ground[i].forEach {
                if (it == Ground.WET || it == Ground.WATER) {
                    cnt++
                }
            }
        }

        return cnt
    }

    private fun spread(ground: Point, spreadFrom: MutableSet<Point>) {
        if (groundAt(ground) == Ground.WET) {
            val next = below(ground)
            if (groundAt(next) == Ground.EMPTY) {
                setGroundAt(next, Ground.WET)
                spreadFrom.add(next)
            } else if (groundAt(next) == Ground.CLAY || groundAt(next) == Ground.WATER) {
                if (canFillLevel(ground)) {
                    fillLevel(ground)
                    spreadFrom.add(above(ground))
                } else {
                    fillWithWet(ground, spreadFrom)
                }
            }
        }
    }

    private fun below(ground: Point) = Point(ground.x, ground.y + 1)

    private fun above(ground: Point) = Point(ground.x, ground.y - 1)

    private fun fillLevel(point: Point) {
        var x = point.x
        setGroundAt(x, point.y, Ground.WATER)

        while (x > minX && groundAt(x, point.y) != Ground.CLAY) {
            setGroundAt(x, point.y, Ground.WATER)
            x--
        }

        x = point.x
        while (x < maxX && groundAt(x, point.y) != Ground.CLAY) {
            setGroundAt(x, point.y, Ground.WATER)
            x++
        }

    }

    private fun fillWithWet(point: Point, spreadFrom: MutableSet<Point>) {
        if (groundAt(below(point)) == Ground.EMPTY || groundAt(below(point)) == Ground.WET) {
            return
        }

        var x = point.x
        while (x > minX && groundAt(x, point.y) != Ground.CLAY) {
            setGroundAt(x, point.y, Ground.WET)
            if (groundAt(below(Point(x, point.y))) == Ground.EMPTY || groundAt(
                    below(
                        Point(
                            x,
                            point.y
                        )
                    )
                ) == Ground.WET
            ) {
                spreadFrom.add(Point(x, point.y))
                break
            }

            x--
        }

        x = point.x
        while (x < maxX && groundAt(x, point.y) != Ground.CLAY) {
            setGroundAt(x, point.y, Ground.WET)
            if (groundAt(below(Point(x, point.y))) == Ground.EMPTY || groundAt(
                    below(
                        Point(
                            x,
                            point.y
                        )
                    )
                ) == Ground.WET
            ) {
                spreadFrom.add(Point(x, point.y))
                return
            }
            x++
        }
    }

    private fun canFillLevel(point: Point): Boolean {
        if (groundAt(below(point)) == Ground.EMPTY || groundAt(below(point)) == Ground.WET) {
            return false
        }

        var x = point.x
        while (x > minX && groundAt(x, point.y) != Ground.CLAY) {
            if (groundAt(below(Point(x, point.y))) == Ground.EMPTY || groundAt(
                    below(
                        Point(
                            x,
                            point.y
                        )
                    )
                ) == Ground.WET
            ) {
                return false
            }
            x--
        }

        x = point.x
        while (x < maxX && groundAt(x, point.y) != Ground.CLAY) {
            if (groundAt(below(Point(x, point.y))) == Ground.EMPTY || groundAt(
                    below(
                        Point(
                            x,
                            point.y
                        )
                    )
                ) == Ground.WET
            ) {
                return false
            }
            x++
        }

        return true
    }


    private fun groundAt(point: Point): Ground {
        return groundAt(point.x, point.y)
    }

    private fun groundAt(x: Int, y: Int): Ground {
        return ground[y][x - offset]
    }


    private fun setGroundAt(x: Int, y: Int, value: Ground) {
        ground[y][x - offset] = value
    }

    private fun setGroundAt(point: Point, value: Ground) {
        setGroundAt(point.x, point.y, value)
    }

    private fun printGround() {
        ground.forEach {
            it.forEach {
                print(it.print())
            }
            print("\n")
        }
    }
}

enum class Ground(val printChar: String) {
    CLAY("#"),
    EMPTY("."),
    WATER("~"),
    WET("|");

    fun print(): String {
        return printChar
    }
}

class ClayRange(val xRange: IntRange, val yRange: IntRange)