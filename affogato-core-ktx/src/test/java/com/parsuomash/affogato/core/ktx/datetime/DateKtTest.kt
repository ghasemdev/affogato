package com.parsuomash.affogato.core.ktx.datetime

import com.google.common.truth.Truth.assertThat
import java.text.ParseException
import java.util.*
import kotlin.time.Duration.Companion.days
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DateKtTest {
  private val date = Date()
  private val calendar = Calendar.getInstance()

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("Long as Date")
    fun longAsDate() {
      assertThat(1_659_873_010_453.toDate()).isEqualTo(Date(1_659_873_010_453))
      assertThat(date.time.toDate()).isEqualTo(date)
    }

    @Test
    @DisplayName("Duration as Date")
    fun durationAsDate() {
      assertThat(1.days.toDate()).isEqualTo(1.days.inWholeMilliseconds.toDate().also(::println))
    }

    @Test
    @DisplayName("Date as localDate")
    fun dateAsLocalDate() {
      val date = calendar.time
      with(calendar) {
        assertThat(date.toLocalDate()).isEqualTo(LocalDate(year, month + 1, dayOfMonth))
      }
    }

    @Test
    @DisplayName("Date as LocalTime")
    fun dateAsLocalTime() {
      val date = calendar.time
      with(calendar) {
        assertThat(date.toLocalTime()).isEqualTo(LocalTime(hourOfDay, minute, second))
      }
    }

    @Test
    @DisplayName("Date as localDateTime")
    fun dateAsLocalDateTime() {
      val date = calendar.time
      with(calendar) {
        assertThat(date.toLocalDateTime())
          .isEqualTo(LocalDateTime(year, month + 1, dayOfMonth, hourOfDay, minute, second))
      }
    }

    @Test
    @DisplayName("Date as Calendar")
    fun dateAsCalendar() {
      assertThat(date.toCalendar()).isInstanceOf(Calendar::class.java)
      val calendar = Calendar.getInstance().apply { time = date }
      assertThat(date.toCalendar()).isEqualTo(calendar)
    }

    @Test
    @DisplayName("String to Date")
    fun stringToDate() {
      assertThat("8/7/2022".toDate("MM/dd/yyyy"))
        .isEqualTo(1_659_814_200_000.toDate().also(::println))
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toDate())
        .isEqualTo(1_659_874_062_000.toDate().also(::println))
      assertThrows<ParseException> { "7/2022".toDate("MM/dd/yyyy") }
    }

    @Test
    @DisplayName("String to Date or Null")
    fun stringToDateOrNull() {
      assertThat("8/7/2022".toDateOrNull("MM/dd/yyyy"))
        .isEqualTo(1_659_814_200_000.toDate())
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toDateOrNull())
        .isEqualTo(1_659_874_062_000.toDate())
      assertThat("7/2022".toDateOrNull("MM/dd/yyyy")).isNull()
    }

    @Test
    @DisplayName("Date to String")
    fun dateToString() {
      assertThat(1_659_814_200_000.toDate().toString("MM/dd/yyyy")).isEqualTo("08/07/2022")
      assertThat(1_659_874_062_000.toDate().toString("EEE MMM dd HH:mm:ss zzz yyyy"))
        .isEqualTo("Sun Aug 07 16:37:42 IRDT 2022")

      assertThat(1_659_814_200_000.toDate().format("MM/dd/yyyy")).isEqualTo("08/07/2022")
      assertThat(1_659_874_062_000.toDate().format("EEE MMM dd HH:mm:ss zzz yyyy"))
        .isEqualTo("Sun Aug 07 16:37:42 IRDT 2022")
    }
  }

  @Nested
  @DisplayName("Operations")
  inner class Operations {
    @Test
    fun plusDate() {
      assertThat((date + date).time).isEqualTo(date.time * 2)
      assertThat((date + 1.days).time).isEqualTo(date.time + 1.days.inWholeMilliseconds)
    }

    @Test
    fun minusDate() {
      assertThat((date - date).time).isEqualTo(0)
      assertThat((date - 1.days).time).isEqualTo(date.time - 1.days.inWholeMilliseconds)
    }

    @Test
    fun isSameDay() {
      val date1 = Date()
      val date2 = Date()
      assertThat(date1 isSameDay date2).isTrue()
    }
  }

  @Test
  fun convertDate() {
    val format = "yyyy-MM-dd HH:mm:ss"
    val stringDate = date.format(format)
    val formatDate = stringDate.toDate(format)

    assertThat(stringDate).isEqualTo(formatDate.format(format))
    assertThat(formatDate).isEqualTo(stringDate.toDate(format))
  }
}
