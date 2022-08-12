package com.parsuomash.affogato.core.ktx.time.messages.protocol

import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.toString

/**
 * [MonthMessages] template for [LookupMessages].
 * @since 1.1.0
 */
interface MonthMessages {
  /** Format when time is about a month */
  fun aboutAMonth(days: Int, date: Long): String = date.asDate.toString("MMM dd")

  /** Format when time is in months */
  fun months(months: Int, days: Int, date: Long): String = date.asDate.toString("MMM dd")
}
