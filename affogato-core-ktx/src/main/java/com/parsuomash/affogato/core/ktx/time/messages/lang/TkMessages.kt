package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Turkish Messages.
 * @since 1.1.0
 */
internal object TkMessages : LookupMessages {
  override fun suffixAgo(): String = "öň"
  override fun suffixFromNow(): String = "galdy"
  override fun lessThanOneMinute(seconds: Int): String = "biraz"
  override fun aboutAMinute(minutes: Int): String = "bir minut"
  override fun minutes(minutes: Int): String = "$minutes minut"
  override fun aboutAnHour(minutes: Int): String = "bir sagat"
  override fun hours(hours: Int): String = "$hours sagat"
  override fun aDay(hours: Int): String = "bir gün"
  override fun days(days: Int): String = "$days gün"
  override fun aboutAMonth(days: Int): String = "bir aý"
  override fun months(months: Int): String = "$months aý"
  override fun aboutAYear(year: Int): String = "bir ýyl"
  override fun years(years: Int): String = "$years ýyl"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
