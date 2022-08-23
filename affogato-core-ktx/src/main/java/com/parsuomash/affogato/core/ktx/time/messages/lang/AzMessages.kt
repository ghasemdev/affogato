@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Azeri Messages.
 * @since 1.1.0
 */
internal object AzMessages : LookupMessages {
  override fun suffixAgo(): String = "əvvəl"
  override fun suffixFromNow(): String = "indidən"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "bir dəqiqə"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "bir dəqiqə"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes dəqiqə"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "təxminən 1 saat"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours saat"
  override fun aDay(hours: Int, dateInMillis: Long): String = "bir gün"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days gün"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "təxminən 1 ay"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months ay"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "təxminən 1 il"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years il"
}

/**
 * Azeri Short Messages.
 * @since 1.1.0
 */
internal object AzShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "indi"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 dəq"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes dəq"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 s"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours s"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 g"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days g"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 ay"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months ay"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 il"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years il"
}
