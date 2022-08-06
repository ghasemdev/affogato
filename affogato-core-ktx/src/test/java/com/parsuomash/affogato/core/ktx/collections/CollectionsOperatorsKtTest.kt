package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CollectionsOperatorsKtTest {
  @Nested
  @DisplayName("Minus")
  inner class Minus {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10 sub arrayOf(10..20)).isEqualTo(arrayOf(0 downTo -10))
        assertThat(10 sub listOf(10..20)).isEqualTo(listOf(0 downTo -10))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(arrayOf(10..20) sub 10).isEqualTo(arrayOf(0..10))
        assertThat(listOf(10..20) sub 10).isEqualTo(listOf(0..10))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }
  }

  @Nested
  @DisplayName("Plus")
  inner class Plus {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10 sub arrayOf(10..20)).isEqualTo(arrayOf(0 downTo -10))
        assertThat(10 sub listOf(10..20)).isEqualTo(listOf(0 downTo -10))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(arrayOf(10..20) sub 10).isEqualTo(arrayOf(0..10))
        assertThat(listOf(10..20) sub 10).isEqualTo(listOf(0..10))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }
  }

  @Nested
  @DisplayName("Times")
  inner class Times {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10 sub arrayOf(10..20)).isEqualTo(arrayOf(0 downTo -10))
        assertThat(10 sub listOf(10..20)).isEqualTo(listOf(0 downTo -10))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(arrayOf(10..20) sub 10).isEqualTo(arrayOf(0..10))
        assertThat(listOf(10..20) sub 10).isEqualTo(listOf(0..10))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }
  }

  @Nested
  @DisplayName("Divide")
  inner class Divide {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10 sub arrayOf(10..20)).isEqualTo(arrayOf(0 downTo -10))
        assertThat(10 sub listOf(10..20)).isEqualTo(listOf(0 downTo -10))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(arrayOf(10..20) sub 10).isEqualTo(arrayOf(0..10))
        assertThat(listOf(10..20) sub 10).isEqualTo(listOf(0..10))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }
  }

  @Nested
  @DisplayName("Mod")
  inner class Mod {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10 sub arrayOf(10..20)).isEqualTo(arrayOf(0 downTo -10))
        assertThat(10 sub listOf(10..20)).isEqualTo(listOf(0 downTo -10))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(arrayOf(10..20) sub 10).isEqualTo(arrayOf(0..10))
        assertThat(listOf(10..20) sub 10).isEqualTo(listOf(0..10))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
      }

      @Test
      @DisplayName("right")
      fun right() {
      }
    }
  }
}
