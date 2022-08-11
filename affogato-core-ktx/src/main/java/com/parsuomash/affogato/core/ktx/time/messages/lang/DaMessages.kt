package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Danish Messages.
 * @since 1.1.0
 */
internal object DaMessages : LookupMessages {
  override fun suffixAgo(): String = "siden"
  override fun suffixFromNow(): String = "fra nu"
  override fun lessThanOneMinute(seconds: Int): String = "et øjeblik"
  override fun aboutAMinute(minutes: Int): String = "et minut"
  override fun minutes(minutes: Int): String = "$minutes minutter"
  override fun aboutAnHour(minutes: Int): String = "omkring en time"
  override fun hours(hours: Int): String = "$hours timer"
  override fun aDay(hours: Int): String = "en dag"
  override fun days(days: Int): String = "$days dage"
  override fun aboutAMonth(days: Int): String = "omkring en måned"
  override fun months(months: Int): String = "$months måneder"
  override fun aboutAYear(year: Int): String = "omkring et år"
  override fun years(years: Int): String = "$years år"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Danish Short Messages.
 * @since 1.1.0
 */
internal object DaShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "nu"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 t"
  override fun hours(hours: Int): String = "$hours t"
  override fun aDay(hours: Int): String = "~1 d"
  override fun days(days: Int): String = "$days d"
  override fun aboutAMonth(days: Int): String = "~1 md"
  override fun months(months: Int): String = "$months md"
  override fun aboutAYear(year: Int): String = "~1 år"
  override fun years(years: Int): String = "$years år"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
