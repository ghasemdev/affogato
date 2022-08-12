package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Vietnamese Messages.
 * @since 1.1.0
 */
internal object ViMessages : LookupMessages {
  override fun suffixAgo(): String = "trước"
  override fun suffixFromNow(): String = "nữa"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "một phút"
  override fun aboutAMinute(minutes: Int, date: Long): String = "khoảng một phút"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes phút"
  override fun aboutAnHour(minutes: Int, date: Long): String = "khoảng 1 tiếng"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours tiếng"
  override fun aDay(hours: Int, date: Long): String = "một ngày"
  override fun days(days: Int, hours: Int, date: Long): String = "$days ngày"
  override fun aboutAMonth(days: Int, date: Long): String = "khoảng 1 tháng"
  override fun months(months: Int, days: Int, date: Long): String = "$months tháng"
  override fun aboutAYear(year: Int, date: Long): String = "khoảng 1 năm"
  override fun years(years: Int, months: Int, date: Long): String = "$years năm"
}

/**
 * Vietnamese Short Messages.
 * @since 1.1.0
 */
internal object ViShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "bây giờ"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 ph"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes ph"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 h"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours h"
  override fun aDay(hours: Int, date: Long): String = "~1 ngày"
  override fun days(days: Int, hours: Int, date: Long): String = "$days ngày"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 tháng"
  override fun months(months: Int, days: Int, date: Long): String = "$months tháng"
  override fun aboutAYear(year: Int, date: Long): String = "~1 năm"
  override fun years(years: Int, months: Int, date: Long): String = "$years năm"
}
