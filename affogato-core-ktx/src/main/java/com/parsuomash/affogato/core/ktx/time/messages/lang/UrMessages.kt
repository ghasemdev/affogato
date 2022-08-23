@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.text.NumberConverter
import com.parsuomash.affogato.core.ktx.time.TimeAgo
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Urdu Messages.
 * @since 1.1.0
 */
internal object UrMessages : LookupMessages {
  override fun suffixAgo(): String = "پہلے"
  override fun suffixFromNow(): String = "اب سے"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "ایک لمحہ"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "ایک منٹ"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${toUrdu(minutes.toString())} منٹ"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "ایک گھنٹہ"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${toUrdu(hours.toString())} گھنٹے"

  override fun aDay(hours: Int, dateInMillis: Long): String = "ایک دن"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${toUrdu(days.toString())} دن"

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "ایک مہینہ"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${toUrdu(months.toString())} مہینہ"

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "ایک سال"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${toUrdu(years.toString())} برس"
}

/**
 * Urdu Short Messages.
 * @since 1.1.0
 */
internal object UrShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "ابھی"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "${toUrdu("1")} م"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${toUrdu(minutes.toString())} منٹ"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~${toUrdu("1")} گھ"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${toUrdu(hours.toString())} گھ"

  override fun aDay(hours: Int, dateInMillis: Long): String = "~${toUrdu("1")} د"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${toUrdu(days.toString())} د"

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~${toUrdu("1")} ماہ"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${toUrdu(months.toString())} ماہ"

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~${toUrdu("1")} س"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${toUrdu(years.toString())} س"
}

private fun toUrdu(number: String) =
  if (TimeAgo.isLocaleNumberEnabled) NumberConverter.toUrdu(number) else number
