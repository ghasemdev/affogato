@file:JvmName("_ZhMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Chinese Messages.
 * @since 1.1.0
 */
internal object ZhMessages : LookupMessages {
  override fun suffixAgo(): String = "前"
  override fun suffixFromNow(): String = "後"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "少於一分鐘"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "約1分鐘"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes 分"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "約1小時"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "約 $hours 小時"
  override fun aDay(hours: Int, dateInMillis: Long): String = "約1天"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "約 $days 日"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "約1個月"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "約 $months 月"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "約1年"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "約 $years 年"
}
