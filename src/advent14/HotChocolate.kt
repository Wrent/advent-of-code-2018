package advent14

import java.lang.Integer.parseInt

class HotChocolate(first: Int, second: Int) {

    val recipes = ArrayList<Int>()

    init {
        recipes.add(first)
        recipes.add(second)
    }

    fun getRecipesAfter(count: Int, after: Int): String {
        var currentA = 0
        var currentB = 1

        while (recipes.size < count + after) {
            val currentAValue = recipes[currentA]
            val currentBValue = recipes[currentB]
            val next = currentAValue + currentBValue

            addDigitsToRecipes(next)

            currentA = shift(currentA, currentAValue)
            currentB = shift(currentB, currentBValue)
        }

        return printLastRecipes(count, after)
    }

    fun howManyRecipesUntil(s: String): Int {
        var currentA = 0
        var currentB = 1

        while (!containsRecipe(s)) {
            val currentAValue = recipes[currentA]
            val currentBValue = recipes[currentB]
            val next = currentAValue + currentBValue

            addDigitsToRecipes(next)

            currentA = shift(currentA, currentAValue)
            currentB = shift(currentB, currentBValue)
        }
        recipes.subList(recipes.size - 100, recipes.size).forEach { print(it.toString() + " ") }
        // todo this should check the whole string
        if (recipes.last().toString().equals(s.last().toString())) {
            return recipes.size - s.length
        } else {
            return recipes.size - s.length - 1
        }
    }

    private fun containsRecipe(s: String): Boolean {
        if (recipes.size < s.length) {
            return false
        }

        val sbLast = StringBuilder()
        for (i in recipes.size - s.length until recipes.size) {
            sbLast.append(recipes[i])
        }
        val lastStr = sbLast.toString()

        if (recipes.size < s.length + 1) {
            return lastStr.equals(s)
        }
        val sbLastMinus = StringBuilder()
        for (i in recipes.size - s.length - 1 until recipes.size - 1) {
            sbLastMinus.append(recipes[i])
        }
        val lastMinusStr = sbLastMinus.toString()

        return s.equals(lastStr) || s.equals(lastMinusStr)
    }


    private fun addDigitsToRecipes(next: Int) {
        val toString = next.toString()

        toString.split("").filter { it != "" }
            .forEach { recipes.add(parseInt(it)) }
    }


    private fun shift(current: Int, currentValue: Int): Int {
        val res = current + 1 + currentValue
        if (res >= recipes.size) {
            return res % recipes.size
        } else {
            return res
        }
    }

    private fun printLastRecipes(count: Int, after: Int): String {
        val sb = StringBuilder()
        for (i in after until after + count) {
            sb.append(recipes.get(i))
        }
        return sb.toString()
    }
}