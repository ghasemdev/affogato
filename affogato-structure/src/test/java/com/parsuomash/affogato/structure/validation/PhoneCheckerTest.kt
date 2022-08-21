package com.parsuomash.affogato.structure.validation

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PhoneCheckerTest {
  @Test
  @DisplayName("Phone number is valid")
  fun isValid() {
    assertThat(PhoneChecker("09150000000").value).isEqualTo("09150000000")
    assertThat(PhoneChecker("09150000000").isValid("IR")).isTrue()
    assertThat(PhoneChecker("+989150000000").isValid()).isTrue()
    assertThat(PhoneChecker("+989123456789").isValid()).isTrue()
    assertThat(PhoneChecker("+989150000000").isValid()).isTrue()
    assertThat(PhoneChecker("0123456789").isValid()).isFalse()
    assertThat(PhoneChecker("0515216480").isValid()).isFalse()
    assertThat(PhoneChecker("+169150000000").isValid()).isTrue()
    assertThat(PhoneChecker("").isValid()).isFalse()
  }

  @Test
  @DisplayName("Phone number type")
  fun type() {
    assertThat(PhoneChecker("+989123456789").type()).isEqualTo(PhoneNumberType.MOBILE)
    assertThat(PhoneChecker("09123456789").type("IR")).isEqualTo(PhoneNumberType.MOBILE)
    assertThat(PhoneChecker("044 668 18 00").type("CH")).isEqualTo(PhoneNumberType.FIXED_LINE)
    assertThat(PhoneChecker("").type("CH")).isNull()
  }

  @Test
  @DisplayName("Phone number format")
  fun format() {
    assertThat(PhoneChecker("+989123456789").format()).isEqualTo("+98 912 345 6789")
    assertThat(PhoneChecker("09123456789").format("IR")).isEqualTo("+98 912 345 6789")

    assertThat(PhoneChecker("044 668 18 00").format("CH", PhoneNumberFormat.INTERNATIONAL))
      .isEqualTo("+41 44 668 18 00")
    assertThat(PhoneChecker("044 668 18 00").format("CH", PhoneNumberFormat.NATIONAL))
      .isEqualTo("044 668 18 00")
    assertThat(PhoneChecker("044 668 18 00").format("CH", PhoneNumberFormat.E164))
      .isEqualTo("+41446681800")
    assertThat(PhoneChecker("").format("CH")).isNull()
  }

  @Test
  @DisplayName("Phone number is empty")
  fun isEmpty() {
    assertThat(PhoneChecker("09150000000").isEmpty()).isFalse()
    assertThat(PhoneChecker("").isEmpty()).isTrue()
  }

  @Test
  @DisplayName("Phone number to string")
  fun toStr() {
    assertThat(PhoneChecker("09150000000").toString())
      .isEqualTo("PhoneChecker(value=09150000000)")
  }
}
