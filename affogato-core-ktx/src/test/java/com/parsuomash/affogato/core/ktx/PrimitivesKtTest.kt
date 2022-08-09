package com.parsuomash.affogato.core.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class PrimitivesKtTest {
  @Test
  fun `or zero on null values`() {
    val int: Int? = null
    assertThat(int.orZero()).isEqualTo(0)

    val long: Long? = null
    assertThat(long.orZero()).isEqualTo(0L)

    val float: Float? = null
    assertThat(float.orZero()).isEqualTo(0F)

    val double: Double? = null
    assertThat(double.orZero()).isEqualTo(0.0)
  }

  @Test
  fun `or zero on non-null values`() {
    val int = 1
    assertThat(int.orZero()).isEqualTo(1)

    val long = 1L
    assertThat(long.orZero()).isEqualTo(1L)

    val float = 4.2F
    assertThat(float.orZero()).isEqualTo(4.2F)

    val double = 5.0
    assertThat(double.orZero()).isEqualTo(5.0)
  }

  @Test
  fun `checking negativity`() {
    assertThat(1.isNegative).isFalse()
    assertThat((-1).isNegative).isTrue()

    assertThat(1L.isNegative).isFalse()
    assertThat((-1L).isNegative).isTrue()

    assertThat(1F.isNegative).isFalse()
    assertThat((-1F).isNegative).isTrue()

    assertThat(1.0.isNegative).isFalse()
    assertThat((-1.0).isNegative).isTrue()
  }
}
