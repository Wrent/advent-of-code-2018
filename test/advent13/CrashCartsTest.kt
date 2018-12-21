package advent13

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CrashCartsTest {

    val first = "|\nv\n|\n|\n|\n^\n|"

    val second = """/->-\
|   |  /----\
| /-+--+-\  |
| | |  | v  |
\-+-/  \-+--/
  \------/   """

    @Test
    fun example() {
        assertEquals(Pair(0, 3), CrashCarts(first).getFirstCrashLocation())
    }

    @Test
    fun example2() {
        assertEquals(Pair(7, 3), CrashCarts(second).getFirstCrashLocation())
    }


    @Disabled
    @Test
    fun result() {
        println(CrashCarts(FileUtils.readFileDirectlyAsText("inputData/advent13.txt")).getFirstCrashLocation())
    }
}