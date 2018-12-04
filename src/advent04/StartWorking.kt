package advent04

class StartWorking(val id: Int) : LogType {
    override fun getId(): Int? {
        return id
    }

    override fun isSleepInfo(): Boolean {
        return false
    }

    override fun record(current: Int?, map: MutableMap<Int, SleepStats>, minute: Int) {

    }
}