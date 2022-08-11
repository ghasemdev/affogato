package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Farsi messages.
 * @since 1.1.0
 */
internal object FaMessages : LookupMessages {
  override fun suffixAgo(): String = "پیش"
  override fun suffixFromNow(): String = "بعد"
  override fun lessThanOneMinute(seconds: Int): String = "چند لحظه"
  override fun aboutAMinute(minutes: Int): String = "یک دقیقه"
  override fun minutes(minutes: Int): String = "$minutes دقیقه"
  override fun aboutAnHour(minutes: Int): String = "یک ساعت"
  override fun hours(hours: Int): String = "$hours ساعت"
  override fun aDay(hours: Int): String = "یک روز"
  override fun days(days: Int): String = "$days روز"
  override fun aboutAMonth(days: Int): String = "یک ماه"
  override fun months(months: Int): String = "$months ماه"
  override fun aboutAYear(year: Int): String = "یک سال"
  override fun years(years: Int): String = "$years سال"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("yyyy/MM/dd")
}

/**
 * Farsi Short Messages.
 * @since 1.1.0
 */
internal object FaShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "الان"
  override fun aboutAMinute(minutes: Int): String = "~1 د"
  override fun minutes(minutes: Int): String = "$minutes د"
  override fun aboutAnHour(minutes: Int): String = "~1 س"
  override fun hours(hours: Int): String = "$hours س"
  override fun aDay(hours: Int): String = "~1 ر"
  override fun days(days: Int): String = "$days ر"
  override fun aboutAMonth(days: Int): String = "~1 م"
  override fun months(months: Int): String = "$months م"
  override fun aboutAYear(year: Int): String = "~1 س"
  override fun years(years: Int): String = "$years س"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("yyyy/MM/dd")
}
