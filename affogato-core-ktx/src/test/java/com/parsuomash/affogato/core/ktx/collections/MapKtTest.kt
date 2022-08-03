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
}
