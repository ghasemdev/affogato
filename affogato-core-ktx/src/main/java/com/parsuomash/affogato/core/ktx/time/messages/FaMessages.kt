package com.parsuomash.affogato.core.ktx.time.messages

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString

/**
 * Persian messages.
 * @since 1.1.0
 */
class FaMessages : LookupMessages {
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
