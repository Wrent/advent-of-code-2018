package advent14

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class HotChocolateTest {
    @Test
    internal fun example1() {
        assertEquals("5158916779", HotChocolate(3, 7).getRecipesAfter(10, 9))
    }

    @Test
    internal fun example2() {
        assertEquals("0124515891", HotChocolate(3, 7).getRecipesAfter(10, 5))
    }

    @Test
    internal fun example3() {
        assertEquals("9251071085", HotChocolate(3, 7).getRecipesAfter(10, 18))
    }

    @Test
    internal fun example4() {
        assertEquals("5941429882", HotChocolate(3, 7).getRecipesAfter(10, 2018))
    }


    @Test
    @Disabled
    internal fun result() {
        println(HotChocolate(3, 7).getRecipesAfter(10, 768071))
    }

    @Test
    internal fun exampleTwo1() {
        assertEquals(9, HotChocolate(3, 7).howManyRecipesUntil("51589"))
    }

    @Test
    internal fun exampleTwo2() {
        assertEquals(5, HotChocolate(3, 7).howManyRecipesUntil("01245"))
    }

    @Test
    internal fun exampleTwo3() {
        assertEquals(18, HotChocolate(3, 7).howManyRecipesUntil("92510"))
    }

    @Test
    internal fun exampleTwo4() {
        assertEquals(2018, HotChocolate(3, 7).howManyRecipesUntil("59414"))
    }

    @Test
    @Disabled
    internal fun result2() {
        println(HotChocolate(3, 7).howManyRecipesUntil("768071"))
    }

}