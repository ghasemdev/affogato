package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Hindi Messages.
 * @since 1.1.0
 */
internal object HiMessages : LookupMessages {
  override fun suffixAgo(): String = "पूर्व"
  override fun suffixFromNow(): String = "अब से"
  override fun lessThanOneMinute(seconds: Int): String = "एक क्षण पहले"
  override fun aboutAMinute(minutes: Int): String = "एक मिनट पहले"
  override fun minutes(minutes: Int): String = "$minutes मिनट"
  override fun aboutAnHour(minutes: Int): String = "करीब एक घंटा"
  override fun hours(hours: Int): String = "$hours घंटे"
  override fun aDay(hours: Int): String = "एक दिन पहले"
  override fun days(days: Int): String = "$days दिन"
  override fun aboutAMonth(days: Int): String = "तक़रीबन एक महीना"
  override fun months(months: Int): String = "$months महीने"
  override fun aboutAYear(year: Int): String = "एक साल पहले"
  override fun years(years: Int): String = "$years वर्षों पहले"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Hindi Short Messages.
 * @since 1.1.0
 */
internal object HiShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "अभी अभी"
  override fun aboutAMinute(minutes: Int): String = "1 मि"
  override fun minutes(minutes: Int): String = "$minutes मि"
  override fun aboutAnHour(minutes: Int): String = "~1 घं"
  override fun hours(hours: Int): String = "$hours घं"
  override fun aDay(hours: Int): String = "~1 दि"
  override fun days(days: Int): String = "$days दि"
  override fun aboutAMonth(days: Int): String = "~1 म"
  override fun months(months: Int): String = "$months म"
  override fun aboutAYear(year: Int): String = "~1 सा"
  override fun years(years: Int): String = "$years सा"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
