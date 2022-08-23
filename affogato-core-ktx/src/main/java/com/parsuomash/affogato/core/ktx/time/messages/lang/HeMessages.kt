@file:JvmName("_HeMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Hebrew Messages.
 * @since 1.1.0
 */
internal object HeMessages : LookupMessages {
  override fun prefixAgo(): String = "לפני"
  override fun prefixFromNow(): String = "בעוד"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "כמה רגעים"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "דקה"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes דקות"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "כשעה"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours שעות"
  override fun aDay(hours: Int, dateInMillis: Long): String = "יום"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days ימים"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "כחודש"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months חודשים"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "כשנה"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years שנים"
}

/**
 * Hebrew Short Messages.
 * @since 1.1.0
 */
internal object HeShortMessages : LookupMessages {
  override fun prefixFromNow(): String = "בעוד"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "כעת"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "דקה"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes דקות"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "כשעה"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours שעות"
  override fun aDay(hours: Int, dateInMillis: Long): String = "יום"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days ימים"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "כחודש"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months חודשים"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "כשנה"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years שנים"
}
