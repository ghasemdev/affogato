package com.parsuomash.affogato.core.ktx.operations

import com.google.common.truth.Truth.assertThat
import com.parsuomash.affogato.core.ktx.collections.listOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CollectionsOperationsKtTest {
  @Nested
  @DisplayName("Subtract")
  inner class Subtract {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10 sub listOf(10..20)).isEqualTo(listOf(0 downTo -10))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) sub 10).isEqualTo(listOf(0..10))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10L sub listOf(10..20L)).isEqualTo(listOf(0 downTo -10L))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20L) sub 10L).isEqualTo(listOf(0..10L))
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10F sub listOf(10..20))
          .isEqualTo(listOf(0F, -1F, -2F, -3F, -4F, -5F, -6F, -7F, -8F, -9F, -10F))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) sub 10F)
          .isEqualTo(listOf(0F, 1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F))
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10.0 sub listOf(10..20))
          .isEqualTo(listOf(0.0, -1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) sub 10.0)
          .isEqualTo(listOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0))
      }
    }
  }

  @Nested
  @DisplayName("Add")
  inner class Add {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10 add listOf(10..20)).isEqualTo(listOf(20..30))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) add 10).isEqualTo(listOf(20..30))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10L add listOf(10..20L)).isEqualTo(listOf(20..30L))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20L) add 10L).isEqualTo(listOf(20..30L))
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10F add listOf(10..20))
          .isEqualTo(listOf(20F, 21F, 22F, 23F, 24F, 25F, 26F, 27F, 28F, 29F, 30F))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) add 10F)
          .isEqualTo(listOf(20F, 21F, 22F, 23F, 24F, 25F, 26F, 27F, 28F, 29F, 30F))
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10.0 add listOf(10..20))
          .isEqualTo(listOf(20.0, 21.0, 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) add 10.0)
          .isEqualTo(listOf(20.0, 21.0, 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0))
      }
    }
  }

  @Nested
  @DisplayName("Multiply")
  inner class Multiply {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10 mul listOf(10..20))
          .isEqualTo(listOf(100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) mul 10)
          .isEqualTo(listOf(100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10L mul listOf(10..20L))
          .isEqualTo(listOf(100L, 110L, 120L, 130L, 140L, 150L, 160L, 170L, 180L, 190L, 200L))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20L) mul 10L)
          .isEqualTo(listOf(100L, 110L, 120L, 130L, 140L, 150L, 160L, 170L, 180L, 190L, 200L))
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10F mul listOf(10..20))
          .isEqualTo(listOf(100F, 110F, 120F, 130F, 140F, 150F, 160F, 170F, 180F, 190F, 200F))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) mul 10F)
          .isEqualTo(listOf(100F, 110F, 120F, 130F, 140F, 150F, 160F, 170F, 180F, 190F, 200F))
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(10.0 mul listOf(10..20)).isEqualTo(
          listOf(100.0, 110.0, 120.0, 130.0, 140.0, 150.0, 160.0, 170.0, 180.0, 190.0, 200.0)
        )
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10..20) mul 10.0).isEqualTo(
          listOf(100.0, 110.0, 120.0, 130.0, 140.0, 150.0, 160.0, 170.0, 180.0, 190.0, 200.0)
        )
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
        assertThat(20 div listOf(1, 2, 5, 10, 20)).isEqualTo(listOf(20, 10, 4, 2, 1))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10, 20, 30, 40, 50) div 10).isEqualTo(listOf(1, 2, 3, 4, 5))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(20L div listOf(1, 2, 5, 10, 20)).isEqualTo(listOf(20L, 10L, 4L, 2L, 1L))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10, 20, 30, 40, 50) div 10L).isEqualTo(listOf(1..5L))
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(20F div listOf(1, 2, 5, 10, 20)).isEqualTo(listOf(20F, 10F, 4F, 2F, 1F))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10, 20, 30, 40, 50) div 10F).isEqualTo(listOf(1F, 2F, 3F, 4F, 5F))
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(20.0 div listOf(1, 2, 5, 10, 20)).isEqualTo(listOf(20.0, 10.0, 4.0, 2.0, 1.0))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(10, 20, 30, 40, 50) div 10.0).isEqualTo(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
      }
    }
  }

  @Nested
  @DisplayName("Remainder")
  inner class Remainder {
    @Nested
    @DisplayName("Int")
    inner class Int {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(22 rem listOf(1, 2, 5, 10, 20)).isEqualTo(listOf(0, 0, 2, 2, 2))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(20, 30, 40, 50) rem 12).isEqualTo(listOf(8, 6, 4, 2))
      }
    }

    @Nested
    @DisplayName("Long")
    inner class Long {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(22L rem listOf(1, 2, 5, 10, 20)).isEqualTo(listOf(0L, 0L, 2L, 2L, 2L))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(20, 30, 40, 50) rem 12L).isEqualTo(listOf(8L, 6L, 4L, 2L))
      }
    }

    @Nested
    @DisplayName("Float")
    inner class Float {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(22F rem listOf(1, 2, 5, 10, 20)).isEqualTo(listOf(0F, 0F, 2F, 2F, 2F))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(20, 30, 40, 50) rem 12F).isEqualTo(listOf(8F, 6F, 4F, 2F))
      }
    }

    @Nested
    @DisplayName("Double")
    inner class Double {
      @Test
      @DisplayName("left")
      fun left() {
        assertThat(22.0 rem listOf(1, 2, 5, 10, 20)).isEqualTo(listOf(0.0, 0.0, 2.0, 2.0, 2.0))
      }

      @Test
      @DisplayName("right")
      fun right() {
        assertThat(listOf(20, 30, 40, 50) rem 12.0).isEqualTo(listOf(8.0, 6.0, 4.0, 2.0))
      }
    }
  }
}
