package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Turkish Messages.
 * @since 1.1.0
 */
internal object TrMessages : LookupMessages {
  override fun suffixAgo(): String = "önce"
  override fun suffixFromNow(): String = "kaldı"
  override fun lessThanOneMinute(seconds: Int): String = "biraz"
  override fun aboutAMinute(minutes: Int): String = "bir dakika"
  override fun minutes(minutes: Int): String = "$minutes dakika"
  override fun aboutAnHour(minutes: Int): String = "bir saat"
  override fun hours(hours: Int): String = "$hours saat"
  override fun aDay(hours: Int): String = "bir gün"
  override fun days(days: Int): String = "$days gün"
  override fun aboutAMonth(days: Int): String = "bir ay"
  override fun months(months: Int): String = "$months ay"
  override fun aboutAYear(year: Int): String = "bir yıl"
  override fun years(years: Int): String = "$years yıl"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
