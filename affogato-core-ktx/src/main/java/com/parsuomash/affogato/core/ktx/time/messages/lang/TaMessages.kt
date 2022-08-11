package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Tamil Messages.
 * @since 1.1.0
 */
internal object TaMessages : LookupMessages {
  override fun suffixAgo(): String = "முன்னர்"
  override fun suffixFromNow(): String = "கழித்து"
  override fun lessThanOneMinute(seconds: Int): String = "சில நொடிகள்"
  override fun aboutAMinute(minutes: Int): String = "ஒரு நிமிடம்"
  override fun minutes(minutes: Int): String = "$minutes நிமிடங்கள்"
  override fun aboutAnHour(minutes: Int): String = "ஓர் மணி நேரம்"
  override fun hours(hours: Int): String = "$hours மணி நேரங்கள்"
  override fun aDay(hours: Int): String = "ஓர் நாள்"
  override fun days(days: Int): String = "$days நாட்கள்"
  override fun aboutAMonth(days: Int): String = "ஓர் மாதம்"
  override fun months(months: Int): String = "$months மாதங்கள்"
  override fun aboutAYear(year: Int): String = "ஓராண்டு"
  override fun years(years: Int): String = "$years ஆண்டுகள்"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
