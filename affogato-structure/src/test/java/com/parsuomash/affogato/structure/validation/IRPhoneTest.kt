package com.parsuomash.affogato.structure.validation

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class IRPhoneTest {
  @Test
  fun `IRPhone validation`() {
    assertThat(IRPhone("09150000000").value)
      .isEqualTo("09150000000")
    assertThat(IRPhone("09150000000").toString())
      .isEqualTo("IRPhone(value=09150000000)")

    assertThat(IRPhone("09150000000").isEmpty()).isFalse()
    assertThat(IRPhone("").isEmpty()).isTrue()

    assertThat(IRPhone("09150000000").isValid()).isTrue()
    assertThat(IRPhone("09123456789").isValid()).isTrue()
    assertThat(IRPhone("+989150000000").isValid()).isTrue()
    assertThat(IRPhone("0123456789").isValid()).isFalse()
    assertThat(IRPhone("0515216480").isValid()).isFalse()
    assertThat(IRPhone("+169150000000").isValid()).isFalse()
    assertThat(IRPhone("").isValid()).isFalse()
  }
}
