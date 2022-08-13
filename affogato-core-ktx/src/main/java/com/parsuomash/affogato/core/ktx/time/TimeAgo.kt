@file:Suppress("ObjectPropertyName", "LongMethod", "ComplexMethod", "ReturnCount")

/**
 * A fork of dart time ago package v3.3.0
 * https://github.com/andresaraujo/timeago.dart
 */

package com.parsuomash.affogato.core.ktx.time

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.math.round
import com.parsuomash.affogato.core.ktx.time.DateLimitation.None
import com.parsuomash.affogato.core.ktx.time.TimeAgo.setLocaleMessages
import com.parsuomash.affogato.core.ktx.time.messages.NoSuchMessageException
import com.parsuomash.affogato.core.ktx.time.messages.lang.AmMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.AmShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ArMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.ArShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.AzMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.AzShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.BsMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.BsShortMessages
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
import com.parsuomash.affogato.core.ktx.time.messages.lang.EnDetailMessage
import com.parsuomash.affogato.core.ktx.time.messages.lang.EnMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.EnShortDetailMessages
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
import com.parsuomash.affogato.core.ktx.time.messages.lang.MyMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.MyShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NbNoMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NbNoShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NlMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NlShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NnNoMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.NnNoShortMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.PlMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.PtBrMessages
import com.parsuomash.affogato.core.ktx.time.messages.lang.PtBrShortMessages
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
import com.parsuomash.affogato.core.ktx.time.messages.lang.TkMessages
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
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime

/**
 * TimeAgo is an Object  that converts a date into a humanized text. Instead of showing a date
 * 2020-12-12 18:30 with timeago you can display something like `"now", "an hour ago", "~1y", etc`
 *
 * Note: This class uses ISO 639-1 language code to identify the language. For more information
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
 * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
 * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
 * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
 * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
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

  var isLocaleNumberEnabled = false
  private val lookupMessagesMap = mutableMapOf(
    "en" to EnMessages,
    "en_short" to EnShortMessages,
    "fa" to FaMessages,
    "fa_short" to FaShortMessages
  )

  /**
   * Sets the default [locale]. By default, it is `en`.
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
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
   * Sets [locales] with the auto provided [LookupMessages] to be available when
   * using the [format] function.
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
   *
   * Example:
   * ```Kotlin
   * setLocaleMessages("fa", "en", "ar")
   * ```
   * @since 1.1.0
   * @throws NoSuchMessageException if the locales is not supported.
   * @see LookupMessages
   */
  fun setLocaleMessages(vararg locales: String) {
    locales.forEach { setLocaleMessages(it) }
  }

  /**
   * Sets a [locale] with the auto provided [LookupMessages] to be available when
   * using the [format] function.
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
   *
   * Example:
   * ```Kotlin
   * setLocaleMessages("fa")
   * ```
   * @since 1.1.0
   * @throws NoSuchMessageException if the [locale] is not supported.
   * @see LookupMessages
   */
  fun setLocaleMessages(locale: String) {
    when (locale) {
      "en" -> setLocaleMessages("en", EnMessages)
      "en_short" -> setLocaleMessages("en_short", EnShortMessages)
      "en_short_detail" -> setLocaleMessages("en_short_detail", EnShortDetailMessages)
      "en_detail" -> setLocaleMessages("en_detail", EnDetailMessage)
      "fa" -> setLocaleMessages("fa", FaMessages)
      "fa_short" -> setLocaleMessages("fa_short", FaShortMessages)
      "am" -> setLocaleMessages("am", AmMessages)
      "am_short" -> setLocaleMessages("am_short", AmShortMessages)
      "ar" -> setLocaleMessages("ar", ArMessages)
      "ar_short" -> setLocaleMessages("ar_short", ArShortMessages)
      "az" -> setLocaleMessages("az", AzMessages)
      "az_short" -> setLocaleMessages("az_short", AzShortMessages)
      "bs" -> setLocaleMessages("bs", BsMessages)
      "bs_short" -> setLocaleMessages("bs_short", BsShortMessages)
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
      "my" -> setLocaleMessages("my", MyMessages)
      "my_short" -> setLocaleMessages("my_short", MyShortMessages)
      "nb_no" -> setLocaleMessages("nb_no", NbNoMessages)
      "nb_no_short" -> setLocaleMessages("nb_no_short", NbNoShortMessages)
      "nl" -> setLocaleMessages("nl", NlMessages)
      "nl_short" -> setLocaleMessages("nl_short", NlShortMessages)
      "nn_no" -> setLocaleMessages("nn_no", NnNoMessages)
      "nn_no_short" -> setLocaleMessages("nn_no_short", NnNoShortMessages)
      "pl" -> setLocaleMessages("pl", PlMessages)
      "pt_br" -> setLocaleMessages("pt_br", PtBrMessages)
      "pt_br_short" -> setLocaleMessages("pt_br", PtBrShortMessages)
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
      "tk" -> setLocaleMessages("tk", TkMessages)
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
          "setLocaleMessages(locale: String, lookupMessages: LookupMessages) method."
      )
    }
  }

  /**
   * Sets a [locale] with the provided [lookupMessages] to be available when
   * using the [format] function.
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
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
   * Sets a [locale] with the auto provided [LookupMessages] to be available when
   * using the [format] function. also Sets the default locale.
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
   *
   * Example:
   * ```Kotlin
   * setLocaleMessagesAndDefaultLocale("ar")
   * ```
   * @since 1.1.0
   * @throws NoSuchMessageException if the [locale] is not supported.
   */
  fun setLocaleMessagesAndDefaultLocale(locale: String) {
    setLocaleMessages(locale)
    setDefaultLocale(locale)
  }

  /**
   * Sets a [locale] with the auto provided [LookupMessages] to be available when
   * using the [format] function. also Sets the default locale.
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
   *
   * Example:
   * ```Kotlin
   * object CustomMessages : LookupMessages {
   * ...
   * }
   * setLocaleMessagesAndDefaultLocale("custom", CustomMessages)
   * ```
   * @since 1.1.0
   * @throws NoSuchMessageException if the [locale] is not supported.
   */
  fun setLocaleMessagesAndDefaultLocale(locale: String, lookupMessages: LookupMessages) {
    setLocaleMessages(locale, lookupMessages)
    setDefaultLocale(locale)
  }

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [nowInMilliseconds]
   * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
   * show date without ago. Default value is None.
   * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
   * 1 week to 4 week.
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
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
    minCutOff: DateLimitation = None,
    isWeekFormatEnabled: Boolean = false,
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

    val seconds = elapsed / SECOND_IN_MILLIS
    val minutes = seconds / MINUTE_IN_SECOND
    val hours = minutes / HOUR_IN_MINUTE
    val days = hours / DAY_IN_HOUR
    val weeks = days / WEEK_IN_DAY
    val months = days / MONTH_IN_DAY
    val years = days / YEAR_IN_DAY

    val roundedSeconds = seconds.round(digits = 1).toInt()
    val roundedMinutes = minutes.round(digits = 1).toInt()
    val roundedHours = hours.round(digits = 1).toInt()
    val roundedDays = days.round(digits = 1).toInt()
    val roundedWeeks = weeks.round(digits = 1).toInt()
    val roundedMonths = months.round(digits = 1).toInt()
    val roundedYears = years.round(digits = 1).toInt()

    val result = with(messages) {
      when {
        seconds < LESS_THAN_ONE_MINUTE -> {
          val result = lessThanOneMinute(roundedSeconds, date)
          if (minCutOff.priority > 6) return result else result
        }
        seconds < ABOUT_A_MINUTE -> {
          val result = aboutAMinute(roundedMinutes, date)
          if (minCutOff.priority > 5) return result else result
        }
        minutes < MINUTES -> {
          val remindSecond = roundedSeconds - (roundedMinutes * MINUTE_IN_SECOND.toInt())
          val result = minutes(roundedMinutes, remindSecond, date)
          if (minCutOff.priority > 5) return result else result
        }
        minutes < ABOUT_AN_HOUR -> {
          val result = aboutAnHour(roundedMinutes, date)
          if (minCutOff.priority > 4) return result else result
        }
        hours < HOURS -> {
          val remindMinute = roundedMinutes - (roundedHours * HOUR_IN_MINUTE.toInt())
          val result = hours(roundedHours, remindMinute, date)
          if (minCutOff.priority > 4) return result else result
        }
        hours < A_DAY -> {
          val result = aDay(roundedHours, date)
          if (minCutOff.priority > 3) return result else result
        }
        days < DAYS && !isWeekFormatEnabled -> {
          val remindHour = roundedHours - (roundedDays * DAY_IN_HOUR.toInt())
          val result = days(roundedDays, remindHour, date)
          if (minCutOff.priority > 3) return result else result
        }
        days < A_WEEK && isWeekFormatEnabled -> {
          val remindHour = roundedHours - (roundedDays * DAY_IN_HOUR.toInt())
          val result = days(roundedDays, remindHour, date)
          if (minCutOff.priority > 3) return result else result
        }
        days < WEEKS && isWeekFormatEnabled -> {
          val remindDay = roundedDays - (roundedWeeks * WEEK_IN_DAY.toInt())
          val result = weeks(roundedWeeks, remindDay, date)
          if (minCutOff.priority > 2) return result else result
        }
        days < ABOUT_A_MONTH -> {
          val result = aboutAMonth(roundedDays, date)
          if (minCutOff.priority > 1) return result else result
        }
        days < ABOUT_A_YEAR -> {
          val remindDay = roundedDays - (roundedMonths * MONTH_IN_DAY.toInt())
          val result = months(roundedMonths, remindDay, date)
          if (minCutOff.priority > 1) return result else result
        }
        years < 2 -> {
          val result = aboutAYear(roundedMonths, date)
          if (minCutOff.priority > 0) return result else result
        }
        else -> {
          val remindMonth = roundedMonths - (roundedYears * YEAR_IN_MONTH.toInt())
          val result = years(roundedYears, remindMonth, date)
          if (minCutOff.priority > 0) return result else result
        }
      }
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
   * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
   * show date without ago. Default value is None.
   * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
   * 1 week to 4 week.
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
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
    minCutOff: DateLimitation = None,
    isWeekFormatEnabled: Boolean = false,
    allowFromNow: Boolean = false
  ): String = format(date.time, locale, clock.time, minCutOff, isWeekFormatEnabled, allowFromNow)

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [nowInCalendar]
   * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
   * show date without ago. Default value is None.
   * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
   * 1 week to 4 week.
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
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
    minCutOff: DateLimitation = None,
    isWeekFormatEnabled: Boolean = false,
    allowFromNow: Boolean = false
  ): String = format(
    date.timeInMillis,
    locale,
    clock.timeInMillis,
    minCutOff,
    isWeekFormatEnabled,
    allowFromNow
  )

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [now]
   * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
   * show date without ago. Default value is None.
   * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
   * 1 week to 4 week.
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
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
    minCutOff: DateLimitation = None,
    isWeekFormatEnabled: Boolean = false,
    allowFromNow: Boolean = false
  ): String = format(
    date.toEpochMilliseconds(),
    locale,
    clock.toEpochMilliseconds(),
    minCutOff,
    isWeekFormatEnabled,
    allowFromNow
  )

  /**
   * Formats provided [date] to a fuzzy time like 'a moment ago'.
   *
   * - If [locale] is passed will look for message for that locale, if you want
   * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
   * - If [clock] is passed this will be the point of reference for calculating
   * the elapsed time. Defaults to [nowInLocalDateTime]
   * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
   * show date without ago. Default value is None.
   * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
   * 1 week to 4 week.
   * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
   * 5 minutes from now in 'en' locale will display as "5 minutes from now".
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
   * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
   * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
   * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
   * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
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
    minCutOff: DateLimitation = None,
    isWeekFormatEnabled: Boolean = false,
    allowFromNow: Boolean = false
  ): String =
    format(
      date.asDate.time,
      locale,
      clock.asDate.time,
      minCutOff,
      isWeekFormatEnabled,
      allowFromNow
    )
}

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [nowInMilliseconds]
 * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
 * show date without ago. Default value is None.
 * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
 * 1 week to 4 week.
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * Note: This function uses ISO 639-1 language code to identify the language. For more information
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
 * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
 * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
 * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
 * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
 *
 * ```Kotlin
 * 1565591769464.timeAgo() // on 08/12/2019
 * ```
 * @since 1.1.0
 */
fun Long.timeAgo(
  locale: String = TimeAgo.default,
  clock: Long = nowInMilliseconds(),
  minCutOff: DateLimitation = None,
  isWeekFormatEnabled: Boolean = false,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, minCutOff, isWeekFormatEnabled, allowFromNow)

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [nowInCalendar]
 * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
 * show date without ago. Default value is None.
 * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
 * 1 week to 4 week.
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * Note: This function uses ISO 639-1 language code to identify the language. For more information
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
 * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
 * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
 * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
 * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
 *
 * ```Kotlin
 * (nowInDate() - 4.hours).timeAgo() // 4 hours ago
 * ```
 * @since 1.1.0
 */
fun Date.timeAgo(
  locale: String = TimeAgo.default,
  clock: Date = nowInDate(),
  minCutOff: DateLimitation = None,
  isWeekFormatEnabled: Boolean = false,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, minCutOff, isWeekFormatEnabled, allowFromNow)

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [nowInCalendar]
 * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
 * show date without ago. Default value is None.
 * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
 * 1 week to 4 week.
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * Note: This function uses ISO 639-1 language code to identify the language. For more information
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
 * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
 * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
 * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
 * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
 *
 * ```Kotlin
 * (nowInCalendar() - 1.hours).timeAgo() // about an hour ago
 * ```
 * @since 1.1.0
 */
fun Calendar.timeAgo(
  locale: String = TimeAgo.default,
  clock: Calendar = nowInCalendar(),
  minCutOff: DateLimitation = None,
  isWeekFormatEnabled: Boolean = false,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, minCutOff, isWeekFormatEnabled, allowFromNow)

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [now]
 * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
 * show date without ago. Default value is None.
 * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
 * 1 week to 4 week.
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * Note: This function uses ISO 639-1 language code to identify the language. For more information
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
 * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
 * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
 * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
 * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
 *
 * ```Kotlin
 * now().timeAgo() // a moment ago
 * ```
 * @since 1.1.0
 */
fun Instant.timeAgo(
  locale: String = TimeAgo.default,
  clock: Instant = now(),
  minCutOff: DateLimitation = None,
  isWeekFormatEnabled: Boolean = false,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, minCutOff, isWeekFormatEnabled, allowFromNow)

/**
 * Formats provided this value to a fuzzy time like 'a moment ago'.
 *
 * - If [locale] is passed will look for message for that locale, if you want
 * to add or override locales use [setLocaleMessages]. Defaults to 'en'.
 * - If [clock] is passed this will be the point of reference for calculating
 * the elapsed time. Defaults to [nowInLocalDateTime]
 * - If [minCutOff] is passed from that date bellow all prefix and suffix disabled to
 * show date without ago. Default value is None.
 * - If [isWeekFormatEnabled] is true, week format enabled and show 7 days - 28 days as
 * 1 week to 4 week.
 * - If [allowFromNow] is true, format will use the Form prefix, i.e. a date
 * 5 minutes from now in 'en' locale will display as "5 minutes from now".
 *
 * Note: This function uses ISO 639-1 language code to identify the language. For more information
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes). list of available code
 * is: `am`, `ar`, `az`, `bs`, `ca`, `cs`, `da`, `de`, `dv`, `en`,
 * `es`, `et`, `fa`, `fi`, `fr`, `gr`, `he`, `hi`, `hu`, `id`, `it`, `ja`, `km`, `ko`, `ku`,
 * `mn`, `ms_my`, `my`, `nb_no`, `nl`, `nn_no`, `pl`, `pt_br`, `ro`, `ru`, `rw`, `sv`, `ta`, `th`,
 * `tk`, `tr`, `uk`, `ur`, `vi`, `zh_cn`, `zh`.
 *
 * ```Kotlin
 * (nowInLocalDateTime() - 1.years).timeAgo() // about a year ago
 * ```
 * @since 1.1.0
 */
fun LocalDateTime.timeAgo(
  locale: String = TimeAgo.default,
  clock: LocalDateTime = nowInLocalDateTime(),
  minCutOff: DateLimitation = None,
  isWeekFormatEnabled: Boolean = false,
  allowFromNow: Boolean = false
): String = TimeAgo.format(this, locale, clock, minCutOff, isWeekFormatEnabled, allowFromNow)

private const val SECOND_IN_MILLIS = 1000.0
private const val MINUTE_IN_SECOND = 60.0
private const val HOUR_IN_MINUTE = 60.0
private const val DAY_IN_HOUR = 24.0
private const val WEEK_IN_DAY = 7.0
private const val MONTH_IN_DAY = 30.0
private const val YEAR_IN_DAY = 365.0
private const val YEAR_IN_MONTH = 12.0

private const val LESS_THAN_ONE_MINUTE = 45
private const val ABOUT_A_MINUTE = 90
private const val MINUTES = 45
private const val ABOUT_AN_HOUR = 90
private const val HOURS = 24
private const val A_DAY = 48
private const val DAYS = 30
private const val A_WEEK = 7
private const val WEEKS = 28
private const val ABOUT_A_MONTH = 60
private const val ABOUT_A_YEAR = 365
