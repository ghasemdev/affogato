package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Hindi Messages.
 * @since 1.1.0
 */
internal object HiMessages : LookupMessages {
  override fun suffixAgo(): String = "पूर्व"
  override fun suffixFromNow(): String = "अब से"
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "एक क्षण पहले"
  override fun aboutAMinute(minutes: Int, date: Long): String = "एक मिनट पहले"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes मिनट"
  override fun aboutAnHour(minutes: Int, date: Long): String = "करीब एक घंटा"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours घंटे"
  override fun aDay(hours: Int, date: Long): String = "एक दिन पहले"
  override fun days(days: Int, hours: Int, date: Long): String = "$days दिन"
  override fun aboutAMonth(days: Int, date: Long): String = "तक़रीबन एक महीना"
  override fun months(months: Int, days: Int, date: Long): String = "$months महीने"
  override fun aboutAYear(year: Int, date: Long): String = "एक साल पहले"
  override fun years(years: Int, months: Int, date: Long): String = "$years वर्षों पहले"
}

/**
 * Hindi Short Messages.
 * @since 1.1.0
 */
internal object HiShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, date: Long): String = "अभी अभी"
  override fun aboutAMinute(minutes: Int, date: Long): String = "1 मि"
  override fun minutes(minutes: Int, seconds: Int, date: Long): String = "$minutes मि"
  override fun aboutAnHour(minutes: Int, date: Long): String = "~1 घं"
  override fun hours(hours: Int, minutes: Int, date: Long): String = "$hours घं"
  override fun aDay(hours: Int, date: Long): String = "~1 दि"
  override fun days(days: Int, hours: Int, date: Long): String = "$days दि"
  override fun aboutAMonth(days: Int, date: Long): String = "~1 म"
  override fun months(months: Int, days: Int, date: Long): String = "$months म"
  override fun aboutAYear(year: Int, date: Long): String = "~1 सा"
  override fun years(years: Int, months: Int, date: Long): String = "$years सा"
}
