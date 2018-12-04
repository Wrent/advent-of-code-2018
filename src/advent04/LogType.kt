package advent04

interface LogType {
    fun getId(): Int?
    fun isSleepInfo(): Boolean
    fun record(
        current: Int?,
        map: MutableMap<Int, SleepStats>,
        minute: Int
    )
}
