package com.parsuomash.affogato.core.ktx.operations

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OperationsKtTest {
  @Test
  fun times() {
    assertThat("Hello" * 3).isEqualTo("HelloHelloHello")
    assertThat("Hello" * 0).isEqualTo("")
    assertThat("Hello" * 1).isEqualTo("Hello")
    assertThat("^" * 5).isEqualTo("^^^^^")
    assertThat("25" * 10).isEqualTo("25252525252525252525")
    assertThat('a' * 3).isEqualTo("aaa")
    assertThrows<IllegalArgumentException> { "error" * -1 }
    assertThrows<IllegalArgumentException> { 'z' * -1 }
  }

  @Test
  fun not() {
    assertThat(!0).isEqualTo(-1)
    assertThat(!255).isEqualTo(-256)
    assertThat(!1).isEqualTo(-2)
  }

  @Test
  fun nor() {
    assertThat(0 nor 0).isEqualTo(-1)
    assertThat(0 nor 1).isEqualTo(-2)
    assertThat(1 nor 0).isEqualTo(-2)
    assertThat(1 nor 1).isEqualTo(-2)
  }

  @Test
  fun nand() {
    assertThat(0 nand 0).isEqualTo(-1)
    assertThat(0 nand 1).isEqualTo(-1)
    assertThat(1 nand 0).isEqualTo(-1)
    assertThat(1 nand 1).isEqualTo(-2)
  }

  @Test
  fun xnor() {
    assertThat(0 xnor 0).isEqualTo(-1)
    assertThat(0 xnor 1).isEqualTo(-2)
    assertThat(1 xnor 0).isEqualTo(-2)
    assertThat(1 xnor 1).isEqualTo(-1)
  }

  @Test
  fun `boolean nor`() {
    assertThat(false nor false).isTrue()
    assertThat(false nor true).isFalse()
    assertThat(true nor false).isFalse()
    assertThat(true nor true).isFalse()
  }

  @Test
  fun `boolean nand`() {
    assertThat(false nand false).isTrue()
    assertThat(false nand true).isTrue()
    assertThat(true nand false).isTrue()
    assertThat(true nand true).isFalse()
  }

  @Test
  fun `boolean xnor`() {
    assertThat(false xnor false).isTrue()
    assertThat(false xnor true).isFalse()
    assertThat(true xnor false).isFalse()
    assertThat(true xnor true).isTrue()
  }

  @Test
  fun `to boolean`() {
    assertThat(0.toBoolean()).isFalse()
    assertThat(1.toBoolean()).isTrue()
    assertThrows<IllegalArgumentException> {
      2.toBoolean()
      (-1).toBoolean()
    }
    assertThat(2.toBooleanOrNull()).isNull()
  }

  @Test
  fun `to int`() {
    assertThat(true.toInt()).isEqualTo(1)
    assertThat(false.toInt()).isEqualTo(0)
  }
}
