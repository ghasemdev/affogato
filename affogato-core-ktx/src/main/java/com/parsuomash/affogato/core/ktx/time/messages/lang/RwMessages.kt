package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Russian Messages.
 * @since 1.1.0
 */
internal object RwMessages : LookupMessages {
  override fun prefixAgo(): String = "hashize"
  override fun prefixFromNow(): String = "kuva"
  override fun lessThanOneMinute(seconds: Int): String = "agahe gato"
  override fun aboutAMinute(minutes: Int): String = "umunota"
  override fun minutes(minutes: Int): String = "iminota $minutes"
  override fun aboutAnHour(minutes: Int): String = "isaha"
  override fun hours(hours: Int): String = "amasaha $hours"
  override fun aDay(hours: Int): String = "umunsi"
  override fun days(days: Int): String = "iminsi $days"
  override fun aboutAMonth(days: Int): String = "ukwezi"
  override fun months(months: Int): String = "amezi $months"
  override fun aboutAYear(year: Int): String = "umwaka"
  override fun years(years: Int): String = "imyaka $years"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Russian Short Messages.
 * @since 1.1.0
 */
internal object RwShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "ubu"
  override fun aboutAMinute(minutes: Int): String = "umunota"
  override fun minutes(minutes: Int): String = "iminota $minutes"
  override fun aboutAnHour(minutes: Int): String = "isaha"
  override fun hours(hours: Int): String = "amasaha $hours"
  override fun aDay(hours: Int): String = "umunsi"
  override fun days(days: Int): String = "iminsi $days"
  override fun aboutAMonth(days: Int): String = "ukwezi"
  override fun months(months: Int): String = "amezi $months"
  override fun aboutAYear(year: Int): String = "umwaka"
  override fun years(years: Int): String = "imyaka $years"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
