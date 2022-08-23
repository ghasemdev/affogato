@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Romanian Messages.
 * @since 1.1.0
 */
internal object RoMessages : LookupMessages {
  override fun prefixAgo(): String = "acum"
  override fun prefixFromNow(): String = "peste"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "o clipită"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "un minut"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minute"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "o oră"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours ore"
  override fun aDay(hours: Int, dateInMillis: Long): String = "o zi"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days zile"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "o luna"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months luni"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "un an"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years ani"
}

/**
 * Romanian Short Messages.
 * @since 1.1.0
 */
internal object RoShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "acum"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 oră"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours ore"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 zi"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days zile"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 luni"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months luni"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 ani"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years ani"
}
