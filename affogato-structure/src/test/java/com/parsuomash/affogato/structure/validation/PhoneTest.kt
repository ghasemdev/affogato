package com.parsuomash.affogato.structure.validation

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PhoneTest {
  @Test
  @DisplayName("Phone number is valid")
  fun isValid() {
    assertThat(Phone("09150000000").value).isEqualTo("09150000000")
    assertThat(Phone("09150000000").isValid("IR")).isTrue()
    assertThat(Phone("+989150000000").isValid()).isTrue()
    assertThat(Phone("+989123456789").isValid()).isTrue()
    assertThat(Phone("+989150000000").isValid()).isTrue()
    assertThat(Phone("0123456789").isValid()).isFalse()
    assertThat(Phone("0515216480").isValid()).isFalse()
    assertThat(Phone("+169150000000").isValid()).isTrue()
    assertThat(Phone("").isValid()).isFalse()
  }

  @Test
  @DisplayName("Phone number type")
  fun type() {
    assertThat(Phone("+989123456789").type()).isEqualTo(PhoneNumberType.MOBILE)
    assertThat(Phone("09123456789").type("IR")).isEqualTo(PhoneNumberType.MOBILE)
    assertThat(Phone("044 668 18 00").type("CH")).isEqualTo(PhoneNumberType.FIXED_LINE)
    assertThat(Phone("").type("CH")).isNull()
  }

  @Test
  @DisplayName("Phone number format")
  fun format() {
    assertThat(Phone("+989123456789").format()).isEqualTo("+98 912 345 6789")
    assertThat(Phone("09123456789").format("IR")).isEqualTo("+98 912 345 6789")

    assertThat(Phone("044 668 18 00").format("CH", PhoneNumberFormat.INTERNATIONAL))
      .isEqualTo("+41 44 668 18 00")
    assertThat(Phone("044 668 18 00").format("CH", PhoneNumberFormat.NATIONAL))
      .isEqualTo("044 668 18 00")
    assertThat(Phone("044 668 18 00").format("CH", PhoneNumberFormat.E164))
      .isEqualTo("+41446681800")
    assertThat(Phone("").format("CH")).isNull()
  }

  @Test
  @DisplayName("Phone number is empty")
  fun isEmpty() {
    assertThat(Phone("09150000000").isEmpty()).isFalse()
    assertThat(Phone("").isEmpty()).isTrue()
  }

  @Test
  @DisplayName("Phone number to string")
  fun toStr() {
    assertThat(Phone("09150000000").toString())
      .isEqualTo("Phone(value=09150000000)")
  }
}
