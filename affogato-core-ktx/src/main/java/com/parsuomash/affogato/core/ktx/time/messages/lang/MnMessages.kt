@file:JvmName("_MnMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.text.NumberConverter
import com.parsuomash.affogato.core.ktx.time.TimeAgo
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Mongolian Messages.
 * @since 1.1.0
 */
internal object MnMessages : LookupMessages {
  override fun suffixAgo(): String = "өмнө"
  override fun suffixFromNow(): String = "дараа"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "хэдхэн мөчийн"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "минутын"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${toMongolian(minutes.toString())} минутын"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "цаг орчим"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${toMongolian(hours.toString())} цагийн"

  override fun aDay(hours: Int, dateInMillis: Long): String = "өдрийн"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${toMongolian(days.toString())} өдрийн"

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "сар орчмын"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${toMongolian(months.toString())} сарын"

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "жил орчмын"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${toMongolian(years.toString())} жилийн"
}

/**
 * Mongolian Short Messages.
 * @since 1.1.0
 */
internal object MnShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "саяхан"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "${toMongolian("1")} мин"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${toMongolian(minutes.toString())} мин"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~${toMongolian("1")} ц"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${toMongolian(hours.toString())} ц"

  override fun aDay(hours: Int, dateInMillis: Long): String = "~${toMongolian("1")} ө"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${toMongolian(days.toString())} ө"

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~${toMongolian("1")} с"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${toMongolian(months.toString())} с"

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~${toMongolian("1")} ж"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${toMongolian(years.toString())} ж"
}

private fun toMongolian(number: String) =
  if (TimeAgo.isLocaleNumberEnabled) NumberConverter.toMongolian(number) else number
