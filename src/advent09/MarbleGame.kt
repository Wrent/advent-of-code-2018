package advent09

class MarbleGame(val players: Int, val lastMarble: Long) {
    val scores = Array(players, { i -> 0L })

    fun getBestScore(): Long {
        var current = Marble(0L)
        var player = 0

        for (i in 1..lastMarble) {
            if (i % 23 == 0L) {
                addScore(player, i)
                current = removeMarble(player, current)
            } else {
                current = placeMarble(i, current)
            }
            player = nextPlayer(Math.toIntExact(i))
        }

        return scores.max()!!
    }

    private fun addScore(player: Int, score: Long) {
        scores[player] += score
    }

    private fun removeMarble(player: Int, current: Marble): Marble {
        val toBeRemoved = current.prev.prev.prev.prev.prev.prev.prev
        val next = toBeRemoved.next
        val prev = toBeRemoved.prev
        addScore(player, toBeRemoved.value)

        next.prev = prev
        prev.next = next

        return next
    }

    private fun placeMarble(i: Long, current: Marble): Marble {
        val added = Marble(i)
        val prev = current.next
        val next = current.next.next
        added.prev = prev
        added.next = next

        next.prev = added
        prev.next = added

        return added
    }

    private fun nextPlayer(i: Int): Int {
        return i % players
    }
}