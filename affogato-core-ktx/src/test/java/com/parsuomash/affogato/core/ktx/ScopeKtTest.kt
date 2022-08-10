package com.parsuomash.affogato.core.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ScopeKtTest {
  @Test
  @DisplayName("block scope")
  fun block() {
    var string = "Hello"
    val blockString = string.block { string += " World" }
    assertThat(blockString).isEqualTo("Hello")
    assertThat(string).isEqualTo("Hello World")
  }
}
