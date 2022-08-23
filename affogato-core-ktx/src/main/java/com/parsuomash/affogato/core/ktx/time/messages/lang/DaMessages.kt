package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Danish Messages.
 * @since 1.1.0
 */
internal object DaMessages : LookupMessages {
  override fun suffixAgo(): String = "siden"
  override fun suffixFromNow(): String = "fra nu"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "et øjeblik"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "et minut"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minutter"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "omkring en time"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours timer"
  override fun aDay(hours: Int, dateInMillis: Long): String = "en dag"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days dage"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "omkring en måned"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months måneder"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "omkring et år"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years år"
}

/**
 * Danish Short Messages.
 * @since 1.1.0
 */
internal object DaShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "nu"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 t"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours t"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 d"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days d"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 md"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months md"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 år"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years år"
}
