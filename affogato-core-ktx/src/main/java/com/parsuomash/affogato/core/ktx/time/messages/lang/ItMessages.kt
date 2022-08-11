package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Italian Messages.
 * @since 1.1.0
 */
internal object ItMessages : LookupMessages {
  override fun prefixFromNow(): String = "tra"
  override fun suffixAgo(): String = "fa"
  override fun lessThanOneMinute(seconds: Int): String = "meno di un minuto"
  override fun aboutAMinute(minutes: Int): String = "circa un minuto"
  override fun minutes(minutes: Int): String = "$minutes minuti"
  override fun aboutAnHour(minutes: Int): String = "circa un'ora"
  override fun hours(hours: Int): String = "$hours ore"
  override fun aDay(hours: Int): String = "circa un giorno"
  override fun days(days: Int): String = "$days giorni"
  override fun aboutAMonth(days: Int): String = "circa un mese"
  override fun months(months: Int): String = "$months mesi"
  override fun aboutAYear(year: Int): String = "circa un anno"
  override fun years(years: Int): String = "$years anni"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Italian Short Messages.
 * @since 1.1.0
 */
internal object ItShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "ora"
  override fun aboutAMinute(minutes: Int): String = "1 m"
  override fun minutes(minutes: Int): String = "$minutes m"
  override fun aboutAnHour(minutes: Int): String = "~1 o"
  override fun hours(hours: Int): String = "$hours o"
  override fun aDay(hours: Int): String = "~1 g"
  override fun days(days: Int): String = "$days g"
  override fun aboutAMonth(days: Int): String = "~1 m"
  override fun months(months: Int): String = "$months m"
  override fun aboutAYear(year: Int): String = "~1 a"
  override fun years(years: Int): String = "$years a"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
