@file:JvmSynthetic

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Indonesian Messages.
 * @since 1.1.0
 */
internal object IdMessages : LookupMessages {
  override fun suffixAgo(): String = "yang lalu"
  override fun suffixFromNow(): String = "dari sekarang"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "kurang dari semenit"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "semenit"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes menit"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "sekitar sejam"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours jam"
  override fun aDay(hours: Int, dateInMillis: Long): String = "sehari"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days hari"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "sekitar sebulan"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months bulan"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "sekitar setahun"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years tahun"
}
