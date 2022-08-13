package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Portuguese-Brazil Messages.
 * @since 1.1.0
 */
internal object PtBrMessages : LookupMessages {
  override fun prefixAgo(): String = "há"
  override fun prefixFromNow(): String = "em"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "poucos segundos"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 minuto"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minutos"
  override fun aboutAnHour(minutes: Int, date: Long): String = "1 hora"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours horas"
  override fun aDay(hours: Int, date: Long): String = "1 dia"
  override fun days(days: Int, hours: Int, date: Long): String = "$days dias"
  override fun aboutAMonth(days: Int, date: Long): String = "1 mês"
  override fun months(months: Int, days: Int, date: Long): String = "$months meses"
  override fun aboutAYear(year: Int, date: Long): String = "1 ano"
  override fun years(years: Int, months: Int, date: Long): String = "$years anos"
}

/**
 * Portuguese-Brazil Short Messages.
 * @since 1.1.0
 */
internal object PtBrShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "agora"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1h"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours h"
  override fun aDay(hours: Int, date: Long): String = "~1 dia"
  override fun days(days: Int, hours: Int, date: Long): String = "$days dias"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 mês"
  override fun months(months: Int, days: Int, date: Long): String = "$months meses"
  override fun aboutAYear(year: Int, date: Long): String = "~1 ano"
  override fun years(years: Int, months: Int, date: Long): String = "$years anos"
}
