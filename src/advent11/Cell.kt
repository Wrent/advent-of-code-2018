package advent11

class Cell(val x: Int, val y: Int, serialNumber: Int) {
    val power: Int

    init {
        val rackId = x + 10
        var tempPower = rackId
        tempPower *= y
        tempPower += serialNumber
        tempPower *= rackId
        tempPower /= 100
        tempPower %= 10
        tempPower -= 5

        power = tempPower
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cell

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String {
        return "Cell(x=$x, y=$y, power=$power)"
    }


}