package com.parsuomash.affogato.core.ktx.time.messages

/**
 * [MonthMessages] template month message for [LookupMessages].
 * @since 1.1.0
 */
interface MonthMessages {
  /** Format when time is about a month */
  fun aboutAMonth(days: Int): String

  /** Format when time is in months */
  fun months(months: Int): String
}
