@file:Suppress("ObjectPropertyName")

package com.parsuomash.affogato.core.ktx.time

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.time.TimeAgo.setLocaleMessages
import com.parsuomash.affogato.core.ktx.time.messages.NoSuchMessageException
import com.parsuomash.affogato.core.ktx.time.messages.lang.EnMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.EnShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.FaMessages
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages
import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime

/**
 * TimeAgo is an Object that can be used to calculate the time difference between two dates is
 * specific format.
 *
 * Example:
 * ```Kotlin
 * TimeAgo.setDefaultLocale("fa")
 * TimeAgo.format(now()) // "چند لحظه پیش"
 * ```
 * @since 1.1.0
 * @see LookupMessages
 * @see NoSuchMessageException
 */
object TimeAgo {
  private var _default = "en"
  val default get() = _default

  private val lookupMessagesMap = mutableMapOf(
    "en" to EnMessages(),
    "en_short" to EnShortMessages(),
    "fa" to FaMessages()
  )

  /**
   * Sets the default [locale]. By default, it is `en`.
   *
   * Example:
   * ```Kotlin
   * setLocaleMessages("fa", FaMessages())
   * setDefaultLocale("fa")
   * ```
   * @since 1.1.0
   * @throws IllegalArgumentException if the [locale] is not supported.
   * @see LookupMessages
   */
  fun setDefaultLocale(locale: String) {
    require(lookupMessagesMap.containsKey(locale)) { "[locale] must be a registered locale" }
    _default = locale
  }

  /**
   * Sets a [locale] with the provided [lookupMessages] to be available when
   * using the [format] function.
   *
   * Example:
   * ```Kotlin
   * setLocaleMessages("fa", FaMessages())
   * ```
   *
   * If you want to define locale message implement [LookupMessages] interface
   * with the desired messages.
   *
   * @since 1.1.0
   */
  fun setLocaleMessages(locale: String, lookupMessages: LookupMessages) {
    lookupMessagesMap[locale] = lookupMessages
  }

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [nowInMilliseconds]
   * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Example:
   * ```Kotlin
   * TimeAgo.format(nowInMilliseconds()) // "a moment ago"
   * ```
   * @since 1.1.0
   */
  fun format(
    date: Long,
    locale: String = default,
    clock: Long = nowInMilliseconds(),
    allowOnDate: Boolean = true,
    allowFromNow: Boolean = false
  ): String {
    val messages = lookupMessagesMap[locale] ?: throw NoSuchMessageException(
      "Locale [$locale] has not been added, using [$default] as fallback. To add a locale use" +
        " [setLocaleMessages]"
    )
    var elapsed = clock - date

    val (prefix, suffix) = if (allowFromNow && elapsed < 0) {
      elapsed = abs(elapsed)
      messages.prefixFromNow() to messages.suffixFromNow()
    } else {
      messages.prefixAgo() to messages.suffixAgo()
    }

    val result = calculateResult(elapsed, messages, allowOnDate) {
      return onDate(date)
    }

    return listOf(prefix, result, suffix)
      .filter { it.isNotEmpty() }
      .joinToString(messages.wordSeparator())
  }

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [nowInDate]
   * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Example:
   * ```Kotlin
   * TimeAgo.format(nowInDate()) // "a moment ago"
   * ```
   * @since 1.1.0
   */
  fun format(
    date: Date,
    locale: String = default,
    clock: Date = nowInDate(),
    allowOnDate: Boolean = true,
    allowFromNow: Boolean = false
  ): String = format(date.time, locale, clock.time, allowOnDate, allowFromNow)

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [nowInCalendar]
   * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Example:
   * ```Kotlin
   * TimeAgo.format(nowInCalendar()) // "a moment ago"
   * ```
   * @since 1.1.0
   */
  fun format(
    date: Calendar,
    locale: String = default,
    clock: Calendar = nowInCalendar(),
    allowOnDate: Boolean = true,
    allowFromNow: Boolean = false
  ): String = format(date.timeInMillis, locale, clock.timeInMillis, allowOnDate, allowFromNow)

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [now]
   * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Example:
   * ```Kotlin
   * TimeAgo.format(now()) // "a moment ago"
   * ```
   * @since 1.1.0
   */
  fun format(
    date: Instant,
    locale: String = default,
    clock: Instant = now(),
    allowOnDate: Boolean = true,
    allowFromNow: Boolean = false
  ): String = format(
    date.toEpochMilliseconds(),
    locale,
    clock.toEpochMilliseconds(),
    allowOnDate,
    allowFromNow
  )

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [nowInLocalDateTime]
   * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Example:
   * ```Kotlin
   * TimeAgo.format(nowInLocalDateTime()) // "a moment ago"
   * ```
   * @since 1.1.0
   */
  fun format(
    date: LocalDateTime,
    locale: String = default,
    clock: LocalDateTime = nowInLocalDateTime(),
    allowOnDate: Boolean = true,
    allowFromNow: Boolean = false
  ): String = format(date.asDate.time, locale, clock.asDate.time, allowOnDate, allowFromNow)

  private inline fun calculateResult(
    elapsed: Long,
    messages: LookupMessages,
    allowOnDate: Boolean,
    onDate: LookupMessages.() -> String
  ): String {
    val seconds = elapsed / SECOND_IN_MILLIS
    val minutes = seconds / MINUTE_IN_SECOND
    val hours = minutes / HOUR_IN_MINUTE
    val days = hours / DAY_IN_HOUR
    val months = days / MONTH_IN_DAY
    val years = days / YEAR_IN_DAY

    return with(messages) {
      when {
        seconds < LESS_THAN_ONE_MINUTE -> lessThanOneMinute(seconds.roundToInt())
        seconds < ABOUT_A_MINUTE -> aboutAMinute(minutes.roundToInt())
        minutes < MINUTES -> minutes(minutes.roundToInt())
        minutes < ABOUT_AN_HOUR -> aboutAnHour(minutes.roundToInt())
        hours < HOURS -> hours(hours.roundToInt())
        hours < A_DAY -> aDay(hours.roundToInt())
        days < DAYS -> days(days.roundToInt())
        days < ABOUT_A_MONTH -> aboutAMonth(days.roundToInt())
        days < ABOUT_A_YEAR -> months(months.roundToInt())
        years < 2 -> aboutAYear(months.roundToInt())
        else -> if (allowOnDate) onDate() else years(years.roundToInt())
      }
    }
  }
}

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [nowInMilliseconds]
 * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * ```Kotlin
 * 1565591769464.timeAgo() // on 08/12/2019
 * ```
 * @since 1.1.0
 */
fun Long.timeAgo(
  locale: String = TimeAgo.default,
  clock: Long = nowInMilliseconds(),
  allowOnDate: Boolean = true,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, allowOnDate, allowFromNow)

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [nowInCalendar]
 * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * ```Kotlin
 * (nowInDate() - 4.hours).timeAgo() // 4 hours ago
 * ```
 * @since 1.1.0
 */
fun Date.timeAgo(
  locale: String = TimeAgo.default,
  clock: Date = nowInDate(),
  allowOnDate: Boolean = true,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, allowOnDate, allowFromNow)

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [nowInCalendar]
 * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * ```Kotlin
 * (nowInCalendar() - 1.hours).timeAgo() // about an hour ago
 * ```
 * @since 1.1.0
 */
fun Calendar.timeAgo(
  locale: String = TimeAgo.default,
  clock: Calendar = nowInCalendar(),
  allowOnDate: Boolean = true,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, allowOnDate, allowFromNow)

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [now]
 * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * ```Kotlin
 * now().timeAgo() // a moment ago
 * ```
 * @since 1.1.0
 */
fun Instant.timeAgo(
  locale: String = TimeAgo.default,
  clock: Instant = now(),
  allowOnDate: Boolean = true,
  allowFromNow: Boolean = false
): String = TimeAgo.format(
  this,
  locale,
  clock,
  allowOnDate,
  allowFromNow
)

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [nowInLocalDateTime]
 * - If [allowOnDate] is true, will return on date message (example: on 08/11/2017).
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * ```Kotlin
 * (nowInLocalDateTime() - 1.years).timeAgo() // about a year ago
 * ```
 * @since 1.1.0
 */
fun LocalDateTime.timeAgo(
  locale: String = TimeAgo.default,
  clock: LocalDateTime = nowInLocalDateTime(),
  allowOnDate: Boolean = true,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, allowOnDate, allowFromNow)

private const val SECOND_IN_MILLIS = 1000.0
private const val MINUTE_IN_SECOND = 60.0
private const val HOUR_IN_MINUTE = 60.0
private const val DAY_IN_HOUR = 24.0
private const val MONTH_IN_DAY = 30.0
private const val YEAR_IN_DAY = 365.0

private const val LESS_THAN_ONE_MINUTE = 45
private const val ABOUT_A_MINUTE = 90
private const val MINUTES = 45
private const val ABOUT_AN_HOUR = 90
private const val HOURS = 24
private const val A_DAY = 48
private const val DAYS = 30
private const val ABOUT_A_MONTH = 60
private const val ABOUT_A_YEAR = 365
