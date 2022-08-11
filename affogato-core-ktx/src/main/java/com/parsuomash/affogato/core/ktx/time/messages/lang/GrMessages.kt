package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Greek Messages.
 * @since 1.1.0
 */
internal object GrMessages : LookupMessages {
  override fun suffixAgo(): String = "πρίν"
  override fun suffixFromNow(): String = "απο τώρα"
  override fun lessThanOneMinute(seconds: Int): String = "μια στιγμή"
  override fun aboutAMinute(minutes: Int): String = "ένα λεπτό"
  override fun minutes(minutes: Int): String = "$minutes λεπτά"
  override fun aboutAnHour(minutes: Int): String = "περίπου μια ώρα"
  override fun hours(hours: Int): String = "$hours ώρες"
  override fun aDay(hours: Int): String = "$hours ώρες"
  override fun days(days: Int): String = "$days μέρες"
  override fun aboutAMonth(days: Int): String = "περίπου ένα μήνα"
  override fun months(months: Int): String = "$months μήνες"
  override fun aboutAYear(year: Int): String = "περίπου ένα χρόνο"
  override fun years(years: Int): String = "$years χρόνια"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}

/**
 * Greek Short Messages.
 * @since 1.1.0
 */
internal object GrShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int): String = "τώρα"
  override fun aboutAMinute(minutes: Int): String = "1 λπτ"
  override fun minutes(minutes: Int): String = "$minutes λπτ"
  override fun aboutAnHour(minutes: Int): String = "~1 ώρ"
  override fun hours(hours: Int): String = "$hours ώρες"
  override fun aDay(hours: Int): String = "~1 μρ"
  override fun days(days: Int): String = "$days μρς"
  override fun aboutAMonth(days: Int): String = "~1 μν"
  override fun months(months: Int): String = "$months μνς"
  override fun aboutAYear(year: Int): String = "~1 χρ"
  override fun years(years: Int): String = "$years χρ"
  override fun onDate(elapsed: Long): String = elapsed.asDate.toString("MM/dd/yyyy")
}
