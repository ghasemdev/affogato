package com.parsuomash.affogato.core.ktx.datetime

import com.google.common.truth.Truth.assertThat
import com.parsuomash.affogato.core.ktx.time.nowInLocalTime
import java.text.ParseException
import java.util.*
import kotlin.time.Duration.Companion.minutes
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalTime
import kotlinx.datetime.toKotlinLocalTime
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LocalTimeKtTest {
  private val date = Date()
  private val now = nowInLocalTime()

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("Long as LocalTime")
    fun longAsLocalTime() {
      assertThat(1_659_814_200_000.toLocalTime().also(::println)).isEqualTo(LocalTime(0, 0, 0))
      assertThat(date.time.toLocalTime()).isEqualTo(date.toLocalTime())
    }

    @Test
    @DisplayName("LocalTime as Date")
    fun localTimeAsDate() {
      val time = LocalTime(21, 21, 21)
      val calendar = Calendar.getInstance().apply {
        set(0, 0, 0, 21, 21, 21)
        set(Calendar.MILLISECOND, 0)
      }
      assertThat(time.toDate()).isEqualTo(calendar.time)
    }

    @Test
    @DisplayName("LocalTime as Calendar")
    fun localTimeAsCalendar() {
      val time = LocalTime(0, 13, 0)
      val calendar = Calendar.getInstance().apply {
        set(0, 0, 0, 0, 13, 0)
        set(Calendar.MILLISECOND, 0)
      }
      assertThat(time.toCalendar()).isEqualTo(calendar)
    }

    @Test
    @DisplayName("String to LocalTime")
    fun stringToLocalTime() {
      assertThat("21->15->0".toLocalTime("HH->mm->ss"))
        .isEqualTo(LocalTime(21, 15, 0).also(::println))
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toLocalTime())
        .isEqualTo(LocalTime(16, 37, 42).also(::println))
      assertThrows<ParseException> { "21:10:00".toLocalTime("HH::mm") }
    }

    @Test
    @DisplayName("String to LocalTime or Null")
    fun stringToLocalTimeOrNull() {
      assertThat("21->15->0".toLocalTimeOrNull("HH->mm->ss"))
        .isEqualTo(LocalTime(21, 15, 0).also(::println))
      assertThat("Sun Aug 07 16:37:42 IRDT 2022".toLocalTimeOrNull())
        .isEqualTo(LocalTime(16, 37, 42).also(::println))
      assertThat("21:10:00".toLocalTimeOrNull("HH::mm")).isNull()
    }

    @Test
    @DisplayName("LocalTime to String")
    fun localTimeToString() {
      assertThat(LocalTime(11, 10, 0).toString("HH")).isEqualTo("11")
      assertThat(LocalTime(11, 10, 0).format("HH")).isEqualTo("11")
    }
  }

  @Nested
  @DisplayName("Operations")
  inner class Operations {
    @Test
    fun plusLocalDate() {
      assertThat(now + 1.minutes).isEqualTo(
        now.toJavaLocalTime().plusNanos(1.minutes.inWholeNanoseconds).toKotlinLocalTime()
      )
    }

    @Test
    fun minusLocalDate() {
      assertThat(now - 1.minutes).isEqualTo(
        now.toJavaLocalTime().minusNanos(1.minutes.inWholeNanoseconds).toKotlinLocalTime()
      )
    }
  }

  @Test
  @DisplayName("now")
  fun now() {
    LocalTime.now()
    LocalTime.now(TimeZone.currentSystemDefault())
  }
}
