package com.parsuomash.affogato.app

import com.parsuomash.affogato.core.ktx.datetime.format
import com.parsuomash.affogato.core.ktx.datetime.toDate
import com.parsuomash.affogato.core.ktx.time.DateLimitation
import com.parsuomash.affogato.core.ktx.time.TimeAgo
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages
import com.parsuomash.affogato.core.ktx.time.months
import com.parsuomash.affogato.core.ktx.time.now
import com.parsuomash.affogato.core.ktx.time.timeAgo
import kotlin.time.Duration.Companion.minutes

fun main() {
  val currentTime = now()
  val fiveMinuteAgo = currentTime - 5.minutes
  val twoMonthAgo = currentTime - 2.months

  val customMessage = object : LookupMessages {
    override fun suffixAgo(): String = "ago"
    override fun suffixFromNow(): String = "from now"
    override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = "a moment"
    override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = "a minute"
    override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String =
      "$minutes minutes"

    override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = "about an hour"
    override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = "$hours hours"
    override fun aDay(hours: Int, dateInMillis: Long): String = "a day"
    override fun days(days: Int, hours: Int, dateInMillis: Long): String = "$days days"
    override fun aboutAMonth(days: Int, dateInMillis: Long): String =
      dateInMillis.toDate().format("MMM dd")

    override fun months(months: Int, days: Int, dateInMillis: Long): String =
      dateInMillis.toDate().format("MMM dd")

    override fun aboutAYear(year: Int, dateInMillis: Long): String =
      dateInMillis.toDate().format("MMM dd, yyyy")

    override fun years(years: Int, months: Int, dateInMillis: Long): String =
      dateInMillis.toDate().format("MMM dd, yyyy")
  }
  TimeAgo.setLocaleMessagesAndDefaultLocale("custom", customMessage)
  TimeAgo.isLocaleNumberEnabled = true

  println("Five Minute Ago: $fiveMinuteAgo")
  println("Five Minute Ago: " + fiveMinuteAgo.timeAgo(locale = "fa"))

  println("Two Month Ago: $twoMonthAgo")
  println("Two Month Ago: " + twoMonthAgo.timeAgo(minCutOff = DateLimitation.Month))
}
