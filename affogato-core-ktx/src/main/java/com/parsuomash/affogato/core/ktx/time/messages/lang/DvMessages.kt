package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Divehi Messages.
 * @since 1.1.0
 */
internal object DvMessages : LookupMessages {
  override fun suffixAgo(): String = "ކުރިން"
  override fun suffixFromNow(): String = "ފަހުން"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "ހިނދުކޮޅެއް"
  override fun aboutAMinute(minutes: Int, date: Long): String = "މިނެޓެއް ހާއިރު"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes މިނެޓު"
  override fun aboutAnHour(minutes: Int, date: Long): String = "ގަޑިއިރެއް ހާއިރު"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours ގަޑިއިރު"
  override fun aDay(hours: Int, date: Long): String = "އެއް ދުވަސް"
  override fun days(days: Int, hours: Int, date: Long): String = "$days ދުވަސް"
  override fun aboutAMonth(days: Int, date: Long): String = "މަހެއް ހާ ދުވަސް"
  override fun months(months: Int, days: Int, date: Long): String = "$months މަސް"
  override fun aboutAYear(year: Int, date: Long): String = "އަހަރެއް ހާ ދުވަސް"
  override fun years(years: Int, months: Int, date: Long): String = "$years އަހަރު"
}

/**
 * Divehi Short Messages.
 * @since 1.1.0
 */
internal object DvShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "މިހާރު"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 މިނެޓް"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes މިނެޓް"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 ގ"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours ގ"
  override fun aDay(hours: Int, date: Long): String = "~1 ދުވަސް"
  override fun days(days: Int, hours: Int, date: Long): String = "$days ދުވަސް"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 މަސް"
  override fun months(months: Int, days: Int, date: Long): String = "$months މަސް"
  override fun aboutAYear(year: Int, date: Long): String = "~1 އަހަރު"
  override fun years(years: Int, months: Int, date: Long): String = "$years އަހަރު"
}
