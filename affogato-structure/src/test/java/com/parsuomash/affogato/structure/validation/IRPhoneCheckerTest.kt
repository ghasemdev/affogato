package com.parsuomash.affogato.structure.validation

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class IRPhoneCheckerTest {
  @Test
  fun `IRPhoneChecker validation`() {
    assertThat(IRPhoneChecker("09150000000").value)
      .isEqualTo("09150000000")
    assertThat(IRPhoneChecker("09150000000").toString())
      .isEqualTo("IRPhoneChecker(value=09150000000)")

    assertThat(IRPhoneChecker("09150000000").isEmpty()).isFalse()
    assertThat(IRPhoneChecker("").isEmpty()).isTrue()

    assertThat(IRPhoneChecker("09150000000").isValid()).isTrue()
    assertThat(IRPhoneChecker("09123456789").isValid()).isTrue()
    assertThat(IRPhoneChecker("+989150000000").isValid()).isTrue()
    assertThat(IRPhoneChecker("0123456789").isValid()).isFalse()
    assertThat(IRPhoneChecker("0515216480").isValid()).isFalse()
    assertThat(IRPhoneChecker("+169150000000").isValid()).isFalse()
    assertThat(IRPhoneChecker("").isValid()).isFalse()
  }
}
