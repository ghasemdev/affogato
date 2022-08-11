package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Russian Messages.
 * @since 1.1.0
 */
internal object RuMessages : LookupMessages {
  override fun prefixFromNow(): String = "через"
  override fun suffixAgo(): String = "назад"
  override fun lessThanOneMinute(seconds: Int): String = "минуту"
  override fun aboutAMinute(minutes: Int): String = "минуту"
  override fun minutes(minutes: Int): String = "$minutes ${convert(minutes, " minutes ")}"
  override fun aboutAnHour(minutes: Int): String = "час"
  override fun hours(hours: Int): String = "$hours ${convert(hours, " hours ")}"
  override fun aDay(hours: Int): String = "день"
  override fun days(days: Int): String = "$days ${convert(days, " days ")}"
  override fun aboutAMonth(days: Int): String = "месяц"
  override fun months(months: Int): String = "$months ${convert(months, " months ")}"
  override fun aboutAYear(year: Int): String = "год"
  override fun years(years: Int): String = "$years ${convert(years, " years ")}"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Russian Short Messages.
 * @since 1.1.0
 */
internal object RuShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "только что"
  override fun aboutAMinute(minutes: Int): String = "1 мин."
  override fun minutes(minutes: Int): String = "$minutes мин."
  override fun aboutAnHour(minutes: Int): String = "~1 ч."
  override fun hours(hours: Int): String = "$hours ч."
  override fun aDay(hours: Int): String = "~1 д."
  override fun days(days: Int): String = "$days д."
  override fun aboutAMonth(days: Int): String = "~1 мес."
  override fun months(months: Int): String = "$months мес."
  override fun aboutAYear(year: Int): String = "~1 г."
  override fun years(years: Int): String = "$years г."
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
      "minutes" -> "минут"
      "hours" -> "часов"
      "days" -> "дней"
      "months" -> "месяцев"
      "years" -> "лет"
      else -> ""
    }
  }
}

private fun modIn234ModHNeq121314(type: String): String = when (type) {
  "minutes" -> "минуты"
  "hours" -> "часа"
  "days" -> "дня"
  "months" -> "месяца"
  "years" -> "года"
  else -> ""
}

private fun mod1ModHNEq11(type: String): String = when (type) {
  "minutes" -> "минуту"
  "hours" -> "час"
  "days" -> "день"
  "months" -> "месяц"
  "years" -> "год"
  else -> ""
}
