package com.parsuomash.affogato.core.ktx.datetime

import com.parsuomash.affogato.core.ktx.tryCatchNull
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Convert [Long] to [LocalDateTime].
 *
 * Example:
 * ```Kotlin
 * 1659814200000.asLocalDateTime // 2022-07-07T00:00
 * ```
 * @since 1.1.0
 */
inline val Long.asLocalDateTime: LocalDateTime
  get() {
    val calendar = Calendar.getInstance().apply { time = Date(this@asLocalDateTime) }
    with(calendar) {
      return LocalDateTime(year, month + 1, dayOfMonth, hourOfDay, minute, second)
    }
  }

/**
 * Convert [LocalDateTime] to [Date].
 * @since 1.1.0
 */
inline val LocalDateTime.asDate: Date get() = asCalendar.time

/**
 * Convert [LocalDateTime] to [LocalDate].
 * @since 1.1.0
 */
inline val LocalDateTime.asLocalDate: LocalDate get() = date

/**
 * Convert [LocalDateTime] to [LocalTime].
 * @since 1.1.0
 */
inline val LocalDateTime.asLocalTime: LocalTime get() = time

/**
 * Convert [LocalDateTime] to [Calendar].
 * @since 1.1.0
 */
inline val LocalDateTime.asCalendar: Calendar
  get() = Calendar.getInstance().apply {
    set(
      this@asCalendar.year,
      this@asCalendar.monthNumber - 1,
      this@asCalendar.dayOfMonth,
      this@asCalendar.hour,
      this@asCalendar.minute,
      this@asCalendar.second
    )
    set(Calendar.MILLISECOND, 0)
  }

/**
 * Get current [LocalDateTime].
 * @since 1.1.0
 * @see Clock
 */
fun LocalDateTime.Companion.now(
  timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalDateTime = Clock.System.now().toLocalDateTime(timeZone)

/**
 * Two days are considered to be the same if they have the same day.
 * @since 1.1.0
 */
infix fun LocalDateTime.isSameDay(date: LocalDateTime): Boolean = dayOfYear == date.dayOfYear

/**
 * Produce a LocalDateTime from the given strings value and [pattern].
 *
 * Example:
 * ```Kotlin
 * "08/07/2022 13".toLocalDateTime("MM/dd/yyyy HH") // 2022-08-07T13:00
 * "Sun Aug 07 16:37:42 IRDT 2022".toLocalDateTime() // 2022-08-07T16:37:42
 * "7/2022".toLocalDateTime("MM/dd/yyyy") // ParseException
 * ```
 * @since 1.1.0
 * @throws java.text.ParseException if the beginning of the specified string cannot be parsed.
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return A LocalDateTime parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toLocalDateTime(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): LocalDateTime {
  simpleDateFormat.applyPattern(pattern)
  return simpleDateFormat.parse(this).asLocalDateTime
}

/**
 * Produce a LocalDateTime from the given strings value and [pattern] if possible.
 *
 * Example:
 * ```Kotlin
 * "08/07/2022 13".toLocalDateTimeOrNull("MM/dd/yyyy HH") // 2022-08-07T13:00
 * "Sun Aug 07 16:37:42 IRDT 2022".toLocalDateTimeOrNull() // 2022-08-07T16:37:42
 * "7/2022".toLocalDateTimeOrNull("MM/dd/yyyy") // null
 * ```
 * @since 1.1.0
 * @return A nullable LocalDateTime parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toLocalDateTimeOrNull(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): LocalDateTime? =
  tryCatchNull {
    simpleDateFormat.applyPattern(pattern)
    simpleDateFormat.parse(this).asLocalDateTime
  }

/**
 * Formats a [LocalDateTime] into a date-time [String].
 *
 * Example:
 * ```Kotlin
 * 1659814205950.asLocalDateTime.toString("MM/dd/yyyy") // 08/07/2022
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return The formatted date-time string.
 * @see SimpleDateFormat
 */
fun LocalDateTime.toString(format: String): String {
  simpleDateFormat.applyPattern(format)
  return simpleDateFormat.format(asDate)
}
