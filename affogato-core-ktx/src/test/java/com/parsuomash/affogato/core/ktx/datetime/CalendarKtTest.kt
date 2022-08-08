package com.parsuomash.affogato.core.ktx.datetime

import com.google.common.truth.Truth.assertThat
import java.util.*
import kotlin.time.Duration.Companion.days
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CalendarKtTest {
  private val calendar = Calendar.getInstance()

  @Nested
  @DisplayName("Getter")
  inner class Getter {
    @Test
    @DisplayName("get")
    fun get() {
      assertThat(calendar[Calendar.YEAR]).isEqualTo(calendar.get(Calendar.YEAR))
      assertThat(calendar[Calendar.MONTH]).isEqualTo(calendar.get(Calendar.MONTH))
      assertThat(calendar[Calendar.DAY_OF_MONTH]).isEqualTo(calendar.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    @DisplayName("get year")
    fun getYear() {
      assertThat(calendar.year).isEqualTo(calendar.get(Calendar.YEAR))
    }

    @Test
    @DisplayName("get month")
    fun getMonth() {
      assertThat(calendar.month).isEqualTo(calendar.get(Calendar.MONTH))
    }

    @Test
    @DisplayName("get dayOfYear")
    fun getDayOfYear() {
      assertThat(calendar.dayOfYear).isEqualTo(calendar.get(Calendar.DAY_OF_YEAR))
    }

    @Test
    @DisplayName("get dayOfMonth")
    fun getDayOfMonth() {
      assertThat(calendar.dayOfMonth).isEqualTo(calendar.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    @DisplayName("get dayOfWeek")
    fun getDayOfWeek() {
      assertThat(calendar.dayOfWeek).isEqualTo(calendar.get(Calendar.DAY_OF_WEEK))
    }

    @Test
    @DisplayName("get dayOfWeekInMonth")
    fun getDayOfWeekInMonth() {
      assertThat(calendar.dayOfWeekInMonth).isEqualTo(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH))
    }

    @Test
    @DisplayName("get hour")
    fun getHour() {
      assertThat(calendar.hour).isEqualTo(calendar.get(Calendar.HOUR))
    }

    @Test
    @DisplayName("get hourOfDay")
    fun getHourOfDay() {
      assertThat(calendar.hourOfDay).isEqualTo(calendar.get(Calendar.HOUR_OF_DAY))
    }

    @Test
    @DisplayName("get minute")
    fun getMinute() {
      assertThat(calendar.minute).isEqualTo(calendar.get(Calendar.MINUTE))
    }

    @Test
    @DisplayName("get second")
    fun getSecond() {
      assertThat(calendar.second).isEqualTo(calendar.get(Calendar.SECOND))
    }

    @Test
    @DisplayName("get millisecond")
    fun getMillisecond() {
      assertThat(calendar.millisecond).isEqualTo(calendar.get(Calendar.MILLISECOND))
    }

    @Test
    @DisplayName("get weekOfYear")
    fun getWeekOfYear() {
      assertThat(calendar.weekOfYear).isEqualTo(calendar.get(Calendar.WEEK_OF_YEAR))
    }

    @Test
    @DisplayName("get weekOfMonth")
    fun getWeekOfMonth() {
      assertThat(calendar.weekOfMonth).isEqualTo(calendar.get(Calendar.WEEK_OF_MONTH))
    }
  }

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("Long as Calendar")
    fun longAsCalendar() {
      val calendar = Calendar.getInstance().apply { time = Date(1_659_814_200_000) }
      assertThat(1_659_814_200_000.asCalendar).isEqualTo(calendar)
    }

    @Test
    @DisplayName("Duration as Calendar")
    fun durationAsCalendar() {
      val calendar = Calendar.getInstance().apply { time = Date(1.days.inWholeMilliseconds) }
      assertThat(1.days.asCalendar).isEqualTo(calendar)
    }

    @Test
    @DisplayName("Calendar as Date")
    fun calendarAsDate() {
      assertThat(calendar.asDate).isEqualTo(calendar.time)
    }

    @Test
    @DisplayName("Calendar as LocalDate")
    fun calendarAsLocalDate() {
      assertThat(calendar.asLocalDate)
        .isEqualTo(LocalDate(calendar.year, calendar.month + 1, calendar.dayOfMonth))
    }

    @Test
    @DisplayName("Calendar as LocalTime")
    fun calendarAsLocalTime() {
      assertThat(calendar.asLocalTime)
        .isEqualTo(LocalTime(calendar.hourOfDay, calendar.minute, calendar.second))
    }

    @Test
    @DisplayName("Calendar as LocalDateTime")
    fun calendarAsLocalDateTime() {
      assertThat(calendar.asLocalDateTime).isEqualTo(
        LocalDateTime(
          calendar.year,
          calendar.month + 1,
          calendar.dayOfMonth,
          calendar.hour,
          calendar.minute,
          calendar.second
        )
      )
    }
  }

  @Nested
  @DisplayName("Formatter")
  inner class Formatter {
    @Test
    @DisplayName("String to Calender")
    fun stringToCalendar() {
      assertThat("2020-01-01".toCalendar("yyyy-MM-dd"))
        .isEqualTo("2020-01-01".toDate("yyyy-MM-dd").asCalendar)
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toCalendar())
        .isEqualTo(1_659_874_062_000.asCalendar)
    }

    @Test
    @DisplayName("String to Calender or null")
    fun stringToCalendarOrNull() {
      assertThat("-01-01".toCalendarOrNull("yyyy-dd-mm")).isNull()
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toCalendarOrNull())
        .isEqualTo(1_659_874_062_000.asCalendar)
    }

    @Test
    @DisplayName("Calendar to String")
    fun calendarToString() {
      assertThat(calendar.toString("yyyy")).isEqualTo(LocalDate.now().year.toString())
    }
  }

  @Test
  @DisplayName("is same day")
  fun isSameDay() {
    val calendar = Calendar.getInstance().apply { time = Date() }
    val calendar2 = Calendar.getInstance().apply { time = Date() }
    assertThat(calendar isSameDay calendar2).isTrue()
  }
}
