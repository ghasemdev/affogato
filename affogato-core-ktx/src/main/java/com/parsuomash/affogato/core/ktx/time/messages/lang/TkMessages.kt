package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Turkmen Messages.
 * @since 1.1.0
 */
internal object TkMessages : LookupMessages {
  override fun suffixAgo(): String = "öň"
  override fun suffixFromNow(): String = "galdy"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "biraz"
  override fun aboutAMinute(minutes: Int, date: Long): String = "bir minut"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minut"
  override fun aboutAnHour(minutes: Int, date: Long): String = "bir sagat"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours sagat"
  override fun aDay(hours: Int, date: Long): String = "bir gün"
  override fun days(days: Int, hours: Int, date: Long): String = "$days gün"
  override fun aboutAMonth(days: Int, date: Long): String = "bir aý"
  override fun months(months: Int, days: Int, date: Long): String = "$months aý"
  override fun aboutAYear(year: Int, date: Long): String = "bir ýyl"
  override fun years(years: Int, months: Int, date: Long): String = "$years ýyl"
}
