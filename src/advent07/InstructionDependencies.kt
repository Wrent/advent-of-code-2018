package advent07

import java.util.*

class InstructionDependencies(input: String) {
    val dependencies: MutableMap<String, Dependency> = mutableMapOf()
    val dependsOn: MutableMap<String, Dependency> = mutableMapOf()

    val startValues: List<String>

    val availableValues: TreeSet<String>
    val removed: MutableSet<String> = mutableSetOf()

    init {
        input.split("\n").forEach {
            val regex = """Step (.+) must be finished before step (.+) can begin.""".toRegex()
            val matchResult = regex.find(it)
            val (prev, next) = matchResult!!.destructured

            dependencies.putIfAbsent(prev, Dependency())
            dependencies.putIfAbsent(next, Dependency())
            dependencies.get(prev)?.add(next)

            dependsOn.putIfAbsent(next, Dependency())
            dependsOn.putIfAbsent(prev, Dependency())
            dependsOn.get(next)?.add(prev)
        }

        startValues = dependsOn.entries
            .filter { it.value.dependencies.size == 0 }
            .map { it.key }
            .sorted()
        availableValues = TreeSet<String>(startValues)
    }

    fun getOrder(): String {
        val sb = StringBuilder()
        while (availableValues.size > 0) {
            val first = getNext()
            sb.append(first)
        }
        return sb.toString()
    }

    private fun getNext(): String? {
        val first = availableValues.first()
        availableValues.remove(first)
        removed.add(first)
        addNextDependencies(first, availableValues, removed)
        return first
    }

    private fun addNextDependencies(
        current: String?,
        availableValues: TreeSet<String>,
        removed: MutableSet<String>
    ) {
        val possibleAdditions = dependencies.get(current)?.dependencies
        possibleAdditions?.forEach {
            if (canBeAdded(it, removed)) {
                availableValues.add(it)
            }
        }
    }

    private fun canBeAdded(it: String, removed: MutableSet<String>): Boolean {
        val dependsOn = dependsOn[it]?.dependencies
        return dependsOn?.all { removed.contains(it) }!!
    }

    fun getSeconds(duration: Int, workersCnt: Int): Int {
        var i = 0
        var finished = 0
        val working = mutableMapOf<Int, String>()
        while (finished < dependsOn.size) {
            if (hasAvailableWorker(working, workersCnt) && availableValues.size > 0) {
                val next = availableValues.first()
                availableValues.remove(next)
                working.put(i + getDuration(duration, next) - 1, next)
            } else {
                finished += finishTasks(i, working)
                i++
            }
        }
        return i
    }

    private fun hasAvailableWorker(working: MutableMap<Int, String>, workersCnt: Int): Boolean {
        return working.size < workersCnt
    }

    private fun finishTasks(time: Int, working: MutableMap<Int, String>): Int {
        var finished = 0
        working.entries
            .filter { it.key <= time }
            .forEach {
                removed.add(it.value)
                addNextDependencies(it.value, availableValues, removed)
                working.remove(it.key)
                finished++
            }
        return finished
    }

    fun getDuration(duration: Int, task: String): Int {
        return duration + (task[0].toInt() - 64)
    }
}