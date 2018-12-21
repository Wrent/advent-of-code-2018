package advent08

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class LicenceCheckerTest {
    @Test
    fun example() {
        assertEquals(138, LicenceChecker("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2").getMetadataSum())
    }

    @Disabled
    @Test
    fun result() {
        println(LicenceChecker(FileUtils.readFileDirectlyAsText("inputData/advent08.txt")).getMetadataSum())
    }

    @Test
    fun exampleTwo() {
        assertEquals(66, LicenceChecker("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2").getValue())
    }

    @Disabled
    @Test
    fun resultTwo() {
        println(LicenceChecker(FileUtils.readFileDirectlyAsText("inputData/advent08.txt")).getValue())
    }

}