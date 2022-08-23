@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Estonian Messages.
 * @since 1.1.0
 */
internal object EtMessages : LookupMessages {
  override fun suffixAgo(): String = "tagasi"
  override fun suffixFromNow(): String = "pärast"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "hetk"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "üks minut"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minutit"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "umbes tunni"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours tunni"
  override fun aDay(hours: Int, dateInMillis: Long): String = "üks päev"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days päeva"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "umbes kuu"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months kuud"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "umbes aasta"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years aastat"
}

/**
 * Estonian Short Messages.
 * @since 1.1.0
 */
internal object EtShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "nüüd"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1m"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "${minutes}m"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1t"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "${hours}t"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1p"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "${days}p"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1k"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "${months}k"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1a"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "${years}a"
}
