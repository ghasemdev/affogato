package com.parsuomash.affogato.core.ktx.time

/**
 * [DateLimitation] is an enum class for limitation [TimeAgo] prefix and suffix.
 * @since 1.1.0
 */
enum class DateLimitation(val priority: Int) {
  None(-1),
  Second(7),
  Minute(6),
  Hour(5),
  Day(4),
  Week(3),
  Month(2),
  Year(1)
}
