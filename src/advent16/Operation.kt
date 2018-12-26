package advent16

abstract class Operation {
    abstract fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers
}

class Addr : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) + registers.read(b))
    }
}

class Addi : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) + b)
    }
}

class Mulr : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) * registers.read(b))
    }
}

class Muli : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) * b)
    }
}

class Banr : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) and registers.read(b))
    }
}

class Bani : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) and b)
    }
}


class Borr : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) or registers.read(b))
    }
}

class Bori : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) or b)
    }
}


class Setr : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a))
    }
}

class Seti : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, a)
    }
}

class Gtir : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, a > registers.read(b))
    }
}

class Gtri : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) > b)
    }
}

class Gtrr : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, registers.read(a) > registers.read(b))
    }
}

class Eqir : Operation() {
    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        return registers.write(c, a == registers.read(b))
    }
}

class Eqri : Operation() {

    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {

        return registers.write(c, registers.read(a) == b)
    }
}

class Eqrr : Operation() {
    val encountered = HashSet<Int>()

    override fun perform(registers: Registers, a: Int, b: Int, c: Int): Registers {
        if (!encountered.contains(registers.read(a))) {
            println(registers.read(a))
            encountered.add(registers.read(a))
        }

        return registers.write(c, registers.read(a) == registers.read(b))
    }
}
