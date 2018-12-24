package advent16

import java.lang.Integer.parseInt

class TimeMachineInstructions(input: String) {
    val observations: MutableList<Observation> = mutableListOf()
    val operations: Map<Int, Operation> =
        mapOf(
            Pair(12, Addi()),
            Pair(8, Addr()),
            Pair(14, Mulr()),
            Pair(10, Muli()),
            Pair(11, Banr()),
            Pair(1, Bani()),
            Pair(9, Borr()),
            Pair(5, Bori()),
            Pair(7, Setr()),
            Pair(6, Seti()),
            Pair(3, Gtir()),
            Pair(0, Gtri()),
            Pair(15, Gtrr()),
            Pair(4, Eqir()),
            Pair(13, Eqri()),
            Pair(2, Eqrr())
        )

    init {
        val split = input.split("\n")

        for (i in 0 until split.size / 4) {
            val before = split[i * 4]
            val after = split[i * 4 + 2]
            val instructions = split[i * 4 + 1]

            observations.add(Observation(parseRegisters(before), parseRegisters(after), parseInstruction(instructions)))
        }
    }

    fun getBehavesLikeThreeOrMore(): Int {
        var cnt = 0

        observations.forEach { ob ->
            val matchCount = operations.map { ob.matches(it.value) }
                .filter { it }
                .count()

            if (matchCount >= 3) {
                cnt++
            }

//            if (matchCount == 1) {
//                val first = operations.filter { ob.matches(it.value) }.toList().first()
//                println(first.second.javaClass.toString() + " " + ob.instruction.opcode)
//            }

            if (matchCount == 10) {
                val operations = operations.filter { ob.matches(it.value) }
                    .toList()
                    .filter { it.first < 0 }
                    .map { it.second.javaClass.toString() }
                println(operations + " " + ob.instruction.opcode)
            }
        }
        return cnt
    }

    private fun parseRegisters(input: String): Registers {
        val a = parseInt(input.get(9).toString())
        val b = parseInt(input.get(12).toString())
        val c = parseInt(input.get(15).toString())
        val d = parseInt(input.get(18).toString())

        return Registers(a, b, c, d)
    }

    private fun parseInstruction(instructions: String): Instruction {
        val regex = """(\d+) (\d+) (\d+) (\d+)""".toRegex()
        val matchResult = regex.find(instructions)
        val (opcode, a, b, c) = matchResult!!.destructured

        return Instruction(parseInt(opcode), parseInt(a), parseInt(b), parseInt(c), "")
    }

    fun executeProgram(input: String): Int {
        val instructions = input.split("\n").map { parseInstruction(it) }

        var registers: Registers? = Registers(0, 0, 0, 0)

        instructions.forEach {
            registers = operations.get(it.opcode)?.perform(registers!!, it.a, it.b, it.c)
        }
        return registers?.one ?: 0
    }
}