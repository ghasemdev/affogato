package com.parsuomash.affogato.core.ktx.time.messages

import com.parsuomash.affogato.core.ktx.time.TimeAgo

/**
 * [LookupMessages] template for any language.
 * @since 1.1.0
 * @see TimeAgo
 */
interface LookupMessages :
  PrefixMessages,
  SuffixMessages,
  MinuteMessages,
  HourMessages,
  DayMessages,
  MonthMessages,
  YearMessages {
  /** Format when time is on date */
  fun onDate(elapsed: Long): String

  /** word separator when words are concatenated */
  fun wordSeparator(): String = " "
}
