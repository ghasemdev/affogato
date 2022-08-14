package com.parsuomash.affogato.core.ktx.time.messages.protocol

import com.parsuomash.affogato.core.ktx.datetime.toDate
import com.parsuomash.affogato.core.ktx.datetime.toString

/**
 * [MonthMessages] template for [LookupMessages].
 * @since 1.1.0
 */
interface MonthMessages {
  /** Format when time is about a month */
  fun aboutAMonth(days: Int, dateInMillis: Long): String =
    dateInMillis.toDate().toString("MMM dd")

  /** Format when time is in months */
  fun months(months: Int, days: Int, dateInMillis: Long): String =
    dateInMillis.toDate().toString("MMM dd")
}
