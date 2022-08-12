package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Bosnian Messages.
 * @since 1.1.0
 */
internal object BsMessages : LookupMessages {
  override fun prefixAgo(): String = "prije"
  override fun prefixFromNow(): String = "za"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "manje od minute"
  override fun aboutAMinute(minutes: Int, date: Long): String = "prije minute"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minuta"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 sat"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours sati"
  override fun aDay(hours: Int, date: Long): String = "~1 dan"
  override fun days(days: Int, hours: Int, date: Long): String = "$days dana"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 mjesec"
  override fun months(months: Int, days: Int, date: Long): String = "$months mjeseci"
  override fun aboutAYear(year: Int, date: Long): String = "~1 godina"
  override fun years(years: Int, months: Int, date: Long): String = "$years godina"
}

/**
 * Bosnian Short Messages.
 * @since 1.1.0
 */
internal object BsShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "upravo sad"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 min."
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes min."
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 h."
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours h."
  override fun aDay(hours: Int, date: Long): String = "~1 d."
  override fun days(days: Int, hours: Int, date: Long): String = "$days d."
  override fun aboutAMonth(days: Int, date: Long): String = "~1 m."
  override fun months(months: Int, days: Int, date: Long): String = "$months m."
  override fun aboutAYear(year: Int, date: Long): String = "~1 g."
  override fun years(years: Int, months: Int, date: Long): String = "$years g."
}
