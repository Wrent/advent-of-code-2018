package advent04

class SleepStats {
    val asleep = ArrayList<Int>()

    init {
        for (i in 0..59) {
            asleep.add(0)
        }
    }

    fun recordAsleep(minute: Int) {
        for (i in minute..59) {
            asleep.set(i, asleep.get(i) + 1)
        }
    }

    fun recordAwake(minute: Int) {
        for (i in minute..59) {
            asleep.set(i, asleep.get(i) - 1)
        }
    }

    fun getMinutesAsleep(): Int {
        return asleep.sum()
    }

    fun getMostSleepyMinute(): Int {
        val max = asleep.max()
        return asleep.indexOf(max)
    }

    fun getMostSleepyMinuteCount(): Int {
        return asleep.max() ?: 0
    }
}