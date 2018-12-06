package advent06

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CoordinationsCalculatorTest {
    private val input = "1, 1\n1, 6\n8, 3\n3, 4\n5, 5\n8, 9"

    @Test
    fun example() {
        assertEquals(17, CoordinationsCalculator(input).getLargestArea())
    }

    @Test
    fun testTopLeft() {
        assertEquals(1, CoordinationsCalculator(input).getTopLeft().first)
        assertEquals(1, CoordinationsCalculator(input).getTopLeft().second)
    }

    @Test
    fun testBottomLeft() {
        assertEquals(1, CoordinationsCalculator(input).getBottomLeft().first)
        assertEquals(6, CoordinationsCalculator(input).getBottomLeft().second)
    }

    @Test
    fun testTopRight() {
        assertEquals(8, CoordinationsCalculator(input).getTopRight().first)
        assertEquals(3, CoordinationsCalculator(input).getTopRight().second)
    }

    @Test
    fun testBottomRight() {
        assertEquals(8, CoordinationsCalculator(input).getBottomRight().first)
        assertEquals(9, CoordinationsCalculator(input).getBottomRight().second)
    }

    @Test
    fun testMinimums() {
        assertEquals(1, CoordinationsCalculator(input).getMinTop())
        assertEquals(9, CoordinationsCalculator(input).getMaxBottom())
        assertEquals(8, CoordinationsCalculator(input).getMaxRight())
        assertEquals(1, CoordinationsCalculator(input).getMinLeft())
    }

    @Test
    fun testDistance() {
        assertEquals(9, CoordinationsCalculator(input).calculateDistance(Pair(1, 1), Pair(8, 3)))
    }


    @Disabled
    @Test
    fun result() {
        println(CoordinationsCalculator(FileUtils.readFileDirectlyAsText("inputData/advent06.txt")).getLargestArea())
    }

    @Test
    fun example2() {
        assertEquals(16, CoordinationsCalculator(input).getDenseArea(32))
    }

    @Disabled
    @Test
    fun result2() {
        println(CoordinationsCalculator(FileUtils.readFileDirectlyAsText("inputData/advent06.txt")).getDenseArea(10000))
    }
}