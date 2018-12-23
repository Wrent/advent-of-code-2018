package advent15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ElvesAndGoblinsTest {

    val example = "#########\n" +
            "#G..G..G#\n" +
            "#.......#\n" +
            "#.......#\n" +
            "#G..E..G#\n" +
            "#.......#\n" +
            "#.......#\n" +
            "#G..G..G#\n" +
            "#########";

    @Test
    internal fun testMovement() {
        val example = ElvesAndGoblins(example);
        val roundOne = "#########\n" +
                "#.G...G.#\n" +
                "#...G...#\n" +
                "#...E..G#\n" +
                "#.G.....#\n" +
                "#.......#\n" +
                "#G..G..G#\n" +
                "#.......#\n" +
                "#########";
        val roundTwo = "#########\n" +
                "#..G.G..#\n" +
                "#...G...#\n" +
                "#.G.E.G.#\n" +
                "#.......#\n" +
                "#G..G..G#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#########"
        val roundThree = "#########\n" +
                "#.......#\n" +
                "#..GGG..#\n" +
                "#..GEG..#\n" +
                "#G..G...#\n" +
                "#......G#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#########";
        assertEquals(roundOne, example.performMovement())
        assertEquals(roundTwo, example.performMovement())
//        assertEquals(roundThree, example.performMovement())
    }

    @Test
    internal fun testInit() {
        val example = ElvesAndGoblins(example);
        assertEquals(this.example, example.printGame())
    }
}