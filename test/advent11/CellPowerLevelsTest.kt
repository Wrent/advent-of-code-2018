package advent11

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CellPowerLevelsTest {
    @Test
    fun example() {
        assertEquals(Cell(33, 45, 18), CellPowerLevels(18).getBestGrid().first)
    }

    @Test
    fun example2() {
        assertEquals(Cell(21, 61, 42), CellPowerLevels(42).getBestGrid().first)
    }

    @Test
    fun cellPower() {
        assertEquals(4, Cell(3, 5, 8).power)
    }

    @Test
    fun cellPower2() {
        assertEquals(-5, Cell(122, 79, 57).power)
    }

    @Test
    fun cellPower3() {
        assertEquals(0, Cell(217, 196, 39).power)
    }

    @Test
    fun cellPower4() {
        assertEquals(4, Cell(101, 153, 71).power)
    }

    @Disabled
    @Test
    fun result() {
        println(CellPowerLevels(3214).getBestGrid())
    }

    @Test
    fun exampleSecond() {
        val cell = Cell(90, 269, 18)
        val result = CellPowerLevels(18).getBestAdjustableGrid()
        assertEquals(cell, result.first)
        assertEquals(16, result.second.second)
    }

    @Test
    fun exampleSecond2() {
        val cell = Cell(232, 251, 42)
        val result = CellPowerLevels(42).getBestAdjustableGrid()
        assertEquals(cell, result.first)
        assertEquals(12, result.second.second)
    }

    @Disabled
    @Test
    fun result2() {
        println(CellPowerLevels(3214).getBestAdjustableGrid())
    }

}