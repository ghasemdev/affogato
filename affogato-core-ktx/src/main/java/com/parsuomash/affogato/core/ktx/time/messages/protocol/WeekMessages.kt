package com.parsuomash.affogato.core.ktx.time.messages.protocol

/**
 * [WeekMessages] template for [LookupMessages].
 * @since 1.1.0
 */
interface WeekMessages {
  /** Format when time is in weeks */
  fun weeks(weeks: Int, days: Int, dateInMillis: Long): String =
    "${weeks}w ${days}d".replace(" 0d", "")
}
