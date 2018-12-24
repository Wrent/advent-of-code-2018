package advent18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class GameOfForestTest {
    @Test
    internal fun testExample() {
        val input = ".#.#...|#.\n" +
                ".....#|##|\n" +
                ".|..|...#.\n" +
                "..|#.....#\n" +
                "#.#|||#|#|\n" +
                "...#.||...\n" +
                ".|....|...\n" +
                "||...#|.#|\n" +
                "|.||||..|.\n" +
                "...#.|..|."
        assertEquals(1147, GameOfForest(input).valueAfterMinutes(10))
    }

    @Test
    @Disabled
    internal fun result1() {
//        println(GameOfForest(FileUtils.readFileDirectlyAsText("inputData/advent18.txt")).valueAfterMinutes(10000))

        //repetition:
//        9971 203580 0
//        9972 201260 1
//        9973 201950 2
//        9974 200675 3
//        9975 202208 4
//        9976 200151 5
//        9977 198948 6
//        9978 191420 7
//        9979 189168 8
//        9980 185082 9
//        9981 185227 10
//        9982 185320 11
//        9983 185790 12
//        9984 186120 13
//        9985 189956 14
//        9986 190068 15
//        9987 191080 16
//        9988 190405 17
//        9989 193795 18
//        9990 190950 19
//        9991 193569 20
//        9992 194350 21
//        9993 196308 22
//        9994 195364 23
//        9995 197911 24
//        9996 199755 25
//        9997 201144 26
//        9998 201607 27
//        9999 203580
        val positionZero = 1000000000 - 1 - 9971
        println(positionZero) // position zero
        println(positionZero % 28)
    }
}