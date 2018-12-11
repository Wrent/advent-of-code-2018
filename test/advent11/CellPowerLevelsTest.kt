package advent11

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CellPowerLevelsTest {
    @Test
    fun example() {
        assertEquals(Cell(33, 45, 18), CellPowerLevels(18).getBestGrid())
    }

    @Test
    fun example2() {
        assertEquals(Cell(21, 61, 42), CellPowerLevels(42).getBestGrid())
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


}