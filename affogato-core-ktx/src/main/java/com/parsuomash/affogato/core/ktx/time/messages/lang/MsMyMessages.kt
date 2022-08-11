package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Malay-Malaysia Messages.
 * @since 1.1.0
 */
internal object MsMyMessages : LookupMessages {
  override fun suffixAgo(): String = "lepas"
  override fun suffixFromNow(): String = "dari sekarang"
  override fun lessThanOneMinute(seconds: Int): String = "saat"
  override fun aboutAMinute(minutes: Int): String = "seminit"
  override fun minutes(minutes: Int): String = "$minutes minit"
  override fun aboutAnHour(minutes: Int): String = "sejam"
  override fun hours(hours: Int): String = "$hours jam"
  override fun aDay(hours: Int): String = "sehari"
  override fun days(days: Int): String = "$days hari"
  override fun aboutAMonth(days: Int): String = "sebulan"
  override fun months(months: Int): String = "$months bulan"
  override fun aboutAYear(year: Int): String = "setahun"
  override fun years(years: Int): String = "$years tahun"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Malay-Malaysia Short Messages.
 * @since 1.1.0
 */
internal object MsMyShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "sekarang"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min"
  override fun aboutAnHour(minutes: Int): String = "~1 jam"
  override fun hours(hours: Int): String = "$hours jam"
  override fun aDay(hours: Int): String = "~1 hri"
  override fun days(days: Int): String = "$days hri"
  override fun aboutAMonth(days: Int): String = "~1 bln"
  override fun months(months: Int): String = "$months bln"
  override fun aboutAYear(year: Int): String = "~1 thn"
  override fun years(years: Int): String = "$years thn"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
