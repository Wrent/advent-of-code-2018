package advent12

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PlantGrowingTest {
    private val input = "#..#.#..##......###...###"

    private val rulesInput =
        "...## => #\n..#.. => #\n.#... => #\n.#.#. => #\n.#.## => #\n.##.. => #\n.#### => #\n#.#.# => #\n#.### => #\n##.#. => #\n##.## => #\n###.. => #\n###.# => #\n####. => #"

    @Test
    fun example() {
        assertEquals(
            325, PlantGrowing(
                input,
                rulesInput
            ).getSumOfGeneration(20)
        )
    }

    @Test
    fun exampleFirst() {
        testState("...#...#....#.....#..#..#..#...........", 1)
    }

    @Test
    fun exampleSecond() {
        testState("...##..##...##....#..#..#..##..........", 2)
    }

    @Test
    fun exampleLast() {
        testState("...#....##....#####...#######....#.#..##...", 20)
    }

    private fun testState(expected: String, generation: Long) {
        println("Expected:\t$expected")
        val actual = PlantGrowing(
            input,
            rulesInput
        ).getStateAfterGeneration(generation)
        println("Actual:\t\t$actual")
        assertTrue(expected.startsWith(actual))
    }

    @Test
    @Disabled
    fun result() {
        println(
            PlantGrowing(
                "#...#..##.......####.#..###..#.##..########.#.#...#.#...###.#..###.###.#.#..#...#.#..##..#######.##",
                FileUtils.readFileDirectlyAsText("inputData/advent12.txt")
            ).getSumOfGeneration(20)
        )
    }

    @Test
    @Disabled
    fun resultTwo() {
        println(
            PlantGrowing(
                "#...#..##.......####.#..###..#.##..########.#.#...#.#...###.#..###.###.#.#..#...#.#..##..#######.##",
                FileUtils.readFileDirectlyAsText("inputData/advent12.txt")
            ).getSumOfGeneration(150)
        )

        // 149 is 15670
        // 150 is 15671
        // difference is 91
        // 148 is 15579
        // 149 is 15670
        // difference is 91
        // =>
        // 50000000000 is
        println(15761L + (50000000000L - 150L) * 91L)
    }

}