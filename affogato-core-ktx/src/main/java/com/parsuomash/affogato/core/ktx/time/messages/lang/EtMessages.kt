package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Estonian Messages.
 * @since 1.1.0
 */
internal object EtMessages : LookupMessages {
  override fun suffixAgo(): String = "tagasi"
  override fun suffixFromNow(): String = "pärast"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "hetk"
  override fun aboutAMinute(minutes: Int, date: Long): String = "üks minut"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minutit"
  override fun aboutAnHour(minutes: Int, date: Long): String = "umbes tunni"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours tunni"
  override fun aDay(hours: Int, date: Long): String = "üks päev"
  override fun days(days: Int, hours: Int, date: Long): String = "$days päeva"
  override fun aboutAMonth(days: Int, date: Long): String = "umbes kuu"
  override fun months(months: Int, days: Int, date: Long): String = "$months kuud"
  override fun aboutAYear(year: Int, date: Long): String = "umbes aasta"
  override fun years(years: Int, months: Int, date: Long): String = "$years aastat"
}

/**
 * Estonian Short Messages.
 * @since 1.1.0
 */
internal object EtShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "nüüd"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1m"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "${minutes}m"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1t"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "${hours}t"
  override fun aDay(hours: Int, date: Long): String = "~1p"
  override fun days(days: Int, hours: Int, date: Long): String = "${days}p"
  override fun aboutAMonth(days: Int, date: Long): String = "~1k"
  override fun months(months: Int, days: Int, date: Long): String = "${months}k"
  override fun aboutAYear(year: Int, date: Long): String = "~1a"
  override fun years(years: Int, months: Int, date: Long): String = "${years}a"
}
