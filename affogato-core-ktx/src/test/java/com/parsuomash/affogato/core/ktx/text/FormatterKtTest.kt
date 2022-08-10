package com.parsuomash.affogato.core.ktx.text

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class FormatterKtTest {
  @Test
  fun `remove decimal part`() {
    assertThat(12.0F.removeDecimalPart).isEqualTo("12")
    assertThat(12.3F.removeDecimalPart).isEqualTo("12.3")

    assertThat(12.0.removeDecimalPart).isEqualTo("12")
    assertThat(12.3.removeDecimalPart).isEqualTo("12.3")
  }

  @Test
  fun `separate number with pattern`() {
    val number1 = 1_000_000
    val number2 = 1_000_000.569
    val number3 = 100_000_000_000_000
    val number4 = 12_345.369F

    assertThat(number1.separate()).isEqualTo("1,000,000")
    assertThat(number2.separate()).isEqualTo("1,000,000.57")
    assertThat(number3.separate()).isEqualTo("100,000,000,000,000")
    assertThat(number4.separate()).isEqualTo("12,345.37")
  }

  @Test
  fun formatCreditCard() {
    assertThat("1234567890123456".formatCreditCard()).isEqualTo("1234 5678 9012 3456")
    assertThat("1234567890123456789".formatCreditCard()).isEqualTo("1234 5678 9012 3456 789")
    assertThat("12".formatCreditCard()).isEqualTo("12")

    assertThat("1234567890123456".formatCreditCard(separator = "-"))
      .isEqualTo("1234-5678-9012-3456")
    assertThat("1234567890123456789".formatCreditCard(separator = "-"))
      .isEqualTo("1234-5678-9012-3456-789")
    assertThat("12".formatCreditCard("@", 1)).isEqualTo("1@2")

    assertThat("  1234  567890  12345 6".formatCreditCard()).isEqualTo("1234 5678 9012 3456")
  }
}
