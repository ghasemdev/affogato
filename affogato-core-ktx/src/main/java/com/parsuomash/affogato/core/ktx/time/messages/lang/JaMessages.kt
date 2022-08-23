@file:JvmSynthetic

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
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "${seconds}秒"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "約1分"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "${minutes}分"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "約1時間"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "${hours}時間"
  override fun aDay(hours: Int, dateInMillis: Long): String = "1日"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "${days}日"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "約1か月"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "${months}か月"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "約1年"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "${years}年"
}
