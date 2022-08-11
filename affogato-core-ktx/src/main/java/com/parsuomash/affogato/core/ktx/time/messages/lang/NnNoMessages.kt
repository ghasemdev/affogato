package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Norwegian-Nynorsk-Norway Messages.
 * @since 1.1.0
 */
internal object NnNoMessages : LookupMessages {
  override fun suffixAgo(): String = "sidan"
  override fun suffixFromNow(): String = "frå no"
  override fun lessThanOneMinute(seconds: Int): String = "eit augeblink"
  override fun aboutAMinute(minutes: Int): String = "eit minutt"
  override fun minutes(minutes: Int): String = "$minutes minutt"
  override fun aboutAnHour(minutes: Int): String = "rundt ein time"
  override fun hours(hours: Int): String = "$hours timer"
  override fun aDay(hours: Int): String = "ein dag"
  override fun days(days: Int): String = "$days dagar"
  override fun aboutAMonth(days: Int): String = "omtrent ein månad"
  override fun months(months: Int): String = "$months månadar"
  override fun aboutAYear(year: Int): String = "omtrent eit år"
  override fun years(years: Int): String = "$years år"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Norwegian-Nynorsk-Norway Short Messages.
 * @since 1.1.0
 */
internal object NnNoShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "no"
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
