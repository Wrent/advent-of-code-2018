package advent11

class CellPowerLevels(val input: Int) {

    val cells: MutableList<MutableList<Cell>> = mutableListOf()


    init {
        cells.add(mutableListOf())
        for (i in 1..300) {
            cells.add(mutableListOf())
            cells[i].add(Cell(-1, -1, -1))
            for (j in 1..300) {
                cells[i].add(Cell(i, j, input))
            }
        }
    }

    fun getBestGrid(size: Int = 3): Pair<Cell, Int> {
        var maxCell = cells[1][1]
        var max = Int.MIN_VALUE
        for (i in 1..301 - size) {
            for (j in 1..301 - size) {
                var value = 0
                for (k in 0..size - 1) {
                    val row = i + k
                    for (l in 0..size - 1) {
                        val column = j + l
                        value += cells[row][column].power
                    }
                }
                if (value > max) {
                    max = value
                    maxCell = cells[i][j]
                }
            }
        }
        return Pair(maxCell, max)
    }


    // TODO refactoring candidate = instead of pure brute force, we can incrementaly add just few cells to every grid
    fun getBestAdjustableGrid(): Pair<Cell, Pair<Int, Int>> {
        var maxCell = cells[1][1]
        var max = Int.MIN_VALUE
        var maxSize = 0
        for (i in 1..300) {
            println(i)
            val bestGrid = getBestGrid(i)
            if (bestGrid.second > max) {
                maxCell = bestGrid.first
                max = bestGrid.second
                maxSize = i
            }
        }
        return Pair(maxCell, Pair(max, maxSize))
    }
}