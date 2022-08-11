package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Azeri Messages.
 * @since 1.1.0
 */
internal object AzMessages : LookupMessages {
  override fun suffixAgo(): String = "əvvəl"
  override fun suffixFromNow(): String = "indidən"
  override fun lessThanOneMinute(seconds: Int): String = "bir dəqiqə"
  override fun aboutAMinute(minutes: Int): String = "bir dəqiqə"
  override fun minutes(minutes: Int): String = "$minutes dəqiqə"
  override fun aboutAnHour(minutes: Int): String = "təxminən 1 saat"
  override fun hours(hours: Int): String = "$hours saat"
  override fun aDay(hours: Int): String = "bir gün"
  override fun days(days: Int): String = "$days gün"
  override fun aboutAMonth(days: Int): String = "təxminən 1 ay"
  override fun months(months: Int): String = "$months ay"
  override fun aboutAYear(year: Int): String = "təxminən 1 il"
  override fun years(years: Int): String = "$years il"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Azeri Short Messages.
 * @since 1.1.0
 */
internal object AzShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "indi"
  override fun aboutAMinute(minutes: Int): String = "1 dəq"
  override fun minutes(minutes: Int): String = "$minutes dəq"
  override fun aboutAnHour(minutes: Int): String = "~1 s"
  override fun hours(hours: Int): String = "$hours s"
  override fun aDay(hours: Int): String = "~1 g"
  override fun days(days: Int): String = "$days g"
  override fun aboutAMonth(days: Int): String = "~1 ay"
  override fun months(months: Int): String = "$months ay"
  override fun aboutAYear(year: Int): String = "~1 il"
  override fun years(years: Int): String = "$years il"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
