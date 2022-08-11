package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Japanese Messages.
 * @since 1.1.0
 */
internal object JaMessages : LookupMessages {
  override fun prefixFromNow(): String = "今から"
  override fun suffixAgo(): String = "前"
  override fun suffixFromNow(): String = "後"
  override fun lessThanOneMinute(seconds: Int): String = "${seconds}秒"
  override fun aboutAMinute(minutes: Int): String = "約1分"
  override fun minutes(minutes: Int): String = "${minutes}分"
  override fun aboutAnHour(minutes: Int): String = "約1時間"
  override fun hours(hours: Int): String = "${hours}時間"
  override fun aDay(hours: Int): String = "1日"
  override fun days(days: Int): String = "${days}日"
  override fun aboutAMonth(days: Int): String = "約1か月"
  override fun months(months: Int): String = "${months}か月"
  override fun aboutAYear(year: Int): String = "約1年"
  override fun years(years: Int): String = "${years}年"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
