package com.parsuomash.affogato.core.ktx

import com.google.common.truth.Truth.assertThat
import java.math.BigInteger
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class BigIntegerKtTest {
  @Test
  @DisplayName("to BigInteger")
  fun toBigInteger() {
    assertThat(1.BI).isEqualTo(BigInteger.valueOf(1))
    assertThat(1L.BI).isEqualTo(BigInteger.valueOf(1))
  }
}
