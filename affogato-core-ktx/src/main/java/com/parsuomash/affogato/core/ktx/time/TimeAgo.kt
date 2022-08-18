@file:Suppress("ObjectPropertyName", "LongMethod", "ComplexMethod", "ReturnCount")

/**
 * A fork of dart time ago package v3.3.0
 * https://github.com/andresaraujo/timeago.dart
 */

package com.parsuomash.affogato.core.ktx.time

import com.parsuomash.affogato.core.ktx.datetime.toDate
import com.parsuomash.affogato.core.ktx.math.round
import com.parsuomash.affogato.core.ktx.time.DateLimitation.None
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.AM
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.AM_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.AR
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.AR_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.AZ
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.AZ_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.BS
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.BS_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.CA
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.CA_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.CS
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.CS_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.DA
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.DA_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.DE
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.DE_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.DV
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.DV_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.EN
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.EN_DETAIL
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.EN_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.EN_SHORT_DETAIL
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.ES
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.ES_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.ET
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.ET_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.FA
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.FA_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.FI
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.FI_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.FR
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.FR_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.GR
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.GR_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.HE
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.HE_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.HI
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.HI_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.HU
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.HU_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.ID
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.IT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.IT_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.JA
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.KM
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.KM_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.KO
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.KU
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.KU_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.MN
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.MN_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.MS_MY
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.MS_MY_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.MY
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.MY_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.NB_NO
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.NB_NO_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.NL
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.NL_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.NN_NO
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.NN_NO_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.PL
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.PT_BR
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.PT_BR_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.RO
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.RO_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.RU
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.RU_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.RW
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.RW_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.SV
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.SV_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.TA
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.TH
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.TH_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.TK
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.TR
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.UK
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.UK_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.UR
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.UR_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.VI
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.VI_SHORT
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.ZH
import com.parsuomash.affogato.core.ktx.time.TimeAgo.Locale.ZH_CN
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
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
  private var _default = EN
  val default get() = _default

  var isLocaleNumberEnabled = false
  private val lookupMessagesMap = mutableMapOf(
    EN to EnMessages,
    EN_SHORT to EnShortMessages,
    FA to FaMessages,
    FA_SHORT to FaShortMessages
  )

  /**
   * Sets the default [locale]. By default, it is `en`.
   *
   * Note: This function uses ISO 639-1 language code to identify the language. For more information
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
   *
   * Example:
   * ```Kotlin
   * setLocaleMessages("fa", "en", AR)
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
      EN -> setLocaleMessages(EN, EnMessages)
      EN_SHORT -> setLocaleMessages(EN_SHORT, EnShortMessages)
      EN_SHORT_DETAIL -> setLocaleMessages(EN_SHORT_DETAIL, EnShortDetailMessages)
      EN_DETAIL -> setLocaleMessages(EN_DETAIL, EnDetailMessage)
      FA -> setLocaleMessages(FA, FaMessages)
      FA_SHORT -> setLocaleMessages(FA_SHORT, FaShortMessages)
      AM -> setLocaleMessages(AM, AmMessages)
      AM_SHORT -> setLocaleMessages(AM_SHORT, AmShortMessages)
      AR -> setLocaleMessages(AR, ArMessages)
      AR_SHORT -> setLocaleMessages(AR_SHORT, ArShortMessages)
      AZ -> setLocaleMessages(AZ, AzMessages)
      AZ_SHORT -> setLocaleMessages(AZ_SHORT, AzShortMessages)
      BS -> setLocaleMessages(BS, BsMessages)
      BS_SHORT -> setLocaleMessages(BS_SHORT, BsShortMessages)
      CA -> setLocaleMessages(CA, CaMessages)
      CA_SHORT -> setLocaleMessages(CA_SHORT, CaShortMessages)
      CS -> setLocaleMessages(CS, CsMessages)
      CS_SHORT -> setLocaleMessages(CS_SHORT, CsShortMessages)
      DA -> setLocaleMessages(DA, DaMessages)
      DA_SHORT -> setLocaleMessages(DA_SHORT, DaShortMessages)
      DE -> setLocaleMessages(DE, DeMessages)
      DE_SHORT -> setLocaleMessages(DE_SHORT, DeShortMessages)
      DV -> setLocaleMessages(DV, DvMessages)
      DV_SHORT -> setLocaleMessages(DV_SHORT, DvShortMessages)
      ES -> setLocaleMessages(ES, EsMessages)
      ES_SHORT -> setLocaleMessages(ES_SHORT, EsShortMessages)
      ET -> setLocaleMessages(ET, EtMessages)
      ET_SHORT -> setLocaleMessages(ET_SHORT, EtShortMessages)
      FI -> setLocaleMessages(FI, FiMessages)
      FI_SHORT -> setLocaleMessages(FI_SHORT, FiShortMessages)
      FR -> setLocaleMessages(FR, FrMessages)
      FR_SHORT -> setLocaleMessages(FR_SHORT, FrShortMessages)
      GR -> setLocaleMessages(GR, GrMessages)
      GR_SHORT -> setLocaleMessages(GR_SHORT, GrShortMessages)
      HE -> setLocaleMessages(HE, HeMessages)
      HE_SHORT -> setLocaleMessages(HE_SHORT, HeShortMessages)
      HI -> setLocaleMessages(HI, HiMessages)
      HI_SHORT -> setLocaleMessages(HI_SHORT, HiShortMessages)
      HU -> setLocaleMessages(HU, HuMessages)
      HU_SHORT -> setLocaleMessages(HU_SHORT, HuShortMessages)
      ID -> setLocaleMessages(ID, IdMessages)
      IT -> setLocaleMessages(IT, ItMessages)
      IT_SHORT -> setLocaleMessages(IT_SHORT, ItShortMessages)
      JA -> setLocaleMessages(JA, JaMessages)
      KM -> setLocaleMessages(KM, KmMessages)
      KM_SHORT -> setLocaleMessages(KM_SHORT, KmShortMessages)
      KO -> setLocaleMessages(KO, KoMessages)
      KU -> setLocaleMessages(KU, KuMessages)
      KU_SHORT -> setLocaleMessages(KU_SHORT, KuShortMessages)
      MN -> setLocaleMessages(MN, MnMessages)
      MN_SHORT -> setLocaleMessages(MN_SHORT, MnShortMessages)
      MS_MY -> setLocaleMessages(MS_MY, MsMyMessages)
      MS_MY_SHORT -> setLocaleMessages(MS_MY_SHORT, MsMyShortMessages)
      MY -> setLocaleMessages(MY, MyMessages)
      MY_SHORT -> setLocaleMessages(MY_SHORT, MyShortMessages)
      NB_NO -> setLocaleMessages(NB_NO, NbNoMessages)
      NB_NO_SHORT -> setLocaleMessages(NB_NO_SHORT, NbNoShortMessages)
      NL -> setLocaleMessages(NL, NlMessages)
      NL_SHORT -> setLocaleMessages(NL_SHORT, NlShortMessages)
      NN_NO -> setLocaleMessages(NN_NO, NnNoMessages)
      NN_NO_SHORT -> setLocaleMessages(NN_NO_SHORT, NnNoShortMessages)
      PL -> setLocaleMessages(PL, PlMessages)
      PT_BR -> setLocaleMessages(PT_BR, PtBrMessages)
      PT_BR_SHORT -> setLocaleMessages(PT_BR, PtBrShortMessages)
      RO -> setLocaleMessages(RO, RoMessages)
      RO_SHORT -> setLocaleMessages(RO_SHORT, RoShortMessages)
      RU -> setLocaleMessages(RU, RuMessages)
      RU_SHORT -> setLocaleMessages(RU_SHORT, RuShortMessages)
      RW -> setLocaleMessages(RW, RwMessages)
      RW_SHORT -> setLocaleMessages(RW_SHORT, RwShortMessages)
      SV -> setLocaleMessages(SV, SvMessages)
      SV_SHORT -> setLocaleMessages(SV_SHORT, SvShortMessages)
      TA -> setLocaleMessages(TA, TaMessages)
      TH -> setLocaleMessages(TH, ThMessages)
      TH_SHORT -> setLocaleMessages(TH_SHORT, ThShortMessages)
      TK -> setLocaleMessages(TK, TkMessages)
      TR -> setLocaleMessages(TR, TrMessages)
      UK -> setLocaleMessages(UK, UkMessages)
      UK_SHORT -> setLocaleMessages(UK_SHORT, UkShortMessages)
      UR -> setLocaleMessages(UR, UrMessages)
      UR_SHORT -> setLocaleMessages(UR_SHORT, UrShortMessages)
      VI -> setLocaleMessages(VI, ViMessages)
      VI_SHORT -> setLocaleMessages(VI_SHORT, ViShortMessages)
      ZH_CN -> setLocaleMessages(ZH_CN, ZhCnMessages)
      ZH -> setLocaleMessages(ZH, ZhMessages)
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
   *
   * Example:
   * ```Kotlin
   * setLocaleMessagesAndDefaultLocale(AR)
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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

    val roundedSeconds = seconds.round(digits = 2).toInt()
    val roundedMinutes = minutes.round(digits = 2).toInt()
    val roundedHours = hours.round(digits = 2).toInt()
    val roundedDays = days.round(digits = 2).toInt()
    val roundedWeeks = weeks.round(digits = 2).toInt()
    val roundedMonths = months.round(digits = 2).toInt()
    val roundedYears = years.round(digits = 2).toInt()

    val result = with(messages) {
      when {
        roundedSeconds < LESS_THAN_ONE_MINUTE -> {
          val result = lessThanOneMinute(roundedSeconds, date)
          if (minCutOff.priority > 6) return result else result
        }
        roundedSeconds < ABOUT_A_MINUTE -> {
          val result = aboutAMinute(roundedMinutes, date)
          if (minCutOff.priority > 5) return result else result
        }
        roundedMinutes < MINUTES -> {
          val remindSecond = roundedSeconds - (roundedMinutes * MINUTE_IN_SECOND.toInt())
          val result = minutes(roundedMinutes, remindSecond, date)
          if (minCutOff.priority > 5) return result else result
        }
        roundedMinutes < ABOUT_AN_HOUR -> {
          val result = aboutAnHour(roundedMinutes, date)
          if (minCutOff.priority > 4) return result else result
        }
        roundedHours < HOURS -> {
          val remindMinute = roundedMinutes - (roundedHours * HOUR_IN_MINUTE.toInt())
          val result = hours(roundedHours, remindMinute, date)
          if (minCutOff.priority > 4) return result else result
        }
        roundedHours < A_DAY -> {
          val result = aDay(roundedHours, date)
          if (minCutOff.priority > 3) return result else result
        }
        roundedDays < A_WEEK && isWeekFormatEnabled -> {
          val remindHour = roundedHours - (roundedDays * DAY_IN_HOUR.toInt())
          val result = days(roundedDays, remindHour, date)
          if (minCutOff.priority > 3) return result else result
        }
        roundedDays < DAYS && isWeekFormatEnabled -> {
          val remindDay = roundedDays - (roundedWeeks * WEEK_IN_DAY.toInt())
          val result = weeks(roundedWeeks, remindDay, date)
          if (minCutOff.priority > 2) return result else result
        }
        roundedDays < DAYS && !isWeekFormatEnabled -> {
          val remindHour = roundedHours - (roundedDays * DAY_IN_HOUR.toInt())
          val result = days(roundedDays, remindHour, date)
          if (minCutOff.priority > 3) return result else result
        }
        roundedDays < ABOUT_A_MONTH -> {
          val result = aboutAMonth(roundedDays, date)
          if (minCutOff.priority > 1) return result else result
        }
        roundedDays < ABOUT_A_YEAR -> {
          val remindDay = roundedDays - (roundedMonths * MONTH_IN_DAY.toInt())
          val result = months(roundedMonths, remindDay, date)
          if (minCutOff.priority > 1) return result else result
        }
        roundedYears < 2 -> {
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
   * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
      date.toDate().time,
      locale,
      clock.toDate().time,
      minCutOff,
      isWeekFormatEnabled,
      allowFromNow
    )

  object Locale {
    const val EN: String = "en"
    const val EN_SHORT: String = "en_short"
    const val EN_SHORT_DETAIL: String = "en_short_detail"
    const val EN_DETAIL: String = "en_detail"
    const val FA: String = "fa"
    const val FA_SHORT: String = "fa_short"
    const val AM: String = "am"
    const val AM_SHORT: String = "am_short"
    const val AR: String = "ar"
    const val AR_SHORT: String = "ar_short"
    const val AZ: String = "az"
    const val AZ_SHORT: String = "az_short"
    const val BS: String = "bs"
    const val BS_SHORT: String = "bs_short"
    const val CA: String = "ca"
    const val CA_SHORT: String = "ca_short"
    const val CS: String = "cs"
    const val CS_SHORT: String = "cs_short"
    const val DA: String = "da"
    const val DA_SHORT: String = "da_short"
    const val DE: String = "de"
    const val DE_SHORT: String = "de_short"
    const val DV: String = "dv"
    const val DV_SHORT: String = "dv_short"
    const val ES: String = "es"
    const val ES_SHORT: String = "es_short"
    const val ET: String = "et"
    const val ET_SHORT: String = "et_short"
    const val FI: String = "fi"
    const val FI_SHORT: String = "fi_short"
    const val FR: String = "fr"
    const val FR_SHORT: String = "fr_short"
    const val GR: String = "gr"
    const val GR_SHORT: String = "gr_short"
    const val HE: String = "he"
    const val HE_SHORT: String = "he_short"
    const val HI: String = "hi"
    const val HI_SHORT: String = "hi_short"
    const val HU: String = "hu"
    const val HU_SHORT: String = "hu_short"
    const val ID: String = "id"
    const val IT: String = "it"
    const val IT_SHORT: String = "it_short"
    const val JA: String = "ja"
    const val KM: String = "km"
    const val KM_SHORT: String = "km_short"
    const val KO: String = "ko"
    const val KU: String = "ku"
    const val KU_SHORT: String = "ku_short"
    const val MN: String = "mn"
    const val MN_SHORT: String = "mn_short"
    const val MS_MY: String = "ms_my"
    const val MS_MY_SHORT: String = "ms_my_short"
    const val MY: String = "my"
    const val MY_SHORT: String = "my_short"
    const val NB_NO: String = "nb_no"
    const val NB_NO_SHORT: String = "nb_no_short"
    const val NL: String = "nl"
    const val NL_SHORT: String = "nl_short"
    const val NN_NO: String = "nn_no"
    const val NN_NO_SHORT: String = "nn_no_short"
    const val PL: String = "pl"
    const val PT_BR: String = "pt_br"
    const val PT_BR_SHORT: String = "pt_br_short"
    const val RO: String = "ro"
    const val RO_SHORT: String = "ro_short"
    const val RU: String = "ru"
    const val RU_SHORT: String = "ru_short"
    const val RW: String = "rw"
    const val RW_SHORT: String = "rw_short"
    const val SV: String = "sv"
    const val SV_SHORT: String = "sv_short"
    const val TA: String = "ta"
    const val TH: String = "th"
    const val TH_SHORT: String = "th_short"
    const val TK: String = "tk"
    const val TR: String = "tr"
    const val UK: String = "uk"
    const val UK_SHORT: String = "uk_short"
    const val UR: String = "ur"
    const val UR_SHORT: String = "ur_short"
    const val VI: String = "vi"
    const val VI_SHORT: String = "vi_short"
    const val ZH_CN: String = "zh_cn"
    const val ZH: String = "zh"
  }
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
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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
 * see [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
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

private const val LESS_THAN_ONE_MINUTE = 60.0
private const val ABOUT_A_MINUTE = 120.0
private const val MINUTES = 60.0
private const val ABOUT_AN_HOUR = 120.0
private const val HOURS = 24.0
private const val A_DAY = 48.0
private const val DAYS = 30.0
private const val A_WEEK = 7.0
private const val ABOUT_A_MONTH = 60.0
private const val ABOUT_A_YEAR = 365.0
