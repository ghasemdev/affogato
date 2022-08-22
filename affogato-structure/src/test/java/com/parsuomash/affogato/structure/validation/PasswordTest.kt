package com.parsuomash.affogato.structure.validation

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class PasswordTest {
  @Test
  fun `check password is valid`() {
    val password = password {
      isValidLength { assertThat(it).isTrue() }
      includeDigit { assertThat(it).isTrue() }
      includeLowerCase { assertThat(it).isTrue() }
      includeUpperCase { assertThat(it).isTrue() }
      includeSpecialChar { assertThat(it).isTrue() }
      excludeWhitespace { assertThat(it).isTrue() }
    }
    password.value = "#Ghasem79shirdel"
  }

  @Test
  fun `check length is valid`() {
    val password = password {
      isValidLength { assertThat(it).isFalse() }
    }
    password.value = "ghasem"
  }
}
