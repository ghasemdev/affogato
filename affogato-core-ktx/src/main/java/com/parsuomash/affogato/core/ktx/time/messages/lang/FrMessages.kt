package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * French Messages.
 * @since 1.1.0
 */
internal object FrMessages : LookupMessages {
  override fun prefixAgo(): String = "il y a"
  override fun prefixFromNow(): String = "d'ini"
  override fun lessThanOneMinute(seconds: Int): String = "moins d'une minute"
  override fun aboutAMinute(minutes: Int): String = "environ une minute"
  override fun minutes(minutes: Int): String = "environ $minutes minutes"
  override fun aboutAnHour(minutes: Int): String = "environ une heure"
  override fun hours(hours: Int): String = "$hours heures"
  override fun aDay(hours: Int): String = "environ un jour"
  override fun days(days: Int): String = "environ $days jours"
  override fun aboutAMonth(days: Int): String = "environ un mois"
  override fun months(months: Int): String = "environ $months mois"
  override fun aboutAYear(year: Int): String = "un an"
  override fun years(years: Int): String = "$years ans"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * French Short Messages.
 * @since 1.1.0
 */
internal object FrShortMessages : LookupMessages {
  override fun prefixAgo(): String = "il y a"
  override fun prefixFromNow(): String = "d'ici"
  override fun lessThanOneMinute(seconds: Int): String = "moins d'une minute"
  override fun aboutAMinute(minutes: Int): String = "une minute"
  override fun minutes(minutes: Int): String = "$minutes minutes"
  override fun aboutAnHour(minutes: Int): String = "une heure"
  override fun hours(hours: Int): String = "$hours heures"
  override fun aDay(hours: Int): String = "un jour"
  override fun days(days: Int): String = "$days jours"
  override fun aboutAMonth(days: Int): String = "un mois"
  override fun months(months: Int): String = "$months mois"
  override fun aboutAYear(year: Int): String = "un an"
  override fun years(years: Int): String = "$years ans"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
