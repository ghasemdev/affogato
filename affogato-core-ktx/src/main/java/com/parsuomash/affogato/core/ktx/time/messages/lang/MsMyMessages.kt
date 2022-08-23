@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Malay-Malaysia Messages.
 * @since 1.1.0
 */
internal object MsMyMessages : LookupMessages {
  override fun suffixAgo(): String = "lepas"
  override fun suffixFromNow(): String = "dari sekarang"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "saat"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "seminit"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes minit"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "sejam"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours jam"
  override fun aDay(hours: Int, dateInMillis: Long): String = "sehari"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days hari"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "sebulan"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months bulan"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "setahun"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years tahun"
}

/**
 * Malay-Malaysia Short Messages.
 * @since 1.1.0
 */
internal object MsMyShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "sekarang"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes min"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 jam"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours jam"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 hri"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days hri"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 bln"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months bln"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 thn"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years thn"
}
