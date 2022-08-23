@file:JvmName("_FrMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * French Messages.
 * @since 1.1.0
 */
internal object FrMessages : LookupMessages {
  override fun prefixAgo(): String = "il y a"
  override fun prefixFromNow(): String = "d'ini"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "moins d'une minute"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "environ une minute"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "environ $minutes minutes"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "environ une heure"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours heures"
  override fun aDay(hours: Int, dateInMillis: Long): String = "environ un jour"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "environ $days jours"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "environ un mois"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "environ $months mois"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "un an"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years ans"
}

/**
 * French Short Messages.
 * @since 1.1.0
 */
internal object FrShortMessages : LookupMessages {
  override fun prefixAgo(): String = "il y a"
  override fun prefixFromNow(): String = "d'ici"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "moins d'une minute"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "une minute"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minutes"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "une heure"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours heures"
  override fun aDay(hours: Int, dateInMillis: Long): String = "un jour"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days jours"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "un mois"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months mois"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "un an"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years ans"
}
