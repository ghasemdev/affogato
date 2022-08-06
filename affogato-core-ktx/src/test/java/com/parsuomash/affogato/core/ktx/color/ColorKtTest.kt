package com.parsuomash.affogato.core.ktx.color

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ColorKtTest {
  @Test
  @DisplayName("rgb color to hex color")
  fun rgbToHex() {
    val black = "#000000".hexToRgb!!
    val white = "#FFFFFF".hexToRgb!!

    assertThat(black.rgbToHex).isEqualTo("#000000")
    assertThat(white.rgbToHex).isEqualTo("#FFFFFF")

    assertThat(0.rgbToHex).isEqualTo("#000000")
    assertThat(255.rgbToHex).isEqualTo("#0000FF")
  }

  @Test
  @DisplayName("hex to rgb")
  fun hexToRgb() {
    val black = Triple(0.toUByte(), 0.toUByte(), 0.toUByte())
    assertThat("#000000".hexToRgb).isEqualTo(black)
    val white = Triple(255.toUByte(), 255.toUByte(), 255.toUByte())
    assertThat("#FFFFFF".hexToRgb).isEqualTo(white)
  }
}
