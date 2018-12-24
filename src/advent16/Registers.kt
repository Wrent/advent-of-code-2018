package advent16

class Registers(val one: Int, val two: Int, val three: Int, val four: Int, val five: Int, val six: Int) {

    constructor(one: Int, two: Int, three: Int, four: Int) : this(one, two, three, four, 0, 0)

    fun read(register: Int): Int {
        if (register == 0) {
            return one
        } else if (register == 1) {
            return two
        } else if (register == 2) {
            return three
        } else if (register == 3) {
            return four
        } else if (register == 4) {
            return five
        } else if (register == 5) {
            return six
        }
        return 0
    }

    fun write(register: Int, value: Int): Registers {
        if (register == 0) {
            return Registers(value, two, three, four, five, six)
        } else if (register == 1) {
            return Registers(one, value, three, four, five, six)
        } else if (register == 2) {
            return Registers(one, two, value, four, five, six)
        } else if (register == 3) {
            return Registers(one, two, three, value, five, six)
        } else if (register == 4) {
            return Registers(one, two, three, four, value, six)
        } else if (register == 5) {
            return Registers(one, two, three, four, five, value)
        }
        return Registers(one, two, three, four, five, six)
    }

    fun write(register: Int, value: Boolean): Registers {
        val intValue: Int
        if (value) {
            intValue = 1
        } else {
            intValue = 0
        }
        return write(register, intValue)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Registers

        if (one != other.one) return false
        if (two != other.two) return false
        if (three != other.three) return false
        if (four != other.four) return false
        if (five != other.five) return false
        if (six != other.six) return false

        return true
    }

    override fun hashCode(): Int {
        var result = one
        result = 31 * result + two
        result = 31 * result + three
        result = 31 * result + four
        result = 31 * result + five
        result = 31 * result + six
        return result
    }

    override fun toString(): String {
        return "0=$one $two $three $four ($five) $six"
    }


}