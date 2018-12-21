package advent13

import java.util.*

class CrashCarts(input: String) {

    val roads: Array<Array<Road>>
    var carts: SortedSet<Cart> = TreeSet<Cart>()

    init {
        val split = input.split("\n")
        val rows = split.size
        val cols = split.map { it.length }.max() ?: 0

        roads = Array(rows) { i -> Array(cols) { j -> Road.EMPTY } }

        for (y in 0 until rows) {
            val chars = split[y].split("").filter { it != "" }
            for (x in 0 until cols) {
                val char = getChar(chars, x)
                var roadSymbol = Road.from(char)
                if (isCart(char)) {
                    val direction = Direction.from(char)
                    carts.add(Cart(x, y, direction, 0))
                    roadSymbol = direction.road
                }
                roads[y][x] = roadSymbol
            }
        }
    }

    private fun getChar(chars: List<String>, x: Int): String {
        if (x >= chars.size) {
            return " "
        } else {
            return chars[x]
        }
    }

    private fun isCart(s: String): Boolean {
        return Direction.values().map { it.symbol }.contains(s)
    }

    fun getFirstCrashLocation(): Pair<Int, Int> {
        while (true) {
            val newCarts = TreeSet<Cart>()
            for (cart in carts) {
                val moved = move(cart)
                val newCartsSize = newCarts.size
                newCarts.add(moved)
                if (newCartsSize == newCarts.size) {
                    return Pair(moved.x, moved.y)
                }
            }
            carts = newCarts
//            printMap()
        }
    }

    private fun printMap() {
        val rest = TreeSet<Cart>()
        carts.forEach { rest.add(it) }
        var current = rest.first()
        rest.remove(current)

        for (i in 0 until roads.size) {
            for (j in 0 until roads[i].size) {
                if (current != null && (current.x == j && current.y == i)) {
                    print(current.direction.symbol)
                    if (rest.size == 0) {
                        current = null
                    } else {
                        current = rest.first()
                        rest.remove(current)
                    }
                } else {
                    print(roads[i][j].symbol)
                }
            }
            println()
        }
        println()
        println()
    }

    private fun move(cart: Cart): Cart {
        return roads[cart.y][cart.x].move(cart)
    }
}