package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Kurdish Messages.
 * @since 1.1.0
 */
internal object KuMessages : LookupMessages {
  override fun suffixFromNow(): String = "لە ئێستاوە"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "چەند چرکەیەک لەمەوپێش"
  override fun aboutAMinute(minutes: Int, date: Long): String = "خولەکێک لەمەوپێش"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = if (minutes == 1) {
    "خولەکێک لەمەوپێش"
  } else {
    "$minutes خولەک لەمەوپێش"
  }

  override fun aboutAnHour(minutes: Int, date: Long): String = "کاژێرێک لەمەوپێش"
  override fun hours(hours: Int, minutes: Int, date: Long): String = if (hours == 1) {
    "کاژێرێک لەمەوپێش"
  } else {
    "$hours کاژێر لەمەوپێش"
  }

  override fun aDay(hours: Int, date: Long): String = "ڕۆژێک لەمەوپێش"
  override fun days(days: Int, hours: Int, date: Long): String = if (days == 1) {
    "ڕۆژێک لەمەوپێش"
  } else {
    "$days ڕۆژ لەمەوپێش"
  }

  override fun aboutAMonth(days: Int, date: Long): String = "مانگێک لەمەوپێش"
  override fun months(months: Int, days: Int, date: Long): String = if (months == 1) {
    "مانگێک لەمەوپێش"
  } else {
    "$months مانگ لەمەوپێش"
  }

  override fun aboutAYear(year: Int, date: Long): String = "ساڵێک لەمەوپێش"
  override fun years(years: Int, months: Int, date: Long): String = if (years == 1) {
    "ساڵێک لەمەوپێش"
  } else {
    "$years ساڵ لەمەوپێش"
  }
}

/**
 * Kurdish Short Messages.
 * @since 1.1.0
 */
internal object KuShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "ئێستا"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 خولەک"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "خولەک $minutes"
  override fun aboutAnHour(minutes: Int, date: Long): String = "کاژێر ~1"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "کاژێر $hours"
  override fun aDay(hours: Int, date: Long): String = "~1 ڕۆژ"
  override fun days(days: Int, hours: Int, date: Long): String = "رۆژ $days"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 مانگ"
  override fun months(months: Int, days: Int, date: Long): String = "مانگ $months"
  override fun aboutAYear(year: Int, date: Long): String = "~1 ساڵ"
  override fun years(years: Int, months: Int, date: Long): String = "ساڵ $years "
}
