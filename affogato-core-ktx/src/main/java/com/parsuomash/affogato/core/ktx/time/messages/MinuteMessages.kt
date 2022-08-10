package com.parsuomash.affogato.core.ktx.time.messages

/**
 * [MinuteMessages] template minute message for [LookupMessages].
 * @since 1.1.0
 */
interface MinuteMessages {
  /** Format when time is less than a minute */
  fun lessThanOneMinute(seconds: Int): String

  /** Format when time is about a minute */
  fun aboutAMinute(minutes: Int): String

  /** Format when time is in minutes */
  fun minutes(minutes: Int): String
}
