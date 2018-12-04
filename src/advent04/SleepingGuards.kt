package advent04

class SleepingGuards(input: String) {

    val map: MutableMap<Int, SleepStats> = mutableMapOf()


    init {
        val records = input.split("\n")
            .map { LogRecord(it) }
            .sortedBy { it }

        var current: Int? = null
        for (record in records) {
            if (record.type.getId() != null) {
                current = record.type.getId()
            }
            if (record.type.isSleepInfo()) {
                record.type.record(current, map, record.minute)
            }
        }

    }

    fun getSleepingGuard(): Int {
        val max = map.entries.maxBy { it.value.getMinutesAsleep() }

        return max!!.key * max.value.getMostSleepyMinute()
    }

    fun getSleepingGuardMostAsleep(): Int {
        val max = map.entries.maxBy { it.value.getMostSleepyMinuteCount() }

        return max!!.key * max.value.getMostSleepyMinute()
    }
}