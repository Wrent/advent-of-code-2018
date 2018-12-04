package advent04

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LogRecordTest {
    @Test
    internal fun testParse() {
        val test = LogRecord("[1518-11-01 00:00] Guard #10 begins shift")
        assertEquals(1518, test.year)
        assertEquals(11, test.month)
        assertEquals(1, test.day)
        assertEquals(0, test.hour)
        assertEquals(0, test.minute)
        assertEquals("Guard #10 begins shift", test.rest)
    }

}