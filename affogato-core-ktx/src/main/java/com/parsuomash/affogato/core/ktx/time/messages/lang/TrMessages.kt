@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Turkish Messages.
 * @since 1.1.0
 */
internal object TrMessages : LookupMessages {
  override fun suffixAgo(): String = "önce"
  override fun suffixFromNow(): String = "kaldı"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "biraz"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "bir dakika"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes dakika"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "bir saat"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours saat"
  override fun aDay(hours: Int, dateInMillis: Long): String = "bir gün"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days gün"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "bir ay"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months ay"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "bir yıl"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years yıl"
}
