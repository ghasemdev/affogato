package com.parsuomash.affogato.core.ktx.time.messages

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString

/**
 * English Messages.
 * @since 1.1.0
 */
class EnMessages : LookupMessages {
  override fun suffixAgo(): String = "ago"
  override fun suffixFromNow(): String = "from now"
  override fun lessThanOneMinute(seconds: Int): String = "a moment"
  override fun aboutAMinute(minutes: Int): String = "a minute"
  override fun minutes(minutes: Int): String = "$minutes minutes"
  override fun aboutAnHour(minutes: Int): String = "about an hour"
  override fun hours(hours: Int): String = "$hours hours"
  override fun aDay(hours: Int): String = "a day"
  override fun days(days: Int): String = "$days days"
  override fun aboutAMonth(days: Int): String = "about a month"
  override fun months(months: Int): String = "$months months"
  override fun aboutAYear(year: Int): String = "about a year"
  override fun years(years: Int): String = "$years years"
  override fun onDate(elapsed: Long): String = "on ${elapsed.asDate.toString("MM/dd/yyyy")}"
}

/**
 * English Short Messages.
 * @since 1.1.0
 */
class EnShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "now"
  override fun aboutAMinute(minutes: Int): String = "1m"
  override fun minutes(minutes: Int): String = "${minutes}m"
  override fun aboutAnHour(minutes: Int): String = "~1h"
  override fun hours(hours: Int): String = "${hours}h"
  override fun aDay(hours: Int): String = "~1d"
  override fun days(days: Int): String = "${days}d"
  override fun aboutAMonth(days: Int): String = "~1mo"
  override fun months(months: Int): String = "${months}mo"
  override fun aboutAYear(year: Int): String = "~1y"
  override fun years(years: Int): String = "${years}y"
  override fun onDate(elapsed: Long): String = "on ${elapsed.asDate.toString("MM/dd/yyyy")}"
}
