package advent02

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test as test


internal class BoxChecksumTest {

    @test
    fun example() {
        assertEquals(12, BoxChecksum().getChecksum("abcdef\nbababc\nabbcde\nabcccd\naabcdd\nabcdee\nababab"))
    }

    @Disabled
    @test
    fun result() {
        println(BoxChecksum().getChecksum(FileUtils.readFileDirectlyAsText("inputData/advent02_1.txt")))
    }

    @test
    fun example2LessEffective() {
        assertEquals(
            "fgij",
            BoxChecksum().findTwoSimilarBoxesLessEffective("abcde\nfghij\nklmno\npqrst\nfguij\naxcye\nwvxyz")
        )
    }

    @Disabled
    @test
    fun result2LessEffective() {
        println(BoxChecksum().findTwoSimilarBoxesLessEffective(FileUtils.readFileDirectlyAsText("inputData/advent02_1.txt")))
    }

    @test
    fun example2() {
        assertEquals("fgij", BoxChecksum().findTwoSimilarBoxes("abcde\nfghij\nklmno\npqrst\nfguij\naxcye\nwvxyz"))
    }

    @Disabled
    @test
    fun result2() {
        println(BoxChecksum().findTwoSimilarBoxes(FileUtils.readFileDirectlyAsText("inputData/advent02_1.txt")))
    }
}
