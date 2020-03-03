package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToLong

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

fun Date.humanizeDiff(date: Date = Date()): String {

    val timeNow = this.time
//var timeNow = Date().add(3,TimeUnits.HOUR).time

    val time = (timeNow-date.time) /1000

    var state = ""
    state += when (time) {
        in 0..1 -> "только что"
        in 1..45 -> "через несколько секунд"
        in 45..75 -> "через минуту"
        in 75..45*60 -> "через ${time/ 60} минут "
        in 45*60..75*60 -> "через час"
        in 75*60..22*60*60  -> "через ${time/60/60} часов"
        in 22*60*60..26* 60*60  ->  "через день"
        in 22*60*60..360* 60*60 -> "более чем ${time / 60 / 60 / 24} дней назад"
        in 360*60*60..Long.MAX_VALUE -> "более чем ${time/ 60/60/24} дней назад"
        in -1..0 -> "только что"
        in -45..-1 -> "несколько секунд назад"
        in -75..-45 -> "минуту назад"
        in -45*60..-75 -> "${kotlin.math.abs(time / 60)} минут назад"
        in -75*60..-45* 60 -> "час назад"
        in -22* 60*60..-75* 60  -> "${kotlin.math.abs(time/60/60)} часа назад"
        in  -26* 60*60..-22*60*60  ->  "день назад"
        in -360* 60*60..-22* 60*60 -> "${kotlin.math.abs(time/ 60/60/24)} дней назад"
        else -> "более года назад"
    }
    return time.toString()

/*
 in -1 downTo 0  -> "только что"
         -1 downTo -45 -> "несколько секунд назад"
         -45 downTo -75 -> "минуту назад"
         75 downTo -45*60 -> "${time/ 60} минут назад"
         -45* 60 downTo -75*60 -> "час назад"
         -75* 60 downTo -22* 60*60 -> "${time/60/60} часов назад"
          -22*60*60 downTo -26* 60*60  ->  "день назад"
         -22* 60*60 downTo -360* 60*60 -> "${time/ 60/60/24} дней назад"
 */
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY


}