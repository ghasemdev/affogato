@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.text.NumberConverter
import com.parsuomash.affogato.core.ktx.time.TimeAgo
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Farsi messages.
 * @since 1.1.0
 */
internal object FaMessages : LookupMessages {
  override fun suffixAgo(): String = "پیش"
  override fun suffixFromNow(): String = "بعد"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "چند لحظه"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "یک دقیقه"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${toFarsi(minutes.toString())} دقیقه"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "یک ساعت"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${toFarsi(hours.toString())} ساعت"

  override fun aDay(hours: Int, dateInMillis: Long): String = "یک روز"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${toFarsi(days.toString())} روز"

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "یک ماه"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${toFarsi(months.toString())} ماه"

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "یک سال"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${toFarsi(years.toString())} سال"
}

/**
 * Farsi Short Messages.
 * @since 1.1.0
 */
internal object FaShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "الان"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "~${toFarsi("1")} د"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${toFarsi(minutes.toString())} د"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~${toFarsi("1")} س"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${toFarsi(hours.toString())} س"

  override fun aDay(hours: Int, dateInMillis: Long): String = "~${toFarsi("1")} ر"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${toFarsi(days.toString())} ر"

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~${toFarsi("1")} م"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${toFarsi(months.toString())} م"

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~${toFarsi("1")} س"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${toFarsi(years.toString())} س"
}

private fun toFarsi(number: String) =
  if (TimeAgo.isLocaleNumberEnabled) NumberConverter.toFarsi(number) else number
