package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Czech Messages.
 * @since 1.1.0
 */
internal object CsMessages : LookupMessages {
  override fun prefixAgo(): String = "před"
  override fun suffixFromNow(): String = "od teď"
  override fun lessThanOneMinute(seconds: Int): String = "chvílí"
  override fun aboutAMinute(minutes: Int): String = "minutou"
  override fun minutes(minutes: Int): String = pluralize(minutes, "minutou", "minutami", "minutami")
  override fun aboutAnHour(minutes: Int): String = "hodinou"
  override fun hours(hours: Int): String = pluralize(hours, "hodinou", "hodinami", "hodinami")
  override fun aDay(hours: Int): String = "dnem"
  override fun days(days: Int): String = pluralize(days, "dnem", "dny", "dny")
  override fun aboutAMonth(days: Int): String = "měsícem"
  override fun months(months: Int): String = pluralize(months, "měsícem", "měsíci", "měsíci")
  override fun aboutAYear(year: Int): String = "rokem"
  override fun years(years: Int): String = pluralize(years, "rokem", "roky", "roky")
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Czech Short Messages.
 * @since 1.1.0
 */
internal object CsShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "teď"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 hod"
  override fun hours(hours: Int): String = "$hours hod"
  override fun aDay(hours: Int): String = "~1 den"
  override fun days(days: Int): String = pluralize(days, "den", "dny", "dní")
  override fun aboutAMonth(days: Int): String = "~1 měsíc"
  override fun months(months: Int): String = pluralize(months, "měsíc", "měsíce", "měsíců")
  override fun aboutAYear(year: Int): String = "~1 rok"
  override fun years(years: Int): String = pluralize(years, "rok", "roky", "roků")
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

private fun pluralize(n: Int, form1: String, form2: String, form3: String): String {
  // Rules as per https://www.gnu.org/software/gettext/manual/html_node/Plural-forms.html
  if (n == 1) return "$n $form1"
  return if (n in 2..4) "$n $form2" else "$n $form3"
}
