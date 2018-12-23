package advent16

class Observation(val before: Registers, val after: Registers, val instruction: Instruction) {

    fun matches(operation: Operation): Boolean {
        return after.equals(operation.perform(before, instruction.a, instruction.b, instruction.c))
    }
}

data class Instruction(val opcode: Int, val a: Int, val b: Int, val c: Int)