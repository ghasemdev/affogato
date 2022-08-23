package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Cambodian Messages.
 * @since 1.1.0
 */
internal object KmMessages : LookupMessages {
  override fun prefixAgo(): String = "មុននេះ"
  override fun prefixFromNow(): String = "ក្រោយពីនេះ"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "បន្ដិច"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "ប្រមាណមួយនាទី"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = " $minutes នាទី"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "ប្រមាណមួយម៉ោង"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = " $hours ម៉ោង"
  override fun aDay(hours: Int, dateInMillis: Long): String = "មួយថ្ងៃ"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = " $days ថ្ងៃ"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "ប្រមាណមួយខែ"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = " $months ខែ"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "ប្រមាណមួយឆ្នាំ"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = " $years ឆ្នាំ"
}

/**
 * Cambodian Short Messages.
 * @since 1.1.0
 */
internal object KmShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "មិញ"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 ន"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes ន"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 ម"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours ម"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 ថ"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days ថ"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 ខ"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months ខ"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 ឆ"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years ឆ"
}
