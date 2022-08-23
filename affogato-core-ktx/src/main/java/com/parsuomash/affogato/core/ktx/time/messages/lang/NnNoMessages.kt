@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Norwegian-Nynorsk-Norway Messages.
 * @since 1.1.0
 */
internal object NnNoMessages : LookupMessages {
  override fun suffixAgo(): String = "sidan"
  override fun suffixFromNow(): String = "frå no"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "eit augeblink"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "eit minutt"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minutt"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "rundt ein time"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours timer"
  override fun aDay(hours: Int, dateInMillis: Long): String = "ein dag"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days dagar"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "omtrent ein månad"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months månadar"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "omtrent eit år"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years år"
}

/**
 * Norwegian-Nynorsk-Norway Short Messages.
 * @since 1.1.0
 */
internal object NnNoShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "no"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 t"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours t"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 d"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days d"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 mnd"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months mnd"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 år"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years år"
}
