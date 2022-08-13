package com.parsuomash.affogato.core.ktx.time.messages.protocol

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
  WeekMessages,
  MonthMessages,
  YearMessages {
  /** word separator when words are concatenated */
  fun wordSeparator(): String = " "
}
