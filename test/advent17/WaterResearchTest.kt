package advent17

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WaterResearchTest {
    @Test
    internal fun testExample() {
        val input = "x=495, y=2..7\n" +
                "y=7, x=495..501\n" +
                "x=501, y=3..7\n" +
                "x=498, y=2..4\n" +
                "x=506, y=1..2\n" +
                "x=498, y=10..13\n" +
                "x=504, y=10..13\n" +
                "y=13, x=498..504"
        assertEquals(57, WaterResearch(input).reachableTilesCnt())
    }

    @Test
    @Disabled
    internal fun result1() {
        println(WaterResearch(FileUtils.readFileDirectlyAsText("inputData/advent17.txt")).reachableTilesCnt())

        // TODO I manually added the WET places on bottom on the left, which were not generated for some reason
    }

}