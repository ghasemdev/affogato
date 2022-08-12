package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Russian Messages.
 * @since 1.1.0
 */
internal object RuMessages : LookupMessages {
  override fun prefixFromNow(): String = "через"
  override fun suffixAgo(): String = "назад"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "минуту"
  override fun aboutAMinute(minutes: Int, date: Long): String = "минуту"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String =
    "$minutes ${convert(minutes, " minutes ")}"

  override fun aboutAnHour(minutes: Int, date: Long): String = "час"
  override fun hours(hours: Int, minutes: Int, date: Long): String =
    "$hours ${convert(hours, " hours ")}"

  override fun aDay(hours: Int, date: Long): String = "день"
  override fun days(days: Int, hours: Int, date: Long): String = "$days ${convert(days, " days ")}"
  override fun aboutAMonth(days: Int, date: Long): String = "месяц"
  override fun months(months: Int, days: Int, date: Long): String =
    "$months ${convert(months, " months ")}"

  override fun aboutAYear(year: Int, date: Long): String = "год"
  override fun years(years: Int, months: Int, date: Long): String =
    "$years ${convert(years, " years ")}"
}

/**
 * Russian Short Messages.
 * @since 1.1.0
 */
internal object RuShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "только что"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 мин."
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes мин."
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 ч."
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours ч."
  override fun aDay(hours: Int, date: Long): String = "~1 д."
  override fun days(days: Int, hours: Int, date: Long): String = "$days д."
  override fun aboutAMonth(days: Int, date: Long): String = "~1 мес."
  override fun months(months: Int, days: Int, date: Long): String = "$months мес."
  override fun aboutAYear(year: Int, date: Long): String = "~1 г."
  override fun years(years: Int, months: Int, date: Long): String = "$years г."
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
