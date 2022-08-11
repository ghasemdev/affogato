package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Kurdish Messages.
 * @since 1.1.0
 */
internal object KuMessages : LookupMessages {
  override fun suffixFromNow(): String = "لە ئێستاوە"
  override fun lessThanOneMinute(seconds: Int): String = "چەند چرکەیەک لەمەوپێش"
  override fun aboutAMinute(minutes: Int): String = "خولەکێک لەمەوپێش"
  override fun minutes(minutes: Int): String = if (minutes == 1) {
    "خولەکێک لەمەوپێش"
  } else {
    "$minutes خولەک لەمەوپێش"
  }

  override fun aboutAnHour(minutes: Int): String = "کاژێرێک لەمەوپێش"
  override fun hours(hours: Int): String = if (hours == 1) {
    "کاژێرێک لەمەوپێش"
  } else {
    "$hours کاژێر لەمەوپێش"
  }

  override fun aDay(hours: Int): String = "ڕۆژێک لەمەوپێش"
  override fun days(days: Int): String = if (days == 1) {
    "ڕۆژێک لەمەوپێش"
  } else {
    "$days ڕۆژ لەمەوپێش"
  }

  override fun aboutAMonth(days: Int): String = "مانگێک لەمەوپێش"
  override fun months(months: Int): String = if (months == 1) {
    "مانگێک لەمەوپێش"
  } else {
    "$months مانگ لەمەوپێش"
  }

  override fun aboutAYear(year: Int): String = "ساڵێک لەمەوپێش"
  override fun years(years: Int): String = if (years == 1) {
    "ساڵێک لەمەوپێش"
  } else {
    "$years ساڵ لەمەوپێش"
  }

  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Kurdish Short Messages.
 * @since 1.1.0
 */
internal object KuShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "ئێستا"
  override fun aboutAMinute(minutes: Int): String = "1 خولەک"
  override fun minutes(minutes: Int): String = "خولەک $minutes"
  override fun aboutAnHour(minutes: Int): String = "کاژێر ~1"
  override fun hours(hours: Int): String = "کاژێر $hours"
  override fun aDay(hours: Int): String = "~1 ڕۆژ"
  override fun days(days: Int): String = "رۆژ $days"
  override fun aboutAMonth(days: Int): String = "~1 مانگ"
  override fun months(months: Int): String = "مانگ $months"
  override fun aboutAYear(year: Int): String = "~1 ساڵ"
  override fun years(years: Int): String = "ساڵ $years "
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
