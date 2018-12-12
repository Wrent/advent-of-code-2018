package advent07

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InstructionDependenciesTest {


    @Test
    fun getOrder() {
        assertEquals(
            "CABDFE",
            InstructionDependencies("Step C must be finished before step A can begin.\nStep C must be finished before step F can begin.\nStep A must be finished before step B can begin.\nStep A must be finished before step D can begin.\nStep B must be finished before step E can begin.\nStep D must be finished before step E can begin.\nStep F must be finished before step E can begin.").getOrder()
        )
    }

    @Disabled
    @Test
    fun result() {
        println(InstructionDependencies(FileUtils.readFileDirectlyAsText("inputData/advent07.txt")).getOrder())
    }

    @Test
    fun getSeconds() {
        assertEquals(
            15,
            InstructionDependencies("Step C must be finished before step A can begin.\nStep C must be finished before step F can begin.\nStep A must be finished before step B can begin.\nStep A must be finished before step D can begin.\nStep B must be finished before step E can begin.\nStep D must be finished before step E can begin.\nStep F must be finished before step E can begin.").getSeconds(
                0,
                2
            )
        )
    }

    @Disabled
    @Test
    fun result2() {
        println(InstructionDependencies(FileUtils.readFileDirectlyAsText("inputData/advent07.txt")).getSeconds(60, 5))
    }
}