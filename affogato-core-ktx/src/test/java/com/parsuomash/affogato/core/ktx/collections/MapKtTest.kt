package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class MapKtTest {
  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("toHashMap")
    fun toHashMap() {
      assertThat(mapOf(1 to 1, 2 to 2).toHashMap()).isEqualTo(hashMapOf(1 to 1, 2 to 2))
    }

    @Test
    @DisplayName("toLinkedMap")
    fun toLinkedMap() {
      assertThat(mapOf(1 to 1, 2 to 2).toLinkedMap()).isEqualTo(linkedMapOf(1 to 1, 2 to 2))
    }
  }

  @Nested
  @DisplayName("Sorting")
  inner class Sorting {
    @Test
    @DisplayName("sorted by key")
    fun sortedByKey() {
      assertThat(mapOf(5 to 1, 10 to 10, 1 to 0).sortedByKey())
        .isEqualTo(mapOf(1 to 0, 5 to 1, 10 to 10))
      assertThat(mapOf("11" to 1, "1" to 10, "a" to 0).sortedByKey())
        .isEqualTo(mapOf("1" to 10, "11" to 1, "a" to 0))
    }

    @Test
    @DisplayName("sort by key dec")
    fun sortedByKeyDec() {
      assertThat(mapOf(5 to 1, 10 to 10, 1 to 0).sortedByKeyDescending())
        .isEqualTo(mapOf(10 to 10, 5 to 1, 1 to 0))
      assertThat(mapOf("11" to 1, "1" to 10, "a" to 0).sortedByKeyDescending())
        .isEqualTo(mapOf("a" to 0, "1" to 10, "11" to 1))
    }

    @Test
    @DisplayName("sorted by value")
    fun sortedByValue() {
      assertThat(mapOf(1 to 0, 5 to 1, 10 to 10, 7 to 0).sortedByValue())
        .isEqualTo(mapOf(1 to 0, 7 to 0, 5 to 1, 10 to 10))
      assertThat(mapOf(1 to "a", 2 to "0", 3 to "11", 4 to "01", 5 to "1").sortedByValue())
        .isEqualTo(mapOf(2 to "0", 4 to "01", 5 to "1", 3 to "11", 1 to "a"))
    }

    @Test
    @DisplayName("sort by value dec")
    fun sortedByValueDec() {
      assertThat(mapOf(1 to 0, 5 to 1, 10 to 10, 7 to 0).sortedByValueDescending())
        .isEqualTo(mapOf(10 to 10, 5 to 1, 1 to 0, 7 to 0))
      assertThat(mapOf(2 to "0", 3 to "11", 4 to "01", 5 to "1").sortedByValueDescending())
        .isEqualTo(mapOf(3 to "11", 5 to "1", 4 to "01", 2 to "0"))
    }
  }
}
