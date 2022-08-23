package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Finnish Messages.
 * @since 1.1.0
 */
internal object FiMessages : LookupMessages {
  override fun suffixAgo(): String = "sitten"
  override fun suffixFromNow(): String = "kuluttua"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "hetki"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "noin minuutti"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
    "$minutes minuuttia"

  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "noin tunti"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours tuntia"
  override fun aDay(hours: Int, dateInMillis: Long): String = "vuorokausi"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days päivää"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "noin kuukausi"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months kuukautta"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "noin vuosi"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years vuotta"
}

/**
 * Finnish Short Messages.
 * @since 1.1.0
 */
internal object FiShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "nyt"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 min"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes min:ia"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 t"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours t"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~pvä"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days pvää"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~kk"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months kk:ta"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 v"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "${years}v:ta"
}
