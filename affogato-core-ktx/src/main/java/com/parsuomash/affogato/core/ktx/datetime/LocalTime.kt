package com.parsuomash.affogato.core.ktx.datetime

import com.parsuomash.affogato.core.ktx.tryCatchNull
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Convert [Long] to [LocalTime].
 *
 * Example:
 * ```Kotlin
 * 1_659_814_200_000.toLocalTime() // 00:00
 * ```
 * @since 1.1.0
 */
fun Long.toLocalTime(): LocalTime {
  val calendar = Calendar.getInstance().apply { time = Date(this@toLocalTime) }
  return LocalTime(calendar.hourOfDay, calendar.minute, calendar.second)
}

/**
 * Convert [LocalTime] to [Date].
 * @since 1.1.0
 */
fun LocalTime.toDate(): Date = Calendar.getInstance().apply {
  set(0, 0, 0, this@toDate.hour, this@toDate.minute, this@toDate.second)
  set(Calendar.MILLISECOND, 0)
}.time

/**
 * Convert [LocalTime] to [Calendar].
 * @since 1.1.0
 */
fun LocalTime.toCalendar(): Calendar = Calendar.getInstance().apply {
  set(0, 0, 0, this@toCalendar.hour, this@toCalendar.minute, this@toCalendar.second)
  set(Calendar.MILLISECOND, 0)
}

/**
 * Get current [LocalTime].
 * @since 1.1.0
 * @see Clock
 */
fun LocalTime.Companion.now(
  timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalTime = Clock.System.now().toLocalDateTime(timeZone).time

/**
 * Adds the other value to this value.
 * @since 1.1.0
 */
operator fun LocalTime.plus(duration: Duration): LocalTime =
  LocalTime.fromNanosecondOfDay(toNanosecondOfDay() + duration.inWholeNanoseconds)

/**
 * Subtracts the other value from this value.
 * @since 1.1.0
 */
operator fun LocalTime.minus(duration: Duration): LocalTime =
  LocalTime.fromNanosecondOfDay(toNanosecondOfDay() - duration.inWholeNanoseconds)

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
  return simpleDateFormat.parse(this).toLocalTime()
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
    simpleDateFormat.parse(this).toLocalTime()
  }

/**
 * Formats a [LocalTime] into a date-time [String].
 *
 * Example:
 * ```Kotlin
 * val time = LocalTime(11, 10, 0)
 * time.toLocalDate().format("HH") // 11
 * ```
 * @since 1.1.1
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return The formatted date-time string.
 * @see SimpleDateFormat
 */
fun LocalTime.format(pattern: String): String {
  simpleDateFormat.applyPattern(pattern)
  return simpleDateFormat.format(toDate())
}

// TODO v2.0.0 remove deprecated functions ---------------------------------------------------------

/**
 * Formats a [LocalTime] into a date-time [String].
 *
 * Example:
 * ```Kotlin
 * val time = LocalTime(11, 10, 0)
 * time.toLocalDate().toString("HH") // 11
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return The formatted date-time string.
 * @see SimpleDateFormat
 */
@Deprecated(
  message = "This function is deprecated and will be removed in next major release." +
    "Use format() instead.",
  replaceWith = ReplaceWith(
    expression = "format(format)",
    imports = ["com.parsuomash.affogato.core.ktx.datetime.format"]
  ),
  level = DeprecationLevel.WARNING
)
fun LocalTime.toString(format: String): String {
  simpleDateFormat.applyPattern(format)
  return simpleDateFormat.format(toDate())
}
