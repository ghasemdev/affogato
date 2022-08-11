package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Vietnamese Messages.
 * @since 1.1.0
 */
internal object ViMessages : LookupMessages {
  override fun suffixAgo(): String = "trước"
  override fun suffixFromNow(): String = "nữa"
  override fun lessThanOneMinute(seconds: Int): String = "một phút"
  override fun aboutAMinute(minutes: Int): String = "khoảng một phút"
  override fun minutes(minutes: Int): String = "$minutes phút"
  override fun aboutAnHour(minutes: Int): String = "khoảng 1 tiếng"
  override fun hours(hours: Int): String = "$hours tiếng"
  override fun aDay(hours: Int): String = "một ngày"
  override fun days(days: Int): String = "$days ngày"
  override fun aboutAMonth(days: Int): String = "khoảng 1 tháng"
  override fun months(months: Int): String = "$months tháng"
  override fun aboutAYear(year: Int): String = "khoảng 1 năm"
  override fun years(years: Int): String = "$years năm"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Vietnamese Short Messages.
 * @since 1.1.0
 */
internal object ViShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "bây giờ"
  override fun aboutAMinute(minutes: Int): String = "1 ph"
  override fun minutes(minutes: Int): String = "$minutes ph"
  override fun aboutAnHour(minutes: Int): String = "~1 h"
  override fun hours(hours: Int): String = "$hours h"
  override fun aDay(hours: Int): String = "~1 ngày"
  override fun days(days: Int): String = "$days ngày"
  override fun aboutAMonth(days: Int): String = "~1 tháng"
  override fun months(months: Int): String = "$months tháng"
  override fun aboutAYear(year: Int): String = "~1 năm"
  override fun years(years: Int): String = "$years năm"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
