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
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "en stund"
  override fun aboutAMinute(minutes: Int, date: Long): String = "en minut"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minuter"
  override fun aboutAnHour(minutes: Int, date: Long): String = "ungefär en timme"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours timmar"
  override fun aDay(hours: Int, date: Long): String = "en dag"
  override fun days(days: Int, hours: Int, date: Long): String = "$days dagar"
  override fun aboutAMonth(days: Int, date: Long): String = "ungefär en månad"
  override fun months(months: Int, days: Int, date: Long): String = "$months månader"
  override fun aboutAYear(year: Int, date: Long): String = "ungefär ett år"
  override fun years(years: Int, months: Int, date: Long): String = "$years år"
}

/**
 * Swedish Short Messages.
 * @since 1.1.0
 */
internal object SvShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "nu"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 h"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours h"
  override fun aDay(hours: Int, date: Long): String = "~1 d"
  override fun days(days: Int, hours: Int, date: Long): String = "$days d"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 mån"
  override fun months(months: Int, days: Int, date: Long): String = "$months mån"
  override fun aboutAYear(year: Int, date: Long): String = "~1 år"
  override fun years(years: Int, months: Int, date: Long): String = "$years år"
}
