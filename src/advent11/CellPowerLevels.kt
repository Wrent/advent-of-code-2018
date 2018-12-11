package advent11

class CellPowerLevels(val input: Int) {

    val cells: MutableList<MutableList<Cell>> = mutableListOf()


    fun getBestGrid(): Cell {
        cells.add(mutableListOf())
        for (i in 1..300) {
            cells.add(mutableListOf())
            cells[i].add(Cell(-1, -1, -1))
            for (j in 1..300) {
                cells[i].add(Cell(i, j, input))
            }
        }

        var maxCell = cells[1][1]
        var max = Int.MIN_VALUE
        for (i in 1..298) {
            for (j in 1..298) {
                val value =
                    cells[i][j].power + cells[i][j + 1].power + cells[i][j + 2].power + cells[i + 1][j].power + cells[i + 1][j + 1].power + cells[i + 1][j + 2].power + cells[i + 2][j].power + cells[i + 2][j + 1].power + cells[i + 2][j + 2].power
                if (value > max) {
                    max = value
                    maxCell = cells[i][j]
                }
            }
        }
        return maxCell
    }
}