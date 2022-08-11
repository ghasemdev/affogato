package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Thai Messages.
 * @since 1.1.0
 */
internal object ThMessages : LookupMessages {
  override fun prefixAgo(): String = "เมื่อ"
  override fun prefixFromNow(): String = "ใน"
  override fun suffixAgo(): String = "ที่แล้ว"
  override fun suffixFromNow(): String = "จากนี้"
  override fun lessThanOneMinute(seconds: Int): String = "เมื่อครู่นี้"
  override fun aboutAMinute(minutes: Int): String = "ประมาณหนึ่งนาที"
  override fun minutes(minutes: Int): String = "$minutes นาที"
  override fun aboutAnHour(minutes: Int): String = "ประมาณหนึ่งชั่วโมง"
  override fun hours(hours: Int): String = "$hours ชั่วโมง"
  override fun aDay(hours: Int): String = "หนึ่งวัน"
  override fun days(days: Int): String = "$days วัน"
  override fun aboutAMonth(days: Int): String = "ประมาณหนึ่งเดือน"
  override fun months(months: Int): String = "$months เดือน"
  override fun aboutAYear(year: Int): String = "ประมาณหนึ่งปี"
  override fun years(years: Int): String = "$years ปี"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Thai Short Messages.
 * @since 1.1.0
 */
internal object ThShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "เมื่อครู่"
  override fun aboutAMinute(minutes: Int): String = "1 นาที"
  override fun minutes(minutes: Int): String = "$minutes นาที"
  override fun aboutAnHour(minutes: Int): String = "~1 ชม"
  override fun hours(hours: Int): String = "$hours ชม"
  override fun aDay(hours: Int): String = "~1 ว"
  override fun days(days: Int): String = "$days ว"
  override fun aboutAMonth(days: Int): String = "~1 ด"
  override fun months(months: Int): String = "$months ด"
  override fun aboutAYear(year: Int): String = "~1 ป"
  override fun years(years: Int): String = "$years ป"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
