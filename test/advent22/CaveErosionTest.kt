package advent22

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.awt.Point

internal class CaveErosionTest {

    @Test
    internal fun testExample() {
        Assertions.assertEquals(114, CaveErosion(510, Point(10, 10)).getRiskLevel())
    }

    @Test
    internal fun testExample2() {
        Assertions.assertEquals(45, CaveErosion(510, Point(10, 10)).fastestWayToReachTarget())
    }

    @Test
    @Disabled
    internal fun result1() {
        println(CaveErosion(11820, Point(7, 782)).getRiskLevel())
    }

    @Test
    @Disabled
    internal fun result2() {
        println(CaveErosion(11820, Point(7, 782)).fastestWayToReachTarget())
    }
}