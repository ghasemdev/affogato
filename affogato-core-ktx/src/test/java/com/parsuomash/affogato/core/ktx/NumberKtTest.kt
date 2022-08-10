package com.parsuomash.affogato.core.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class NumberKtTest {
  @Test
  fun `or zero on null values`() {
    val int: Number? = null
    assertThat(int.orZero()).isEqualTo(0)
  }

  @Test
  fun `or zero on non-null values`() {
    val int: Number = 1
    assertThat(int.orZero()).isEqualTo(1)
  }
}
