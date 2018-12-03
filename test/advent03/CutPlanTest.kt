package advent03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CutPlanTest {
    @Test
    internal fun testParse() {
        val test = CutPlan("#1254 @ 348,63: 27x11")
        assertEquals("1254", test.id)
        assertEquals(348, test.left)
        assertEquals(63, test.top)
        assertEquals(27, test.width)
        assertEquals(11, test.height)
    }
}