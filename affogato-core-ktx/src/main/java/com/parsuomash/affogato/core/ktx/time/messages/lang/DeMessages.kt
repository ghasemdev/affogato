package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * German Messages.
 * @since 1.1.0
 */
internal object DeMessages : LookupMessages {
  override fun prefixAgo(): String = "vor"
  override fun prefixFromNow(): String = "in"
  override fun lessThanOneMinute(seconds: Int): String = "weniger als einer Minute"
  override fun aboutAMinute(minutes: Int): String = "einer Minute"
  override fun minutes(minutes: Int): String = "$minutes Minuten"
  override fun aboutAnHour(minutes: Int): String = "~1 Stunde"
  override fun hours(hours: Int): String = "$hours Stunden"
  override fun aDay(hours: Int): String = "~1 Tag"
  override fun days(days: Int): String = "$days Tagen"
  override fun aboutAMonth(days: Int): String = "~1 Monat"
  override fun months(months: Int): String = "$months Monaten"
  override fun aboutAYear(year: Int): String = "~1 Jahr"
  override fun years(years: Int): String = "$years Jahren"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * German Short Messages.
 * @since 1.1.0
 */
internal object DeShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "Jetzt"
  override fun aboutAMinute(minutes: Int): String = "1 Min."
  override fun minutes(minutes: Int): String = "$minutes Min."
  override fun aboutAnHour(minutes: Int): String = "~1 Std."
  override fun hours(hours: Int): String = "$hours Std."
  override fun aDay(hours: Int): String = "~1 Tg."
  override fun days(days: Int): String = "$days Tg."
  override fun aboutAMonth(days: Int): String = "~1 Mo."
  override fun months(months: Int): String = "$months Mo."
  override fun aboutAYear(year: Int): String = "~1 Jr."
  override fun years(years: Int): String = "$years Jr."
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
