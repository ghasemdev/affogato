package com.parsuomash.affogato.core.ktx

import com.google.common.truth.Truth.assertThat
import java.math.BigDecimal
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class BigDecimalKtTest {
  @Test
  @DisplayName("to BigDecimal")
  fun toBigDecimal() {
    assertThat(1.BD).isEqualTo(BigDecimal.valueOf(1))
    assertThat(1L.BD).isEqualTo(BigDecimal.valueOf(1L))
    assertThat(1.0.BD).isEqualTo(BigDecimal.valueOf(1.0))
    assertThat(1.0f.BD).isEqualTo(BigDecimal.valueOf(1.0))

    assertThat(5.BI.BD).isEqualTo(BigDecimal.valueOf(5))
  }
}
