package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Romanian Messages.
 * @since 1.1.0
 */
internal object RoMessages : LookupMessages {
  override fun prefixAgo(): String = "acum"
  override fun prefixFromNow(): String = "peste"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "o clipită"
  override fun aboutAMinute(minutes: Int, date: Long): String = "un minut"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minute"
  override fun aboutAnHour(minutes: Int, date: Long): String = "o oră"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours ore"
  override fun aDay(hours: Int, date: Long): String = "o zi"
  override fun days(days: Int, hours: Int, date: Long): String = "$days zile"
  override fun aboutAMonth(days: Int, date: Long): String = "o luna"
  override fun months(months: Int, days: Int, date: Long): String = "$months luni"
  override fun aboutAYear(year: Int, date: Long): String = "un an"
  override fun years(years: Int, months: Int, date: Long): String = "$years ani"
}

/**
 * Romanian Short Messages.
 * @since 1.1.0
 */
internal object RoShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "acum"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 oră"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours ore"
  override fun aDay(hours: Int, date: Long): String = "~1 zi"
  override fun days(days: Int, hours: Int, date: Long): String = "$days zile"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 luni"
  override fun months(months: Int, days: Int, date: Long): String = "$months luni"
  override fun aboutAYear(year: Int, date: Long): String = "~1 ani"
  override fun years(years: Int, months: Int, date: Long): String = "$years ani"
}
