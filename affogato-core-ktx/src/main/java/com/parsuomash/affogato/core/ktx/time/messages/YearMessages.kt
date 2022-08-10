package com.parsuomash.affogato.core.ktx.time.messages

/**
 * [YearMessages] template year message for [LookupMessages].
 * @since 1.1.0
 */
interface YearMessages {
  /** Format when time is about a year */
  fun aboutAYear(year: Int): String

  /** Format when time is in years */
  fun years(years: Int): String
}
