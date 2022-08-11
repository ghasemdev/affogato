package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Romanian Messages.
 * @since 1.1.0
 */
internal object RoMessages : LookupMessages {
  override fun prefixAgo(): String = "acum"
  override fun prefixFromNow(): String = "peste"
  override fun lessThanOneMinute(seconds: Int): String = "o clipită"
  override fun aboutAMinute(minutes: Int): String = "un minut"
  override fun minutes(minutes: Int): String = "$minutes minute"
  override fun aboutAnHour(minutes: Int): String = "o oră"
  override fun hours(hours: Int): String = "$hours ore"
  override fun aDay(hours: Int): String = "o zi"
  override fun days(days: Int): String = "$days zile"
  override fun aboutAMonth(days: Int): String = "o luna"
  override fun months(months: Int): String = "$months luni"
  override fun aboutAYear(year: Int): String = "un an"
  override fun years(years: Int): String = "$years ani"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Romanian Short Messages.
 * @since 1.1.0
 */
internal object RoShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "acum"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 oră"
  override fun hours(hours: Int): String = "$hours ore"
  override fun aDay(hours: Int): String = "~1 zi"
  override fun days(days: Int): String = "$days zile"
  override fun aboutAMonth(days: Int): String = "~1 luni"
  override fun months(months: Int): String = "$months luni"
  override fun aboutAYear(year: Int): String = "~1 ani"
  override fun years(years: Int): String = "$years ani"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
