package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Ukrainian Messages.
 * @since 1.1.0
 */
internal object UkMessages : LookupMessages {
  override fun prefixFromNow(): String = "через"
  override fun suffixAgo(): String = "тому"
  override fun lessThanOneMinute(seconds: Int): String = "хвилину"
  override fun aboutAMinute(minutes: Int): String = "хвилину"
  override fun minutes(minutes: Int): String = "$minutes ${convert(minutes, " minutes ")}"
  override fun aboutAnHour(minutes: Int): String = "годину"
  override fun hours(hours: Int): String = "$hours ${convert(hours, " hours ")}"
  override fun aDay(hours: Int): String = "день"
  override fun days(days: Int): String = "$days ${convert(days, " days ")}"
  override fun aboutAMonth(days: Int): String = "місяць"
  override fun months(months: Int): String = "$months ${convert(months, " months ")}"
  override fun aboutAYear(year: Int): String = "рік"
  override fun years(years: Int): String = "$years ${convert(years, " years ")}"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Ukrainian Short Messages.
 * @since 1.1.0
 */
internal object UkShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "тільки що"
  override fun aboutAMinute(minutes: Int): String = "~1 хв."
  override fun minutes(minutes: Int): String = "$minutes хв."
  override fun aboutAnHour(minutes: Int): String = "~1 год."
  override fun hours(hours: Int): String = "$hours год."
  override fun aDay(hours: Int): String = "~1 д."
  override fun days(days: Int): String = "$days д."
  override fun aboutAMonth(days: Int): String = "~1 міс."
  override fun months(months: Int): String = "$months міс."
  override fun aboutAYear(year: Int): String = "~1 р."
  override fun years(years: Int): String = "$years р."
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

@Suppress("MagicNumber")
private fun convert(number: Int, type: String): String {
  val mod = number % 10
  val modH = number % 100

  return if (mod == 1 && modH != 11) {
    mod1ModHNEq11(type)
  } else if (intArrayOf(2, 3, 4).contains(mod) && !intArrayOf(12, 13, 14).contains(modH)) {
    modIn234ModHNeq121314(type)
  } else {
    when (type) {
      "minutes" -> "хвилин"
      "hours" -> "годин"
      "days" -> "днів"
      "months" -> "місяців"
      "years" -> "років"
      else -> ""
    }
  }
}

private fun modIn234ModHNeq121314(type: String): String = when (type) {
  "minutes" -> "хвилини"
  "hours" -> "години"
  "days" -> "дні"
  "months" -> "місяця"
  "years" -> "роки"
  else -> ""
}

private fun mod1ModHNEq11(type: String): String = when (type) {
  "minutes" -> "хвилину"
  "hours" -> "годину"
  "days" -> "день"
  "months" -> "місяць"
  "years" -> "рік"
  else -> ""
}
