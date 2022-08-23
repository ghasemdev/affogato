@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Russian Messages.
 * @since 1.1.0
 */
internal object RwMessages : LookupMessages {
  override fun prefixAgo(): String = "hashize"
  override fun prefixFromNow(): String = "kuva"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "agahe gato"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "umunota"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "iminota $minutes"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "isaha"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "amasaha $hours"
  override fun aDay(hours: Int, dateInMillis: Long): String = "umunsi"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "iminsi $days"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "ukwezi"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "amezi $months"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "umwaka"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "imyaka $years"
}

/**
 * Russian Short Messages.
 * @since 1.1.0
 */
internal object RwShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "ubu"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "umunota"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "iminota $minutes"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "isaha"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "amasaha $hours"
  override fun aDay(hours: Int, dateInMillis: Long): String = "umunsi"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "iminsi $days"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "ukwezi"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "amezi $months"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "umwaka"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "imyaka $years"
}
