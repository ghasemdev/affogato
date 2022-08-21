package com.parsuomash.affogato.structure.validation

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class EmailCheckerTest {
  @Test
  fun `email validation`() {
    assertThat(EmailChecker("jakode@gmail.com").value)
      .isEqualTo("jakode@gmail.com")
    assertThat(EmailChecker("jakode@gmail.com").toString())
      .isEqualTo("EmailChecker(value=jakode@gmail.com)")

    assertThat(EmailChecker("jakode@gmail.com").isEmpty()).isFalse()
    assertThat(EmailChecker("").isEmpty()).isTrue()

    assertThat(EmailChecker("jakode@gmail.com").isValid()).isTrue()
    assertThat(EmailChecker("jakode.2020@gmail.com").isValid()).isTrue()
    assertThat(EmailChecker("jakode@@gmail.com").isValid()).isFalse()
    assertThat(EmailChecker("jakode@").isValid()).isFalse()
    assertThat(EmailChecker("").isValid()).isFalse()
  }
}
