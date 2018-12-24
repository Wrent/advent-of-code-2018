package advent19

import common.FileUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TimeMachineInstructionsWithJumpsTest {

    @Test
    internal fun testExample() {
        val input = "#ip 0\n" +
                "seti 5 0 1\n" +
                "seti 6 0 2\n" +
                "addi 0 1 0\n" +
                "addr 1 2 3\n" +
                "setr 1 0 0\n" +
                "seti 8 0 4\n" +
                "seti 9 0 5"
        Assertions.assertEquals(6, TimeMachineInstructionsWithJumps(input).getFinalValueInRegisterZero())
    }

    @Test
    internal fun testRegression() {
        Assertions.assertEquals(
            1620,
            TimeMachineInstructionsWithJumps(FileUtils.readFileDirectlyAsText("inputData/advent19.txt")).getFinalValueInRegisterZero()
        )
    }

    @Test
    @Disabled
    internal fun result1() {
        println(TimeMachineInstructionsWithJumps(FileUtils.readFileDirectlyAsText("inputData/advent19.txt")).getFinalValueInRegisterZero())
    }

    @Test
    @Disabled
    internal fun result2() {
        println(TimeMachineInstructionsWithJumps(FileUtils.readFileDirectlyAsText("inputData/advent19.txt")).getFinalValueInRegisterZeroSecond())
    }


    @Test
    @Disabled
    internal fun result3() {
        println(TimeMachineInstructionsWithJumps(FileUtils.readFileDirectlyAsText("inputData/advent19.txt")).getFinalValueInRegisterZeroSecond())
    }

    @Test
    @Disabled
    internal fun result4() {
        var zero = 1
        var one = 0
        var two = 0
        var three = 0
        var four = 0
        var five = 0

        four += 17
        two += 2
        four++
        two *= 2
        four++
        two *= four
        four++
        two *= 11
        four++
        one += 6
        four++
        one *= four
        four++
        one += 18
        four++
        two += one
        four++
        four += zero
        four++
        one = four
        four++
        one *= four
        four++
        one += four
        four++
        one *= four
        four++
        one *= 14
        four++
        one *= four
        four++
        two += one
        four++
        zero = 0
        four++
        four = 0
        four++
        // 0 10550400 10551386 0 1 0

        five = 1
        four++
        three = 1
        four++

        //cycle start
        while (three <= two) {
            one = five * three
            four++

            if (one == two) {
                one = 1
            } else {
                one = 0
            }
            four++

            four += one
            four++

            four += 1
            four++

            three += 1
            four++

            if (three > two) {
                one = 1
                four++
                break
            } else {
                one = 0
            }
            four++

            four += one
            four++

            four = 2
            four++

            // 0 0 10551386 2 3 1

            //cycle end
        }

        four += one
        four++

        five += 1
        four++

        if (five > two) {
            one = 1
        } else {
            one = 2
        }
        four++

        four += one
        four++

        four = 1
        four++




        println(zero.toString() + " " + one + " " + two + " " + three + " " + four + " " + five)

        // oba cykly jedou az do 10551386
        // pokud narazi na rozklad 10551386, tak prictou do 0
        // petka roste pomalejc
        // 2 × 5275693
        // kdyz bude petka 1, tak se pricte 1 kdyz bude trojka nase cislo
        // kduz bude petka 2, tak se pricte 2 kdyz bude trojka 5275693
        // kdyz bude petka 5275693, tak se pricte 5275693 kdyz bude trojka 2
        // kdyz bue petka 10551386, tak se pricte 10551386 kdyz bude trojka 1

    }

}