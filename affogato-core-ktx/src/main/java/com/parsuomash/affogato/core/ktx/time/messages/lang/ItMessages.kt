@file:JvmName("_ItMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Italian Messages.
 * @since 1.1.0
 */
internal object ItMessages : LookupMessages {
  override fun prefixFromNow(): String = "tra"
  override fun suffixAgo(): String = "fa"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "meno di un minuto"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "circa un minuto"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minuti"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "circa un'ora"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours ore"
  override fun aDay(hours: Int, dateInMillis: Long): String = "circa un giorno"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days giorni"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "circa un mese"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months mesi"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "circa un anno"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years anni"
}

/**
 * Italian Short Messages.
 * @since 1.1.0
 */
internal object ItShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "ora"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 m"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes m"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 o"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours o"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 g"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days g"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 m"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months m"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 a"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years a"
}
