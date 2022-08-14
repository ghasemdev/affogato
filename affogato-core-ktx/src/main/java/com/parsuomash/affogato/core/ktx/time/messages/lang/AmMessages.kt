package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Amharic Messages.
 * @since 1.1.0
 */
internal object AmMessages : LookupMessages {
  override fun suffixAgo(): String = "በፊት"
  override fun suffixFromNow(): String = "ከአሁን ጀምሮ"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "አንድ አፍታ"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "አንድ ደቂቃ"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = if (minutes == 1) {
    "$minutes ደቂቃ"
  } else {
    "$minutes ደቂቃዎች"
  }

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "ለአንድ ሰዓት ያህል"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = if (hours == 1) {
    "$hours ሰአት"
  } else {
    "$hours ሰአታት"
  }

  override fun aDay(hours: Int, dateInMillis: Long): String = "يوم"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = if (days == 1) {
    "$days ቀን"
  } else {
    "$days ቀናት"
  }

  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "አንድ ወር ገደማ"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = if (months == 1) {
    "$months ወር"
  } else {
    "$months ወራት"
  }

  override fun aboutAYear(year: Int, dateInMillis: Long): String = "አንድ ዓመት ገደማ"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = if (years == 1) {
    "$years አመት"
  } else {
    "$years አመታት"
  }
}

/**
 * Amharic Short Messages.
 * @since 1.1.0
 */
internal object AmShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "አሁን"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1ደ"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "${minutes}ደ"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1ሰ"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "${hours}ሰ"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1ቀ"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "${days}ቀ"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1ወር"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "${months}ወር"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1ዓ"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "${years}ዓ"
}
