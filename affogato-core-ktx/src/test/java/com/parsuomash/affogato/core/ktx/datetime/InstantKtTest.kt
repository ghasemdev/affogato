package com.parsuomash.affogato.core.ktx.datetime

import com.google.common.truth.Truth.assertThat
import com.parsuomash.affogato.core.ktx.time.now
import java.text.ParseException
import java.util.*
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toKotlinInstant
import kotlinx.datetime.toLocalDateTime
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class InstantKtTest {
  private val date = Date()
  private val timeZone = TimeZone.currentSystemDefault()

  @Test
  @DisplayName("Long to Instant")
  fun longToInstant() {
    assertThat(1_659_814_200_000.toInstant().also(::println))
      .isEqualTo(Instant.fromEpochMilliseconds(1_659_814_200_000))
    assertThat(date.time.toInstant()).isEqualTo(date.toInstant().toKotlinInstant())
  }

  @Test
  @DisplayName("Instant to Date")
  fun instantToDate() {
    val date = now()
    assertThat(date.toDate()).isEqualTo(Date(date.toEpochMilliseconds()))
  }

  @Test
  @DisplayName("Instant to localDate")
  fun instantToLocalDate() {
    val date = now()
    assertThat(date.toLocalDate(timeZone)).isEqualTo(date.toLocalDateTime(timeZone).date)
    assertThat(date.toLocalDate()).isEqualTo(date.toLocalDateTime(timeZone).date)
  }

  @Test
  @DisplayName("Instant to localTime")
  fun instantToLocalTime() {
    val date = now()
    assertThat(date.toLocalTime(timeZone)).isEqualTo(date.toLocalDateTime(timeZone).time)
    assertThat(date.toLocalTime()).isEqualTo(date.toLocalDateTime(timeZone).time)
  }

  @Test
  @DisplayName("Instant to Calendar")
  fun instantToCalendar() {
    val date = now()
    assertThat(date.toCalendar())
      .isEqualTo(Calendar.getInstance().apply { time = Date(date.toEpochMilliseconds()) })
  }

  @Test
  @DisplayName("String to Instant")
  fun stringToInstant() {
    assertThat("8/7/2022".toInstant("MM/dd/yyyy").also(::println))
      .isEqualTo(1_659_814_200_000.toInstant())
    assertThat("Sun Aug 07 16:37:42 IRDT 2022".toInstant().also(::println))
      .isEqualTo(1_659_874_062_000.toInstant())
    assertThrows<ParseException> { "7/2022".toInstant("MM/dd/yyyy") }
  }

  @Test
  @DisplayName("String to Instant or Null")
  fun stringToInstantOrNull() {
    assertThat("8/7/2022".toInstantOrNull("MM/dd/yyyy"))
      .isEqualTo(1_659_814_200_000.toInstant())
    assertThat("Sun Aug 07 16:37:42 IRDT 2022".toInstantOrNull())
      .isEqualTo(1_659_874_062_000.toInstant())
    assertThat("7/2022".toInstantOrNull("MM/dd/yyyy")).isNull()
  }

  @Test
  @DisplayName("Instant to String")
  fun localDateToString() {
    assertThat(1_659_814_200_000.toInstant().toString("MM/dd/yyyy")).isEqualTo("08/07/2022")
    assertThat(1_659_874_062_000.toInstant().toString("EEE MMM dd HH:mm:ss zzz yyyy"))
      .isEqualTo("Sun Aug 07 16:37:42 IRDT 2022")

    assertThat(1_659_814_200_000.toInstant().format("MM/dd/yyyy")).isEqualTo("08/07/2022")
    assertThat(1_659_874_062_000.toInstant().format("EEE MMM dd HH:mm:ss zzz yyyy"))
      .isEqualTo("Sun Aug 07 16:37:42 IRDT 2022")
  }

  @Test
  @DisplayName("is same day")
  fun isSameDay() {
    assertThat(now() isSameDay now()).isTrue()
  }
}
