package advent12

class PlantGrowing(initial: String, rulesInput: String) {
    var state = initial
    val rules: MutableMap<String, String> = mutableMapOf()
    var addedToBeginning = 0

    init {
        rulesInput.split("\n").forEach {
            val split = it.split(" => ")
            rules.put(split[0], split[1])
        }

        state = addDotOffset(initial)
    }

    fun getSumOfGeneration(generation: Long): Long {
        getStateAfterGeneration(generation)
        return countState()
    }

    private fun countState(): Long {
        var sum = 0L
        for (i in 0..state.length - 1) {
            if (state[i] == '#') {
                sum += i - addedToBeginning
            }
        }
        return sum
    }

    fun getStateAfterGeneration(generation: Long): String {
        for (i in 1..generation) {
            var newState = generateNewState(state.length - 1)
            for (j in 0..state.length - 5) {
                val substring = state.substring(j, j + 5)
                if (rules.containsKey(substring)) {
                    newState = newState.substring(0, j + 2) + rules.get(substring) + newState.substring(j + 3)
                }
            }
            newState = addDotOffset(newState)
            state = newState
            println(i.toString() + " " + state + " " + countState())
        }
        return state
    }

    private fun addDotOffset(newState: String): String {
        var state = newState
        while (!(state[0] == '.' && state[1] == '.' && state[2] == '.')) {
            state = "." + state
            addedToBeginning++
        }
        while (!(state[state.length - 1] == '.' && state[state.length - 2] == '.' && state[state.length - 3] == '.')) {
            state = state + "."
        }
        return state

    }

    private fun generateNewState(length: Int): String {
        val sb = StringBuilder()
        for (i in 0..length) {
            sb.append(".")
        }
        return sb.toString()
    }
}