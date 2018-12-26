package advent20

import common.FileUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DoorRegexTest {


    @Test
    internal fun testExample() {
        val input = "^WNE$"
        Assertions.assertEquals(3, DoorRegex(input).getFurthestRoom())
    }

    @Test
    internal fun testExample2() {
        val input = "^ENWWW(NEEE|SSE(EE|N))$"
        Assertions.assertEquals(10, DoorRegex(input).getFurthestRoom())
    }

    @Test
    internal fun testExample3() {
        val input = "^ENNWSWW(NEWS|)SSSEEN(WNSE|)EE(SWEN|)NNN$"
        Assertions.assertEquals(18, DoorRegex(input).getFurthestRoom())
    }

    @Test
    internal fun testExample4() {
        val input = "^ESSWWN(E|NNENN(EESS(WNSE|)SSS|WWWSSSSE(SW|NNNE)))$"
        Assertions.assertEquals(23, DoorRegex(input).getFurthestRoom())
    }

    @Test
    internal fun testExample5() {
        val input = " ^WSSEESWWWNW(S|NENNEEEENN(ESSSSW(NWSW|SSEN)|WSWWN(E|WWS(E|SS))))$"
        Assertions.assertEquals(31, DoorRegex(input).getFurthestRoom())
    }

    @Test
    @Disabled
    internal fun result1() {
        println(DoorRegex(FileUtils.readFileDirectlyAsText("inputData/advent20.txt")).getFurthestRoom())
    }

    @Test
    @Disabled
    internal fun result2() {
        println(DoorRegex(FileUtils.readFileDirectlyAsText("inputData/advent20.txt")).getCntRoomsOverThousandDoors())
    }
}