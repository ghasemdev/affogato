package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Russian Messages.
 * @since 1.1.0
 */
internal object RwMessages : LookupMessages {
  override fun prefixAgo(): String = "hashize"
  override fun prefixFromNow(): String = "kuva"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "agahe gato"
  override fun aboutAMinute(minutes: Int, date: Long): String = "umunota"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "iminota $minutes"
  override fun aboutAnHour(minutes: Int, date: Long): String = "isaha"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "amasaha $hours"
  override fun aDay(hours: Int, date: Long): String = "umunsi"
  override fun days(days: Int, hours: Int, date: Long): String = "iminsi $days"
  override fun aboutAMonth(days: Int, date: Long): String = "ukwezi"
  override fun months(months: Int, days: Int, date: Long): String = "amezi $months"
  override fun aboutAYear(year: Int, date: Long): String = "umwaka"
  override fun years(years: Int, months: Int, date: Long): String = "imyaka $years"
}

/**
 * Russian Short Messages.
 * @since 1.1.0
 */
internal object RwShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "ubu"
  override fun aboutAMinute(minutes: Int, date: Long): String = "umunota"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "iminota $minutes"
  override fun aboutAnHour(minutes: Int, date: Long): String = "isaha"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "amasaha $hours"
  override fun aDay(hours: Int, date: Long): String = "umunsi"
  override fun days(days: Int, hours: Int, date: Long): String = "iminsi $days"
  override fun aboutAMonth(days: Int, date: Long): String = "ukwezi"
  override fun months(months: Int, days: Int, date: Long): String = "amezi $months"
  override fun aboutAYear(year: Int, date: Long): String = "umwaka"
  override fun years(years: Int, months: Int, date: Long): String = "imyaka $years"
}
