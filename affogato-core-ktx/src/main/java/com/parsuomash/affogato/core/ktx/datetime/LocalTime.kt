package com.parsuomash.affogato.core.ktx.datetime

import com.parsuomash.affogato.core.ktx.tryCatchNull
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.datetime.LocalTime

/**
 * Convert [Long] to [LocalTime].
 *
 * Example:
 * ```Kotlin
 * 1_659_814_200_000.asLocalTime // 00:00
 * ```
 * @since 1.1.0
 */
inline val Long.asLocalTime: LocalTime
  get() {
    val calendar = Calendar.getInstance().apply { time = Date(this@asLocalTime) }
    return LocalTime(calendar.hourOfDay, calendar.minute, calendar.second)
  }

/**
 * Convert [LocalTime] to [Date].
 * @since 1.1.0
 */
inline val LocalTime.asDate: Date
  get() = Calendar.getInstance().apply {
    set(0, 0, 0, this@asDate.hour, this@asDate.minute, this@asDate.second)
    set(Calendar.MILLISECOND, 0)
  }.time

/**
 * Convert [LocalTime] to [Calendar].
 * @since 1.1.0
 */
inline val LocalTime.asCalendar: Calendar
  get() = Calendar.getInstance().apply {
    set(0, 0, 0, this@asCalendar.hour, this@asCalendar.minute, this@asCalendar.second)
    set(Calendar.MILLISECOND, 0)
  }

/**
 * Produce a LocalTime from the given strings value and [pattern].
 *
 * Example:
 * ```Kotlin
 * "21->15->0".toLocalTime("HH->mm->ss") // 21:15
 * "Sun Aug 07 16:37:42 IRDT 2022".toLocalTime() // 16:37:42
 * "21:10:00".toLocalTime("HH::mm") // ParseException
 * ```
 * @since 1.1.0
 * @throws java.text.ParseException if the beginning of the specified string cannot be parsed.
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return A LocalTime parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toLocalTime(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): LocalTime {
  simpleDateFormat.applyPattern(pattern)
  return simpleDateFormat.parse(this).asLocalTime
}

/**
 * Produce a LocalTime from the given strings value and [pattern] if possible.
 *
 * Example:
 * ```Kotlin
 * "21->15->0".toLocalTime("HH->mm->ss") // 21:15
 * "Sun Aug 07 16:37:42 IRDT 2022".toLocalTime() // 16:37:42
 * "21:10:00".toLocalTime("HH::mm") // null
 * ```
 * @since 1.1.0
 * @return A nullable LocalTime parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toLocalTimeOrNull(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): LocalTime? =
  tryCatchNull {
    simpleDateFormat.applyPattern(pattern)
    simpleDateFormat.parse(this).asLocalTime
  }

/**
 * Formats a [LocalTime] into a date-time [String].
 *
 * Example:
 * ```Kotlin
 * val time = LocalTime(11, 10, 0)
 * time.asLocalDate.toString("HH") // 11
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return The formatted date-time string.
 * @see SimpleDateFormat
 */
fun LocalTime.toString(format: String): String {
  simpleDateFormat.applyPattern(format)
  return simpleDateFormat.format(asDate)
}
