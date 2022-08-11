package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Amharic Messages.
 * @since 1.1.0
 */
internal object AmMessages : LookupMessages {
  override fun suffixAgo(): String = "በፊት"
  override fun suffixFromNow(): String = "ከአሁን ጀምሮ"
  override fun lessThanOneMinute(seconds: Int): String = "አንድ አፍታ"
  override fun aboutAMinute(minutes: Int): String = "አንድ ደቂቃ"
  override fun minutes(minutes: Int): String = if (minutes == 1) {
    "$minutes ደቂቃ"
  } else {
    "$minutes ደቂቃዎች"
  }

  override fun aboutAnHour(minutes: Int): String = "ለአንድ ሰዓት ያህል"
  override fun hours(hours: Int): String = if (hours == 1) {
    "$hours ሰአት"
  } else {
    "$hours ሰአታት"
  }

  override fun aDay(hours: Int): String = "يوم"
  override fun days(days: Int): String = if (days == 1) {
    "$days ቀን"
  } else {
    "$days ቀናት"
  }

  override fun aboutAMonth(days: Int): String = "አንድ ወር ገደማ"
  override fun months(months: Int): String = if (months == 1) {
    "$months ወር"
  } else {
    "$months ወራት"
  }

  override fun aboutAYear(year: Int): String = "አንድ ዓመት ገደማ"
  override fun years(years: Int): String = if (years == 1) {
    "$years አመት"
  } else {
    "$years አመታት"
  }

  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Amharic Short Messages.
 * @since 1.1.0
 */
internal object AmShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "አሁን"
  override fun aboutAMinute(minutes: Int): String = "1ደ"
  override fun minutes(minutes: Int): String = "${minutes}ደ"
  override fun aboutAnHour(minutes: Int): String = "~1ሰ"
  override fun hours(hours: Int): String = "${hours}ሰ"
  override fun aDay(hours: Int): String = "~1ቀ"
  override fun days(days: Int): String = "${days}ቀ"
  override fun aboutAMonth(days: Int): String = "~1ወር"
  override fun months(months: Int): String = "${months}ወር"
  override fun aboutAYear(year: Int): String = "~1ዓ"
  override fun years(years: Int): String = "${years}ዓ"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
