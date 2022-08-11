package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
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
  override fun lessThanOneMinute(seconds: Int): String = "kevesebb mint egy perc"
  override fun aboutAMinute(minutes: Int): String = "kb. egy perc"
  override fun minutes(minutes: Int): String = "$minutes perc"
  override fun aboutAnHour(minutes: Int): String = "kb. 1 óra"
  override fun hours(hours: Int): String = "$hours óra"
  override fun aDay(hours: Int): String = "egy nap"
  override fun days(days: Int): String = "$days napok"
  override fun aboutAMonth(days: Int): String = "kb. egy hónap"
  override fun months(months: Int): String = "$months hónap"
  override fun aboutAYear(year: Int): String = "kb. egy év"
  override fun years(years: Int): String = "$years évek"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
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
  override fun lessThanOneMinute(seconds: Int): String = "kevesebb mint egy perc"
  override fun aboutAMinute(minutes: Int): String = "kb. egy perc"
  override fun minutes(minutes: Int): String = "$minutes perc"
  override fun aboutAnHour(minutes: Int): String = "kb. 1 óra"
  override fun hours(hours: Int): String = "$hours óra"
  override fun aDay(hours: Int): String = "egy nap"
  override fun days(days: Int): String = "$days nap"
  override fun aboutAMonth(days: Int): String = "kb. 1 hónap"
  override fun months(months: Int): String = "$months honap"
  override fun aboutAYear(year: Int): String = "kb. 1 év"
  override fun years(years: Int): String = "$years év"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
