package advent01

import org.junit.jupiter.api.Disabled
import util.FileUtils.Companion.readFileDirectlyAsText
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test as test

class FrequencyCalibratorTest() {
    @test fun example1() {
        testCalibrator("+1\n-2\n+3\n+1", 3)
    }

    @test fun example2() {
        testCalibrator("+1\n+1\n+1", 3)
    }

    @test fun example3() {
        testCalibrator("+1\n+1\n-2", 0)
    }

    @test fun example4() {
        testCalibrator("-1\n-2\n-3", -6)
    }

    @Disabled
    @test fun result() {
        println(FrequencyCalibrator(readFileDirectlyAsText("inputData/advent01_1.txt")).getFrequency())
    }

    @test fun example2_1() {
        testCalibratorRepeating("+1\n-2\n+3\n+1", 2)
    }

    @test fun example2_2() {
        testCalibratorRepeating("+1\n-1", 0)
    }

    @test fun example2_3() {
        testCalibratorRepeating("+3\n+3\n+4\n-2\n-4", 10)
    }

    @test fun example2_4() {
        testCalibratorRepeating("-6\n+3\n+8\n+5\n-6", 5)
    }

    @test fun example2_5() {
        testCalibratorRepeating("+7\n+7\n-2\n-7\n-4", 14)
    }

    @Disabled
    @test fun result2() {
        println(FrequencyCalibrator(readFileDirectlyAsText("inputData/advent01_1.txt")).getFirstRepeatingFrequency())
    }

    private fun testCalibrator(input: String, result: Long) {
        val calibrator = FrequencyCalibrator(input)
        assertEquals(result, calibrator.getFrequency())
    }

    private fun testCalibratorRepeating(input: String, result: Long) {
        val calibrator = FrequencyCalibrator(input)
        assertEquals(result, calibrator.getFirstRepeatingFrequency())
    }
}