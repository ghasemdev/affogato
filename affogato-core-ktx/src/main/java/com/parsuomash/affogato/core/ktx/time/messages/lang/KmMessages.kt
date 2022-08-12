package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Cambodian Messages.
 * @since 1.1.0
 */
internal object KmMessages : LookupMessages {
  override fun prefixAgo(): String = "មុននេះ"
  override fun prefixFromNow(): String = "ក្រោយពីនេះ"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "បន្ដិច"
  override fun aboutAMinute(minutes: Int, date: Long): String = "ប្រមាណមួយនាទី"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = " $minutes នាទី"
  override fun aboutAnHour(minutes: Int, date: Long): String = "ប្រមាណមួយម៉ោង"
  override fun hours(hours: Int, minutes: Int, date: Long): String = " $hours ម៉ោង"
  override fun aDay(hours: Int, date: Long): String = "មួយថ្ងៃ"
  override fun days(days: Int, hours: Int, date: Long): String = " $days ថ្ងៃ"
  override fun aboutAMonth(days: Int, date: Long): String = "ប្រមាណមួយខែ"
  override fun months(months: Int, days: Int, date: Long): String = " $months ខែ"
  override fun aboutAYear(year: Int, date: Long): String = "ប្រមាណមួយឆ្នាំ"
  override fun years(years: Int, months: Int, date: Long): String = " $years ឆ្នាំ"
}

/**
 * Cambodian Short Messages.
 * @since 1.1.0
 */
internal object KmShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "មិញ"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 ន"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes ន"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 ម"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours ម"
  override fun aDay(hours: Int, date: Long): String = "~1 ថ"
  override fun days(days: Int, hours: Int, date: Long): String = "$days ថ"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 ខ"
  override fun months(months: Int, days: Int, date: Long): String = "$months ខ"
  override fun aboutAYear(year: Int, date: Long): String = "~1 ឆ"
  override fun years(years: Int, months: Int, date: Long): String = "$years ឆ"
}
