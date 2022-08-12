package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Polish Messages.
 * @since 1.1.0
 */
internal object PlMessages : LookupMessages {
  override fun suffixAgo(): String = "temu"
  override fun suffixFromNow(): String = "od tego momentu"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "chwilę"
  override fun aboutAMinute(minutes: Int, date: Long): String = "około minuty"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String =
    pluralize(minutes, "minuty", "minut")

  override fun aboutAnHour(minutes: Int, date: Long): String = "około godziny"
  override fun hours(hours: Int, minutes: Int, date: Long): String =
    pluralize(hours, "godziny", "godzin")

  override fun aDay(hours: Int, date: Long): String = "dzień"
  override fun days(days: Int, hours: Int, date: Long): String = "$days dni"
  override fun aboutAMonth(days: Int, date: Long): String = "około miesiąca"
  override fun months(months: Int, days: Int, date: Long): String =
    pluralize(months, "miesiące", "miesięcy")

  override fun aboutAYear(year: Int, date: Long): String = "około roku"
  override fun years(years: Int, months: Int, date: Long): String = pluralize(years, "lata", "lat")
}

@Suppress("MagicNumber")
private fun pluralize(n: Int, form1: String, form2: String): String {
  // Rules as per https://www.gnu.org/software/gettext/manual/html_node/Plural-forms.html
  return if (n % 10 in 2..4 && (n % 100 < 10 || n % 100 >= 20)) {
    "$n $form1"
  } else {
    "$n $form2"
  }
}
