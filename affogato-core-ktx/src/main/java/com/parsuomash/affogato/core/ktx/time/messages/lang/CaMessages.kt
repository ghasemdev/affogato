package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Catalan Messages.
 * @since 1.1.0
 */
internal object CaMessages : LookupMessages {
  override fun prefixAgo(): String = "fa"
  override fun prefixFromNow(): String = "d'aquí a"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "un moment"
  override fun aboutAMinute(minutes: Int, date: Long): String = "un minut"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minuts"
  override fun aboutAnHour(minutes: Int, date: Long): String = "una hora"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours hores"
  override fun aDay(hours: Int, date: Long): String = "un dia"
  override fun days(days: Int, hours: Int, date: Long): String = "$days dies"
  override fun aboutAMonth(days: Int, date: Long): String = "un mes"
  override fun months(months: Int, days: Int, date: Long): String = "$months mesos"
  override fun aboutAYear(year: Int, date: Long): String = "un any"
  override fun years(years: Int, months: Int, date: Long): String = "$years anys"
}

/**
 * Catalan Short Messages.
 * @since 1.1.0
 */
internal object CaShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "ara"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 hr"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours hr "
  override fun aDay(hours: Int, date: Long): String = "~1 dia"
  override fun days(days: Int, hours: Int, date: Long): String = "$days dies"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 mes"
  override fun months(months: Int, days: Int, date: Long): String = "$months mesos"
  override fun aboutAYear(year: Int, date: Long): String = "~1 any"
  override fun years(years: Int, months: Int, date: Long): String = "$years anys"
}
