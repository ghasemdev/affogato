package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Dutch Messages.
 * @since 1.1.0
 */
internal object NlMessages : LookupMessages {
  override fun prefixFromNow(): String = "over"
  override fun suffixAgo(): String = "geleden"
  override fun lessThanOneMinute(seconds: Int): String = "een moment"
  override fun aboutAMinute(minutes: Int): String = "één minuut"
  override fun minutes(minutes: Int): String = "$minutes minuten"
  override fun aboutAnHour(minutes: Int): String = "ongeveer één uur"
  override fun hours(hours: Int): String = "$hours uur"
  override fun aDay(hours: Int): String = "één dag"
  override fun days(days: Int): String = "$days dagen"
  override fun aboutAMonth(days: Int): String = "ongeveer één maand"
  override fun months(months: Int): String = "$months maanden"
  override fun aboutAYear(year: Int): String = "ongeveer één jaar"
  override fun years(years: Int): String = "$years jaren"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Dutch Short Messages.
 * @since 1.1.0
 */
internal object NlShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "nu"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 u"
  override fun hours(hours: Int): String = "$hours u"
  override fun aDay(hours: Int): String = "~1 d"
  override fun days(days: Int): String = "$days d"
  override fun aboutAMonth(days: Int): String = "~1 ma"
  override fun months(months: Int): String = "$months ma"
  override fun aboutAYear(year: Int): String = "~1 jr"
  override fun years(years: Int): String = "$years jr"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
