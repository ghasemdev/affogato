package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Indonesian Messages.
 * @since 1.1.0
 */
internal object IdMessages : LookupMessages {
  override fun suffixAgo(): String = "yang lalu"
  override fun suffixFromNow(): String = "dari sekarang"
  override fun lessThanOneMinute(seconds: Int): String = "kurang dari semenit"
  override fun aboutAMinute(minutes: Int): String = "semenit"
  override fun minutes(minutes: Int): String = "$minutes menit"
  override fun aboutAnHour(minutes: Int): String = "sekitar sejam"
  override fun hours(hours: Int): String = "$hours jam"
  override fun aDay(hours: Int): String = "sehari"
  override fun days(days: Int): String = "$days hari"
  override fun aboutAMonth(days: Int): String = "sekitar sebulan"
  override fun months(months: Int): String = "$months bulan"
  override fun aboutAYear(year: Int): String = "sekitar setahun"
  override fun years(years: Int): String = "$years tahun"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
