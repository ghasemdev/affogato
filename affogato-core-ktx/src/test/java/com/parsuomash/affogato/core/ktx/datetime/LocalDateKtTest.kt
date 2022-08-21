package com.parsuomash.affogato.core.ktx.datetime

import com.google.common.truth.Truth.assertThat
import java.text.ParseException
import java.util.*
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LocalDateKtTest {
  private val date = Date()
  private val now = LocalDate.now()

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("Long as LocalDate")
    fun longAsLocalDate() {
      assertThat(1_659_814_200_000.toLocalDate().also(::println)).isEqualTo(LocalDate(2022, 8, 7))
      assertThat(date.time.toLocalDate()).isEqualTo(date.toLocalDate())
    }

    @Test
    @DisplayName("localDate as Date")
    fun localDateAsDate() {
      val date = LocalDate(2020, 1, 2)
      val calendar = Calendar.getInstance().apply {
        set(2020, 0, 2, 0, 0, 0)
        set(Calendar.MILLISECOND, 0)
      }
      assertThat(date.toDate()).isEqualTo(calendar.time)
    }

    @Test
    @DisplayName("localDate as localDateTime")
    fun localDateAsLocalDateTime() {
      val date = LocalDate(2020, 1, 2)
      val local = LocalDateTime(2020, 1, 2, 0, 0)
      assertThat(date.toLocalDateTime()).isEqualTo(local)
    }

    @Test
    @DisplayName("localDate as Calendar")
    fun localDateAsCalendar() {
      val date = LocalDate(2020, 1, 2)
      val calendar = Calendar.getInstance().apply {
        set(2020, 0, 2, 0, 0, 0)
        set(Calendar.MILLISECOND, 0)
      }
      assertThat(date.toCalendar()).isEqualTo(calendar)
    }

    @Test
    @DisplayName("String to LocalDate")
    fun stringToLocalDate() {
      assertThat("8/7/2022".toLocalDate("MM/dd/yyyy"))
        .isEqualTo(1_659_814_200_000.toLocalDate().also(::println))
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toLocalDate())
        .isEqualTo(1_659_874_062_000.toLocalDate().also(::println))
      assertThrows<ParseException> { "7/2022".toLocalDate("MM/dd/yyyy") }
    }

    @Test
    @DisplayName("String to LocalDate or Null")
    fun stringToLocalDateOrNull() {
      assertThat("8/7/2022".toLocalDateOrNull("MM/dd/yyyy"))
        .isEqualTo(1_659_814_200_000.toLocalDate())
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toLocalDateOrNull())
        .isEqualTo(1_659_874_062_000.toLocalDate())
      assertThat("7/2022".toLocalDateOrNull("MM/dd/yyyy")).isNull()
    }

    @Test
    @DisplayName("LocalDate to String")
    fun localDateToString() {
      assertThat(1_659_814_200_000.toLocalDate().toString("MM/dd/yyyy")).isEqualTo("08/07/2022")
      assertThat(1_659_874_062_000.toLocalDate().toString("EEE MMM dd HH:mm:ss zzz yyyy"))
        .isEqualTo("Sun Aug 07 00:00:00 IRDT 2022")

      assertThat(1_659_814_200_000.toLocalDate().format("MM/dd/yyyy")).isEqualTo("08/07/2022")
      assertThat(1_659_874_062_000.toLocalDate().format("EEE MMM dd HH:mm:ss zzz yyyy"))
        .isEqualTo("Sun Aug 07 00:00:00 IRDT 2022")
    }
  }

  @Nested
  @DisplayName("Operations")
  inner class Operations {
    @Test
    fun plusLocalDate() {
      assertThat(now + 1.days).isEqualTo(now.plus(1.days.inWholeDays, DateTimeUnit.DAY))
    }

    @Test
    fun minusLocalDate() {
      assertThat(now - 1.days).isEqualTo(now.minus(1.days.inWholeDays, DateTimeUnit.DAY))
    }

    @Test
    fun isSameDay() {
      assertThat(now isSameDay (now + 5.hours)).isTrue()
    }
  }
}
