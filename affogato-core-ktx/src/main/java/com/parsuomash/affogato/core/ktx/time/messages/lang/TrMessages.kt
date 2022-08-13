package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Turkish Messages.
 * @since 1.1.0
 */
internal object TrMessages : LookupMessages {
  override fun suffixAgo(): String = "önce"
  override fun suffixFromNow(): String = "kaldı"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "biraz"
  override fun aboutAMinute(minutes: Int, date: Long): String = "bir dakika"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes dakika"
  override fun aboutAnHour(minutes: Int, date: Long): String = "bir saat"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours saat"
  override fun aDay(hours: Int, date: Long): String = "bir gün"
  override fun days(days: Int, hours: Int, date: Long): String = "$days gün"
  override fun aboutAMonth(days: Int, date: Long): String = "bir ay"
  override fun months(months: Int, days: Int, date: Long): String = "$months ay"
  override fun aboutAYear(year: Int, date: Long): String = "bir yıl"
  override fun years(years: Int, months: Int, date: Long): String = "$years yıl"
}
