package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Catalan Messages.
 * @since 1.1.0
 */
internal object CaMessages : LookupMessages {
  override fun prefixAgo(): String = "fa"
  override fun prefixFromNow(): String = "d'aquí a"
  override fun lessThanOneMinute(seconds: Int): String = "un moment"
  override fun aboutAMinute(minutes: Int): String = "un minut"
  override fun minutes(minutes: Int): String = "$minutes minuts"
  override fun aboutAnHour(minutes: Int): String = "una hora"
  override fun hours(hours: Int): String = "$hours hores"
  override fun aDay(hours: Int): String = "un dia"
  override fun days(days: Int): String = "$days dies"
  override fun aboutAMonth(days: Int): String = "un mes"
  override fun months(months: Int): String = "$months mesos"
  override fun aboutAYear(year: Int): String = "un any"
  override fun years(years: Int): String = "$years anys"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Catalan Short Messages.
 * @since 1.1.0
 */
internal object CaShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "ara"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 hr"
  override fun hours(hours: Int): String = "$hours hr "
  override fun aDay(hours: Int): String = "~1 dia"
  override fun days(days: Int): String = "$days dies"
  override fun aboutAMonth(days: Int): String = "~1 mes"
  override fun months(months: Int): String = "$months mesos"
  override fun aboutAYear(year: Int): String = "~1 any"
  override fun years(years: Int): String = "$years anys"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
