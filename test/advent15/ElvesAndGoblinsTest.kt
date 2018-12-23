package advent15

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
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
            "#########"

    @Test
    internal fun testMovement() {
        val example = ElvesAndGoblins(example)
        val roundOne = "#########\n" +
                "#.G...G.#\n" +
                "#...G...#\n" +
                "#...E..G#\n" +
                "#.G.....#\n" +
                "#.......#\n" +
                "#G..G..G#\n" +
                "#.......#\n" +
                "#########"
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
                "#########"
        assertEquals(roundOne, example.roundAndPrint())
        assertEquals(roundTwo, example.roundAndPrint())
        assertEquals(roundThree, example.roundAndPrint())
    }

    @Test
    internal fun testExampleOne() {
        val input = "#######\n" +
                "#.G...#\n" +
                "#...EG#\n" +
                "#.#.#G#\n" +
                "#..G#E#\n" +
                "#.....#\n" +
                "#######"

        assertEquals(27730, ElvesAndGoblins(input).getOutcome(3))
    }

    @Test
    internal fun testExampleOneImproved() {
        val input = "#######\n" +
                "#.G...#\n" +
                "#...EG#\n" +
                "#.#.#G#\n" +
                "#..G#E#\n" +
                "#.....#\n" +
                "#######"

        assertEquals(4988, ElvesAndGoblins(input).getOutcomeImproved())
    }

    @Test
    internal fun testExampleTwo() {
        val input = "#######\n" +
                "#G..#E#\n" +
                "#E#E.E#\n" +
                "#G.##.#\n" +
                "#...#E#\n" +
                "#...E.#\n" +
                "#######"
        assertEquals(36334, ElvesAndGoblins(input).getOutcome(3))
    }

    @Test
    internal fun testExampleTwoImproved() {
        val input = "#######\n" +
                "#G..#E#\n" +
                "#E#E.E#\n" +
                "#G.##.#\n" +
                "#...#E#\n" +
                "#...E.#\n" +
                "#######"
        assertEquals(31284, ElvesAndGoblins(input).getOutcomeImproved())
    }

    @Test
    internal fun testExampleThree() {
        val input = "#######\n" +
                "#E..EG#\n" +
                "#.#G.E#\n" +
                "#E.##E#\n" +
                "#G..#.#\n" +
                "#..E#.#\n" +
                "#######"
        assertEquals(39514, ElvesAndGoblins(input).getOutcome(3))
    }

    @Test
    internal fun testExampleThreeImproved() {
        val input = "#######\n" +
                "#E..EG#\n" +
                "#.#G.E#\n" +
                "#E.##E#\n" +
                "#G..#.#\n" +
                "#..E#.#\n" +
                "#######"
        assertEquals(3478, ElvesAndGoblins(input).getOutcomeImproved())
    }

    @Test
    internal fun testExampleFour() {
        val input = "#######\n" +
                "#E.G#.#\n" +
                "#.#G..#\n" +
                "#G.#.G#\n" +
                "#G..#.#\n" +
                "#...E.#\n" +
                "#######"
        assertEquals(27755, ElvesAndGoblins(input).getOutcome(3))
    }

    @Test
    internal fun testExampleFourImproved() {
        val input = "#######\n" +
                "#E.G#.#\n" +
                "#.#G..#\n" +
                "#G.#.G#\n" +
                "#G..#.#\n" +
                "#...E.#\n" +
                "#######"
        assertEquals(6474, ElvesAndGoblins(input).getOutcomeImproved())
    }

    @Test
    internal fun testExampleSix() {
        val input = "#########\n" +
                "#G......#\n" +
                "#.E.#...#\n" +
                "#..##..G#\n" +
                "#...##..#\n" +
                "#...#...#\n" +
                "#.G...G.#\n" +
                "#.....G.#\n" +
                "#########"
        assertEquals(18740, ElvesAndGoblins(input).getOutcome(3))
    }

    @Test
    internal fun testExampleSixImproved() {
        val input = "#########\n" +
                "#G......#\n" +
                "#.E.#...#\n" +
                "#..##..G#\n" +
                "#...##..#\n" +
                "#...#...#\n" +
                "#.G...G.#\n" +
                "#.....G.#\n" +
                "#########"
        assertEquals(1140, ElvesAndGoblins(input).getOutcomeImproved())
    }

    @Test
    internal fun testInit() {
        val example = ElvesAndGoblins(example)
        assertEquals(this.example, example.printGame())
    }

    // TODO some tests have wrong inputs, needs to be fixed
    // TODO of by one error for some rounds count

    @Test
    @Disabled
    internal fun result1() {
        println(ElvesAndGoblins(FileUtils.readFileDirectlyAsText("inputData/advent15.txt")).getOutcome(3))
    }

    @Test
    @Disabled
    internal fun result2() {
        println(ElvesAndGoblins(FileUtils.readFileDirectlyAsText("inputData/advent15.txt")).getOutcomeImproved())
    }
}