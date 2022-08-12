package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Azeri Messages.
 * @since 1.1.0
 */
internal object AzMessages : LookupMessages {
  override fun suffixAgo(): String = "əvvəl"
  override fun suffixFromNow(): String = "indidən"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "bir dəqiqə"
  override fun aboutAMinute(minutes: Int, date: Long): String = "bir dəqiqə"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes dəqiqə"
  override fun aboutAnHour(minutes: Int, date: Long): String = "təxminən 1 saat"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours saat"
  override fun aDay(hours: Int, date: Long): String = "bir gün"
  override fun days(days: Int, hours: Int, date: Long): String = "$days gün"
  override fun aboutAMonth(days: Int, date: Long): String = "təxminən 1 ay"
  override fun months(months: Int, days: Int, date: Long): String = "$months ay"
  override fun aboutAYear(year: Int, date: Long): String = "təxminən 1 il"
  override fun years(years: Int, months: Int, date: Long): String = "$years il"
}

/**
 * Azeri Short Messages.
 * @since 1.1.0
 */
internal object AzShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "indi"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 dəq"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes dəq"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 s"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours s"
  override fun aDay(hours: Int, date: Long): String = "~1 g"
  override fun days(days: Int, hours: Int, date: Long): String = "$days g"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 ay"
  override fun months(months: Int, days: Int, date: Long): String = "$months ay"
  override fun aboutAYear(year: Int, date: Long): String = "~1 il"
  override fun years(years: Int, months: Int, date: Long): String = "$years il"
}
