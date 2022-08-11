package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Mongolian Messages.
 * @since 1.1.0
 */
internal object MnMessages : LookupMessages {
  override fun suffixAgo(): String = "өмнө"
  override fun suffixFromNow(): String = "дараа"
  override fun lessThanOneMinute(seconds: Int): String = "хэдхэн мөчийн"
  override fun aboutAMinute(minutes: Int): String = "минутын"
  override fun minutes(minutes: Int): String = "$minutes минутын"
  override fun aboutAnHour(minutes: Int): String = "цаг орчим"
  override fun hours(hours: Int): String = "$hours цагийн"
  override fun aDay(hours: Int): String = "өдрийн"
  override fun days(days: Int): String = "$days өдрийн"
  override fun aboutAMonth(days: Int): String = "сар орчмын"
  override fun months(months: Int): String = "$months сарын"
  override fun aboutAYear(year: Int): String = "жил орчмын"
  override fun years(years: Int): String = "$years жилийн"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Mongolian Short Messages.
 * @since 1.1.0
 */
internal object MnShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "саяхан"
  override fun aboutAMinute(minutes: Int): String = "1 мин"
  override fun minutes(minutes: Int): String = "$minutes мин"
  override fun aboutAnHour(minutes: Int): String = "~1 ц"
  override fun hours(hours: Int): String = "$hours ц"
  override fun aDay(hours: Int): String = "~1 ө"
  override fun days(days: Int): String = "$days ө"
  override fun aboutAMonth(days: Int): String = "~1 с"
  override fun months(months: Int): String = "$months с"
  override fun aboutAYear(year: Int): String = "~1 ж"
  override fun years(years: Int): String = "$years ж"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
