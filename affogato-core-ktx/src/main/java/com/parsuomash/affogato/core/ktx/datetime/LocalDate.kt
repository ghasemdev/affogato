package com.parsuomash.affogato.core.ktx.datetime

import com.parsuomash.affogato.core.ktx.tryCatchNull
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlinx.datetime.todayIn

/**
 * Convert [Long] to [LocalDate].
 *
 * Example:
 * ```Kotlin
 * 1659814200000.asLocalDate // 2022-07-07
 * ```
 * @since 1.1.0
 */
inline val Long.asLocalDate: LocalDate
  get() {
    val calendar = Calendar.getInstance().apply { time = Date(this@asLocalDate) }
    return LocalDate(calendar.year, calendar.month + 1, calendar.dayOfMonth)
  }

/**
 * Convert [LocalDate] to [Date].
 * @since 1.1.0
 */
inline val LocalDate.asDate: Date
  get() = Calendar.getInstance().apply {
    set(this@asDate.year, this@asDate.monthNumber - 1, this@asDate.dayOfMonth, 0, 0, 0)
  }.time

/**
 * Convert [LocalDate] to [LocalDateTime].
 * @since 1.1.0
 */
inline val LocalDate.asLocalDateTime: LocalDateTime
  get() = LocalDateTime(year, month, dayOfMonth, 0, 0, 0)

/**
 * Convert [LocalDate] to [Calendar].
 * @since 1.1.0
 */
inline val LocalDate.asCalendar: Calendar
  get() = Calendar.getInstance().apply {
    set(this@asCalendar.year, this@asCalendar.monthNumber - 1, this@asCalendar.dayOfMonth, 0, 0, 0)
  }

/**
 * Get current local date.
 * @since 1.1.0
 * @see Clock
 */
fun LocalDate.Companion.now(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDate =
  Clock.System.todayIn(timeZone)

/**
 * Two days are considered to be the same if they have the same day.
 *
 * Example:
 * ```Kotlin
 * val date1 = now()
 * val date2 = now()
 * date1 isSameDay date2 // true
 * ```
 * @since 1.1.0
 * @see now
 */
infix fun LocalDate.isSameDay(date: LocalDate): Boolean = dayOfYear == date.dayOfYear

/**
 * Adds the other value to this value.
 * @since 1.1.0
 */
operator fun LocalDate.plus(duration: Duration): LocalDate =
  plus(duration.inWholeDays, DateTimeUnit.DAY)

/**
 * Subtracts the other value from this value.
 * @since 1.1.0
 */
operator fun LocalDate.minus(duration: Duration): LocalDate =
  minus(duration.inWholeDays, DateTimeUnit.DAY)

/**
 * Produce a LocalDate from the given strings value and [pattern].
 *
 * Example:
 * ```Kotlin
 * "8/7/2022".toLocalDate("MM/dd/yyyy") // 2022-07-07
 * "Sun Aug 07 16:37:42 IRDT 2022".toLocalDate() // 2022-07-07
 * "7/2022".toLocalDate("MM/dd/yyyy") // ParseException
 * ```
 * @since 1.1.0
 * @throws java.text.ParseException if the beginning of the specified string cannot be parsed.
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return A LocalDate parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toLocalDate(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): LocalDate {
  simpleDateFormat.applyPattern(pattern)
  return simpleDateFormat.parse(this).asLocalDate
}

/**
 * Produce a LocalDate from the given strings value and [pattern] if possible.
 *
 * Example:
 * ```Kotlin
 * "8/7/2022".toLocalDateOrNull("MM/dd/yyyy") // 2022-07-07
 * "Sun Aug 07 16:37:42 IRDT 2022".toLocalDateOrNull() // 2022-07-07
 * "7/2022".toLocalDateOrNull("MM/dd/yyyy") // null
 * ```
 * @since 1.1.0
 * @return A nullable LocalDate parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toLocalDateOrNull(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): LocalDate? =
  tryCatchNull {
    simpleDateFormat.applyPattern(pattern)
    simpleDateFormat.parse(this).asLocalDate
  }

/**
 * Formats a [LocalDate] into a date-time [String].
 *
 * Example:
 * ```Kotlin
 * 1659814200000.asLocalDate.toString("MM/dd/yyyy") // 08/07/2022
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return The formatted date-time string.
 * @see SimpleDateFormat
 */
fun LocalDate.toString(format: String): String {
  simpleDateFormat.applyPattern(format)
  return simpleDateFormat.format(asDate)
}
