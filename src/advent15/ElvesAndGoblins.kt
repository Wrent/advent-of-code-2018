package advent15

class ElvesAndGoblins(input: String) {
    var cavern: Array<Array<Cavern>>
    val rowsCnt: Int
    val colsCnt: Int


    init {
        val rows = input.split("\n");
        rowsCnt = rows.size
        colsCnt = rows[0].length
        cavern = Array(rowsCnt) { Array(colsCnt) { Wall() as Cavern } };

        rows.forEachIndexed { i, s ->
            s.forEachIndexed { j, c ->
                if (c == '#') {
                    cavern[i][j] = Wall()
                } else if (c == '.') {
                    cavern[i][j] = Cave()
                    cavern
                } else if (c == 'G') {
                    cavern[i][j] = Cave()
                    addEntity(cavern[i][j], Goblin())
                } else if (c == 'E') {
                    cavern[i][j] = Cave()
                    addEntity(cavern[i][j], Elf())
                }
            }
        }
    }

    fun performMovement(): String {
        cavern.forEachIndexed { i, row ->
            row.forEachIndexed { j, cavern ->
                if (cavern.hasEntity() && cavern.entity?.done != true) {
                    val coords = Pair(i, j)
                    val distances = getDistances(coords)
                    val enemies = getEnemies(cavern.entity!!.getEnemy())

                    val closest = getClosest(enemies, distances)
                    //move
                    if (closest != null) {
                        val distancesFromClosest = getDistances(closest)
                        val newCoords = getClosest(getNeighbors(coords), distancesFromClosest)

                        if (newCoords != null) {
                            cavernAt(newCoords).entity = cavern.entity
                            cavernAt(coords).entity = null
                            cavernAt(newCoords).entity?.done = true
                        }
                    }
                    cavern.entity?.done = true
                }
            }
        }

        cavern.forEachIndexed { i, row ->
            row.forEachIndexed { j, cavern ->
                cavern.entity?.done = false
            }
        }

        return printGame();
    }

    fun printGame(): String {
        val sb = StringBuilder()
        cavern.forEach {
            it.forEach {
                sb.append(it.print())
            }
            sb.append("\n")
        }
        return sb.toString().trim()
    }

    private fun addEntity(cavern: Cavern, entity: Entity) {
        cavern.entity = entity;
    }

    fun getEmptySquaresOfEntity(coords: Pair<Int, Int>, entity: String): List<Pair<Int, Int>> {
        val cave = cavernAt(coords)
        if (cave.hasEntity(entity)) {
            val neighbors = getNeighbors(coords)
            return neighbors
                .filter { cavern[it.first][it.second].isEmpty() }
        }
        return emptyList()
    }

    private fun cavernAt(coords: Pair<Int, Int>) = cavern[coords.first][coords.second]

    private fun getNeighbors(coords: Pair<Int, Int>): List<Pair<Int, Int>> {
        val list = mutableListOf<Pair<Int, Int>>()

        if (coords.first > 0) {
            list.add(Pair(coords.first - 1, coords.second))
        }
        if (coords.first < rowsCnt - 1) {
            list.add(Pair(coords.first + 1, coords.second))
        }
        if (coords.second > 0) {
            list.add(Pair(coords.first, coords.second - 1))
        }
        if (coords.second < colsCnt - 1) {
            list.add(Pair(coords.first, coords.second + 1))
        }

        return list

    }

    private fun getDistances(coords: Pair<Int, Int>): Map<Pair<Int, Int>, Int> {
        val map = mutableMapOf<Pair<Int, Int>, Int>()

        map.put(coords, 0)
        addNeighbors(coords, map, 1)

        return map
    }

    private fun addNeighbors(
        coords: Pair<Int, Int>,
        map: MutableMap<Pair<Int, Int>, Int>,
        distance: Int
    ) {
        val neighbors = getNeighbors(coords)

        neighbors.forEach {
            if (cavern[it.first][it.second].isEmpty()) {
                if (map.containsKey(it)) {
                    if (map.get(it)!! > distance) {
                        map.put(it, distance)
                        addNeighbors(it, map, distance + 1)
                    }
                } else {
                    map.put(it, distance)
                    addNeighbors(it, map, distance + 1)
                }
            } else {
                map.put(it, -1)
            }
        }
    }

    private fun getEnemies(enemy: String): List<Pair<Int, Int>> {
        val list = mutableListOf<Pair<Int, Int>>()
        cavern.forEachIndexed { i, row ->
            row.forEachIndexed { j, cavern ->
                list.addAll(getEmptySquaresOfEntity(Pair(i, j), enemy))
            }
        }
        return list
    }

    private fun getClosest(coords: List<Pair<Int, Int>>, distances: Map<Pair<Int, Int>, Int>): Pair<Int, Int>? {
        val sortedCoords = sortByDistances(coords, distances)
        if (sortedCoords.isEmpty()) {
            return null
        }
        val closesCoords = sortedCoords.filter { distances.get(it) == distances.get(sortedCoords.get(0)) }

        return getFirstInReadingOrder(closesCoords)
    }

    private fun sortByDistances(
        enemies: List<Pair<Int, Int>>,
        distances: Map<Pair<Int, Int>, Int>
    ) = enemies.filter { distances.contains(it) }.sortedBy { distances.get(it) }.filter { distances.get(it) != -1 }

    private fun getFirstInReadingOrder(coords: List<Pair<Int, Int>>): Pair<Int, Int>? {
        return coords.sortedWith(compareBy({ it.first }, { it.second })).first()
    }

}
