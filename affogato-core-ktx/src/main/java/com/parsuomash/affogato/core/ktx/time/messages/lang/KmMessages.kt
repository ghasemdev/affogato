package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Cambodian Messages.
 * @since 1.1.0
 */
internal object KmMessages : LookupMessages {
  override fun prefixAgo(): String = "មុននេះ"
  override fun prefixFromNow(): String = "ក្រោយពីនេះ"
  override fun lessThanOneMinute(seconds: Int): String = "បន្ដិច"
  override fun aboutAMinute(minutes: Int): String = "ប្រមាណមួយនាទី"
  override fun minutes(minutes: Int): String = " $minutes នាទី"
  override fun aboutAnHour(minutes: Int): String = "ប្រមាណមួយម៉ោង"
  override fun hours(hours: Int): String = " $hours ម៉ោង"
  override fun aDay(hours: Int): String = "មួយថ្ងៃ"
  override fun days(days: Int): String = " $days ថ្ងៃ"
  override fun aboutAMonth(days: Int): String = "ប្រមាណមួយខែ"
  override fun months(months: Int): String = " $months ខែ"
  override fun aboutAYear(year: Int): String = "ប្រមាណមួយឆ្នាំ"
  override fun years(years: Int): String = " $years ឆ្នាំ"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Cambodian Short Messages.
 * @since 1.1.0
 */
internal object KmShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "មិញ"
  override fun aboutAMinute(minutes: Int): String = "1 ន"
  override fun minutes(minutes: Int): String = "$minutes ន"
  override fun aboutAnHour(minutes: Int): String = "~1 ម"
  override fun hours(hours: Int): String = "$hours ម"
  override fun aDay(hours: Int): String = "~1 ថ"
  override fun days(days: Int): String = "$days ថ"
  override fun aboutAMonth(days: Int): String = "~1 ខ"
  override fun months(months: Int): String = "$months ខ"
  override fun aboutAYear(year: Int): String = "~1 ឆ"
  override fun years(years: Int): String = "$years ឆ"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
