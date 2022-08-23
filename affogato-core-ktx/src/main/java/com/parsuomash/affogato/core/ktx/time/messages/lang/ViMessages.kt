@file:JvmName("_ViMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Vietnamese Messages.
 * @since 1.1.0
 */
internal object ViMessages : LookupMessages {
  override fun suffixAgo(): String = "trước"
  override fun suffixFromNow(): String = "nữa"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "một phút"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "khoảng một phút"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes phút"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "khoảng 1 tiếng"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours tiếng"
  override fun aDay(hours: Int, dateInMillis: Long): String = "một ngày"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days ngày"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "khoảng 1 tháng"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months tháng"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "khoảng 1 năm"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years năm"
}

/**
 * Vietnamese Short Messages.
 * @since 1.1.0
 */
internal object ViShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "bây giờ"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 ph"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes ph"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 h"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours h"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 ngày"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days ngày"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 tháng"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months tháng"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 năm"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years năm"
}
