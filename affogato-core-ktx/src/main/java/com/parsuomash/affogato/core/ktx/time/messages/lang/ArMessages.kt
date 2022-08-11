package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Arabic Messages.
 * @since 1.1.0
 */
internal object ArMessages : LookupMessages {
  override fun prefixAgo(): String = "منذ"
  override fun prefixFromNow(): String = "بعد"
  override fun lessThanOneMinute(seconds: Int): String = when (seconds) {
    1 -> "ثانية واحدة"
    2 -> "ثانيتين"
    in 3..10 -> "$seconds ثواني"
    else -> "$seconds ثانية"
  }

  override fun aboutAMinute(minutes: Int): String = "حوالي دقيقة"
  override fun minutes(minutes: Int): String = when (minutes) {
    1 -> "دقيقة واحدة"
    2 -> "دقيقتين"
    in 3..10 -> "$minutes دقائق"
    else -> "$minutes دقيقة"
  }

  override fun aboutAnHour(minutes: Int): String = "حوالي الساعة"
  override fun hours(hours: Int): String = when (hours) {
    1 -> "ساعة"
    2 -> "ساعتين"
    in 3..10 -> "$hours ساعات"
    else -> "$hours ساعة"
  }

  override fun aDay(hours: Int): String = "يوم"
  override fun days(days: Int): String = when (days) {
    1 -> "يوم واحد"
    2 -> "يومين"
    in 3..10 -> "$days ايام"
    else -> "$days يوم"
  }

  override fun aboutAMonth(days: Int): String = "حوالي شهر"
  override fun months(months: Int): String = when {
    months == 1 -> "منذ شهر"
    months == 2 -> "منذ شهرين"
    months in 3..10 -> "$months اشهر"
    months > 10 -> "$months شهر"
    else -> "$months شهور"
  }

  override fun aboutAYear(year: Int): String = "قبل سنة"
  override fun years(years: Int): String = when (years) {
    1 -> "منذ سنة"
    2 -> "منذ سنتين"
    in 3..10 -> "$years سنوات"
    else -> "$years سنة"
  }

  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("yyyy/MM/dd")
}

/**
 * Arabic Short Messages.
 * @since 1.1.0
 */
internal object ArShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "$seconds ثا"
  override fun aboutAMinute(minutes: Int): String = "~1 د"
  override fun minutes(minutes: Int): String = "$minutes د"
  override fun aboutAnHour(minutes: Int): String = "~1 س"
  override fun hours(hours: Int): String = "$hours س"
  override fun aDay(hours: Int): String = "~1 ي"
  override fun days(days: Int): String = "$days ي"
  override fun aboutAMonth(days: Int): String = "~1 ش"
  override fun months(months: Int): String = "$months ش"
  override fun aboutAYear(year: Int): String = "~1 س"
  override fun years(years: Int): String = "$years س"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("yyyy/MM/dd")
}
