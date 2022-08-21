package com.parsuomash.affogato.core.ktx.time

import com.google.common.truth.Truth.assertThat
import com.parsuomash.affogato.core.ktx.datetime.format
import com.parsuomash.affogato.core.ktx.datetime.minus
import com.parsuomash.affogato.core.ktx.time.messages.NoSuchMessageException
import com.parsuomash.affogato.core.ktx.time.messages.protocol.LookupMessages
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlinx.datetime.LocalDateTime
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class TimeAgoKtTest {
  @Nested
  @DisplayName("Time Ago")
  inner class TimeAgoTest {
    @Test
    fun `less then one minute`() {
      assertThat((now() - 1.seconds).timeAgo()).isEqualTo("a moment ago")
      assertThat((now() - 5.seconds).timeAgo()).isEqualTo("a moment ago")
      assertThat((now() - 59.seconds).timeAgo()).isEqualTo("a moment ago")
      assertThat((now() - 59.99.seconds).timeAgo()).isEqualTo("a moment ago")
      assertThat((now() - 60.seconds).timeAgo()).isEqualTo("a minute ago")

      assertThat((now() - 0.5.minutes).timeAgo()).isEqualTo("a moment ago")
      assertThat((now() - 0.99.minutes).timeAgo()).isEqualTo("a moment ago")
      assertThat((now() - 1.minutes).timeAgo()).isEqualTo("a minute ago")
    }

    @Test
    fun `about a minute`() {
      assertThat((now() - 60.seconds).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 90.seconds).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 100.seconds).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 119.99.seconds).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 120.seconds).timeAgo()).isEqualTo("2 minutes ago")

      assertThat((now() - 1.minutes).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 1.99.minutes).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 2.minutes).timeAgo()).isEqualTo("2 minutes ago")
    }

    @Test
    fun `about an hour`() {
      assertThat((now() - 1.minutes).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 1.99.minutes).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 2.minutes).timeAgo()).isEqualTo("2 minutes ago")
      assertThat((now() - 5.minutes).timeAgo()).isEqualTo("5 minutes ago")
      assertThat((now() - 30.minutes).timeAgo()).isEqualTo("30 minutes ago")
      assertThat((now() - 45.minutes).timeAgo()).isEqualTo("45 minutes ago")
      assertThat((now() - 50.minutes).timeAgo()).isEqualTo("50 minutes ago")
      assertThat((now() - 59.99.minutes).timeAgo()).isEqualTo("59 minutes ago")
      assertThat((now() - 60.minutes).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 61.minutes).timeAgo()).isEqualTo("about an hour ago")

      assertThat((now() - 0.99.hours).timeAgo()).isEqualTo("59 minutes ago")
      assertThat((now() - 1.hours).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 1.hours - 29.minutes).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 1.hours - 30.minutes).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 1.99.hours).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 1.hours - 59.minutes).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 2.hours).timeAgo()).isEqualTo("2 hours ago")
    }

    @Test
    fun `about an day`() {
      assertThat((now() - 60.minutes).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 61.minutes).timeAgo()).isEqualTo("about an hour ago")

      assertThat((now() - 1.hours).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 1.hours - 29.minutes).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 1.hours - 30.minutes).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 2.hours).timeAgo()).isEqualTo("2 hours ago")
      assertThat((now() - 5.hours).timeAgo()).isEqualTo("5 hours ago")
      assertThat((now() - 10.hours).timeAgo()).isEqualTo("10 hours ago")
      assertThat((now() - 23.hours).timeAgo()).isEqualTo("23 hours ago")
      assertThat((now() - 23.hours - 59.minutes).timeAgo()).isEqualTo("23 hours ago")
      assertThat((now() - 23.99.hours).timeAgo()).isEqualTo("23 hours ago")
      assertThat((now() - 24.hours).timeAgo()).isEqualTo("a day ago")
      assertThat((now() - 25.hours).timeAgo()).isEqualTo("a day ago")

      assertThat((now() - 0.99.days).timeAgo()).isEqualTo("23 hours ago")
      assertThat((now() - 1.days).timeAgo()).isEqualTo("a day ago")
      assertThat((now() - 1.99.days).timeAgo()).isEqualTo("a day ago")
      assertThat((now() - 2.days).timeAgo()).isEqualTo("2 days ago")
    }

    @Test
    fun `about an week`() {
      assertThat((now() - 0.99.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("23 hours ago")
      assertThat((now() - 1.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("a day ago")
      assertThat((now() - 1.99.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("a day ago")
      assertThat((now() - 2.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("2 days ago")
      assertThat((now() - 3.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("3 days ago")
      assertThat((now() - 4.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("4 days ago")
      assertThat((now() - 5.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("5 days ago")
      assertThat((now() - 6.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("6 days ago")
      assertThat((now() - 6.99.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("6 days ago")

      assertThat((now() - 7.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("a week ago")
      assertThat((now() - 13.99.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("2 weeks ago")
      assertThat((now() - 14.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("2 weeks ago")
      assertThat((now() - 20.99.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("3 weeks ago")
      assertThat((now() - 21.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("3 weeks ago")
      assertThat((now() - 27.99.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("4 weeks ago")
      assertThat((now() - 28.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("4 weeks ago")
      assertThat((now() - 29.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("4 weeks ago")
      assertThat((now() - 29.99.days).timeAgo(isWeekFormatEnabled = true)).isEqualTo("4 weeks ago")

      assertThat((now() - 30.days).timeAgo(isWeekFormatEnabled = true))
        .isEqualTo("about a month ago")
    }

    @Test
    fun `about an month`() {
      assertThat((now() - 28.days).timeAgo()).isEqualTo("28 days ago")
      assertThat((now() - 29.days).timeAgo()).isEqualTo("29 days ago")
      assertThat((now() - 29.99.days).timeAgo()).isEqualTo("29 days ago")
      assertThat((now() - 29.days - 23.hours - 59.minutes - 59.seconds).timeAgo())
        .isEqualTo("about a month ago")
      assertThat((now() - 30.days).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 31.days).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 59.99.days).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 60.days).timeAgo()).isEqualTo("2 months ago")

      assertThat((now() - 1.months).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 1.99.months).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 2.months).timeAgo()).isEqualTo("2 months ago")
    }

    @Test
    fun `about an year`() {
      assertThat((now() - 30.days).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 31.days).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 59.99.days).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 60.days).timeAgo()).isEqualTo("2 months ago")

      assertThat((now() - 1.months).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 1.99.months).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 2.months).timeAgo()).isEqualTo("2 months ago")
      assertThat((now() - 5.months).timeAgo()).isEqualTo("5 months ago")
      assertThat((now() - 10.months).timeAgo()).isEqualTo("10 months ago")
      assertThat((now() - 11.months).timeAgo()).isEqualTo("11 months ago")
      assertThat((now() - 11.99.months).timeAgo()).isEqualTo("11 months ago")
      assertThat((now() - 12.months).timeAgo()).isEqualTo("12 months ago")
      assertThat((now() - 12.99.months).timeAgo()).isEqualTo("about a year ago")

      assertThat((now() - 0.99.years).timeAgo()).isEqualTo("12 months ago")
      assertThat((now() - 1.years).timeAgo()).isEqualTo("about a year ago")
      assertThat((now() - 1.99.years).timeAgo()).isEqualTo("about a year ago")
      assertThat((now() - 2.years).timeAgo()).isEqualTo("2 years ago")
      assertThat((now() - 100.years).timeAgo()).isEqualTo("100 years ago")
    }
  }

  @Nested
  @DisplayName("Types")
  inner class Types {
    @Test
    fun `time ago for long type`() {
      assertThrows<NoSuchMessageException> { nowInMilliseconds().timeAgo(locale = "*") }
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
      assertThat(threeYearsAgo.timeAgo()).isEqualTo("3 years ago")

      assertThat(nowInMilliseconds().timeAgo(locale = "en")).isEqualTo("a moment ago")

      assertThat((now() - 1.seconds).toEpochMilliseconds().timeAgo(clock = nowInMilliseconds()))
        .isEqualTo("a moment ago")
      assertThat(
        nowInMilliseconds().timeAgo(
          clock = (now() - 5.seconds).toEpochMilliseconds(),
          allowFromNow = true
        )
      ).isEqualTo("a moment from now")

      assertThat((now() - 2.years).toEpochMilliseconds().timeAgo()).isEqualTo("2 years ago")

      assertThat(nowInMilliseconds().timeAgo(allowFromNow = true))
        .isEqualTo("a moment ago")
    }

    @Test
    fun `time ago for date type`() {
      assertThrows<NoSuchMessageException> { nowInDate().timeAgo(locale = "*") }
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
      assertThat(threeYearsAgo.timeAgo()).isEqualTo("3 years ago")

      assertThat(nowInDate().timeAgo(locale = "en")).isEqualTo("a moment ago")

      assertThat((nowInDate() - 1.seconds).timeAgo(clock = nowInDate()))
        .isEqualTo("a moment ago")
      assertThat(nowInDate().timeAgo(clock = nowInDate() - 5.seconds, allowFromNow = true))
        .isEqualTo("a moment from now")

      assertThat((nowInDate() - 2.years).timeAgo()).isEqualTo("2 years ago")

      assertThat(nowInDate().timeAgo(allowFromNow = true))
        .isEqualTo("a moment ago")
    }

    @Test
    fun `time ago for calendar type`() {
      assertThrows<NoSuchMessageException> { nowInCalendar().timeAgo(locale = "*") }
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
      assertThat(threeYearsAgo.timeAgo()).isEqualTo("3 years ago")

      assertThat(nowInCalendar().timeAgo(locale = "en")).isEqualTo("a moment ago")

      assertThat((nowInCalendar() - 1.seconds).timeAgo(clock = nowInCalendar()))
        .isEqualTo("a moment ago")
      assertThat(nowInCalendar().timeAgo(clock = nowInCalendar() - 5.seconds, allowFromNow = true))
        .isEqualTo("a moment from now")

      assertThat((nowInCalendar() - 2.years).timeAgo()).isEqualTo("2 years ago")

      assertThat(nowInCalendar().timeAgo(allowFromNow = true))
        .isEqualTo("a moment ago")
    }

    @Test
    fun `time ago for instant type`() {
      assertThrows<NoSuchMessageException> { now().timeAgo(locale = "*") }
      assertThat(TimeAgo.format(now())).isEqualTo("a moment ago")

      assertThat(now().timeAgo()).isEqualTo("a moment ago")
      assertThat((now() - 1.minutes).timeAgo()).isEqualTo("a minute ago")
      assertThat((now() - 5.minutes).timeAgo()).isEqualTo("5 minutes ago")
      assertThat((now() - 1.hours).timeAgo()).isEqualTo("about an hour ago")
      assertThat((now() - 4.hours).timeAgo()).isEqualTo("4 hours ago")
      assertThat((now() - 1.days).timeAgo()).isEqualTo("a day ago")
      assertThat((now() - 7.days).timeAgo()).isEqualTo("7 days ago")
      assertThat((now() - 7.days).timeAgo("ar")).isEqualTo("منذ 7 ايام")
      assertThat((now() - 1.months).timeAgo()).isEqualTo("about a month ago")
      assertThat((now() - 10.months).timeAgo()).isEqualTo("10 months ago")
      assertThat((now() - 1.years).timeAgo()).isEqualTo("about a year ago")
      val threeYearsAgo = (now() - 3.years)
      assertThat(threeYearsAgo.timeAgo()).isEqualTo("3 years ago")

      assertThat(now().timeAgo(locale = "en")).isEqualTo("a moment ago")

      assertThat((now() - 1.seconds).timeAgo(clock = now()))
        .isEqualTo("a moment ago")
      assertThat(now().timeAgo(clock = now() - 5.seconds, allowFromNow = true))
        .isEqualTo("a moment from now")

      assertThat((now() - 2.years).timeAgo()).isEqualTo("2 years ago")

      assertThat(now().timeAgo(allowFromNow = true))
        .isEqualTo("a moment ago")
    }

    @Test
    fun `time ago for local date time type`() {
      assertThrows<NoSuchMessageException> { nowInLocalDateTime().timeAgo(locale = "*") }
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
      assertThat(threeYearsAgo.timeAgo()).isEqualTo("3 years ago")

      assertThat(nowInLocalDateTime().timeAgo(locale = "en")).isEqualTo("a moment ago")

      assertThat((nowInLocalDateTime() - 1.seconds).timeAgo(clock = nowInLocalDateTime()))
        .isEqualTo("a moment ago")
      assertThat(
        nowInLocalDateTime().timeAgo(
          clock = nowInLocalDateTime() - 5.seconds,
          allowFromNow = true
        )
      ).isEqualTo("a moment from now")

      assertThat((nowInLocalDateTime() - 2.years).timeAgo()).isEqualTo("2 years ago")

      assertThat(nowInLocalDateTime().timeAgo(allowFromNow = true))
        .isEqualTo("a moment ago")
    }
  }

  @Test
  fun `12 hours`() {
    val date1 = LocalDateTime(2022, 8, 11, 12, 0, 0)
    val date2 = LocalDateTime(2022, 8, 12, 0, 0, 0)
    assertThat(date1.timeAgo(clock = date2)).isEqualTo("12 hours ago")
  }

  @Test
  fun `min cut off`() {
    var date = now() - 2.years
    assertThat(date.timeAgo(locale = "en_detail", minCutOff = DateLimitation.Year).also(::println))
      .isEqualTo(date.format("MMM dd, yyyy"))

    date = now() - 1.days
    assertThat(date.timeAgo(locale = "en_detail", minCutOff = DateLimitation.Year).also(::println))
      .isEqualTo("a day ago")

    date = now() - 1.months
    assertThat(date.timeAgo(locale = "en_detail", minCutOff = DateLimitation.Month).also(::println))
      .isEqualTo(date.format("MMM dd"))

    date = now() - 2.months
    assertThat(date.timeAgo(locale = "en_detail", minCutOff = DateLimitation.Month).also(::println))
      .isEqualTo(date.format("MMM dd"))

    date = now() - 1.years
    assertThat(date.timeAgo(locale = "en_detail", minCutOff = DateLimitation.Month).also(::println))
      .isEqualTo(date.format("MMM dd, yyyy"))
  }

  @Test
  fun remind() {
    var date = now() - 2.years - 2.months
    assertThat(date.timeAgo(locale = "en_short_detail").also(::println)).isEqualTo("2y 2m")

    date = now() - 265.days
    assertThat(date.timeAgo(locale = "en_short_detail").also(::println)).isEqualTo("8mo 25d")

    date = now() - 2.days - 8.hours
    assertThat(date.timeAgo(locale = "en_short_detail").also(::println)).isEqualTo("2d 8h")

    date = now() - 2.hours - 45.minutes
    assertThat(date.timeAgo(locale = "en_short_detail").also(::println)).isEqualTo("2h 45m")

    date = now() - 5.minutes - 23.seconds
    assertThat(date.timeAgo(locale = "en_short_detail").also(::println)).isEqualTo("5m 23s")

    date = now() - 2.days
    assertThat(date.timeAgo(locale = "en_short_detail", isWeekFormatEnabled = true).also(::println))
      .isEqualTo("2d")

    date = now() - 3.days
    assertThat(date.timeAgo(locale = "en_short_detail", isWeekFormatEnabled = true).also(::println))
      .isEqualTo("3d")

    date = now() - 4.days
    assertThat(date.timeAgo(locale = "en_short_detail", isWeekFormatEnabled = true).also(::println))
      .isEqualTo("4d")

    date = now() - 5.days
    assertThat(date.timeAgo(locale = "en_short_detail", isWeekFormatEnabled = true).also(::println))
      .isEqualTo("5d")

    date = now() - 6.days
    assertThat(date.timeAgo(locale = "en_short_detail", isWeekFormatEnabled = true).also(::println))
      .isEqualTo("6d")

    date = now() - 7.days
    assertThat(date.timeAgo(locale = "en_short_detail", isWeekFormatEnabled = true).also(::println))
      .isEqualTo("1w")

    date = now() - 8.days
    assertThat(date.timeAgo(locale = "en_short_detail", isWeekFormatEnabled = true).also(::println))
      .isEqualTo("1w 1d")

    date = now() - 29.days
    assertThat(date.timeAgo(locale = "en_short_detail", isWeekFormatEnabled = true).also(::println))
      .isEqualTo("4w 1d")
  }

  companion object {
    private val languages = listOf(
      "am", "ar", "az", "bs", "ca", "cs", "da", "de", "dv", "en", "es", "et", "fa", "fi", "fr",
      "gr", "he", "hi", "hu", "it", "km", "ku", "mn", "ms_my", "my", "nb_no", "nl", "pt_br",
      "ru", "rw", "sv", "uk", "ur", "vi", "nn_no", "ro", "th"
    )

    @JvmStatic
    @BeforeAll
    fun init() {
      assertThrows<NoSuchMessageException> {
        TimeAgo.setLocaleMessages("*")
      }
      for (lang in languages) {
        TimeAgo.setLocaleMessages(lang)
        TimeAgo.setLocaleMessages(lang + "_short")
        println(lang + "_short")
      }
      TimeAgo.setLocaleMessages(
        "id", "ja", "ko", "pl", "ta", "tk", "tr", "zh_cn", "zh"
      )
      TimeAgo.setLocaleMessages("en_short_detail")
      TimeAgo.setLocaleMessages("en_detail")

      TimeAgo.setLocaleMessagesAndDefaultLocale(
        locale = "custom",
        object : LookupMessages {
          override fun lessThanOneMinute(seconds: Int, dateInMillis: Long): String = ""
          override fun aboutAMinute(minutes: Int, dateInMillis: Long): String = ""
          override fun minutes(minutes: Int, seconds: Int, dateInMillis: Long): String = ""
          override fun aboutAnHour(minutes: Int, dateInMillis: Long): String = ""
          override fun hours(hours: Int, minutes: Int, dateInMillis: Long): String = ""
          override fun aDay(hours: Int, dateInMillis: Long): String = ""
          override fun days(days: Int, hours: Int, dateInMillis: Long): String = ""
          override fun aboutAMonth(days: Int, dateInMillis: Long): String = ""
          override fun months(months: Int, days: Int, dateInMillis: Long): String = ""
          override fun aboutAYear(year: Int, dateInMillis: Long): String = ""
          override fun years(years: Int, months: Int, dateInMillis: Long): String = ""
        }
      )
      TimeAgo.setLocaleMessagesAndDefaultLocale("en")
      TimeAgo.setDefaultLocale("en")
    }
  }
}
