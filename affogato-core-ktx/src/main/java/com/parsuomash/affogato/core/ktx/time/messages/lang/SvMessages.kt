package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Swedish Messages.
 * @since 1.1.0
 */
internal object SvMessages : LookupMessages {
  override fun prefixAgo(): String = "för"
  override fun prefixFromNow(): String = "om"
  override fun suffixAgo(): String = "sedan"
  override fun lessThanOneMinute(seconds: Int): String = "en stund"
  override fun aboutAMinute(minutes: Int): String = "en minut"
  override fun minutes(minutes: Int): String = "$minutes minuter"
  override fun aboutAnHour(minutes: Int): String = "ungefär en timme"
  override fun hours(hours: Int): String = "$hours timmar"
  override fun aDay(hours: Int): String = "en dag"
  override fun days(days: Int): String = "$days dagar"
  override fun aboutAMonth(days: Int): String = "ungefär en månad"
  override fun months(months: Int): String = "$months månader"
  override fun aboutAYear(year: Int): String = "ungefär ett år"
  override fun years(years: Int): String = "$years år"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Swedish Short Messages.
 * @since 1.1.0
 */
internal object SvShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "nu"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 h"
  override fun hours(hours: Int): String = "$hours h"
  override fun aDay(hours: Int): String = "~1 d"
  override fun days(days: Int): String = "$days d"
  override fun aboutAMonth(days: Int): String = "~1 mån"
  override fun months(months: Int): String = "$months mån"
  override fun aboutAYear(year: Int): String = "~1 år"
  override fun years(years: Int): String = "$years år"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
