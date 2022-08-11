package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Divehi Messages.
 * @since 1.1.0
 */
internal object DvMessages : LookupMessages {
  override fun suffixAgo(): String = "ކުރިން"
  override fun suffixFromNow(): String = "ފަހުން"
  override fun lessThanOneMinute(seconds: Int): String = "ހިނދުކޮޅެއް"
  override fun aboutAMinute(minutes: Int): String = "މިނެޓެއް ހާއިރު"
  override fun minutes(minutes: Int): String = "$minutes މިނެޓު"
  override fun aboutAnHour(minutes: Int): String = "ގަޑިއިރެއް ހާއިރު"
  override fun hours(hours: Int): String = "$hours ގަޑިއިރު"
  override fun aDay(hours: Int): String = "އެއް ދުވަސް"
  override fun days(days: Int): String = "$days ދުވަސް"
  override fun aboutAMonth(days: Int): String = "މަހެއް ހާ ދުވަސް"
  override fun months(months: Int): String = "$months މަސް"
  override fun aboutAYear(year: Int): String = "އަހަރެއް ހާ ދުވަސް"
  override fun years(years: Int): String = "$years އަހަރު"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Divehi Short Messages.
 * @since 1.1.0
 */
internal object DvShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "މިހާރު"
  override fun aboutAMinute(minutes: Int): String = "1 މިނެޓް"
  override fun minutes(minutes: Int): String = "$minutes މިނެޓް"
  override fun aboutAnHour(minutes: Int): String = "~1 ގ"
  override fun hours(hours: Int): String = "$hours ގ"
  override fun aDay(hours: Int): String = "~1 ދުވަސް"
  override fun days(days: Int): String = "$days ދުވަސް"
  override fun aboutAMonth(days: Int): String = "~1 މަސް"
  override fun months(months: Int): String = "$months މަސް"
  override fun aboutAYear(year: Int): String = "~1 އަހަރު"
  override fun years(years: Int): String = "$years އަހަރު"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
