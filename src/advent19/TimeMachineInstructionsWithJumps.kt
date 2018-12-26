package advent19

import advent16.*
import java.lang.Integer.parseInt

class TimeMachineInstructionsWithJumps(input: String) {

    val instructionPointer: Int
    val instructions: MutableList<Instruction>
    var registers: Registers = Registers(0, 0, 0, 0, 0, 0)
    var instructionsCnt = 0

    val operations: Map<String, Operation> =
        mapOf(
            Pair("addi", Addi()),
            Pair("addr", Addr()),
            Pair("mulr", Mulr()),
            Pair("muli", Muli()),
            Pair("banr", Banr()),
            Pair("bani", Bani()),
            Pair("borr", Borr()),
            Pair("bori", Bori()),
            Pair("setr", Setr()),
            Pair("seti", Seti()),
            Pair("gtir", Gtir()),
            Pair("gtri", Gtri()),
            Pair("gtrr", Gtrr()),
            Pair("eqir", Eqir()),
            Pair("eqri", Eqri()),
            Pair("eqrr", Eqrr())
        )

    init {
        val split = input.split("\n")

        instructionPointer = parseInt(split.first().get(4).toString())
        val rest = split.subList(1, split.size)

        instructions = mutableListOf()
        rest.forEach {
            val regex = """(.+) (\d+) (\d+) (\d+)""".toRegex()
            val matchResult = regex.find(it)
            val (name, a, b, c) = matchResult!!.destructured

            instructions.add(Instruction(0, parseInt(a), parseInt(b), parseInt(c), name))
        }

    }

    fun getFinalValueInRegisterZero(): Int {
        execute()
        return registers.read(0)
    }

    fun execute() {
        val print = false
        var pointer = registers.read(instructionPointer)
        while (pointer >= 0 && pointer < instructions.size) {
            registers = registers.write(instructionPointer, pointer)
            val instruction = instructions.get(pointer)
            instructionsCnt++
            if (print) {
                println(registers)
                println(pointer.toString() + " " + instruction)
            }
            val operation = operations.get(instruction.instruction)
            registers = operation!!.perform(registers, instruction.a, instruction.b, instruction.c)
            pointer = registers.read(instructionPointer)
            pointer++
        }
    }

    fun getFinalValueInRegisterZeroSecond(): Any? {
        registers = registers.write(0, 1)
        return getFinalValueInRegisterZero()
    }

    fun getLowestZeroRegisterVal() {
//        for (i in 0..100) {
        val i = 6196817
        registers.write(0, i)
        instructionsCnt = 0
        execute()
        println(i.toString() + ", " + instructionsCnt)
//        }
    }

//    #ip 4
//0 addi 4 16 4 - add 16 to register 4 -> jump to 16
//1 seti 1 3 5
//2 seti 1 1 3
//3 mulr 5 3 1
//4 eqrr 1 2 1
//5 addr 1 4 4
//6 addi 4 1 4
//7 addr 5 0 0
//8 addi 3 1 3
//9 gtrr 3 2 1
//10 addr 4 1 4
//11 seti 2 8 4
//12 addi 5 1 5
//13 gtrr 5 2 1
//14 addr 1 4 4
//15 seti 1 3 4
//16 mulr 4 4 4
//17 addi 2 2 2
//18 mulr 2 2 2
//19 mulr 4 2 2
//20 muli 2 11 2
//21 addi 1 6 1
//22 mulr 1 4 1
//23 addi 1 18 1
//24 addr 2 1 2
//25 addr 4 0 4
//26 seti 0 3 4
//27 setr 4 5 1
//28 mulr 1 4 1
//29 addr 4 1 1
//30 mulr 4 1 1
//31 muli 1 14 1
//32 mulr 1 4 1
//33 addr 2 1 2
//34 seti 0 1 0
//35 seti 0 4 4
}