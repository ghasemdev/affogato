package com.parsuomash.affogato.core.ktx.time.messages.protocol

import com.parsuomash.affogato.core.ktx.datetime.format
import com.parsuomash.affogato.core.ktx.datetime.toDate

/**
 * [YearMessages] template for [LookupMessages].
 * @since 1.1.0
 */
interface YearMessages {
  /** Format when time is about a year */
  fun aboutAYear(year: Int, dateInMillis: Long): String =
    dateInMillis.toDate().format("MMM dd, yyyy")

  /** Format when time is in years */
  fun years(years: Int, months: Int, dateInMillis: Long): String =
    dateInMillis.toDate().format("MMM dd, yyyy")
}
