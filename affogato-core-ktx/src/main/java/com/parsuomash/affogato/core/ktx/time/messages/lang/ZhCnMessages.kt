@file:JvmName("_ZhCnMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Chinese-China Messages.
 * @since 1.1.0
 */
internal object ZhCnMessages : LookupMessages {
  override fun suffixAgo(): String = "前"
  override fun suffixFromNow(): String = "后"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "少于一分钟"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "约1分钟"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes 分"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "约1小时"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "约 $hours 小时"
  override fun aDay(hours: Int, dateInMillis: Long): String = "约1天"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "约 $days 日"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "约1个月"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "约 $months 月"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "约1年"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "约 $years 年"
}
