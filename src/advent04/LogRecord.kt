package advent04

import java.lang.Integer.parseInt
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LogRecord(line: String) : Comparable<LogRecord> {
    val year: Int
    val month: Int
    val day: Int
    val hour: Int
    val minute: Int
    val rest: String

    val date: LocalDateTime
    val type: LogType

    init {
        val regex = """\[(\d+)-(\d+)-(\d+) (\d+):(\d+)] (.*)""".toRegex()
        val matchResult = regex.find(line)
        val (year, month, day, hour, minute, rest) = matchResult!!.destructured

        this.date = LocalDateTime.parse("$year-$month-$day" + "T" + "$hour:$minute:00", DateTimeFormatter.ISO_DATE_TIME)

        this.year = parseInt(year)
        this.month = parseInt(month)
        this.day = parseInt(day)
        this.hour = parseInt(hour)
        this.minute = parseInt(minute)
        this.rest = rest

        if (rest.startsWith("w")) {
            this.type = WakeUp()
        } else if (rest.startsWith("f")) {
            this.type = FallAsleep()
        } else {
            val guardRegex = """Guard #(\d+) (.*)""".toRegex()
            val guardMatchResult = guardRegex.find(line)
            val (id, _) = guardMatchResult!!.destructured

            this.type = StartWorking(parseInt(id))
        }
    }


    override fun compareTo(other: LogRecord): Int {
        return this.date.compareTo(other.date)
    }
}