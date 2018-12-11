package advent10

import common.FileUtils
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MessageInTheSkyTest {


    @Disabled
    @Test
    fun result() {
        val messageInTheSky = MessageInTheSky(FileUtils.readFileDirectlyAsText("inputData/advent10.txt"))
        println(messageInTheSky.getMinVariance())
        // 10312 is minimal Y variance
        messageInTheSky.printStars(10312)

    }

}