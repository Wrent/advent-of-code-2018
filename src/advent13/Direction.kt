package advent13

enum class Direction(val symbol: String, val road: Road) {
    UP("^", Road.VERTICAL),
    DOWN("v", Road.VERTICAL),
    LEFT("<", Road.HORIZONTAL),
    RIGHT(">", Road.HORIZONTAL);

    companion object Factory {
        fun from(input: String): Direction {
            return Direction.values().find { it.symbol.equals(input) } ?: UP
        }
    }
}