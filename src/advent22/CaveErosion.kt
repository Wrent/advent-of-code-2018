package advent22

import java.awt.Point
import java.util.*

class CaveErosion(val depth: Int, val target: Point) {

    val regions: Array<Array<Region>>

    init {
        val offset = 1000
        regions = Array(target.y + offset) {
            Array(target.x + offset) {
                Region(
                    RegionType.ROCKY,
                    0,
                    0
                )
            }
        }

        regions.forEachIndexed { y, row ->
            row.forEachIndexed { x, region ->
                val geologicIndex = geologicIndex(Point(x, y))
                val erosionLevel = erosionLevel(geologicIndex)

                regions[y][x] = getRegion(geologicIndex, erosionLevel)
            }
        }

        printCave()
    }

    private fun printCave() {
        regions.forEachIndexed { y, row ->
            row.forEachIndexed { x, region ->
                print(region.type.char)
            }
            print("\n")
        }
    }

    fun geologicIndex(point: Point): Long {
        if (point.equals(Point(0, 0))) {
            return 0
        }
        if (point.equals(target)) {
            return 0
        }
        if (point.x == 0) {
            return (point.y * 48271L) % 20183L
        }
        if (point.y == 0) {
            return (point.x * 16807L) % 20183L
        } else {
            return (regions[point.y - 1][point.x].erosionLevel * regions[point.y][point.x - 1].erosionLevel) % 20183L
        }
    }

    fun erosionLevel(index: Long): Long {
        return (index + depth) % 20183
    }

    fun getRiskLevel(): Long {
        var sum = 0L
        for (i in 0..target.y) {
            for (j in 0..target.x) {
                sum += regions[i][j].type.risk
            }
        }
        return sum
    }

    fun fastestWayToReachTarget(): Int {
        val priorityQueue = PriorityQueue<Position>(200, compareBy { it.time })

        priorityQueue.add(Position(0, Point(0, 0), Tool.TORCH))
        regions[0][0].timeTools.put(Tool.TORCH, 0)
        while (!priorityQueue.peek().point.equals(target)) {
            val position = priorityQueue.poll()

            val region = regions[position.point.y][position.point.x]

            tryPosition(
                Point(position.point.x - 1, position.point.y),
                position.time,
                position.tool,
                region.type,
                priorityQueue
            )
            tryPosition(
                Point(position.point.x + 1, position.point.y),
                position.time,
                position.tool,
                region.type,
                priorityQueue
            )
            tryPosition(
                Point(position.point.x, position.point.y - 1),
                position.time,
                position.tool,
                region.type,
                priorityQueue
            )
            tryPosition(
                Point(position.point.x, position.point.y + 1),
                position.time,
                position.tool,
                region.type,
                priorityQueue
            )
        }

        val top = priorityQueue.peek()
        return top.time
    }

    private fun tryPosition(
        point: Point,
        time: Int,
        tool: Tool,
        fromRegionType: RegionType,
        priorityQueue: PriorityQueue<Position>
    ) {
        if (point.x < 0 || point.y < 0) {
            return
        }
        val region = regions[point.y][point.x]
        val newTool = switchTool(fromRegionType, region.type, tool)
        if (newTool != null) {
            val movePenalty = getMovePenalty(tool, newTool)
            var newTime = time + movePenalty
            if (point.equals(target) && newTool != Tool.TORCH) {
                newTime += 7
            }
            if (region.timeTools.containsKey(newTool)) {
                if (region.timeTools.get(newTool)!! > newTime) {
                    region.timeTools.put(newTool, newTime)
                    priorityQueue.add(Position(newTime, point, newTool))
                }
            } else {
                region.timeTools.put(newTool, newTime)
                priorityQueue.add(Position(newTime, point, newTool))
            }
        }
    }

    private fun getMovePenalty(tool: Tool, newTool: Tool): Int {
        if (tool == newTool) {
            return 1
        } else {
            return 8
        }
    }

    private fun switchTool(from: RegionType, to: RegionType, tool: Tool): Tool? {
        if (from == to) {
            return tool
        }
        if (tool == Tool.TORCH) {
            if (from == RegionType.ROCKY) {
                if (to == RegionType.WET) {
                    return Tool.GEAR
                } else {
                    return Tool.TORCH
                }
            } else { // NARROW
                if (to == RegionType.WET) {
                    return Tool.NEITHER
                } else {
                    return Tool.TORCH
                }
            }
        } else if (tool == Tool.GEAR) {
            if (from == RegionType.ROCKY) {
                if (to == RegionType.WET) {
                    return Tool.GEAR
                } else {
                    return Tool.TORCH
                }
            } else { // WET
                if (to == RegionType.NARROW) {
                    return Tool.NEITHER
                } else {
                    return Tool.GEAR
                }
            }
        } else { // NEITHER
            if (from == RegionType.WET) {
                if (to == RegionType.NARROW) {
                    return Tool.NEITHER
                } else {
                    return Tool.GEAR
                }
            } else { // NARROW
                if (to == RegionType.ROCKY) {
                    return Tool.TORCH
                } else {
                    return Tool.NEITHER
                }
            }
        }
    }
}

data class Position(val time: Int, val point: Point, val tool: Tool)

class Region(
    val type: RegionType,
    val modGeologicalIndex: Long,
    val erosionLevel: Long,
    var timeTools: MutableMap<Tool, Int> = mutableMapOf()
)

enum class Tool {
    TORCH,
    GEAR,
    NEITHER;
}

enum class RegionType(val risk: Long, val char: String) {
    ROCKY(0, "."),
    WET(1, "="),
    NARROW(2, "|");
}

fun getRegion(geologicalIndex: Long, erosionLevel: Long): Region {
    val type = RegionType.values().filter { it.risk == erosionLevel % 3 }.first()
    return Region(type, geologicalIndex, erosionLevel)
}