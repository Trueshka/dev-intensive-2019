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

    val timeNow = this.time
//var timeNow = Date().add(4,TimeUnits.DAY).time

    val time = (timeNow-date.time) /1000

    var state = ""
    state += when (time) {
        in 0..1 -> "только что"
        in 1..45 -> "несколько секунд назад"
        in 45..75 -> "минуту назад"
        in 75..45*60 -> "${time/ 60} минут назад"
        in 45* 60..75*60 -> "час назад"
        in 75* 60..22* 60*60 -> "${time/60/60} часов назад"
        in 22*60*60..26* 60*60 ->  "день назад"
        in 22* 60*60..360* 60*60 -> "${time/ 60/60/24} дней назад"
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