package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Korean Messages.
 * @since 1.1.0
 */
internal object KoMessages : LookupMessages {
  override fun prefixFromNow(): String = "지금부터"
  override fun suffixAgo(): String = "전"
  override fun suffixFromNow(): String = "후"
  override fun lessThanOneMinute(seconds: Int): String = "$seconds"
  override fun aboutAMinute(minutes: Int): String = "약 1분"
  override fun minutes(minutes: Int): String = "${minutes}분"
  override fun aboutAnHour(minutes: Int): String = "약 1시간"
  override fun hours(hours: Int): String = "${hours}시간"
  override fun aDay(hours: Int): String = "약 1일"
  override fun days(days: Int): String = "${days}일"
  override fun aboutAMonth(days: Int): String = "약 1달"
  override fun months(months: Int): String = "${months}달"
  override fun aboutAYear(year: Int): String = "약 1년"
  override fun years(years: Int): String = "${years}년"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
