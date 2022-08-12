package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Hebrew Messages.
 * @since 1.1.0
 */
internal object HeMessages : LookupMessages {
  override fun prefixAgo(): String = "לפני"
  override fun prefixFromNow(): String = "בעוד"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "כמה רגעים"
  override fun aboutAMinute(minutes: Int, date: Long): String = "דקה"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes דקות"
  override fun aboutAnHour(minutes: Int, date: Long): String = "כשעה"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours שעות"
  override fun aDay(hours: Int, date: Long): String = "יום"
  override fun days(days: Int, hours: Int, date: Long): String = "$days ימים"
  override fun aboutAMonth(days: Int, date: Long): String = "כחודש"
  override fun months(months: Int, days: Int, date: Long): String = "$months חודשים"
  override fun aboutAYear(year: Int, date: Long): String = "כשנה"
  override fun years(years: Int, months: Int, date: Long): String = "$years שנים"
}

/**
 * Hebrew Short Messages.
 * @since 1.1.0
 */
internal object HeShortMessages : LookupMessages {
  override fun prefixFromNow(): String = "בעוד"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "כעת"
  override fun aboutAMinute(minutes: Int, date: Long): String = "דקה"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes דקות"
  override fun aboutAnHour(minutes: Int, date: Long): String = "כשעה"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours שעות"
  override fun aDay(hours: Int, date: Long): String = "יום"
  override fun days(days: Int, hours: Int, date: Long): String = "$days ימים"
  override fun aboutAMonth(days: Int, date: Long): String = "כחודש"
  override fun months(months: Int, days: Int, date: Long): String = "$months חודשים"
  override fun aboutAYear(year: Int, date: Long): String = "כשנה"
  override fun years(years: Int, months: Int, date: Long): String = "$years שנים"
}
