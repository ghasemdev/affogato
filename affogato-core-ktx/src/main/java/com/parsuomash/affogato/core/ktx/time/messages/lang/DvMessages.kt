package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Divehi Messages.
 * @since 1.1.0
 */
internal object DvMessages : LookupMessages {
  override fun suffixAgo(): String = "ކުރިން"
  override fun suffixFromNow(): String = "ފަހުން"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "ހިނދުކޮޅެއް"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "މިނެޓެއް ހާއިރު"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes މިނެޓު"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "ގަޑިއިރެއް ހާއިރު"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours ގަޑިއިރު"
  override fun aDay(hours: Int, dateInMillis: Long): String = "އެއް ދުވަސް"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days ދުވަސް"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "މަހެއް ހާ ދުވަސް"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months މަސް"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "އަހަރެއް ހާ ދުވަސް"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years އަހަރު"
}

/**
 * Divehi Short Messages.
 * @since 1.1.0
 */
internal object DvShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "މިހާރު"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 މިނެޓް"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes މިނެޓް"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 ގ"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours ގ"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 ދުވަސް"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days ދުވަސް"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 މަސް"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months މަސް"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 އަހަރު"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years އަހަރު"
}
