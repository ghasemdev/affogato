package com.parsuomash.affogato.core.ktx.datetime

import com.google.common.truth.Truth.assertThat
import com.parsuomash.affogato.core.ktx.time.nowInLocalDateTime
import java.text.ParseException
import java.util.*
import kotlin.time.Duration.Companion.days
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.datetime.toKotlinLocalDateTime
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LocalDateTimeKtTest {
  private val date = Date()
  private val now = nowInLocalDateTime()

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("Long as LocalDateTime")
    fun longAsLocalDateTime() {
      assertThat(1_659_814_200_000.toLocalDateTime().also(::println))
        .isEqualTo(LocalDateTime(2022, 8, 7, 0, 0, 0))
      assertThat(date.time.toLocalDateTime()).isEqualTo(date.toLocalDateTime())
    }

    @Test
    @DisplayName("LocalDateTime as Date")
    fun localDateTimeAsDate() {
      val date = LocalDateTime(2020, 1, 2, 3, 4, 5)
      val calendar = Calendar.getInstance().apply {
        set(2020, 0, 2, 3, 4, 5)
        set(Calendar.MILLISECOND, 0)
      }
      assertThat(date.toDate()).isEqualTo(calendar.time)
    }

    @Test
    @DisplayName("LocalDateTime as localDate")
    fun localDateTimeAsLocalDate() {
      val date = LocalDateTime(2020, 1, 2, 8, 0, 0)
      val local = LocalDate(2020, 1, 2)
      assertThat(date.toLocalDate()).isEqualTo(local)
    }

    @Test
    @DisplayName("LocalDateTime as LocalTime")
    fun localDateTimeAsLocalTime() {
      val date = LocalDateTime(2020, 1, 2, 8, 0, 0)
      val local = LocalTime(8, 0, 0)
      assertThat(date.toLocalTime()).isEqualTo(local)
    }

    @Test
    @DisplayName("LocalDateTime as Calendar")
    fun localDateTimeAsCalendar() {
      val date = LocalDateTime(2020, 1, 2, 0, 10, 0)
      val calendar = Calendar.getInstance().apply {
        set(2020, 0, 2, 0, 10, 0)
        set(Calendar.MILLISECOND, 0)
      }
      assertThat(date.toCalendar()).isEqualTo(calendar)
    }

    @Test
    @DisplayName("String to LocalDateTime")
    fun stringToLocalDateTime() {
      assertThat("08/07/2022 13".toLocalDateTime("MM/dd/yyyy HH").also(::println))
        .isEqualTo(LocalDateTime(2022, 8, 7, 13, 0, 0))
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toLocalDateTime())
        .isEqualTo(LocalDateTime(2022, 8, 7, 16, 37, 42))
      assertThrows<ParseException> { "7/2022".toLocalDateTime("MM/dd/yyyy") }
    }

    @Test
    @DisplayName("String to LocalDateTime or Null")
    fun stringToLocalDateTimeOrNull() {
      assertThat("08/07/2022 13".toLocalDateTimeOrNull("MM/dd/yyyy HH").also(::println))
        .isEqualTo(LocalDateTime(2022, 8, 7, 13, 0, 0))
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toLocalDateTimeOrNull().also(::println))
        .isEqualTo(LocalDateTime(2022, 8, 7, 16, 37, 42))
      assertThat("7/2022".toLocalDateTimeOrNull("MM/dd/yyyy")).isNull()
    }

    @Test
    @DisplayName("LocalDateTime to String")
    fun localDateTimeToString() {
      assertThat(1_659_814_205_950.toLocalDateTime().format("MM/dd/yyyy"))
        .isEqualTo("08/07/2022")
      assertThat(1_659_814_205_950.toLocalDateTime().format("EEE MMM dd HH:mm:ss zzz yyyy"))
        .isEqualTo("Sun Aug 07 00:00:05 IRDT 2022")
    }
  }

  @Nested
  @DisplayName("Operations")
  inner class Operations {
    @Test
    fun plusLocalDate() {
      assertThat(now + 1.days).isEqualTo(
        now.toJavaLocalDateTime().plusNanos(1.days.inWholeNanoseconds).toKotlinLocalDateTime()
      )
    }

    @Test
    fun minusLocalDate() {
      assertThat(now - 1.days).isEqualTo(
        now.toJavaLocalDateTime().minusNanos(1.days.inWholeNanoseconds).toKotlinLocalDateTime()
      )
    }

    @Test
    fun isSameDay() {
      val date = LocalDateTime(2020, 1, 2, 8, 0, 0)
      val date2 = LocalDateTime(2020, 1, 2, 7, 0, 0)
      assertThat(date isSameDay date2).isTrue()
    }
  }

  @Test
  @DisplayName("now")
  fun now() {
    LocalDateTime.now()
    LocalDateTime.now(TimeZone.currentSystemDefault())
  }
}
