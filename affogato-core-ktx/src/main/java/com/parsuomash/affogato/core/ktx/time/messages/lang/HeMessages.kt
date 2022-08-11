package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Hebrew Messages.
 * @since 1.1.0
 */
internal object HeMessages : LookupMessages {
  override fun prefixAgo(): String = "לפני"
  override fun prefixFromNow(): String = "בעוד"
  override fun lessThanOneMinute(seconds: Int): String = "כמה רגעים"
  override fun aboutAMinute(minutes: Int): String = "דקה"
  override fun minutes(minutes: Int): String = "$minutes דקות"
  override fun aboutAnHour(minutes: Int): String = "כשעה"
  override fun hours(hours: Int): String = "$hours שעות"
  override fun aDay(hours: Int): String = "יום"
  override fun days(days: Int): String = "$days ימים"
  override fun aboutAMonth(days: Int): String = "כחודש"
  override fun months(months: Int): String = "$months חודשים"
  override fun aboutAYear(year: Int): String = "כשנה"
  override fun years(years: Int): String = "$years שנים"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Hebrew Short Messages.
 * @since 1.1.0
 */
internal object HeShortMessages : LookupMessages {
  override fun prefixFromNow(): String = "בעוד"
  override fun lessThanOneMinute(seconds: Int): String = "כעת"
  override fun aboutAMinute(minutes: Int): String = "דקה"
  override fun minutes(minutes: Int): String = "$minutes דקות"
  override fun aboutAnHour(minutes: Int): String = "כשעה"
  override fun hours(hours: Int): String = "$hours שעות"
  override fun aDay(hours: Int): String = "יום"
  override fun days(days: Int): String = "$days ימים"
  override fun aboutAMonth(days: Int): String = "כחודש"
  override fun months(months: Int): String = "$months חודשים"
  override fun aboutAYear(year: Int): String = "כשנה"
  override fun years(years: Int): String = "$years שנים"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
