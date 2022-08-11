package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Estonian Messages.
 * @since 1.1.0
 */
internal object EtMessages : LookupMessages {
  override fun suffixAgo(): String = "tagasi"
  override fun suffixFromNow(): String = "pärast"
  override fun lessThanOneMinute(seconds: Int): String = "hetk"
  override fun aboutAMinute(minutes: Int): String = "üks minut"
  override fun minutes(minutes: Int): String = "$minutes minutit"
  override fun aboutAnHour(minutes: Int): String = "umbes tunni"
  override fun hours(hours: Int): String = "$hours tunni"
  override fun aDay(hours: Int): String = "üks päev"
  override fun days(days: Int): String = "$days päeva"
  override fun aboutAMonth(days: Int): String = "umbes kuu"
  override fun months(months: Int): String = "$months kuud"
  override fun aboutAYear(year: Int): String = "umbes aasta"
  override fun years(years: Int): String = "$years aastat"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Estonian Short Messages.
 * @since 1.1.0
 */
internal object EtShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "nüüd"
  override fun aboutAMinute(minutes: Int): String = "1m"
  override fun minutes(minutes: Int): String = "${minutes}m"
  override fun aboutAnHour(minutes: Int): String = "~1t"
  override fun hours(hours: Int): String = "${hours}t"
  override fun aDay(hours: Int): String = "~1p"
  override fun days(days: Int): String = "${days}p"
  override fun aboutAMonth(days: Int): String = "~1k"
  override fun months(months: Int): String = "${months}k"
  override fun aboutAYear(year: Int): String = "~1a"
  override fun years(years: Int): String = "${years}a"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
