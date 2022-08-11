package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Norwegian-Bokm-Norway Messages.
 * @since 1.1.0
 */
internal object NbNoMessages : LookupMessages {
  override fun suffixAgo(): String = "siden"
  override fun suffixFromNow(): String = "fra nå"
  override fun lessThanOneMinute(seconds: Int): String = "ett øyeblikk"
  override fun aboutAMinute(minutes: Int): String = "ett minutt"
  override fun minutes(minutes: Int): String = "$minutes minutter"
  override fun aboutAnHour(minutes: Int): String = "rundt en time"
  override fun hours(hours: Int): String = "$hours timer"
  override fun aDay(hours: Int): String = "en dag"
  override fun days(days: Int): String = "$days dager"
  override fun aboutAMonth(days: Int): String = "omtrent en måned"
  override fun months(months: Int): String = "$months måneder"
  override fun aboutAYear(year: Int): String = "omtrent et år"
  override fun years(years: Int): String = "$years år"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Norwegian-Bokm-Norway Short Messages.
 * @since 1.1.0
 */
internal object NbNoShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "nå"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 t"
  override fun hours(hours: Int): String = "$hours t"
  override fun aDay(hours: Int): String = "~1 d"
  override fun days(days: Int): String = "$days d"
  override fun aboutAMonth(days: Int): String = "~1 mnd"
  override fun months(months: Int): String = "$months mnd"
  override fun aboutAYear(year: Int): String = "~1 år"
  override fun years(years: Int): String = "$years år"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
