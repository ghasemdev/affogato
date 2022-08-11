package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Chinese-China Messages.
 * @since 1.1.0
 */
internal object ZhCnMessages : LookupMessages {
  override fun suffixAgo(): String = "前"
  override fun suffixFromNow(): String = "后"
  override fun lessThanOneMinute(seconds: Int): String = "少于一分钟"
  override fun aboutAMinute(minutes: Int): String = "约1分钟"
  override fun minutes(minutes: Int): String = "$minutes 分"
  override fun aboutAnHour(minutes: Int): String = "约1小时"
  override fun hours(hours: Int): String = "约 $hours 小时"
  override fun aDay(hours: Int): String = "约1天"
  override fun days(days: Int): String = "约 $days 日"
  override fun aboutAMonth(days: Int): String = "约1个月"
  override fun months(months: Int): String = "约 $months 月"
  override fun aboutAYear(year: Int): String = "约1年"
  override fun years(years: Int): String = "约 $years 年"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
