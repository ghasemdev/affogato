package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Portuguese-Brazil Messages.
 * @since 1.1.0
 */
internal object PtBrMessages : LookupMessages {
  override fun prefixAgo(): String = "há"
  override fun prefixFromNow(): String = "em"
  override fun lessThanOneMinute(seconds: Int): String = "poucos segundos"
  override fun aboutAMinute(minutes: Int): String = "1 minuto"
  override fun minutes(minutes: Int): String = "$minutes minutos"
  override fun aboutAnHour(minutes: Int): String = "1 hora"
  override fun hours(hours: Int): String = "$hours horas"
  override fun aDay(hours: Int): String = "1 dia"
  override fun days(days: Int): String = "$days dias"
  override fun aboutAMonth(days: Int): String = "1 mês"
  override fun months(months: Int): String = "$months meses"
  override fun aboutAYear(year: Int): String = "1 ano"
  override fun years(years: Int): String = "$years anos"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Portuguese-Brazil Short Messages.
 * @since 1.1.0
 */
internal object PtBrShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "agora"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1h"
  override fun hours(hours: Int): String = "$hours h"
  override fun aDay(hours: Int): String = "~1 dia"
  override fun days(days: Int): String = "$days dias"
  override fun aboutAMonth(days: Int): String = "~1 mês"
  override fun months(months: Int): String = "$months meses"
  override fun aboutAYear(year: Int): String = "~1 ano"
  override fun years(years: Int): String = "$years anos"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
