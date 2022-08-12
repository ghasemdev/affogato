package com.parsuomash.affogato.core.ktx.time.messages.protocol

/**
 * [DayMessages] template for [LookupMessages].
 * @since 1.1.0
 */
interface DayMessages {
  /** Format when time is a day */
  fun aDay(hours: Int, date: Long): String

  /** Format when time is in days */
  fun days(days: Int, hours: Int, date: Long): String
}
