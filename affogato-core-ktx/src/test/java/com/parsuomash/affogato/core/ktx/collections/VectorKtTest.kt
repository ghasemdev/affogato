package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import io.kotlintest.matchers.instanceOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class VectorKtTest {
  @Nested
  @DisplayName("Vector Builders")
  inner class Builder {
    @Nested
    @DisplayName("empty")
    inner class Empty {
      @Test
      @DisplayName("vector")
      fun vector() {
        with(assertThat(vectorOf<Int>())) {
          isEmpty()
          instanceOf(Vector::class)
        }
        with(assertThat(emptyVector<Int>())) {
          instanceOf(Vector::class)
          isEmpty()
        }
      }
    }

    @Nested
    @DisplayName("from vararg")
    inner class VarArgs {
      @Test
      @DisplayName("vector")
      fun vector() {
        val vector = vectorOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(vector.size).isEqualTo(7)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1..7).toList())
      }
    }

    @Nested
    @DisplayName("from Range")
    inner class Range {
      @Test
      @DisplayName("build integer vector")
      fun integer() {
        val vector: Vector<Int> = vectorOf(1..10)
        assertThat(vector.size).isEqualTo(10)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1..10).toList())
      }

      @Test
      @DisplayName("build long vector")
      fun long() {
        val vector: Vector<Long> = vectorOf(1..10L)
        assertThat(vector.size).isEqualTo(10)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1..10L).toList())
      }

      @Test
      @DisplayName("build char vector")
      fun char() {
        val vector: Vector<Char> = vectorOf('a'..'z')
        assertThat(vector.size).isEqualTo(26)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo(('a'..'z').toList())
      }

      @Test
      @DisplayName("build un sign integer vector")
      fun uInteger() {
        val vector: Vector<UInt> = vectorOf(1u..10u)
        assertThat(vector.size).isEqualTo(10)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1u..10u).toList())
      }

      @Test
      @DisplayName("build un sign long vector")
      fun uLong() {
        val vector: Vector<ULong> = vectorOf(1uL..10uL)
        assertThat(vector.size).isEqualTo(10)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1uL..10uL).toList())
      }
    }

    @Nested
    @DisplayName("from Progression")
    inner class Progression {
      @Test
      @DisplayName("build integer vector")
      fun integer() {
        val vector: Vector<Int> = vectorOf(1..10 step 2)
        assertThat(vector.size).isEqualTo(5)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1..10 step 2).toList())
      }

      @Test
      @DisplayName("build long vector")
      fun long() {
        val vector: Vector<Long> = vectorOf(1..10L step 2)
        assertThat(vector.size).isEqualTo(5)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1..10L step 2).toList())
      }

      @Test
      @DisplayName("build char vector")
      fun char() {
        val vector: Vector<Char> = vectorOf('a'..'z' step 2)
        assertThat(vector.size).isEqualTo(13)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo(('a'..'z' step 2).toList())
      }

      @Test
      @DisplayName("build un sign integer vector")
      fun uInteger() {
        val vector: Vector<UInt> = vectorOf(1u..10u step 2)
        assertThat(vector.size).isEqualTo(5)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1u..10u step 2).toList())
      }

      @Test
      @DisplayName("build un sign long vector")
      fun uLong() {
        val vector: Vector<ULong> = vectorOf(1uL..10uL step 2)
        assertThat(vector.size).isEqualTo(5)
        assertThat(vector).isInstanceOf(Vector::class.java)
        assertThat(vector).isEqualTo((1uL..10uL step 2).toList())
      }
    }
  }
}
