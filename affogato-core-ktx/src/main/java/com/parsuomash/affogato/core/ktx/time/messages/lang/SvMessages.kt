@file:JvmName("_SvMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Swedish Messages.
 * @since 1.1.0
 */
internal object SvMessages : LookupMessages {
  override fun prefixAgo(): String = "för"
  override fun prefixFromNow(): String = "om"
  override fun suffixAgo(): String = "sedan"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "en stund"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "en minut"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minuter"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "ungefär en timme"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours timmar"
  override fun aDay(hours: Int, dateInMillis: Long): String = "en dag"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days dagar"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "ungefär en månad"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months månader"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "ungefär ett år"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years år"
}

/**
 * Swedish Short Messages.
 * @since 1.1.0
 */
internal object SvShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "nu"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 h"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours h"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 d"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days d"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 mån"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months mån"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 år"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years år"
}
