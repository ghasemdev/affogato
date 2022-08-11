package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Polish Messages.
 * @since 1.1.0
 */
internal object PlMessages : LookupMessages {
  override fun suffixAgo(): String = "temu"
  override fun suffixFromNow(): String = "od tego momentu"
  override fun lessThanOneMinute(seconds: Int): String = "chwilę"
  override fun aboutAMinute(minutes: Int): String = "około minuty"
  override fun minutes(minutes: Int): String = pluralize(minutes, "minuty", "minut")
  override fun aboutAnHour(minutes: Int): String = "około godziny"
  override fun hours(hours: Int): String = pluralize(hours, "godziny", "godzin")
  override fun aDay(hours: Int): String = "dzień"
  override fun days(days: Int): String = "$days dni"
  override fun aboutAMonth(days: Int): String = "około miesiąca"
  override fun months(months: Int): String = pluralize(months, "miesiące", "miesięcy")
  override fun aboutAYear(year: Int): String = "około roku"
  override fun years(years: Int): String = pluralize(years, "lata", "lat")
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
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
