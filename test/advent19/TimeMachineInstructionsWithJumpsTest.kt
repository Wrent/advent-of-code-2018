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
    internal fun result21() {
        println(TimeMachineInstructionsWithJumps(FileUtils.readFileDirectlyAsText("inputData/advent21.txt")).getLowestZeroRegisterVal())
    }


    @Test
    @Disabled
    internal fun result21_1() {
        var zero = 0
        var one = 0
        var two = 0
        var three = 0
        var four = 0
        var five = 0

        three = 123
        one++
        three = three and 456
        one++
        if (three == 72) {
            three = 1
        } else {
            three = 0
        }
        one++

        one += three
        one++

        three = 0
        one++

        five = three or 65536
        one++

        three = 15028787
        one++

        two = five and 255
        one++

        three += two
        one++

        three = three and 16777215
        one++

        three *= 65899
        one++

        three = three and 16777215
        one++

        if (256 > five) {
            two = 1
        } else {
            two = 0
        }
        one++

        one += two
        one++

        one += 1 // tohle by se vynechalo, kdyby bylo 65536 v petce mensi nez 256
        one++ // a misto toho by se skocilo na eqrr 3 0 2


        two = 0
        one++

        four = two + 1
        one++

        four *= 256
        one++

        if (four > five) {
            four = 1
        } else {
            four = 0
        }
        one++

        one += four
        one++

        one += 1 // tohle by se vynechalo, kdyby bylo 65536 v petce mensi nez 256 ve ctyrce
        one++ // a misto toho by se skocilo na setr 2 4 5

        two += 1
        one++

        one =
                17 // skok na addi 2 1 4 (takze misto nuly je ctyrka 2, takze pak je razem 512 a takhle nam poroste az k 65536
        one++


        // skok na setr 2 4 5
        five = two // two by ted melo nejspis byt 255
        one++

        one = 7
        one++ // skok na osm, tedy bani 5 255 2


//        one = 27 // skok na eqrr 3 0 2
//        one++
//
//        if (zero == three) {
//            two = 1
//        } else {
//            two = 0
//        }
//        one++
//
//        one += two

        println((((255L + 6196817L) and 16777215L) * 65899L) and 16777215L)


        println(zero.toString() + " " + one + " " + two + " " + three + " " + four + " " + five)

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