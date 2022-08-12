package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Malay-Malaysia Messages.
 * @since 1.1.0
 */
internal object MsMyMessages : LookupMessages {
  override fun suffixAgo(): String = "lepas"
  override fun suffixFromNow(): String = "dari sekarang"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "saat"
  override fun aboutAMinute(minutes: Int, date: Long): String = "seminit"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes minit"
  override fun aboutAnHour(minutes: Int, date: Long): String = "sejam"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours jam"
  override fun aDay(hours: Int, date: Long): String = "sehari"
  override fun days(days: Int, hours: Int, date: Long): String = "$days hari"
  override fun aboutAMonth(days: Int, date: Long): String = "sebulan"
  override fun months(months: Int, days: Int, date: Long): String = "$months bulan"
  override fun aboutAYear(year: Int, date: Long): String = "setahun"
  override fun years(years: Int, months: Int, date: Long): String = "$years tahun"
}

/**
 * Malay-Malaysia Short Messages.
 * @since 1.1.0
 */
internal object MsMyShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "sekarang"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 jam"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours jam"
  override fun aDay(hours: Int, date: Long): String = "~1 hri"
  override fun days(days: Int, hours: Int, date: Long): String = "$days hri"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 bln"
  override fun months(months: Int, days: Int, date: Long): String = "$months bln"
  override fun aboutAYear(year: Int, date: Long): String = "~1 thn"
  override fun years(years: Int, months: Int, date: Long): String = "$years thn"
}
