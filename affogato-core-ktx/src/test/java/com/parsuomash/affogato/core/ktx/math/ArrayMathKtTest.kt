package com.parsuomash.affogato.core.ktx.math

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ArrayMathKtTest {
  @Nested
  @DisplayName("Median")
  inner class Median {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1, 5, 3, 9, 0, 4).median()).isEqualTo(Pair(3, 4))
      assertThat(arrayOf(1, 5, 3, 0, 4).median()).isEqualTo(Pair(3, null))
      assertThat(arrayOf("hi", "hello", "f ", "d", "a").median()).isEqualTo(Pair("f ", null))
      assertThrows<IllegalArgumentException> { emptyArray<Float>().median() }
    }
  }

  @Nested
  @DisplayName("Mode")
  inner class Mode {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1, 1, 1, 2, 3, 4, 5, 5, 2).mode()).isEqualTo(listOf(1))
      assertThat(arrayOf(1, 2, 3, 4, 5, 6, 7).mode()).isEqualTo(listOf(1, 2, 3, 4, 5, 6, 7))
      assertThat(arrayOf("a", "a", "a", "b").mode()).isEqualTo(listOf("a"))
      assertThat(emptyArray<Long>().mode()).isEqualTo(listOf<Long>())
    }
  }

  @Nested
  @DisplayName("Std")
  inner class STD {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1, 1, 1, 2, 3, 4, 5, 5, 2).std()).isEqualTo(1.5634719199411433)
      assertThat(arrayOf(1, 2, 3, 4, 5, 6, 7).std()).isEqualTo(2)
      assertThat(emptyArray<Long>().std()).isEqualTo(Double.NaN)
    }
  }

  @Nested
  @DisplayName("Variance")
  inner class Variance {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1, 1, 1, 2, 3, 4, 5, 5, 2).variance()).isEqualTo(2.75)
      assertThat(arrayOf(1, 2, 3, 4, 5, 6, 7).variance()).isEqualTo(4.666666666666667)
      assertThat(emptyArray<Long>().variance()).isEqualTo(Double.NaN)
    }
  }

  @Nested
  @DisplayName("Power")
  inner class Power {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1, 2, 3, 4, 5) pow 2).isEqualTo(arrayOf(1.0, 4.0, 9.0, 16.0, 25.0))
      assertThat(2 pow arrayOf(1, 2, 3, 4, 5)).isEqualTo(arrayOf(2.0, 4.0, 8.0, 16.0, 32.0))
    }
  }

  @Nested
  @DisplayName("Logaritm")
  inner class Logaritm {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(10, 100, 1_000, 10_000) log 10)
        .isEqualTo(arrayOf(1.0, 2.0, 2.9999999999999996, 4.0))
      assertThat(1_000 log arrayOf(1_000, 100, 10))
        .isEqualTo(arrayOf(1.0, 1.4999999999999998, 2.9999999999999996))
    }
  }

  @Nested
  @DisplayName("Log10")
  inner class Log10 {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(10, 100, 1_000, 10_000).log10())
        .isEqualTo(arrayOf(1.0, 2.0, 3.0, 4.0))
      assertThat(arrayOf(1_000, 100, 10).log10())
        .isEqualTo(arrayOf(3.0, 2.0, 1.0))
    }
  }

  @Nested
  @DisplayName("Log2")
  inner class Log2 {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(2, 4, 8, 16).log2())
        .isEqualTo(arrayOf(1.0, 2.0, 3.0, 4.0))
      assertThat(arrayOf(16, 8, 4).log2())
        .isEqualTo(arrayOf(4.0, 3.0, 2.0))
    }
  }

  @Nested
  @DisplayName("Ln")
  inner class Ln {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(10, 100, 1_000, 10_000).ln())
        .isEqualTo(
          arrayOf(
            2.302585092994046,
            4.605170185988092,
            6.907755278982137,
            9.210340371976184
          )
        )
      assertThat(arrayOf(1_000, 100, 10).ln())
        .isEqualTo(arrayOf(6.907755278982137, 4.605170185988092, 2.302585092994046))
    }
  }

  @Nested
  @DisplayName("Round")
  inner class Round {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(3.1622776601683795, 10.0, 31.622776601683793, 100.0).round())
        .isEqualTo(arrayOf(3.0, 10.0, 32.0, 100.0))
      assertThat(arrayOf(31.622776601683793, 10.0, 3.1622776601683795).round())
        .isEqualTo(arrayOf(32.0, 10.0, 3.0))
      assertThat(arrayOf(2.6F, 1.999F, 21.0006F).round())
        .isEqualTo(arrayOf(3F, 2F, 21F))
    }
  }

  @Nested
  @DisplayName("Sqrt")
  inner class Sqrt {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(10, 100, 1_000, 10_000).sqrt())
        .isEqualTo(arrayOf(3.1622776601683795, 10.0, 31.622776601683793, 100.0))
      assertThat(arrayOf(1_000, 100, 10).sqrt())
        .isEqualTo(arrayOf(31.622776601683793, 10.0, 3.1622776601683795))
    }
  }

  @Nested
  @DisplayName("Abs")
  inner class Abs {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(-1, 2, 0, -6).abs()).isEqualTo(arrayOf(1, 2, 0, 6))
      assertThat(arrayOf(-1F, 2F, 0F, -6F).abs()).isEqualTo(arrayOf(1F, 2F, 0F, 6F))
      assertThat(arrayOf(-1.0, 2.0, 0.0, -6.0).abs()).isEqualTo(arrayOf(1.0, 2.0, 0.0, 6.0))
      assertThat(arrayOf(-1L, 2L, 0L, -6L).abs()).isEqualTo(arrayOf(1L, 2L, 0L, 6L))
    }
  }

  @Nested
  @DisplayName("Ceil")
  inner class Ceil {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1.1, 1.4999999999999998, 2.9999999999999996, 2.6).ceil())
        .isEqualTo(arrayOf(2.0, 2.0, 3.0, 3.0))
      assertThat(arrayOf(1.1F, 1.49F, 2.99F, 2.6F).ceil())
        .isEqualTo(arrayOf(2.0, 2.0, 3.0, 3.0))
    }
  }

  @Nested
  @DisplayName("Floor")
  inner class Floor {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1.1, 1.4999999999999998, 2.9999999999999996, 2.6).floor())
        .isEqualTo(arrayOf(1.0, 1.0, 2.0, 2.0))
      assertThat(arrayOf(1.1F, 1.49F, 2.99F, 2.6F).floor())
        .isEqualTo(arrayOf(1.0, 1.0, 2.0, 2.0))
    }
  }

  @Nested
  @DisplayName("Sign")
  inner class Sign {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(-1F, 2F, 0F, -6F).sign()).isEqualTo(arrayOf(-1.0, 1.0, 0.0, -1.0))
      assertThat(arrayOf(-1.0, 2.0, 0.0, -6.0).sign()).isEqualTo(arrayOf(-1.0, 1.0, 0.0, -1.0))
    }
  }

  @Nested
  @DisplayName("Exp")
  inner class Exp {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1, 2, 3, 4).exp())
        .isEqualTo(
          arrayOf(
            2.718281828459045,
            7.38905609893065,
            20.085536923187668,
            54.598150033144236
          )
        )
    }
  }

  @Nested
  @DisplayName("Truncate")
  inner class Truncate {
    @Test
    @DisplayName("Array")
    fun array() {
      assertThat(arrayOf(1.1, 1.49998, 2.99996, 2.6).truncate())
        .isEqualTo(arrayOf(1.0, 1.0, 2.0, 2.0))
    }
  }
}
