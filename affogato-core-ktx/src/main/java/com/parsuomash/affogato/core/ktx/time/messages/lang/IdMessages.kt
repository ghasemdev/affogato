package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Indonesian Messages.
 * @since 1.1.0
 */
internal object IdMessages : LookupMessages {
  override fun suffixAgo(): String = "yang lalu"
  override fun suffixFromNow(): String = "dari sekarang"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "kurang dari semenit"
  override fun aboutAMinute(minutes: Int, date: Long): String = "semenit"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes menit"
  override fun aboutAnHour(minutes: Int, date: Long): String = "sekitar sejam"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours jam"
  override fun aDay(hours: Int, date: Long): String = "sehari"
  override fun days(days: Int, hours: Int, date: Long): String = "$days hari"
  override fun aboutAMonth(days: Int, date: Long): String = "sekitar sebulan"
  override fun months(months: Int, days: Int, date: Long): String = "$months bulan"
  override fun aboutAYear(year: Int, date: Long): String = "sekitar setahun"
  override fun years(years: Int, months: Int, date: Long): String = "$years tahun"
}
