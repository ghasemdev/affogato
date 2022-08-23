@file:JvmSynthetic

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
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "$seconds"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "약 1분"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "${minutes}분"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "약 1시간"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "${hours}시간"
  override fun aDay(hours: Int, dateInMillis: Long): String = "약 1일"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "${days}일"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "약 1달"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "${months}달"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "약 1년"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "${years}년"
}
