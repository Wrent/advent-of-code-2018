package advent09

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MarbleGameTest {
    @Test
    fun example() {
        assertEquals(32, MarbleGame(9, 25).getBestScore())
    }

    @Test
    fun example2() {
        assertEquals(8317, MarbleGame(10, 1618).getBestScore())
    }

    @Test
    fun example3() {
        assertEquals(146373, MarbleGame(13, 7999).getBestScore())
    }

    @Test
    fun example4() {
        assertEquals(2764, MarbleGame(17, 1104).getBestScore())
    }

    @Test
    fun example5() {
        assertEquals(54718, MarbleGame(21, 6111).getBestScore())
    }

    @Test
    fun example6() {
        assertEquals(37305, MarbleGame(30, 5807).getBestScore())
    }

    @Disabled
    @Test
    fun result() {
        println(MarbleGame(416, 71617).getBestScore())
    }

    @Disabled
    @Test
    fun result2() {
        println(MarbleGame(416, 7161700).getBestScore())
    }
}