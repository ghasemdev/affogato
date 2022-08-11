@file:Suppress("ObjectPropertyName", "LongMethod")

package com.parsuomash.affogato.core.ktx.time

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.time.TimeAgo.setLocaleMessages
import com.parsuomash.affogato.core.ktx.time.messages.NoSuchMessageException
import com.parsuomash.affogato.core.ktx.time.messages.lang.ArMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ArShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.AzMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.AzShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.CaMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.CaShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.CsMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.CsShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.DaMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.DaShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.DeMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.DeShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.DvMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.DvShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.EnMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.EnShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.EsMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.EsShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.EtMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.EtShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.FaMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.FaShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.FiMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.FiShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.FrMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.FrShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.GrMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.GrShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.HeMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.HeShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.HiMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.HiShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.HuMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.HuShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.IdMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ItMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ItShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.JaMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.KmMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.KmShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.KoMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.KuMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.KuShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.MnMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.MnShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.MsMyMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.MsMyShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NbNoMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NbNoShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NlMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NlShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NnNoMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NnNoShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.PlMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.RoMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.RoShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.RuMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.RuShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.RwMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.RwShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.SvMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.SvShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.TaMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ThMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ThShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.TrMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.UkMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.UkShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.UrMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.UrShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ViMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ViShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ZhCnMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ZhMessages
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
    "en" to EnMessages,
    "en_short" to EnShortMessages,
    "fa" to FaMessages,
    "fa_short" to FaShortMessages
  )

  /**
   * Sets the default [locale]. By default, it is `en`.
   *
   * Example:
   * ```Kotlin
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
   * Sets a [locale] with the auto provided [LookupMessages] to be available when
   * using the [format] function.
   *
   * Example:
   * ```Kotlin
   * setLocaleMessages("fa")
   * ```
   * @since 1.1.0
   */
  fun setLocaleMessages(locale: String) {
    when (locale) {
      "en" -> setLocaleMessages("en", EnMessages)
      "en_short" -> setLocaleMessages("en_short", EnShortMessages)
      "fa" -> setLocaleMessages("fa", FaMessages)
      "fa_short" -> setLocaleMessages("fa_short", FaShortMessages)
      "ar" -> setLocaleMessages("ar", ArMessages)
      "ar_short" -> setLocaleMessages("ar_short", ArShortMessages)
      "az" -> setLocaleMessages("az", AzMessages)
      "az_short" -> setLocaleMessages("az_short", AzShortMessages)
      "ca" -> setLocaleMessages("ca", CaMessages)
      "ca_short" -> setLocaleMessages("ca_short", CaShortMessages)
      "cs" -> setLocaleMessages("cs", CsMessages)
      "cs_short" -> setLocaleMessages("cs_short", CsShortMessages)
      "da" -> setLocaleMessages("da", DaMessages)
      "da_short" -> setLocaleMessages("da_short", DaShortMessages)
      "de" -> setLocaleMessages("de", DeMessages)
      "de_short" -> setLocaleMessages("de_short", DeShortMessages)
      "dv" -> setLocaleMessages("dv", DvMessages)
      "dv_short" -> setLocaleMessages("dv_short", DvShortMessages)
      "es" -> setLocaleMessages("es", EsMessages)
      "es_short" -> setLocaleMessages("es_short", EsShortMessages)
      "et" -> setLocaleMessages("et", EtMessages)
      "et_short" -> setLocaleMessages("et_short", EtShortMessages)
      "fi" -> setLocaleMessages("fi", FiMessages)
      "fi_short" -> setLocaleMessages("fi_short", FiShortMessages)
      "fr" -> setLocaleMessages("fr", FrMessages)
      "fr_short" -> setLocaleMessages("fr_short", FrShortMessages)
      "gr" -> setLocaleMessages("gr", GrMessages)
      "gr_short" -> setLocaleMessages("gr_short", GrShortMessages)
      "he" -> setLocaleMessages("he", HeMessages)
      "he_short" -> setLocaleMessages("he_short", HeShortMessages)
      "hi" -> setLocaleMessages("he", HiMessages)
      "hi_short" -> setLocaleMessages("he_short", HiShortMessages)
      "hu" -> setLocaleMessages("hu", HuMessages)
      "hu_short" -> setLocaleMessages("hu_short", HuShortMessages)
      "id" -> setLocaleMessages("id", IdMessages)
      "it" -> setLocaleMessages("it", ItMessages)
      "it_short" -> setLocaleMessages("it_short", ItShortMessages)
      "ja" -> setLocaleMessages("ja", JaMessages)
      "km" -> setLocaleMessages("km", KmMessages)
      "km_short" -> setLocaleMessages("km_short", KmShortMessages)
      "ko" -> setLocaleMessages("ko", KoMessages)
      "ku" -> setLocaleMessages("ku", KuMessages)
      "ku_short" -> setLocaleMessages("ku_short", KuShortMessages)
      "mn" -> setLocaleMessages("mn", MnMessages)
      "mn_short" -> setLocaleMessages("mn_short", MnShortMessages)
      "ms_my" -> setLocaleMessages("ms_my", MsMyMessages)
      "ms_my_short" -> setLocaleMessages("ms_my_short", MsMyShortMessages)
      "nb_no" -> setLocaleMessages("nb_no", NbNoMessages)
      "nb_no_short" -> setLocaleMessages("nb_no_short", NbNoShortMessages)
      "nl" -> setLocaleMessages("nl", NlMessages)
      "nl_short" -> setLocaleMessages("nl_short", NlShortMessages)
      "nn_no" -> setLocaleMessages("nn_no", NnNoMessages)
      "nn_no_short" -> setLocaleMessages("nn_no_short", NnNoShortMessages)
      "pl" -> setLocaleMessages("pl", PlMessages)
      "ro" -> setLocaleMessages("ro", RoMessages)
      "ro_short" -> setLocaleMessages("ro_short", RoShortMessages)
      "ru" -> setLocaleMessages("ru", RuMessages)
      "ru_short" -> setLocaleMessages("ru_short", RuShortMessages)
      "rw" -> setLocaleMessages("rw", RwMessages)
      "rw_short" -> setLocaleMessages("rw_short", RwShortMessages)
      "sv" -> setLocaleMessages("sv", SvMessages)
      "sv_short" -> setLocaleMessages("sv_short", SvShortMessages)
      "ta" -> setLocaleMessages("ta", TaMessages)
      "th" -> setLocaleMessages("th", ThMessages)
      "th_short" -> setLocaleMessages("th_short", ThShortMessages)
      "tr" -> setLocaleMessages("tr", TrMessages)
      "uk" -> setLocaleMessages("uk", UkMessages)
      "uk_short" -> setLocaleMessages("uk_short", UkShortMessages)
      "ur" -> setLocaleMessages("ur", UrMessages)
      "ur_short" -> setLocaleMessages("ur_short", UrShortMessages)
      "vi" -> setLocaleMessages("vi", ViMessages)
      "vi_short" -> setLocaleMessages("vi_short", ViShortMessages)
      "zh_cn" -> setLocaleMessages("zh_cn", ZhCnMessages)
      "zh" -> setLocaleMessages("zh", ZhMessages)
      else -> throw NoSuchMessageException(
        "Instead of using the factory, use the " +
          "setLocaleMessages(locale: String, lookupMessages: LookupMessages method)."
      )
    }
  }

  /**
   * Sets a [locale] with the provided [lookupMessages] to be available when
   * using the [format] function.
   *
   * Example:
   * ```Kotlin
   * object CustomMessages : LookupMessages {
   * ...
   * }
   * setLocaleMessages("custom", CustomMessages)
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
