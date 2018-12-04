package advent04

import common.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SleepingGuardsTest {
    private val input = "[1518-11-01 00:00] Guard #10 begins shift\n" +
            "[1518-11-01 00:05] falls asleep\n" +
            "[1518-11-01 00:25] wakes up\n" +
            "[1518-11-01 00:30] falls asleep\n" +
            "[1518-11-01 00:55] wakes up\n" +
            "[1518-11-01 23:58] Guard #99 begins shift\n" +
            "[1518-11-02 00:40] falls asleep\n" +
            "[1518-11-02 00:50] wakes up\n" +
            "[1518-11-03 00:05] Guard #10 begins shift\n" +
            "[1518-11-03 00:24] falls asleep\n" +
            "[1518-11-03 00:29] wakes up\n" +
            "[1518-11-04 00:02] Guard #99 begins shift\n" +
            "[1518-11-04 00:36] falls asleep\n" +
            "[1518-11-04 00:46] wakes up\n" +
            "[1518-11-05 00:03] Guard #99 begins shift\n" +
            "[1518-11-05 00:45] falls asleep\n" +
            "[1518-11-05 00:55] wakes up"

    @Test
    fun example() {
        assertEquals(240, SleepingGuards(input).getSleepingGuard())
    }


    @Disabled
    @Test
    fun result() {
        println(SleepingGuards(FileUtils.readFileDirectlyAsText("inputData/advent04_1.txt")).getSleepingGuard())
    }


    @Test
    fun example2() {
        assertEquals(4455, SleepingGuards(input).getSleepingGuardMostAsleep())
    }

    @Disabled
    @Test
    fun result2() {
        println(SleepingGuards(FileUtils.readFileDirectlyAsText("inputData/advent04_1.txt")).getSleepingGuardMostAsleep())
    }
}