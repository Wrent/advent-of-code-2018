package advent20

import java.awt.Point
import java.util.*

class DoorRegex(input: String) {
    val rooms = mutableMapOf<Point, Room>()

    init {

        val deque: Deque<Point> = LinkedList<Point>()
        deque.push(Point(0, 0))
        rooms.putIfAbsent(deque.peek(), Room())
        for (c in input) {
            if (c == '^') {
                continue
            }

            if (c == '$') {
                setAllUnknownsToNo()
                break
            }

            if (c == '(') {
                deque.push(deque.peek())
            }

            if (c == ')') {
                deque.pop()
            }

            if (c == '|') {
                deque.pop()
                deque.push(deque.peek())

            }

            parseDirection(c, deque)
        }
    }

    private fun parseDirection(c: Char, deque: Deque<Point>) {
        if (c == 'W') {
            val current = deque.pop()
            rooms[current]?.west = Door.YES
            val next = west(current)
            rooms.putIfAbsent(next, Room())
            rooms[next]?.east = Door.YES
            deque.push(next)
            return
        }

        if (c == 'E') {
            val current = deque.pop()
            rooms[current]?.east = Door.YES
            val next = east(current)
            rooms.putIfAbsent(next, Room())
            rooms[next]?.west = Door.YES
            deque.push(next)
            return
        }

        if (c == 'N') {
            val current = deque.pop()
            rooms[current]?.north = Door.YES
            val next = north(current)
            rooms.putIfAbsent(next, Room())
            rooms[next]?.south = Door.YES
            deque.push(next)
            return
        }

        if (c == 'S') {
            val current = deque.pop()
            rooms[current]?.south = Door.YES
            val next = south(current)
            rooms.putIfAbsent(next, Room())
            rooms[next]?.north = Door.YES
            deque.push(next)
            return
        }
    }

    private fun west(current: Point) = Point(current.x - 1, current.y)

    private fun east(current: Point) = Point(current.x + 1, current.y)

    private fun south(current: Point) = Point(current.x, current.y + 1)

    private fun north(current: Point) = Point(current.x, current.y - 1)

    private fun setAllUnknownsToNo() {
        rooms.values.forEach { it.setAllUnknownsToNo() }
    }

    fun getFurthestRoom(): Int {
        calculateDistances()

        return rooms.values.map { it.distance }.max()!!
    }

    fun getCntRoomsOverThousandDoors(): Any? {
        calculateDistances()

        return rooms.values.map { it.distance }.filter { it >= 1000 }.count()
    }

    private fun calculateDistances() {
        val stack: Deque<Pair<Point, Int>> = LinkedList()
        stack.push(Pair(Point(0, 0), 0))

        while (!stack.isEmpty()) {
            val (point, distance) = stack.pop()

            val room = rooms[point]
            room?.distance = distance

            if (room?.north == Door.YES) {
                setDistance(north(point), distance + 1, stack)
            }
            if (room?.south == Door.YES) {
                setDistance(south(point), distance + 1, stack)
            }
            if (room?.east == Door.YES) {
                setDistance(east(point), distance + 1, stack)
            }
            if (room?.west == Door.YES) {
                setDistance(west(point), distance + 1, stack)
            }
        }
    }

    private fun setDistance(point: Point, distance: Int, stack: Deque<Pair<Point, Int>>) {
        val room = rooms[point]

        if (room?.distance!! > distance) {
            room.distance = distance
            stack.push(Pair(point, distance))
        }
    }

//    private fun markDistances(point: Point, distance: Int) {
//        val room = rooms[point]
//
//        if (room?.north == Door.YES) {
//            setDistance(north(point), distance)
//        }
//        if (room?.south == Door.YES) {
//            setDistance(south(point), distance)
//        }
//        if (room?.east == Door.YES) {
//            setDistance(east(point), distance)
//        }
//        if (room?.west == Door.YES) {
//            setDistance(west(point), distance)
//        }
//    }
//
//    private fun setDistance(point: Point, distance: Int) {
//        if (distance < rooms[point]!!.distance) {
//            rooms[point]?.distance = distance
//            markDistances(point, distance + 1)
//        }
//    }

}

class Room {
    var north = Door.UNKNOWN
    var south = Door.UNKNOWN
    var west = Door.UNKNOWN
    var east = Door.UNKNOWN

    var distance = Int.MAX_VALUE

    fun setAllUnknownsToNo() {
        if (north == Door.UNKNOWN) {
            north = Door.NO
        }
        if (south == Door.UNKNOWN) {
            south = Door.NO
        }
        if (west == Door.UNKNOWN) {
            west = Door.NO
        }
        if (east == Door.UNKNOWN) {
            east = Door.NO
        }
    }


}

enum class Door {
    YES,
    NO,
    UNKNOWN;
}