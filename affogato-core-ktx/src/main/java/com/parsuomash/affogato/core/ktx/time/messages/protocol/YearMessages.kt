package com.parsuomash.affogato.core.ktx.time.messages.protocol

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString

/**
 * [YearMessages] template for [LookupMessages].
 * @since 1.1.0
 */
interface YearMessages {
  /** Format when time is about a year */
  fun aboutAYear(year: Int, date: Long): String = date.asDate.toString("MMM dd, yyyy")

  /** Format when time is in years */
  fun years(years: Int, months: Int, date: Long): String = date.asDate.toString("MMM dd, yyyy")
}
