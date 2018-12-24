package advent18

import java.awt.Point

class GameOfForest(input: String) {
    var forest: Array<Array<Forest>>


    init {
        val split = input.split("\n")
        forest = Array(split.size) { Array(split.size) { Forest.GROUND } }

        split.forEachIndexed { i, row ->
            row.forEachIndexed { j, char ->
                forest[i][j] = getForest(char.toString())
            }
        }
    }

    fun valueAfterMinutes(minutes: Int): Int {

        for (index in 0 until minutes) {
            val newForest = Array(forest.size) { Array(forest.size) { Forest.GROUND } }

            forest.forEachIndexed { i, row ->
                row.forEachIndexed { j, col ->
                    newForest[i][j] = process(i, j)
                }
            }
            forest = newForest
//            printGame()
//            println()
//            println()
            println(index.toString() + " " + countResult())
        }

        return countResult()
    }

    private fun countResult(): Int {
        val flatMap = forest.flatMap { it.asList() }
        val lumberyards = flatMap.filter { it == Forest.LUMBERYARD }.count()
        val trees = flatMap.filter { it == Forest.TREES }.count()

        return lumberyards * trees
    }

    private fun printGame() {
        forest.forEach {
            it.forEach {
                print(it.printChar)
            }
            print("\n")
        }
    }

    private fun process(y: Int, x: Int): Forest {
        val current = forest[y][x]
        val neighbors = getNeighbors(Point(x, y))
            .map { forest[it.y][it.x] }
        if (current == Forest.GROUND) {
            val trees = neighbors.filter { it == Forest.TREES }.count()
            if (trees >= 3) {
                return Forest.TREES
            } else {
                return Forest.GROUND
            }
        } else if (current == Forest.TREES) {
            val lumberyards = neighbors.filter { it == Forest.LUMBERYARD }.count()
            if (lumberyards >= 3) {
                return Forest.LUMBERYARD
            } else {
                return Forest.TREES
            }
        } else {
            val trees = neighbors.filter { it == Forest.TREES }.count()
            val lumberyards = neighbors.filter { it == Forest.LUMBERYARD }.count()

            if (trees >= 1 && lumberyards >= 1) {
                return Forest.LUMBERYARD
            } else {
                return Forest.GROUND
            }
        }
    }

    private fun getNeighbors(point: Point): List<Point> {
        val list = mutableListOf<Point>()
        add(list, Point(point.x - 1, point.y))
        add(list, Point(point.x - 1, point.y - 1))
        add(list, Point(point.x - 1, point.y + 1))
        add(list, Point(point.x + 1, point.y))
        add(list, Point(point.x + 1, point.y - 1))
        add(list, Point(point.x + 1, point.y + 1))
        add(list, Point(point.x, point.y + 1))
        add(list, Point(point.x, point.y - 1))
        return list
    }

    private fun add(list: MutableList<Point>, point: Point) {
        if (point.x >= 0 && point.y >= 0 && point.x < forest.size && point.y < forest.size) {
            list.add(point)
        }
    }
}

enum class Forest(val printChar: String) {
    GROUND("."),
    TREES("|"),
    LUMBERYARD("#")
}

fun getForest(str: String): Forest {
    return Forest.values().filter { it.printChar.equals(str) }.first()
}