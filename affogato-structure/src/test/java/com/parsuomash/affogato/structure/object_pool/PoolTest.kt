package com.parsuomash.affogato.structure.object_pool

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PoolTest {
  @Test
  @DisplayName("Default Pool")
  fun defaultPool() {
    assertThat(DefaultPool.size).isEqualTo(0)

    assertThrows<NoSuchElementException> { DefaultPool.last() }
    assertThrows<NoSuchElementException> { DefaultPool[""] }
    assertThat(DefaultPool.lastOrNull()).isNull()
    assertThat(DefaultPool.lastOrElse { -1 }).isEqualTo(-1)

    assertThrows<NoSuchElementException> { DefaultPool.first() }
    assertThat(DefaultPool.firstOrNull()).isNull()
    assertThat(DefaultPool.firstOrElse { -1 }).isEqualTo(-1)

    DefaultPool["one"] = 1
    assertThat(DefaultPool.size).isEqualTo(1)

    assertThat(DefaultPool.last()).isEqualTo(1)
    assertThat(DefaultPool.lastOrNull()).isEqualTo(1)
    assertThat(DefaultPool.lastOrElse { -1 }).isEqualTo(1)

    assertThat(DefaultPool.first()).isEqualTo(1)
    assertThat(DefaultPool.firstOrNull()).isEqualTo(1)
    assertThat(DefaultPool.firstOrElse { -1 }).isEqualTo(1)

    DefaultPool["two"] = 2
    assertThat(DefaultPool.size).isEqualTo(2)
    assertThat(DefaultPool["two"]).isEqualTo(2)

    assertThat(DefaultPool.getOrNull("three")).isNull()
    assertThat(DefaultPool.getOrElse("three") { -1 }).isEqualTo(-1)

    assertThat(DefaultPool.objects).isEqualTo(mapOf("one" to 1, "two" to 2))
  }

  @Test
  @DisplayName("BooleanPool Pool")
  fun booleanPool() {
    assertThat(BooleanPool.size).isEqualTo(0)

    assertThrows<NoSuchElementException> { BooleanPool.last() }
    assertThrows<NoSuchElementException> { BooleanPool[""] }
    assertThat(BooleanPool.lastOrNull()).isNull()
    assertThat(BooleanPool.lastOrElse { true }).isTrue()

    assertThrows<NoSuchElementException> { BooleanPool.first() }
    assertThat(BooleanPool.firstOrNull()).isNull()
    assertThat(BooleanPool.firstOrElse { false }).isFalse()

    BooleanPool["one"] = true
    assertThat(BooleanPool.size).isEqualTo(1)

    assertThat(BooleanPool.last()).isTrue()
    assertThat(BooleanPool.lastOrNull()).isTrue()
    assertThat(BooleanPool.lastOrElse { false }).isTrue()

    assertThat(BooleanPool.first()).isTrue()
    assertThat(BooleanPool.firstOrNull()).isTrue()
    assertThat(BooleanPool.firstOrElse { false }).isTrue()

    BooleanPool["two"] = false
    assertThat(BooleanPool.size).isEqualTo(2)
    assertThat(BooleanPool["two"]).isFalse()

    assertThat(BooleanPool.getOrNull("three")).isNull()
    assertThat(BooleanPool.getOrElse("three") { false }).isFalse()

    assertThat(BooleanPool.objects).isEqualTo(mapOf("one" to true, "two" to false))
  }

  @Test
  @DisplayName("IntPool Pool")
  fun intPool() {
    assertThat(IntPool.size).isEqualTo(0)

    assertThrows<NoSuchElementException> { IntPool.last() }
    assertThrows<NoSuchElementException> { IntPool[""] }
    assertThat(IntPool.lastOrNull()).isNull()
    assertThat(IntPool.lastOrElse { -1 }).isEqualTo(-1)

    assertThrows<NoSuchElementException> { IntPool.first() }
    assertThat(IntPool.firstOrNull()).isNull()
    assertThat(IntPool.firstOrElse { -1 }).isEqualTo(-1)

    IntPool["one"] = 1
    assertThat(IntPool.size).isEqualTo(1)

    assertThat(IntPool.last()).isEqualTo(1)
    assertThat(IntPool.lastOrNull()).isEqualTo(1)
    assertThat(IntPool.lastOrElse { -1 }).isEqualTo(1)

    assertThat(IntPool.first()).isEqualTo(1)
    assertThat(IntPool.firstOrNull()).isEqualTo(1)
    assertThat(IntPool.firstOrElse { -1 }).isEqualTo(1)

    IntPool["two"] = 2
    assertThat(IntPool.size).isEqualTo(2)
    assertThat(IntPool["two"]).isEqualTo(2)

    assertThat(IntPool.getOrNull("three")).isNull()
    assertThat(IntPool.getOrElse("three") { -1 }).isEqualTo(-1)

    assertThat(IntPool.objects).isEqualTo(mapOf("one" to 1, "two" to 2))
  }

  @Test
  @DisplayName("LongPool Pool")
  fun longPool() {
    assertThat(LongPool.size).isEqualTo(0)

    assertThrows<NoSuchElementException> { LongPool.last() }
    assertThrows<NoSuchElementException> { LongPool[""] }
    assertThat(LongPool.lastOrNull()).isNull()
    assertThat(LongPool.lastOrElse { -1L }).isEqualTo(-1L)

    assertThrows<NoSuchElementException> { LongPool.first() }
    assertThat(LongPool.firstOrNull()).isNull()
    assertThat(LongPool.firstOrElse { -1L }).isEqualTo(-1L)

    LongPool["one"] = 1
    assertThat(LongPool.size).isEqualTo(1)

    assertThat(LongPool.last()).isEqualTo(1L)
    assertThat(LongPool.lastOrNull()).isEqualTo(1L)
    assertThat(LongPool.lastOrElse { -1L }).isEqualTo(1L)

    assertThat(LongPool.first()).isEqualTo(1L)
    assertThat(LongPool.firstOrNull()).isEqualTo(1L)
    assertThat(LongPool.firstOrElse { -1L }).isEqualTo(1L)

    LongPool["two"] = 2L
    assertThat(LongPool.size).isEqualTo(2L)
    assertThat(LongPool["two"]).isEqualTo(2L)

    assertThat(LongPool.getOrNull("three")).isNull()
    assertThat(LongPool.getOrElse("three") { -1L }).isEqualTo(-1L)

    assertThat(LongPool.objects).isEqualTo(mapOf("one" to 1L, "two" to 2L))
  }

  @Test
  @DisplayName("FloatPool Pool")
  fun floatPool() {
    assertThat(FloatPool.size).isEqualTo(0)

    assertThrows<NoSuchElementException> { FloatPool.last() }
    assertThrows<NoSuchElementException> { FloatPool[""] }
    assertThat(FloatPool.lastOrNull()).isNull()
    assertThat(FloatPool.lastOrElse { 1f }).isEqualTo(1f)

    assertThrows<NoSuchElementException> { FloatPool.first() }
    assertThat(FloatPool.firstOrNull()).isNull()
    assertThat(FloatPool.firstOrElse { 1f }).isEqualTo(1f)

    FloatPool["one"] = 1f
    assertThat(FloatPool.size).isEqualTo(1)

    assertThat(FloatPool.last()).isEqualTo(1f)
    assertThat(FloatPool.lastOrNull()).isEqualTo(1f)
    assertThat(FloatPool.lastOrElse { 0f }).isEqualTo(1f)

    assertThat(FloatPool.first()).isEqualTo(1f)
    assertThat(FloatPool.firstOrNull()).isEqualTo(1f)
    assertThat(FloatPool.firstOrElse { 0f }).isEqualTo(1f)

    FloatPool["two"] = 2f
    assertThat(FloatPool.size).isEqualTo(2)
    assertThat(FloatPool["two"]).isEqualTo(2f)

    assertThat(FloatPool.getOrNull("three")).isNull()
    assertThat(FloatPool.getOrElse("three") { 0f }).isEqualTo(0f)

    assertThat(FloatPool.objects).isEqualTo(mapOf("one" to 1f, "two" to 2f))
  }

  @Test
  @DisplayName("DoublePool Pool")
  fun doublePool() {
    assertThat(DoublePool.size).isEqualTo(0)

    assertThrows<NoSuchElementException> { DoublePool.last() }
    assertThrows<NoSuchElementException> { DoublePool[""] }
    assertThat(DoublePool.lastOrNull()).isNull()
    assertThat(DoublePool.lastOrElse { 1.0 }).isEqualTo(1.0)

    assertThrows<NoSuchElementException> { DoublePool.first() }
    assertThat(DoublePool.firstOrNull()).isNull()
    assertThat(DoublePool.firstOrElse { 1.0 }).isEqualTo(1.0)

    DoublePool["one"] = 1.0
    assertThat(DoublePool.size).isEqualTo(1)

    assertThat(DoublePool.last()).isEqualTo(1.0)
    assertThat(DoublePool.lastOrNull()).isEqualTo(1.0)
    assertThat(DoublePool.lastOrElse { 0.0 }).isEqualTo(1.0)

    assertThat(DoublePool.first()).isEqualTo(1.0)
    assertThat(DoublePool.firstOrNull()).isEqualTo(1.0)
    assertThat(DoublePool.firstOrElse { 0.0 }).isEqualTo(1.0)

    DoublePool["two"] = 2.0
    assertThat(DoublePool.size).isEqualTo(2)
    assertThat(DoublePool["two"]).isEqualTo(2.0)

    assertThat(DoublePool.getOrNull("three")).isNull()
    assertThat(DoublePool.getOrElse("three") { 0.0 }).isEqualTo(0.0)

    assertThat(DoublePool.objects).isEqualTo(mapOf("one" to 1.0, "two" to 2.0))
  }

  @Test
  @DisplayName("StringPool Pool")
  fun stringPool() {
    assertThat(StringPool.size).isEqualTo(0)

    assertThrows<NoSuchElementException> { StringPool.last() }
    assertThrows<NoSuchElementException> { StringPool[""] }
    assertThat(StringPool.lastOrNull()).isNull()
    assertThat(StringPool.lastOrElse { "else" }).isEqualTo("else")

    assertThrows<NoSuchElementException> { StringPool.first() }
    assertThat(StringPool.firstOrNull()).isNull()
    assertThat(StringPool.firstOrElse { "else" }).isEqualTo("else")

    StringPool["one"] = "1"
    assertThat(StringPool.size).isEqualTo(1)

    assertThat(StringPool.last()).isEqualTo("1")
    assertThat(StringPool.lastOrNull()).isEqualTo("1")
    assertThat(StringPool.lastOrElse { "else" }).isEqualTo("1")

    assertThat(StringPool.first()).isEqualTo("1")
    assertThat(StringPool.firstOrNull()).isEqualTo("1")
    assertThat(StringPool.firstOrElse { "else" }).isEqualTo("1")

    StringPool["two"] = "2"
    assertThat(StringPool.size).isEqualTo(2)
    assertThat(StringPool["two"]).isEqualTo("2")

    assertThat(StringPool.getOrNull("three")).isNull()
    assertThat(StringPool.getOrElse("three") { "else" }).isEqualTo("else")

    assertThat(StringPool.objects).isEqualTo(mapOf("one" to "1", "two" to "2"))
  }
}
