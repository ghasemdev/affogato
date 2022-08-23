@file:JvmName("_GrMessages")

package com.parsuomash.affogato.core.ktx.time.messages.lang

import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages

/**
 * Greek Messages.
 * @since 1.1.0
 */
internal object GrMessages : LookupMessages {
  override fun suffixAgo(): String = "πρίν"
  override fun suffixFromNow(): String = "απο τώρα"
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "μια στιγμή"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "ένα λεπτό"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes λεπτά"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "περίπου μια ώρα"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours ώρες"
  override fun aDay(hours: Int, dateInMillis: Long): String = "$hours ώρες"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days μέρες"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "περίπου ένα μήνα"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months μήνες"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "περίπου ένα χρόνο"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years χρόνια"
}

/**
 * Greek Short Messages.
 * @since 1.1.0
 */
internal object GrShortMessages : LookupMessages {
  override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "τώρα"
  override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "1 λπτ"
  override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = "$minutes λπτ"
  override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "~1 ώρ"
  override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours ώρες"
  override fun aDay(hours: Int, dateInMillis: Long): String = "~1 μρ"
  override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days μρς"
  override fun aboutAMonth(days: Int, dateInMillis: Long): String = "~1 μν"
  override fun months(months: Int, days: Int, dateInMillis: Long): String = "$months μνς"
  override fun aboutAYear(year: Int, dateInMillis: Long): String = "~1 χρ"
  override fun years(years: Int, months: Int, dateInMillis: Long): String = "$years χρ"
}
