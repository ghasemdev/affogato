package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.text.NumberConverter
import com.parsuomash.affogato.core.ktx.time.TimeAgo
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Tamil Messages.
 * @since 1.1.0
 */
internal object TaMessages : LookupMessages {
  override fun suffixAgo(): String = "முன்னர்"
  override fun suffixFromNow(): String = "கழித்து"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "சில நொடிகள்"
  override fun aboutAMinute(minutes: Int, date: Long): String = "ஒரு நிமிடம்"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String =
    "${toTamil(minutes.toString())} நிமிடங்கள்"

  override fun aboutAnHour(minutes: Int, date: Long): String = "ஓர் மணி நேரம்"
  override fun hours(hours: Int, minutes: Int, date: Long): String =
    "${toTamil(hours.toString())} மணி நேரங்கள்"

  override fun aDay(hours: Int, date: Long): String = "ஓர் நாள்"
  override fun days(days: Int, hours: Int, date: Long): String =
    "${toTamil(days.toString())} நாட்கள்"

  override fun aboutAMonth(days: Int, date: Long): String = "ஓர் மாதம்"
  override fun months(months: Int, days: Int, date: Long): String =
    "${toTamil(months.toString())} மாதங்கள்"

  override fun aboutAYear(year: Int, date: Long): String = "ஓராண்டு"
  override fun years(years: Int, months: Int, date: Long): String =
    "${toTamil(years.toString())} ஆண்டுகள்"
}

private fun toTamil(number: String) =
  if (TimeAgo.isLocaleNumberEnabled) NumberConverter.toTamil(number) else number
