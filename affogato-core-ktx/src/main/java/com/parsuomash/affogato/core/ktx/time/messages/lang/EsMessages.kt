package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Spanish Messages.
 * @since 1.1.0
 */
internal object EsMessages : LookupMessages {
  override fun prefixAgo(): String = "hace"
  override fun prefixFromNow(): String = "dentro de"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "un momento"
  override fun aboutAMinute(minutes: Int, date: Long): String = "un minuto"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minutos"
  override fun aboutAnHour(minutes: Int, date: Long): String = "una hora"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours horas"
  override fun aDay(hours: Int, date: Long): String = "un día"
  override fun days(days: Int, hours: Int, date: Long): String = "$days días"
  override fun aboutAMonth(days: Int, date: Long): String = "un mes"
  override fun months(months: Int, days: Int, date: Long): String = "$months meses"
  override fun aboutAYear(year: Int, date: Long): String = "un año"
  override fun years(years: Int, months: Int, date: Long): String = "$years años"
}

/**
 * Spanish Short Messages.
 * @since 1.1.0
 */
internal object EsShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "ahora"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 hr"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours hr"
  override fun aDay(hours: Int, date: Long): String = "~1 día"
  override fun days(days: Int, hours: Int, date: Long): String = "$days días"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 mes"
  override fun months(months: Int, days: Int, date: Long): String = "$months meses"
  override fun aboutAYear(year: Int, date: Long): String = "~1 año"
  override fun years(years: Int, months: Int, date: Long): String = "$years años"
}
