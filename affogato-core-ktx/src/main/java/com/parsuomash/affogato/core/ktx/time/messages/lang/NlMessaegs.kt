package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Dutch Messages.
 * @since 1.1.0
 */
internal object NlMessages : LookupMessages {
  override fun prefixFromNow(): String = "over"
  override fun suffixAgo(): String = "geleden"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "een moment"
  override fun aboutAMinute(minutes: Int, date: Long): String = "één minuut"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minuten"
  override fun aboutAnHour(minutes: Int, date: Long): String = "ongeveer één uur"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours uur"
  override fun aDay(hours: Int, date: Long): String = "één dag"
  override fun days(days: Int, hours: Int, date: Long): String = "$days dagen"
  override fun aboutAMonth(days: Int, date: Long): String = "ongeveer één maand"
  override fun months(months: Int, days: Int, date: Long): String = "$months maanden"
  override fun aboutAYear(year: Int, date: Long): String = "ongeveer één jaar"
  override fun years(years: Int, months: Int, date: Long): String = "$years jaren"
}

/**
 * Dutch Short Messages.
 * @since 1.1.0
 */
internal object NlShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "nu"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 u"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours u"
  override fun aDay(hours: Int, date: Long): String = "~1 d"
  override fun days(days: Int, hours: Int, date: Long): String = "$days d"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 ma"
  override fun months(months: Int, days: Int, date: Long): String = "$months ma"
  override fun aboutAYear(year: Int, date: Long): String = "~1 jr"
  override fun years(years: Int, months: Int, date: Long): String = "$years jr"
}
