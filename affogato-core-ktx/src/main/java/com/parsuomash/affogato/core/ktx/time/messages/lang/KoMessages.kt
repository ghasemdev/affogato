package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Korean Messages.
 * @since 1.1.0
 */
internal object KoMessages : LookupMessages {
  override fun prefixFromNow(): String = "지금부터"
  override fun suffixAgo(): String = "전"
  override fun suffixFromNow(): String = "후"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "$seconds"
  override fun aboutAMinute(minutes: Int, date: Long): String = "약 1분"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "${minutes}분"
  override fun aboutAnHour(minutes: Int, date: Long): String = "약 1시간"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "${hours}시간"
  override fun aDay(hours: Int, date: Long): String = "약 1일"
  override fun days(days: Int, hours: Int, date: Long): String = "${days}일"
  override fun aboutAMonth(days: Int, date: Long): String = "약 1달"
  override fun months(months: Int, days: Int, date: Long): String = "${months}달"
  override fun aboutAYear(year: Int, date: Long): String = "약 1년"
  override fun years(years: Int, months: Int, date: Long): String = "${years}년"
}
