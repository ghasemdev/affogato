package com.parsuomash.affogato.core.ktx.text

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class NumberConverterTest {
  @Test
  @DisplayName("convert number to other languages")
  fun convert() {
    assertThat(NumberConverter.toArabic("1234567890")).isEqualTo("١٢٣٤٥٦٧٨٩٠")
    assertThat(NumberConverter.toFarsi("1234567890")).isEqualTo("۱۲۳۴۵۶۷۸۹۰")
    assertThat(NumberConverter.toMongolian("1234567890")).isEqualTo("᠑᠒᠓᠔᠕᠖᠗᠘᠙᠐")
    assertThat(NumberConverter.toMyanmar("1234567890")).isEqualTo("၁၂၃၄၅၆၇၈၉၀")
    assertThat(NumberConverter.toTamil("1234567890")).isEqualTo("௧௨௩௪௫௬௭௮௯௦")
    assertThat(NumberConverter.toThai("1234567890")).isEqualTo("๑๒๓๔๕๖๗๘๙๐")
    assertThat(NumberConverter.toUrdu("1234567890")).isEqualTo("۱۲۳۴۵۶۷۸۹۰")
  }
}
