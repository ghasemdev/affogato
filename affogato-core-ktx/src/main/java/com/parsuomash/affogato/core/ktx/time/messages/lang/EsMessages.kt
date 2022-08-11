package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Spanish Messages.
 * @since 1.1.0
 */
internal object EsMessages : LookupMessages {
  override fun prefixAgo(): String = "hace"
  override fun prefixFromNow(): String = "dentro de"
  override fun lessThanOneMinute(seconds: Int): String = "un momento"
  override fun aboutAMinute(minutes: Int): String = "un minuto"
  override fun minutes(minutes: Int): String = "$minutes minutos"
  override fun aboutAnHour(minutes: Int): String = "una hora"
  override fun hours(hours: Int): String = "$hours horas"
  override fun aDay(hours: Int): String = "un día"
  override fun days(days: Int): String = "$days días"
  override fun aboutAMonth(days: Int): String = "un mes"
  override fun months(months: Int): String = "$months meses"
  override fun aboutAYear(year: Int): String = "un año"
  override fun years(years: Int): String = "$years años"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Spanish Short Messages.
 * @since 1.1.0
 */
internal object EsShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "ahora"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 hr"
  override fun hours(hours: Int): String = "$hours hr"
  override fun aDay(hours: Int): String = "~1 día"
  override fun days(days: Int): String = "$days días"
  override fun aboutAMonth(days: Int): String = "~1 mes"
  override fun months(months: Int): String = "$months meses"
  override fun aboutAYear(year: Int): String = "~1 año"
  override fun years(years: Int): String = "$years años"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
