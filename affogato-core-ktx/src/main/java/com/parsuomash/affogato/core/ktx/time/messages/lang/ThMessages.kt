@file:JvmName("_ThMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.text.NumberConverter
import com.parsuomash.affogato.core.ktx.time.TimeAgo
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
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "เมื่อครู่นี้"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "ประมาณหนึ่งนาที"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${toThai(minutes.toString())} นาที"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "ประมาณหนึ่งชั่วโมง"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${toThai(hours.toString())} ชั่วโมง"

  override fun aDay(hours: Int, dateInMillis: Long): String = "หนึ่งวัน"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${toThai(days.toString())} วัน"

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "ประมาณหนึ่งเดือน"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${toThai(months.toString())} เดือน"

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "ประมาณหนึ่งปี"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${toThai(years.toString())} ปี"
}

/**
 * Thai Short Messages.
 * @since 1.1.0
 */
internal object ThShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "เมื่อครู่"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "${toThai("1")} นาที"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "${toThai(minutes.toString())} นาที"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~${toThai("1")} ชม"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String =
    "${toThai(hours.toString())} ชม"

  override fun aDay(hours: Int, dateInMillis: Long): String = "~${toThai("1")} ว"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String =
    "${toThai(days.toString())} ว"

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~${toThai("1")} ด"
  override fun months(months: Int, days: Int, dateInMillis: Long): String =
    "${toThai(months.toString())} ด"

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~${toThai("1")} ป"
  override fun years(years: Int, months: Int, dateInMillis: Long): String =
    "${toThai(years.toString())} ป"
}

private fun toThai(number: String) =
  if (TimeAgo.isLocaleNumberEnabled) NumberConverter.toThai(number) else number
