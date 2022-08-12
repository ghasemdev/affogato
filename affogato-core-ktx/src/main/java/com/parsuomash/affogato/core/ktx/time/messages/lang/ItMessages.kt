package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Italian Messages.
 * @since 1.1.0
 */
internal object ItMessages : LookupMessages {
  override fun prefixFromNow(): String = "tra"
  override fun suffixAgo(): String = "fa"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "meno di un minuto"
  override fun aboutAMinute(minutes: Int, date: Long): String = "circa un minuto"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minuti"
  override fun aboutAnHour(minutes: Int, date: Long): String = "circa un'ora"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours ore"
  override fun aDay(hours: Int, date: Long): String = "circa un giorno"
  override fun days(days: Int, hours: Int, date: Long): String = "$days giorni"
  override fun aboutAMonth(days: Int, date: Long): String = "circa un mese"
  override fun months(months: Int, days: Int, date: Long): String = "$months mesi"
  override fun aboutAYear(year: Int, date: Long): String = "circa un anno"
  override fun years(years: Int, months: Int, date: Long): String = "$years anni"
}

/**
 * Italian Short Messages.
 * @since 1.1.0
 */
internal object ItShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "ora"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 m"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes m"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 o"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours o"
  override fun aDay(hours: Int, date: Long): String = "~1 g"
  override fun days(days: Int, hours: Int, date: Long): String = "$days g"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 m"
  override fun months(months: Int, days: Int, date: Long): String = "$months m"
  override fun aboutAYear(year: Int, date: Long): String = "~1 a"
  override fun years(years: Int, months: Int, date: Long): String = "$years a"
}
