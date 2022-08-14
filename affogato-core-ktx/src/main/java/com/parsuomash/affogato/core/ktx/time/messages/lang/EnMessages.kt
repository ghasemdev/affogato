package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * English Messages.
 * @since 1.1.0
 */
internal object EnMessages : LookupMessages {
  override fun suffixAgo(): String = "ago"
  override fun suffixFromNow(): String = "from now"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "a moment"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "a minute"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minutes"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "about an hour"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours hours"
  override fun aDay(hours: Int, dateInMillis: Long): String = "a day"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days days"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "about a month"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months months"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "about a year"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years years"
}

/**
 * English Short Messages.
 * @since 1.1.0
 */
internal object EnShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "now"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1m"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "${minutes}m"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1h"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "${hours}h"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1d"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "${days}d"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1mo"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "${months}mo"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1y"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "${years}y"
}

/**
 * English Short Detail Messages.
 * @since 1.1.0
 */
internal object EnShortDetailMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "now"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1m"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${minutes}m ${seconds}s".replace(" 0s", "")

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1h"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${hours}h ${minutes}m".replace(" 0m", "")

  override fun aDay(hours: Int, dateInMillis: Long): String = "~1d"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${days}d ${hours}h".replace(" 0h", "")

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1mo"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${months}mo ${days}d".replace(" 0d", "")

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1y"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${years}y ${months}m".replace(" 0m", "")
}

/**
 * English Detail Messages.
 * @since 1.1.0
 */
internal object EnDetailMessage : LookupMessages {
  override fun suffixAgo(): String = "ago"
  override fun suffixFromNow(): String = "from now"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "a moment"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "a minute"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minutes"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "about an hour"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours hours"
  override fun aDay(hours: Int, dateInMillis: Long): String = "a day"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days days"
}
