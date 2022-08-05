package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import io.kotlintest.matchers.instanceOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class StackKtTest {
  @Nested
  @DisplayName("Stack Builders")
  inner class Builder {
    @Nested
    @DisplayName("empty")
    inner class Empty {
      @Test
      @DisplayName("stack")
      fun stack() {
        with(assertThat(stackOf<Int>())) {
          isEmpty()
          instanceOf(Stack::class)
        }
        with(assertThat(emptyStack<Int>())) {
          instanceOf(Stack::class)
          isEmpty()
        }
      }
    }

    @Nested
    @DisplayName("from vararg")
    inner class VarArgs {
      @Test
      @DisplayName("stack")
      fun stack() {
        val stack = stackOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(stack.size).isEqualTo(7)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1..7).toList())
      }
    }

    @Nested
    @DisplayName("from Range")
    inner class Range {
      @Test
      @DisplayName("build integer stack")
      fun integer() {
        val stack: Stack<Int> = stackOf(1..10)
        assertThat(stack.size).isEqualTo(10)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1..10).toList())
      }

      @Test
      @DisplayName("build long stack")
      fun long() {
        val stack: Stack<Long> = stackOf(1..10L)
        assertThat(stack.size).isEqualTo(10)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1..10L).toList())
      }

      @Test
      @DisplayName("build char stack")
      fun char() {
        val stack: Stack<Char> = stackOf('a'..'z')
        assertThat(stack.size).isEqualTo(26)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo(('a'..'z').toList())
      }

      @Test
      @DisplayName("build un sign integer stack")
      fun uInteger() {
        val stack: Stack<UInt> = stackOf(1u..10u)
        assertThat(stack.size).isEqualTo(10)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1u..10u).toList())
      }

      @Test
      @DisplayName("build un sign long stack")
      fun uLong() {
        val stack: Stack<ULong> = stackOf(1uL..10uL)
        assertThat(stack.size).isEqualTo(10)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1uL..10uL).toList())
      }
    }

    @Nested
    @DisplayName("from Progression")
    inner class Progression {
      @Test
      @DisplayName("build integer stack")
      fun integer() {
        val stack: Stack<Int> = stackOf(1..10 step 2)
        assertThat(stack.size).isEqualTo(5)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1..10 step 2).toList())
      }

      @Test
      @DisplayName("build long stack")
      fun long() {
        val stack: Stack<Long> = stackOf(1..10L step 2)
        assertThat(stack.size).isEqualTo(5)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1..10L step 2).toList())
      }

      @Test
      @DisplayName("build char stack")
      fun char() {
        val stack: Stack<Char> = stackOf('a'..'z' step 2)
        assertThat(stack.size).isEqualTo(13)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo(('a'..'z' step 2).toList())
      }

      @Test
      @DisplayName("build un sign integer stack")
      fun uInteger() {
        val stack: Stack<UInt> = stackOf(1u..10u step 2)
        assertThat(stack.size).isEqualTo(5)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1u..10u step 2).toList())
      }

      @Test
      @DisplayName("build un sign long stack")
      fun uLong() {
        val stack: Stack<ULong> = stackOf(1uL..10uL step 2)
        assertThat(stack.size).isEqualTo(5)
        assertThat(stack).isInstanceOf(Stack::class.java)
        assertThat(stack).isEqualTo((1uL..10uL step 2).toList())
      }
    }
  }

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("toStack")
    fun toStack() {
      assertThat((1..10).toStack()).isEqualTo(stackOf(1..10))
    }
  }


  @Test
  @DisplayName("stack functionality")
  fun testStackOf() {
    val stack = stackOf(1, 2, 3, 4, 5, 6)
    assertThat(stack.size).isEqualTo(6)
    assertThat(stack.toList()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    assertThat(stack.pop()).isEqualTo(6)
    assertThat(stack.peek()).isEqualTo(5)
    stack.push(4)
    assertThat(stack.peek()).isEqualTo(4)
  }
}
