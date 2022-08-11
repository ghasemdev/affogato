package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Bosnian Messages.
 * @since 1.1.0
 */
internal object BsMessages : LookupMessages {
  override fun prefixAgo(): String = "prije"
  override fun prefixFromNow(): String = "za"
  override fun lessThanOneMinute(seconds: Int): String = "manje od minute"
  override fun aboutAMinute(minutes: Int): String = "prije minute"
  override fun minutes(minutes: Int): String = "$minutes minuta"
  override fun aboutAnHour(minutes: Int): String = "~1 sat"
  override fun hours(hours: Int): String = "$hours sati"
  override fun aDay(hours: Int): String = "~1 dan"
  override fun days(days: Int): String = "$days dana"
  override fun aboutAMonth(days: Int): String = "~1 mjesec"
  override fun months(months: Int): String = "$months mjeseci"
  override fun aboutAYear(year: Int): String = "~1 godina"
  override fun years(years: Int): String = "$years godina"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Bosnian Short Messages.
 * @since 1.1.0
 */
internal object BsShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "upravo sad"
  override fun aboutAMinute(minutes: Int): String = "1 min."
  override fun minutes(minutes: Int): String = "$minutes min."
  override fun aboutAnHour(minutes: Int): String = "~1 h."
  override fun hours(hours: Int): String = "$hours h."
  override fun aDay(hours: Int): String = "~1 d."
  override fun days(days: Int): String = "$days d."
  override fun aboutAMonth(days: Int): String = "~1 m."
  override fun months(months: Int): String = "$months m."
  override fun aboutAYear(year: Int): String = "~1 g."
  override fun years(years: Int): String = "$years g."
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
