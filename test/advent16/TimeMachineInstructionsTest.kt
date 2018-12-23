package advent16

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TimeMachineInstructionsTest {

    @Test
    internal fun testExample() {
        val input = "Before: [3, 2, 1, 1]\n" +
                "9 2 1 2\n" +
                "After:  [3, 2, 2, 1]\n"

        val behavesLikeThreeOrMore = TimeMachineInstructions(input).getBehavesLikeThreeOrMore()
        assertEquals(1, behavesLikeThreeOrMore)
    }

    @Test
    @Disabled
    internal fun result1() {
        println(TimeMachineInstructions(FileUtils.readFileDirectlyAsText("inputData/advent16.txt")).getBehavesLikeThreeOrMore())
    }

    @Test
    @Disabled
    internal fun result2() {
        println(
            TimeMachineInstructions(FileUtils.readFileDirectlyAsText("inputData/advent16.txt")).executeProgram(
                FileUtils.readFileDirectlyAsText("inputData/advent16_2.txt")
            )
        )
    }
}