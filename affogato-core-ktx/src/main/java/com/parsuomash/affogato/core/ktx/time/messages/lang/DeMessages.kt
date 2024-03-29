package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * German Messages.
 * @since 1.1.0
 */
internal object DeMessages : LookupMessages {
  override fun prefixAgo(): String = "vor"
  override fun prefixFromNow(): String = "in"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String =
    "weniger als einer Minute"

  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "einer Minute"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes Minuten"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 Stunde"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours Stunden"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 Tag"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days Tagen"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 Monat"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months Monaten"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 Jahr"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years Jahren"
}

/**
 * German Short Messages.
 * @since 1.1.0
 */
internal object DeShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "Jetzt"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 Min."
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes Min."
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 Std."
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours Std."
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 Tg."
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days Tg."
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 Mo."
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months Mo."
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 Jr."
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years Jr."
}
