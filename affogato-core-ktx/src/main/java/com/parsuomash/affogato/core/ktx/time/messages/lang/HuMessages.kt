package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Hungarian Messages.
 * @since 1.1.0
 */
internal object HuMessages : LookupMessages {
  override fun prefixAgo(): String = "ezelött"
  override fun prefixFromNow(): String = "mostantól"
  override fun suffixAgo(): String = "e"
  override fun suffixFromNow(): String = "mostantól"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "kevesebb mint egy perc"
  override fun aboutAMinute(minutes: Int, date: Long): String = "kb. egy perc"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes perc"
  override fun aboutAnHour(minutes: Int, date: Long): String = "kb. 1 óra"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours óra"
  override fun aDay(hours: Int, date: Long): String = "egy nap"
  override fun days(days: Int, hours: Int, date: Long): String = "$days napok"
  override fun aboutAMonth(days: Int, date: Long): String = "kb. egy hónap"
  override fun months(months: Int, days: Int, date: Long): String = "$months hónap"
  override fun aboutAYear(year: Int, date: Long): String = "kb. egy év"
  override fun years(years: Int, months: Int, date: Long): String = "$years évek"
}

/**
 * Hungarian Short Messages.
 * @since 1.1.0
 */
internal object HuShortMessages : LookupMessages {
  override fun prefixAgo(): String = "ezelött"
  override fun prefixFromNow(): String = "mostantól"
  override fun suffixAgo(): String = "e"
  override fun suffixFromNow(): String = "mostantól"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "kevesebb mint egy perc"
  override fun aboutAMinute(minutes: Int, date: Long): String = "kb. egy perc"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes perc"
  override fun aboutAnHour(minutes: Int, date: Long): String = "kb. 1 óra"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours óra"
  override fun aDay(hours: Int, date: Long): String = "egy nap"
  override fun days(days: Int, hours: Int, date: Long): String = "$days nap"
  override fun aboutAMonth(days: Int, date: Long): String = "kb. 1 hónap"
  override fun months(months: Int, days: Int, date: Long): String = "$months honap"
  override fun aboutAYear(year: Int, date: Long): String = "kb. 1 év"
  override fun years(years: Int, months: Int, date: Long): String = "$years év"
}
