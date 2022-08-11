package com.parsuomash.affogato.core.ktx.time

import com.google.common.truth.Truth.assertThat
import com.parsuomash.affogato.core.ktx.datetime.asDate
import com.parsuomash.affogato.core.ktx.datetime.minus
import com.parsuomash.affogato.core.ktx.datetime.toString
import com.parsuomash.affogato.core.ktx.time.messages.NoSuchMessageException
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class TimeAgoKtTest {
  @Test
  fun `time ago for long type`() {
    assertThrows<NoSuchMessageException> { nowInMilliseconds().timeAgo(locale = "ar") }
    assertThat(TimeAgo.format(nowInMilliseconds())).isEqualTo("a moment ago")

    assertThat(nowInMilliseconds().timeAgo()).isEqualTo("a moment ago")
    assertThat((now() - 1.minutes).toEpochMilliseconds().timeAgo()).isEqualTo("a minute ago")
    assertThat((now() - 5.minutes).toEpochMilliseconds().timeAgo()).isEqualTo("5 minutes ago")
    assertThat((now() - 1.hours).toEpochMilliseconds().timeAgo()).isEqualTo("about an hour ago")
    assertThat((now() - 4.hours).toEpochMilliseconds().timeAgo()).isEqualTo("4 hours ago")
    assertThat((now() - 1.days).toEpochMilliseconds().timeAgo()).isEqualTo("a day ago")
    assertThat((now() - 7.days).toEpochMilliseconds().timeAgo()).isEqualTo("7 days ago")
    assertThat((now() - 1.months).toEpochMilliseconds().timeAgo()).isEqualTo("about a month ago")
    assertThat((now() - 10.months).toEpochMilliseconds().timeAgo()).isEqualTo("10 months ago")
    assertThat((now() - 1.years).toEpochMilliseconds().timeAgo()).isEqualTo("about a year ago")
    val threeYearsAgo = (now() - 3.years).toEpochMilliseconds()
    val date = threeYearsAgo.asDate
    assertThat(threeYearsAgo.timeAgo()).isEqualTo("on ${date.toString("MM/dd/yyyy")}")

    assertThat(nowInMilliseconds().timeAgo(locale = "en")).isEqualTo("a moment ago")

    assertThat((now() - 1.seconds).toEpochMilliseconds().timeAgo(clock = nowInMilliseconds()))
      .isEqualTo("a moment ago")
    assertThat(
      nowInMilliseconds().timeAgo(
        clock = (now() - 5.seconds).toEpochMilliseconds(),
        allowFromNow = true
      )
    ).isEqualTo("a moment from now")

    assertThat((now() - 2.years).toEpochMilliseconds().timeAgo(allowOnDate = false))
      .isEqualTo("2 years ago")

    assertThat(nowInMilliseconds().timeAgo(allowFromNow = true))
      .isEqualTo("a moment ago")
  }

  @Test
  fun `time ago for date type`() {
    assertThrows<NoSuchMessageException> { nowInDate().timeAgo(locale = "ar") }
    assertThat(TimeAgo.format(nowInDate())).isEqualTo("a moment ago")

    assertThat(nowInDate().timeAgo()).isEqualTo("a moment ago")
    assertThat((nowInDate() - 1.minutes).timeAgo()).isEqualTo("a minute ago")
    assertThat((nowInDate() - 5.minutes).timeAgo()).isEqualTo("5 minutes ago")
    assertThat((nowInDate() - 1.hours).timeAgo()).isEqualTo("about an hour ago")
    assertThat((nowInDate() - 4.hours).timeAgo()).isEqualTo("4 hours ago")
    assertThat((nowInDate() - 1.days).timeAgo()).isEqualTo("a day ago")
    assertThat((nowInDate() - 7.days).timeAgo()).isEqualTo("7 days ago")
    assertThat((nowInDate() - 1.months).timeAgo()).isEqualTo("about a month ago")
    assertThat((nowInDate() - 10.months).timeAgo()).isEqualTo("10 months ago")
    assertThat((nowInDate() - 1.years).timeAgo()).isEqualTo("about a year ago")
    val threeYearsAgo = (nowInDate() - 3.years)
    assertThat(threeYearsAgo.timeAgo()).isEqualTo("on ${threeYearsAgo.toString("MM/dd/yyyy")}")

    assertThat(nowInDate().timeAgo(locale = "en")).isEqualTo("a moment ago")

    assertThat((nowInDate() - 1.seconds).timeAgo(clock = nowInDate()))
      .isEqualTo("a moment ago")
    assertThat(nowInDate().timeAgo(clock = nowInDate() - 5.seconds, allowFromNow = true))
      .isEqualTo("a moment from now")

    assertThat((nowInDate() - 2.years).timeAgo(allowOnDate = false))
      .isEqualTo("2 years ago")

    assertThat(nowInDate().timeAgo(allowFromNow = true))
      .isEqualTo("a moment ago")
  }

  @Test
  fun `time ago for calendar type`() {
    assertThrows<NoSuchMessageException> { nowInCalendar().timeAgo(locale = "ar") }
    assertThat(TimeAgo.format(nowInCalendar())).isEqualTo("a moment ago")

    assertThat(nowInCalendar().timeAgo()).isEqualTo("a moment ago")
    assertThat((nowInCalendar() - 1.minutes).timeAgo()).isEqualTo("a minute ago")
    assertThat((nowInCalendar() - 5.minutes).timeAgo()).isEqualTo("5 minutes ago")
    assertThat((nowInCalendar() - 1.hours).timeAgo()).isEqualTo("about an hour ago")
    assertThat((nowInCalendar() - 4.hours).timeAgo()).isEqualTo("4 hours ago")
    assertThat((nowInCalendar() - 1.days).timeAgo()).isEqualTo("a day ago")
    assertThat((nowInCalendar() - 7.days).timeAgo()).isEqualTo("7 days ago")
    assertThat((nowInCalendar() - 1.months).timeAgo()).isEqualTo("about a month ago")
    assertThat((nowInCalendar() - 10.months).timeAgo()).isEqualTo("10 months ago")
    assertThat((nowInCalendar() - 1.years).timeAgo()).isEqualTo("about a year ago")
    val threeYearsAgo = (nowInCalendar() - 3.years)
    assertThat(threeYearsAgo.timeAgo()).isEqualTo("on ${threeYearsAgo.toString("MM/dd/yyyy")}")

    assertThat(nowInCalendar().timeAgo(locale = "en")).isEqualTo("a moment ago")

    assertThat((nowInCalendar() - 1.seconds).timeAgo(clock = nowInCalendar()))
      .isEqualTo("a moment ago")
    assertThat(nowInCalendar().timeAgo(clock = nowInCalendar() - 5.seconds, allowFromNow = true))
      .isEqualTo("a moment from now")

    assertThat((nowInCalendar() - 2.years).timeAgo(allowOnDate = false))
      .isEqualTo("2 years ago")

    assertThat(nowInCalendar().timeAgo(allowFromNow = true))
      .isEqualTo("a moment ago")
  }

  @Test
  fun `time ago for instant type`() {
    assertThrows<NoSuchMessageException> { now().timeAgo(locale = "ar") }
    assertThat(TimeAgo.format(now())).isEqualTo("a moment ago")

    assertThat(now().timeAgo()).isEqualTo("a moment ago")
    assertThat((now() - 1.minutes).timeAgo()).isEqualTo("a minute ago")
    assertThat((now() - 5.minutes).timeAgo()).isEqualTo("5 minutes ago")
    assertThat((now() - 1.hours).timeAgo()).isEqualTo("about an hour ago")
    assertThat((now() - 4.hours).timeAgo()).isEqualTo("4 hours ago")
    assertThat((now() - 1.days).timeAgo()).isEqualTo("a day ago")
    assertThat((now() - 7.days).timeAgo()).isEqualTo("7 days ago")
    assertThat((now() - 1.months).timeAgo()).isEqualTo("about a month ago")
    assertThat((now() - 10.months).timeAgo()).isEqualTo("10 months ago")
    assertThat((now() - 1.years).timeAgo()).isEqualTo("about a year ago")
    val threeYearsAgo = (now() - 3.years)
    assertThat(threeYearsAgo.timeAgo()).isEqualTo("on ${threeYearsAgo.toString("MM/dd/yyyy")}")

    assertThat(now().timeAgo(locale = "en")).isEqualTo("a moment ago")

    assertThat((now() - 1.seconds).timeAgo(clock = now()))
      .isEqualTo("a moment ago")
    assertThat(now().timeAgo(clock = now() - 5.seconds, allowFromNow = true))
      .isEqualTo("a moment from now")

    assertThat((now() - 2.years).timeAgo(allowOnDate = false))
      .isEqualTo("2 years ago")

    assertThat(now().timeAgo(allowFromNow = true))
      .isEqualTo("a moment ago")
  }

  @Test
  fun `time ago for local date time type`() {
    assertThrows<NoSuchMessageException> { nowInLocalDateTime().timeAgo(locale = "ar") }
    assertThat(TimeAgo.format(nowInLocalDateTime())).isEqualTo("a moment ago")

    assertThat(nowInLocalDateTime().timeAgo()).isEqualTo("a moment ago")
    assertThat((nowInLocalDateTime() - 1.minutes).timeAgo()).isEqualTo("a minute ago")
    assertThat((nowInLocalDateTime() - 5.minutes).timeAgo()).isEqualTo("5 minutes ago")
    assertThat((nowInLocalDateTime() - 1.hours).timeAgo()).isEqualTo("about an hour ago")
    assertThat((nowInLocalDateTime() - 4.hours).timeAgo()).isEqualTo("4 hours ago")
    assertThat((nowInLocalDateTime() - 1.days).timeAgo()).isEqualTo("a day ago")
    assertThat((nowInLocalDateTime() - 7.days).timeAgo()).isEqualTo("7 days ago")
    assertThat((nowInLocalDateTime() - 1.months).timeAgo()).isEqualTo("about a month ago")
    assertThat((nowInLocalDateTime() - 10.months).timeAgo()).isEqualTo("10 months ago")
    assertThat((nowInLocalDateTime() - 1.years).timeAgo()).isEqualTo("about a year ago")
    val threeYearsAgo = (nowInLocalDateTime() - 3.years)
    assertThat(threeYearsAgo.timeAgo()).isEqualTo("on ${threeYearsAgo.toString("MM/dd/yyyy")}")

    assertThat(nowInLocalDateTime().timeAgo(locale = "en")).isEqualTo("a moment ago")

    assertThat((nowInLocalDateTime() - 1.seconds).timeAgo(clock = nowInLocalDateTime()))
      .isEqualTo("a moment ago")
    assertThat(
      nowInLocalDateTime().timeAgo(
        clock = nowInLocalDateTime() - 5.seconds,
        allowFromNow = true
      )
    ).isEqualTo("a moment from now")

    assertThat((nowInLocalDateTime() - 2.years).timeAgo(allowOnDate = false))
      .isEqualTo("2 years ago")

    assertThat(nowInLocalDateTime().timeAgo(allowFromNow = true))
      .isEqualTo("a moment ago")
  }

  companion object {
    @JvmStatic
    @BeforeAll
    fun init() {
      TimeAgo.setLocaleMessages("en")
      TimeAgo.setDefaultLocale("en")
    }
  }
}
