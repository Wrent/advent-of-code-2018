package advent03

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FabricProcessorTest {
    @Test
    fun example() {
        assertEquals(4, FabricProcessor("#1 @ 1,3: 4x4\n#2 @ 3,1: 4x4\n#3 @ 5,5: 2x2").getOverlapCount())
    }

    @Disabled
    @Test
    fun result() {
        println(FabricProcessor(FileUtils.readFileDirectlyAsText("inputData/advent03_1.txt")).getOverlapCount())
    }

    @Test
    fun example2() {
        assertEquals("3", FabricProcessor("#1 @ 1,3: 4x4\n#2 @ 3,1: 4x4\n#3 @ 5,5: 2x2").getNotOverlappingId())
    }

    @Disabled
    @Test
    fun result2() {
        println(FabricProcessor(FileUtils.readFileDirectlyAsText("inputData/advent03_1.txt")).getNotOverlappingId())
    }

}