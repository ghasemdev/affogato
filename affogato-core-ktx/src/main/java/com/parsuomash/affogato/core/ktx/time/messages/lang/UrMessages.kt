package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Urdu Messages.
 * @since 1.1.0
 */
internal object UrMessages : LookupMessages {
  override fun suffixAgo(): String = "پہلے"
  override fun suffixFromNow(): String = "اب سے"
  override fun lessThanOneMinute(seconds: Int): String = "ایک لمحہ"
  override fun aboutAMinute(minutes: Int): String = "ایک منٹ"
  override fun minutes(minutes: Int): String = "${toUrduNumber(minutes.toString())} منٹ"
  override fun aboutAnHour(minutes: Int): String = "ایک گھنٹہ"
  override fun hours(hours: Int): String = "${toUrduNumber(hours.toString())} گھنٹے"
  override fun aDay(hours: Int): String = "ایک دن"
  override fun days(days: Int): String = "${toUrduNumber(days.toString())} دن"
  override fun aboutAMonth(days: Int): String = "ایک مہینہ"
  override fun months(months: Int): String = "${toUrduNumber(months.toString())} مہینہ"
  override fun aboutAYear(year: Int): String = "ایک سال"
  override fun years(years: Int): String = "${toUrduNumber(years.toString())} برس"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Urdu Short Messages.
 * @since 1.1.0
 */
internal object UrShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "ابھی"
  override fun aboutAMinute(minutes: Int): String = "١ م"
  override fun minutes(minutes: Int): String = "${toUrduNumber(minutes.toString())} منٹ"
  override fun aboutAnHour(minutes: Int): String = "~١ گھ"
  override fun hours(hours: Int): String = "${toUrduNumber(hours.toString())} گھ"
  override fun aDay(hours: Int): String = "~١ د"
  override fun days(days: Int): String = "${toUrduNumber(days.toString())} د"
  override fun aboutAMonth(days: Int): String = "~١ ماہ"
  override fun months(months: Int): String = "${toUrduNumber(months.toString())} ماہ"
  override fun aboutAYear(year: Int): String = "~١ س"
  override fun years(years: Int): String = "${toUrduNumber(years.toString())} س"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

private val englishNumbers = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
private val urduNumbers = charArrayOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')

private fun toUrduNumber(value: String): String = buildString {
  for (char in value) {
    val index = englishNumbers.indexOf(char)
    if (index != -1) append(urduNumbers[index]) else append(char)
  }
}
