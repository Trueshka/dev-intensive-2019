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
        in 75..45*60 -> "через ${time/ 60} ${if( (time/ 60 / 60 / 24) in 2..4) "минуты" else "минут"}"
        in 45*60..75*60 -> "через час"
        in 75*60..22*60*60  -> "через ${time/60/60} ${if( (time/ 60 / 60 / 24) in 2..4) "часа" else "часов"}"
        in 22*60*60..26* 60*60  ->  "через день"
        in 22*60*60..360* 60*60 -> "через ${time / 60 / 60 / 24}${if( (time/ 60 / 60 / 24) in 2..4) "дня" else "дней"}"
        //in 360*60*60..Long.MAX_VALUE -> "более чем ${time/ 60/60/24} дней назад"
        in 360*60*60..Long.MAX_VALUE -> "более чем через год"
        in -1..0 -> "только что"
        in -45..-1 -> "несколько секунд назад"
        in -75..-45 -> "минуту назад"
        in -45*60..-75 -> "${time / 60 *(-1)} ${if( (time/ 60 / 60 / 24) in 2..4) " минуты назад" else " минут назад"}"
        in -75*60..-45* 60 -> "час назад"
        in -22* 60*60..-75* 60  -> "${time/60/60*(-1)}${if( (time/ 60 / 60 / 24) in 2..4) " часа назад" else " часов назад"}"
        in  -26* 60*60..-22*60*60  ->  "день назад"
        in -360* 60*60..-22* 60*60 -> "${time/ 60/60/24*(-1)} ${if( (time/ 60 / 60 / 24) in 2..4) " дня назад" else " дней назад"}"
        else -> "более года назад"
    }
    return state

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
/*private fun plural(value: Int): String {

    val form = when {
        value % 10 == 1 && value != 11 -> 0
        value % 10 in 2..4 -> 1
        else -> 2
    }
    val forms = listOf(
        "%s секунду",
        "%s секунды",
        "%s секунд",
        "%s минуту",
        "%s минуты",
        "%s минут",
        "%s час",
        "%s часа",
        "%s часов",
        "%s день",
        "%s дня",
        "%s дней"
    )
    return forms[form + 3 * when (unit) {
        TimeUnits.SECOND -> 0
        TimeUnits.MINUTE -> 1
        TimeUnits.HOUR -> 2
        TimeUnits.DAY -> 3
    }].format(value)
}*/
enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY


}