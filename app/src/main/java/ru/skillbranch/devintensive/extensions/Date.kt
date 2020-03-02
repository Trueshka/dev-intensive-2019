package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY

    }
    this.time = time
    return this
}

fun Date.humanizedDiff(date: Date = Date()): String {

    var timeNow = this.time * SECOND
    var time = timeNow-(date.time * SECOND)
    var state = ""
    state += when (time) {
        in 0..1 -> "только что"
        in 1..45 -> "несколько секунд назад"
        in 45..75 -> "минуту назад"
        in 75..45* MINUTE -> "${time* MINUTE} минут назад"
        in 45* MINUTE..75* MINUTE -> "час назад"
        in 75* MINUTE..22* HOUR -> "${time* MINUTE} часов назад"
        in 22* HOUR..26* HOUR -> "час назад"
        in 22* HOUR..360* DAY -> "${time* DAY} дней назад"
        else -> "более года назад"
    }
    return state
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY


}