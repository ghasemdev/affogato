package com.parsuomash.affogato.core.ktx.time.messages

/**
 * [HourMessages] template hour message for [LookupMessages].
 * @since 1.1.0
 */
interface HourMessages {
  /** Format when time is about an hour */
  fun aboutAnHour(minutes: Int): String

  /** Format when time is in hours */
  fun hours(hours: Int): String
}
