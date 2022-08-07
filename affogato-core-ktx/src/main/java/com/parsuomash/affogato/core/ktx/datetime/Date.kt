package com.parsuomash.affogato.core.ktx.datetime

import com.parsuomash.affogato.core.ktx.tryCatchNull
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

/**
 * Convert [Long] to [Date].
 *
 * Example:
 * ```Kotlin
 * 1659873010453L.asDate // Sun Aug 07 16:20:10 IRDT 2022
 * ```
 * @since 1.1.0
 */
inline val Long.asDate: Date get() = Date(this)

/**
 * Convert [Duration] to [Date].
 *
 * Example:
 * ```Kotlin
 * 1.days.asDate // Fri Jan 02 03:30:00 IRST 1970
 * ```
 * @since 1.1.0
 */
inline val Duration.asDate: Date get() = Date(inWholeMilliseconds)

/**
 * Convert [Date] to [LocalDate].
 * @since 1.1.0
 */
inline val Date.asLocalDate: LocalDate
  get() {
    val calendar = Calendar.getInstance().apply { time = this@asLocalDate }
    return LocalDate(calendar.year, calendar.month + 1, calendar.dayOfMonth)
  }

/**
 * Convert [Date] to [LocalDateTime].
 * @since 1.1.0
 */
inline val Date.asLocalDateTime: LocalDateTime
  get() {
    val calendar = Calendar.getInstance().apply { time = this@asLocalDateTime }
    with(calendar) {
      return LocalDateTime(year, month + 1, dayOfMonth, hourOfDay, minute, second)
    }
  }

/**
 * Convert [Date] to [Calendar].
 * @since 1.1.0
 */
inline val Date.asCalendar: Calendar
  get() = Calendar.getInstance().apply { time = this@asCalendar }

/**
 * Two days are considered to be the same if they have the same day.
 *
 * Example:
 * ```Kotlin
 * val date1 = Date()
 * val date2 = Date()
 * date1 isSameDay date2 // true
 * ```
 * @since 1.1.0
 */
infix fun Date.isSameDay(date: Date): Boolean = asCalendar.dayOfYear == date.asCalendar.dayOfYear

/**
 * Adds the other value to this value.
 * @since 1.1.0
 */
operator fun Date.plus(other: Date): Date = Date(time + other.time)

/**
 * Subtracts the other value from this value.
 * @since 1.1.0
 */
operator fun Date.minus(other: Date): Date = Date(time - other.time)

/**
 * Adds the [Duration] value to this [Date].
 * @since 1.1.0
 */
operator fun Date.plus(other: Duration): Date = Date(time + other.inWholeMilliseconds)

/**
 * Subtracts the [Duration] value from this [Date].
 * @since 1.1.0
 */
operator fun Date.minus(other: Duration): Date = Date(time - other.inWholeMilliseconds)

/**
 * Produce a date from the given strings value and [pattern].
 *
 * Example:
 * ```Kotlin
 * "8/7/2022".toDate("MM/dd/yyyy") // Sun Aug 07 00:00:00 IRDT 2022
 * "Sun Aug 07 16:37:42 IRDT 2022".toDate() // Sun Aug 07 16:37:42 IRDT 2022
 * "7/2022".toDate("MM/dd/yyyy") // ParseException
 * ```
 * @since 1.1.0
 * @throws java.text.ParseException if the beginning of the specified string cannot be parsed.
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return A Date parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toDate(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): Date {
  simpleDateFormat.applyPattern(pattern)
  return simpleDateFormat.parse(this)
}

/**
 * Produce a date from the given strings value and [pattern] if possible.
 *
 * Example:
 * ```Kotlin
 * "8/7/2022".toDateOrNull("MM/dd/yyyy") // Sun Aug 07 00:00:00 IRDT 2022
 * "Sun Aug 07 16:37:42 IRDT 2022".toDateOrNull() // Sun Aug 07 16:37:42 IRDT 2022
 * "7/2022".toDateOrNull("MM/dd/yyyy") // null
 * ```
 * @since 1.1.0
 * @return A nullable Date parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toDateOrNull(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): Date? = tryCatchNull {
  simpleDateFormat.applyPattern(pattern)
  simpleDateFormat.parse(this)
}

/**
 * Formats a [Date] into a date-time [String].
 *
 * Example:
 * ```Kotlin
 * 1659814200000.asDate.toString("MM/dd/yyyy") // 08/07/2022
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return The formatted date-time string.
 * @see SimpleDateFormat
 */
fun Date.toString(format: String): String {
  simpleDateFormat.applyPattern(format)
  return simpleDateFormat.format(this)
}
