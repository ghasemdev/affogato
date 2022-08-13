package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Japanese Messages.
 * @since 1.1.0
 */
internal object JaMessages : LookupMessages {
  override fun prefixFromNow(): String = "今から"
  override fun suffixAgo(): String = "前"
  override fun suffixFromNow(): String = "後"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "${seconds}秒"
  override fun aboutAMinute(minutes: Int, date: Long): String = "約1分"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "${minutes}分"
  override fun aboutAnHour(minutes: Int, date: Long): String = "約1時間"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "${hours}時間"
  override fun aDay(hours: Int, date: Long): String = "1日"
  override fun days(days: Int, hours: Int, date: Long): String = "${days}日"
  override fun aboutAMonth(days: Int, date: Long): String = "約1か月"
  override fun months(months: Int, days: Int, date: Long): String = "${months}か月"
  override fun aboutAYear(year: Int, date: Long): String = "約1年"
  override fun years(years: Int, months: Int, date: Long): String = "${years}年"
}
