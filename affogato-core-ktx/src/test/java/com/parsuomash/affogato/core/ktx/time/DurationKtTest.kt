package com.parsuomash.affogato.core.ktx.time

import com.google.common.truth.Truth.assertThat
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DurationKtTest {
  @Test
  @DisplayName("week")
  fun week() {
    assertThat(1.weeks).isEqualTo(7.days)
    assertThat(2.weeks).isEqualTo(14.days)

    assertThat(1L.weeks).isEqualTo(7.days)
    assertThat(2L.weeks).isEqualTo(14.days)

    assertThat(1.5.weeks).isEqualTo(10.days + 12.hours)
    assertThat(2.5.weeks).isEqualTo(17.days + 12.hours)
  }

  @Test
  @DisplayName("month")
  fun month() {
    assertThat(1.months).isEqualTo(30.days)
    assertThat(2.months).isEqualTo(60.days)

    assertThat(1L.months).isEqualTo(30.days)
    assertThat(2L.months).isEqualTo(60.days)

    assertThat(1.5.months).isEqualTo(45.days)
    assertThat(2.5.months).isEqualTo(75.days)
  }

  @Test
  @DisplayName("year")
  fun year() {
    assertThat(1.years).isEqualTo(365.days)
    assertThat(2.years).isEqualTo(730.days)

    assertThat(1L.years).isEqualTo(365.days)
    assertThat(2L.years).isEqualTo(730.days)

    assertThat(1.5.years).isEqualTo(547.days + 12.hours)
    assertThat(2.5.years).isEqualTo(912.days + 12.hours)
  }
}
