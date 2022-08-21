package com.parsuomash.affogato.core.ktx.text

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class StringsKtTest {
  @Test
  fun `is alphanumeric`() {
    assertThat("123".isAlphanumeric).isTrue()
    assertThat("hello".isAlphanumeric).isTrue()
    assertThat("YES".isAlphanumeric).isTrue()
    assertThat("Hello".isAlphanumeric).isTrue()
    assertThat("Hello1400".isAlphanumeric).isTrue()
    assertThat("۵۰۵".isAlphanumeric).isFalse()
    assertThat("سلام".isAlphanumeric).isFalse()
  }

  @Test
  fun `is digit`() {
    assertThat("7865".isDigit).isTrue()
    assertThat("salam".isDigit).isFalse()
    assertThat("hr56".isDigit).isFalse()
    assertThat("الکی".isDigit).isFalse()
  }

  @Test
  fun `is persian digit`() {
    assertThat("۰۹۱۵۰۰۰۰۰۰۰".isPersianDigit).isTrue()
    assertThat("09150000000".isPersianDigit).isFalse()
    assertThat("۵۲s".isPersianDigit).isFalse()
    assertThat("۵۲ض".isPersianDigit).isFalse()
  }

  @Test
  fun `contains latin letter`() {
    assertThat("Hello1400".containsLatinLetter).isTrue()
    assertThat("Hello".containsLatinLetter).isTrue()
    assertThat("hello".containsLatinLetter).isTrue()
    assertThat("Helloسلام".containsLatinLetter).isTrue()
    assertThat("0".containsLatinLetter).isFalse()
    assertThat("ا".containsLatinLetter).isFalse()
  }

  @Test
  fun `contains digit`() {
    assertThat("Hello1400".containsDigit).isTrue()
    assertThat("1234".containsDigit).isTrue()
    assertThat("hello".containsDigit).isFalse()
    assertThat("سلام".containsDigit).isFalse()
    assertThat("۱۵۲۱۶۵".containsDigit).isFalse()
  }

  @Test
  fun `contains persian digit`() {
    assertThat("Hello۲۱".containsPersianDigit).isTrue()
    assertThat("۲۱".containsPersianDigit).isTrue()
    assertThat("hello".containsPersianDigit).isFalse()
    assertThat("سلام5".containsPersianDigit).isFalse()
    assertThat("125".containsPersianDigit).isFalse()
  }

  @Test
  fun `has letters and digits`() {
    assertThat("Hello55".hasLettersAndDigits).isTrue()
    assertThat("hello".hasLettersAndDigits).isFalse()
    assertThat("125".hasLettersAndDigits).isFalse()
  }

  @Test
  fun `is integer number`() {
    assertThat("123".isIntegerNumber).isTrue()
    assertThat("012".isIntegerNumber).isTrue()
    assertThat("12.5".isIntegerNumber).isFalse()
    assertThat("q".isIntegerNumber).isFalse()
  }

  @Test
  fun `is decimal number`() {
    assertThat("123.56".isDecimalNumber).isTrue()
    assertThat("127".isDecimalNumber).isTrue()
    assertThat("012".isDecimalNumber).isTrue()
    assertThat("012.65".isDecimalNumber).isTrue()
    assertThat("q".isDecimalNumber).isFalse()
  }

  @Test
  fun `is Http`() {
    assertThat("http://www.jakode.com".isHttp).isTrue()
    assertThat("https://www.jakode.com".isHttp).isTrue()
    assertThat("htt://www//".isHttp).isFalse()
  }

  @Test
  fun `is null`() {
    assertThat("null".isNull()).isTrue()
    assertThat(null.isNull()).isTrue()
    assertThat(" ".isNull()).isFalse()
  }

  @Test
  fun `is not null`() {
    assertThat("null".isNotNull()).isFalse()
    assertThat(null.isNotNull()).isFalse()
    assertThat(" ".isNotNull()).isTrue()
  }

  @Test
  fun `is not null or blank`() {
    assertThat(" ".isNotNullOrBlank()).isFalse()
    assertThat("null".isNotNullOrBlank()).isFalse()
    assertThat(null.isNotNullOrBlank()).isFalse()
    assertThat("\n".isNotNullOrBlank()).isFalse()
    assertThat("\r".isNotNullOrBlank()).isFalse()
    assertThat("hi".isNotNullOrBlank()).isTrue()

    assertThat(" ".isNotNullNotBlank()).isFalse()
    assertThat("null".isNotNullNotBlank()).isFalse()
    assertThat(null.isNotNullNotBlank()).isFalse()
    assertThat("\n".isNotNullNotBlank()).isFalse()
    assertThat("\r".isNotNullNotBlank()).isFalse()
    assertThat("hi".isNotNullNotBlank()).isTrue()
  }

  @Test
  fun `is not null or empty`() {
    assertThat("null".isNotNullOrEmpty()).isFalse()
    assertThat(null.isNotNullOrEmpty()).isFalse()
    assertThat(" ".isNotNullOrEmpty()).isTrue()
    assertThat("\n".isNotNullOrEmpty()).isTrue()
    assertThat("\r".isNotNullOrEmpty()).isTrue()
    assertThat("hi".isNotNullOrEmpty()).isTrue()

    assertThat("null".isNotNullNotEmpty()).isFalse()
    assertThat(null.isNotNullNotEmpty()).isFalse()
    assertThat(" ".isNotNullNotEmpty()).isTrue()
    assertThat("\n".isNotNullNotEmpty()).isTrue()
    assertThat("\r".isNotNullNotEmpty()).isTrue()
    assertThat("hi".isNotNullNotEmpty()).isTrue()
  }

  @Test
  fun `url encoding`() {
    val originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java"
    val encodingUrl = originalUrl.urlEncode
    println("encoding url: $encodingUrl")
    assertThat(encodingUrl).isEqualTo(
      "https%3A%2F%2Fwww.google.co.nz%2F%3Fgfe" +
        "_rd%3Dcr%26ei%3DdzbFV%26gws_rd%3Dssl%23q%3Djava"
    )

    val decodedUrl = originalUrl.urlDecode
    println("decoded url: $decodedUrl")
    assertThat(decodedUrl).isEqualTo(originalUrl)
  }

  @Test
  fun `last path component`() {
    assertThat("https://google.com/chrome/".lastPathComponent).isEqualTo("chrome")
    assertThat("C:\\Windows\\Fonts\\font.ttf".lastPathComponent).isEqualTo("font.ttf")
    assertThat("C:\\Windows\\Fonts\\font.ttf\\".lastPathComponent).isEqualTo("font.ttf")
    assertThat("".lastPathComponent).isEqualTo("")
    assertThat("/dev/null".lastPathComponent).isEqualTo("null")
  }

  @Test
  fun `string capitalize`() {
    assertThat("hello".capitalize()).isEqualTo("Hello")
    assertThat("Hello".capitalize()).isEqualTo("Hello")
    assertThat("HELLO".capitalize()).isEqualTo("HELLO")
  }

  @Nested
  @DisplayName("rotate")
  inner class Rotate {
    @Test
    @DisplayName("left")
    fun left() {
      assertThat("hello".rotateLeft(3)).isEqualTo("llohe")
      assertThat("Hello".rotateLeft(2)).isEqualTo("loHel")
      assertThat("HELLO".rotateLeft()).isEqualTo("OHELL")
    }

    @Test
    @DisplayName("right")
    fun right() {
      assertThat("hello".rotateRight(3)).isEqualTo("lohel")
      assertThat("Hello".rotateRight(2)).isEqualTo("lloHe")
      assertThat("HELLO".rotateRight()).isEqualTo("ELLOH")
    }
  }

  @Nested
  @DisplayName("substring")
  inner class Substring {
    @Test
    @DisplayName("with range")
    fun range() {
      assertThat("Hi"[0]).isEqualTo('H')
      assertThat("Hello affogato core ktx"[10..20]).isEqualTo("gato core k")
      assertThrows<StringIndexOutOfBoundsException> { ""[0..10] }

      assertThat("Hello".getOrNull(1..3)).isEqualTo("ell")
      assertThat("Hello".getOrNull(1..5)).isNull()

      assertThat("Hello".getOrElse(1..3) { "Hi" }).isEqualTo("ell")
      assertThat("Hello".getOrElse(1..5) { "Hi" }).isEqualTo("Hi")
    }

    @Test
    @DisplayName("with progression")
    fun progression() {
      assertThat("Hello affogato core ktx"[0..20 step 2]).isEqualTo("Hloafgt oek")
      assertThrows<StringIndexOutOfBoundsException> { ""[0..10 step 2] }

      assertThat("Hello".getOrNull(0..4 step 2)).isEqualTo("Hlo")
      assertThat("Hello".getOrNull(0..8 step 2)).isNull()

      assertThat("Hello".getOrElse(0..4 step 2) { "Hi" }).isEqualTo("Hlo")
      assertThat("Hello".getOrElse(0..8 step 2) { "Hi" }).isEqualTo("Hi")
    }
  }

  @Test
  fun `string has valid length`() {
    var result: Boolean? = null
    "12345678".hasValidLength(8) { result = true }
    assertThat(result).isTrue()
  }

  @Test
  fun `append space`() {
    assertThat(buildString { appendSpace() }).isEqualTo(" ")
  }

  @Test
  fun `join with`() {
    assertThat(joinWith("H", "e", "l", "l", "o", separator = "")).isEqualTo("Hello")
    assertThat(joinWith(1, 2, 3, 4, separator = ", ")).isEqualTo("1, 2, 3, 4")
    assertThat(joinWith(1, 2, 3, 4)).isEqualTo("1 2 3 4")
  }
}
