package advent04

class WakeUp : LogType {
    override fun getId(): Int? {
        return null
    }

    override fun isSleepInfo(): Boolean {
        return true
    }


    override fun record(
        current: Int?,
        map: MutableMap<Int, SleepStats>,
        minute: Int
    ) {
        if (current != null) {
            map.putIfAbsent(current, SleepStats())
            map.get(current)?.recordAwake(minute)
        }
    }
}