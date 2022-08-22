package com.parsuomash.affogato.structure.validation

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class EmailTest {
  @Test
  fun `email validation`() {
    assertThat(Email("jakode@gmail.com").value)
      .isEqualTo("jakode@gmail.com")
    assertThat(Email("jakode@gmail.com").toString())
      .isEqualTo("Email(value=jakode@gmail.com)")

    assertThat(Email("jakode@gmail.com").isEmpty()).isFalse()
    assertThat(Email("").isEmpty()).isTrue()

    assertThat(Email("jakode@gmail.com").isValid()).isTrue()
    assertThat(Email("jakode.2020@gmail.com").isValid()).isTrue()
    assertThat(Email("jakode@@gmail.com").isValid()).isFalse()
    assertThat(Email("jakode@").isValid()).isFalse()
    assertThat(Email("").isValid()).isFalse()
  }
}
