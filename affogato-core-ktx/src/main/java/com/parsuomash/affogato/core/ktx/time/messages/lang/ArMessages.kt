package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.text.NumberConverter
import com.parsuomash.affogato.core.ktx.time.TimeAgo
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Arabic Messages.
 * @since 1.1.0
 */
internal object ArMessages : LookupMessages {
  override fun prefixAgo(): String = "منذ"
  override fun prefixFromNow(): String = "بعد"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = when (seconds) {
    1 -> "ثانية واحدة"
    2 -> "ثانيتين"
    in 3..10 -> "${toArabic(seconds.toString())} ثواني"
    else -> "${toArabic(seconds.toString())} ثانية"
  }

  override fun aboutAMinute(minutes: Int, date: Long): String = "دقيقة تقريباً"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = when (minutes) {
    2 -> "دقيقتين"
    in 3..10 -> "${toArabic(minutes.toString())} دقائق"
    else -> "${toArabic(minutes.toString())} دقيقة"
  }

  override fun aboutAnHour(minutes: Int, date: Long): String = "ساعة تقريباً"
  override fun hours(hours: Int, minutes: Int, date: Long): String = when (hours) {
    2 -> "ساعتين"
    in 3..10 -> "${toArabic(hours.toString())} ساعات"
    else -> "${toArabic(hours.toString())} ساعة"
  }

  override fun aDay(hours: Int, date: Long): String = "يوم"
  override fun days(days: Int, hours: Int, date: Long): String = when (days) {
    2 -> "يومين"
    in 3..10 -> "${toArabic(days.toString())} ايام"
    else -> "${toArabic(days.toString())} يوم"
  }

  override fun aboutAMonth(days: Int, date: Long): String = "شهر تقريباً"
  override fun months(months: Int, days: Int, date: Long): String = when {
    months == 2 -> "شهرين"
    months in 3..10 -> "${toArabic(months.toString())} اشهر"
    months > 10 -> "${toArabic(months.toString())} شهر"
    else -> "${toArabic(months.toString())} شهور"
  }

  override fun aboutAYear(year: Int, date: Long): String = "سنة تقريباً"
  override fun years(years: Int, months: Int, date: Long): String = when (years) {
    2 -> "سنتين"
    in 3..10 -> "${toArabic(years.toString())} سنوات"
    else -> "${toArabic(years.toString())} سنة"
  }
}

/**
 * Arabic Short Messages.
 * @since 1.1.0
 */
internal object ArShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String =
    "${toArabic(seconds.toString())} ثا"

  override fun aboutAMinute(minutes: Int, date: Long): String = "~${toArabic("1")} د"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String =
    "${toArabic(minutes.toString())} د"

  override fun aboutAnHour(minutes: Int, date: Long): String = "~${toArabic("1")} س"
  override fun hours(hours: Int, minutes: Int, date: Long): String =
    "${toArabic(hours.toString())} س"

  override fun aDay(hours: Int, date: Long): String = "~${toArabic("1")} ي"
  override fun days(days: Int, hours: Int, date: Long): String = "${toArabic(days.toString())} ي"
  override fun aboutAMonth(days: Int, date: Long): String = "~${toArabic("1")} ش"
  override fun months(months: Int, days: Int, date: Long): String =
    "${toArabic(months.toString())} ش"

  override fun aboutAYear(year: Int, date: Long): String = "~${toArabic("1")} س"
  override fun years(years: Int, months: Int, date: Long): String =
    "${toArabic(years.toString())} س"
}

private fun toArabic(number: String) =
  if (TimeAgo.isLocaleNumberEnabled) NumberConverter.toArabic(number) else number
