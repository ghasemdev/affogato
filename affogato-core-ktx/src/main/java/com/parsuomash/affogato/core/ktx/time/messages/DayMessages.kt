package com.parsuomash.affogato.core.ktx.time.messages

/**
 * [DayMessages] template day message for [LookupMessages].
 * @since 1.1.0
 */
interface DayMessages {
  /** Format when time is a day */
  fun aDay(hours: Int): String

  /** Format when time is in days */
  fun days(days: Int): String
}
