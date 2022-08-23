@file:JvmName("_NbNoMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Norwegian-Bokm-Norway Messages.
 * @since 1.1.0
 */
internal object NbNoMessages : LookupMessages {
  override fun suffixAgo(): String = "siden"
  override fun suffixFromNow(): String = "fra nå"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "ett øyeblikk"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "ett minutt"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minutter"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "rundt en time"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours timer"
  override fun aDay(hours: Int, dateInMillis: Long): String = "en dag"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days dager"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "omtrent en måned"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months måneder"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "omtrent et år"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years år"
}

/**
 * Norwegian-Bokm-Norway Short Messages.
 * @since 1.1.0
 */
internal object NbNoShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "nå"
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
