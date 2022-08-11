package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Myanmar Messages.
 * @since 1.1.0
 */
internal object MyMessages : LookupMessages {
  override fun prefixFromNow(): String = "ယခုမှစ၍ "
  override fun lessThanOneMinute(seconds: Int): String = "စောနက"
  override fun aboutAMinute(minutes: Int): String = "လွန်ခဲ့သော ၁ မိနစ်ခန့်"
  override fun minutes(minutes: Int): String = "လွန်ခဲ့သော $minutes မိနစ်"
  override fun aboutAnHour(minutes: Int): String = "လွန်ခဲ့သော ၁ နာရီခန့်"
  override fun hours(hours: Int): String = "လွန်ခဲ့သော $hours နာရီ"
  override fun aDay(hours: Int): String = "လွန်ခဲ့သော ၁ ရက်"
  override fun days(days: Int): String = "လွန်ခဲ့သော $days ရက်"
  override fun aboutAMonth(days: Int): String = "လွန်ခဲ့သော ၁ လခန့်"
  override fun months(months: Int): String = "လွန်ခဲ့သော $months လ"
  override fun aboutAYear(year: Int): String = "လွန်ခဲ့သော ၁ နှစ်ခန့်"
  override fun years(years: Int): String = "လွန်ခဲ့သော $years နှစ်"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Myanmar Short Messages.
 * @since 1.1.0
 */
internal object MyShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "စောနက"
  override fun aboutAMinute(minutes: Int): String = "၁မိနစ်"
  override fun minutes(minutes: Int): String = "${minutes}မိနစ်"
  override fun aboutAnHour(minutes: Int): String = "၁နာရီ"
  override fun hours(hours: Int): String = "${hours}နာရီ"
  override fun aDay(hours: Int): String = "၁ရက်"
  override fun days(days: Int): String = "${days}ရက်"
  override fun aboutAMonth(days: Int): String = "၁လ"
  override fun months(months: Int): String = "${months}လ"
  override fun aboutAYear(year: Int): String = "၁နှစ်"
  override fun years(years: Int): String = "${years}နှစ်"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
