package advent05

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PolymersTest {

    @Test
    fun example() {
        assertEquals(10, Polymers().getPolymerUnits("dabAcCaCBAcCcaDA"))
    }


    @Disabled
    @Test
    fun result() {
        println(Polymers().getPolymerUnits(FileUtils.readFileDirectlyAsText("inputData/advent05_1.txt")))
    }

    @Test
    fun example2() {
        assertEquals(4, Polymers().getImprovedUnits("dabAcCaCBAcCcaDA"))
    }


    @Disabled
    @Test
    fun result2() {
        println(Polymers().getImprovedUnits(FileUtils.readFileDirectlyAsText("inputData/advent05_1.txt")))
    }
}