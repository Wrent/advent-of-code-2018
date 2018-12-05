package advent05

class Polymers {

    fun getPolymerUnits(input: String): Int {
        val polymer = Polymer(input)

        while (true) {
            val index = polymer.getNextIndex()
            if (polymer.shouldBeRemoved(index)) {
                polymer.remove(index)
            }

            if (polymer.shouldStop()) {
                break
            }
        }

        return polymer.count()
    }

    fun getImprovedUnits(input: String): Int {
        var min = input.length
        for (ascii in 65..90) {
            var str = input
            val first = ascii.toChar()
            println(first)
            val second = (ascii + 32).toChar()
            str = str.replace(first.toString(), "")
            str = str.replace(second.toString(), "")

            val cnt = getPolymerUnits(str)
            if (cnt < min) {
                min = cnt
            }
        }
        return min
    }
}