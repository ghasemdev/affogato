package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.text.NumberConverter
import com.parsuomash.affogato.core.ktx.time.TimeAgo
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Myanmar Messages.
 * @since 1.1.0
 */
internal object MyMessages : LookupMessages {
  override fun prefixFromNow(): String = "ယခုမှစ၍ "
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "စောနက"
  override fun aboutAMinute(minutes: Int, date: Long): String = "လွန်ခဲ့သော ၁ မိနစ်ခန့်"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String =
    "လွန်ခဲ့သော ${toMyanmar(minutes.toString())} မိနစ်"

  override fun aboutAnHour(minutes: Int, date: Long): String = "လွန်ခဲ့သော ၁ နာရီခန့်"
  override fun hours(hours: Int, minutes: Int, date: Long): String =
    "လွန်ခဲ့သော ${toMyanmar(hours.toString())} နာရီ"

  override fun aDay(hours: Int, date: Long): String = "လွန်ခဲ့သော ၁ ရက်"
  override fun days(days: Int, hours: Int, date: Long): String =
    "လွန်ခဲ့သော ${toMyanmar(days.toString())} ရက်"

  override fun aboutAMonth(days: Int, date: Long): String = "လွန်ခဲ့သော ၁ လခန့်"
  override fun months(months: Int, days: Int, date: Long): String =
    "လွန်ခဲ့သော ${toMyanmar(months.toString())} လ"

  override fun aboutAYear(year: Int, date: Long): String = "လွန်ခဲ့သော ၁ နှစ်ခန့်"
  override fun years(years: Int, months: Int, date: Long): String =
    "လွန်ခဲ့သော ${toMyanmar(years.toString())} နှစ်"
}

/**
 * Myanmar Short Messages.
 * @since 1.1.0
 */
internal object MyShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "စောနက"
  override fun aboutAMinute(minutes: Int, date: Long): String = "၁မိနစ်"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String =
    "${toMyanmar(minutes.toString())}မိနစ်"

  override fun aboutAnHour(minutes: Int, date: Long): String = "၁နာရီ"
  override fun hours(hours: Int, minutes: Int, date: Long): String =
    "${toMyanmar(hours.toString())}နာရီ"

  override fun aDay(hours: Int, date: Long): String = "၁ရက်"
  override fun days(days: Int, hours: Int, date: Long): String = "${toMyanmar(days.toString())}ရက်"
  override fun aboutAMonth(days: Int, date: Long): String = "၁လ"
  override fun months(months: Int, days: Int, date: Long): String =
    "${toMyanmar(months.toString())}လ"

  override fun aboutAYear(year: Int, date: Long): String = "၁နှစ်"
  override fun years(years: Int, months: Int, date: Long): String =
    "${toMyanmar(years.toString())}နှစ်"
}

private fun toMyanmar(number: String) =
  if (TimeAgo.isLocaleNumberEnabled) NumberConverter.toMyanmar(number) else number
