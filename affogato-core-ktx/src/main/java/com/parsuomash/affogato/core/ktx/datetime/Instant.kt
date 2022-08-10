package com.parsuomash.affogato.core.ktx.datetime

import com.parsuomash.affogato.core.ktx.tryCatchNull
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toKotlinInstant
import kotlinx.datetime.toLocalDateTime

/**
 * Convert [Long] to [Instant].
 *
 * Example:
 * ```Kotlin
 * 1659814200000.toInstant() // 2022-08-06T19:30:00Z
 * ```
 * @since 1.1.0
 */
fun Long.toInstant(): Instant = Instant.fromEpochMilliseconds(this)

/**
 * Convert [Instant] to [Date].
 * @since 1.1.0
 */
fun Instant.toDate(): Date = Date(toEpochMilliseconds())

/**
 * Convert [Instant] to [Calendar].
 * @since 1.1.0
 */
fun Instant.toCalendar(): Calendar =
  Calendar.getInstance().apply { time = Date(toEpochMilliseconds()) }

/**
 * Convert [Instant] to [LocalDate].
 * @since 1.1.0
 */
fun Instant.toLocalDate(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDate =
  toLocalDateTime(timeZone).date

/**
 * Convert [Instant] to [LocalTime].
 * @since 1.1.0
 */
fun Instant.toLocalTime(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalTime =
  toLocalDateTime(timeZone).time

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
infix fun Instant.isSameDay(date: Instant): Boolean =
  toLocalDate().dayOfYear == date.toLocalDate().dayOfYear

/**
 * Produce an Instant from the given strings value and [pattern].
 *
 * Example:
 * ```Kotlin
 * "8/7/2022".toInstant("MM/dd/yyyy") // 2022-08-06T19:30:00Z
 * "Sun Aug 07 16:37:42 IRDT 2022".toInstant() // 2022-08-07T12:07:42Z
 * "7/2022".toInstant("MM/dd/yyyy") // ParseException
 * ```
 * @since 1.1.0
 * @throws java.text.ParseException if the beginning of the specified string cannot be parsed.
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return An Instant parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toInstant(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): Instant {
  simpleDateFormat.applyPattern(pattern)
  return simpleDateFormat.parse(this).toInstant().toKotlinInstant()
}

/**
 * Produce an Instant from the given strings value and [pattern] if possible.
 *
 * Example:
 * ```Kotlin
 * "8/7/2022".toInstantOrNull("MM/dd/yyyy") // 2022-08-06T19:30:00Z
 * "Sun Aug 07 16:37:42 IRDT 2022".toInstantOrNull() // 2022-08-07T12:07:42Z
 * "7/2022".toInstantOrNull("MM/dd/yyyy") // null
 * ```
 * @since 1.1.0
 * @return A nullable Instant parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toInstantOrNull(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): Instant? =
  tryCatchNull {
    simpleDateFormat.applyPattern(pattern)
    simpleDateFormat.parse(this).toInstant().toKotlinInstant()
  }

/**
 * Formats a [Instant] into a date-time [String].
 *
 * Example:
 * ```Kotlin
 * 1659814200000.toInstant().toString("MM/dd/yyyy") // 08/07/2022
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return The formatted date-time string.
 * @see SimpleDateFormat
 */
fun Instant.toString(format: String): String {
  simpleDateFormat.applyPattern(format)
  return simpleDateFormat.format(toDate())
}
