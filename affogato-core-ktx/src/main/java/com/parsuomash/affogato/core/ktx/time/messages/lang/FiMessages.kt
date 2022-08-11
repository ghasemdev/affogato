package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Finnish Messages.
 * @since 1.1.0
 */
internal object FiMessages : LookupMessages {
  override fun suffixAgo(): String = "sitten"
  override fun suffixFromNow(): String = "kuluttua"
  override fun lessThanOneMinute(seconds: Int): String = "hetki"
  override fun aboutAMinute(minutes: Int): String = "noin minuutti"
  override fun minutes(minutes: Int): String = "$minutes minuuttia"
  override fun aboutAnHour(minutes: Int): String = "noin tunti"
  override fun hours(hours: Int): String = "$hours tuntia"
  override fun aDay(hours: Int): String = "vuorokausi"
  override fun days(days: Int): String = "$days päivää"
  override fun aboutAMonth(days: Int): String = "noin kuukausi"
  override fun months(months: Int): String = "$months kuukautta"
  override fun aboutAYear(year: Int): String = "noin vuosi"
  override fun years(years: Int): String = "$years vuotta"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Finnish Short Messages.
 * @since 1.1.0
 */
internal object FiShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "nyt"
  override fun aboutAMinute(minutes: Int): String = "1 min"
  override fun minutes(minutes: Int): String = "$minutes min:ia"
  override fun aboutAnHour(minutes: Int): String = "~1 t"
  override fun hours(hours: Int): String = "$hours t"
  override fun aDay(hours: Int): String = "~pvä"
  override fun days(days: Int): String = "$days pvää"
  override fun aboutAMonth(days: Int): String = "~kk"
  override fun months(months: Int): String = "$months kk:ta"
  override fun aboutAYear(year: Int): String = "~1 v"
  override fun years(years: Int): String = "${years}v:ta"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
