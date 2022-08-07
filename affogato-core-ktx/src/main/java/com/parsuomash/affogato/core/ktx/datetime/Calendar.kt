@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.parsuomash.affogato.core.ktx.datetime

import com.parsuomash.affogato.core.ktx.tryCatchNull
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

/** @since 1.1.0 */
inline val Calendar.year: Int get() = get(Calendar.YEAR)

/** @since 1.1.0 */
inline val Calendar.month: Int get() = get(Calendar.MONTH)

/** @since 1.1.0 */
inline val Calendar.dayOfYear: Int get() = get(Calendar.DAY_OF_YEAR)

/** @since 1.1.0 */
inline val Calendar.dayOfMonth: Int get() = get(Calendar.DAY_OF_MONTH)

/** @since 1.1.0 */
inline val Calendar.dayOfWeek: Int get() = get(Calendar.DAY_OF_WEEK)

/** @since 1.1.0 */
inline val Calendar.dayOfWeekInMonth: Int get() = get(Calendar.DAY_OF_WEEK_IN_MONTH)

/** @since 1.1.0 */
inline val Calendar.hour: Int get() = get(Calendar.HOUR)

/** @since 1.1.0 */
inline val Calendar.hourOfDay: Int get() = get(Calendar.HOUR_OF_DAY)

/** @since 1.1.0 */
inline val Calendar.minute: Int get() = get(Calendar.MINUTE)

/** @since 1.1.0 */
inline val Calendar.second: Int get() = get(Calendar.SECOND)

/** @since 1.1.0 */
inline val Calendar.millisecond: Int get() = get(Calendar.MILLISECOND)

/** @since 1.1.0 */
inline val Calendar.weekOfYear: Int get() = get(Calendar.WEEK_OF_YEAR)

/** @since 1.1.0 */
inline val Calendar.weekOfMonth: Int get() = get(Calendar.WEEK_OF_MONTH)

/**
 * Convert [Long] to [Calendar].
 * @since 1.1.0
 */
inline val Long.asCalendar: Calendar
  get() = Calendar.getInstance().apply { time = Date(this@asCalendar) }

/**
 * Convert [Duration] to [Calendar].
 * @since 1.1.0
 */
inline val Duration.asCalendar: Calendar
  get() = Calendar.getInstance().apply { time = Date(inWholeMilliseconds) }

/**
 * Convert [Calendar] to [Date].
 * @since 1.1.0
 */
inline val Calendar.asDate: Date get() = time

/**
 * Convert [Calendar] to [LocalDate].
 * @since 1.1.0
 */
inline val Calendar.asLocalDate: LocalDate get() = LocalDate(year, month + 1, dayOfMonth)

/**
 * Convert [Calendar] to [LocalDateTime].
 * @since 1.1.0
 */
inline val Calendar.asLocalDateTime: LocalDateTime
  get() = LocalDateTime(year, month + 1, dayOfMonth, hourOfDay, minute, second)

/**
 * Two days are considered to be the same if they have the same day.
 * @since 1.1.0
 */
infix fun Calendar.isSameDay(date: Calendar): Boolean = dayOfYear == date.dayOfYear

/**
 * Produce a Calendar from the given strings value and [pattern].
 * @since 1.1.0
 * @throws java.text.ParseException if the beginning of the specified string cannot be parsed.
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return A Calendar parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toCalendar(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): Calendar {
  simpleDateFormat.applyPattern(pattern)
  return simpleDateFormat.parse(this).asCalendar
}

/**
 * Produce a Calendar from the given strings value and [pattern] if possible.
 * @since 1.1.0
 * @return A nullable Calendar parsed from the string.
 * @see SimpleDateFormat
 */
fun String.toCalendarOrNull(pattern: String = "EEE MMM dd HH:mm:ss zzz yyyy"): Calendar? =
  tryCatchNull {
    simpleDateFormat.applyPattern(pattern)
    simpleDateFormat.parse(this).asCalendar
  }

/**
 * Formats a [Calendar] into a date-time [String].
 * @since 1.1.0
 * @throws IllegalArgumentException if the given pattern is invalid
 * @return The formatted date-time string.
 * @see SimpleDateFormat
 */
fun Calendar.toString(format: String): String {
  simpleDateFormat.applyPattern(format)
  return simpleDateFormat.format(time)
}
