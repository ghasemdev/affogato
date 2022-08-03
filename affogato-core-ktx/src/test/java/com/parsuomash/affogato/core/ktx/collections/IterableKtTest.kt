package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class IterableKtTest {
  @Test
  @DisplayName("lastIndex")
  fun array() {
    val array: List<Int> = listOf(1..10)
    assertThat(array.size).isEqualTo(10)
    assertThat(array.lastIndex).isEqualTo(9)
  }

  @Nested
  @DisplayName("Getter")
  inner class Get {
    @Nested
    @DisplayName("get sub-array with range")
    inner class GetRange {
      @Test
      @DisplayName("List<T>")
      fun array() {
        val array: List<Int> = listOf(1..10)[0..4]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(List::class.java)
        assertThat(array).isEqualTo((1..5).toList())
      }
    }

    @Nested
    @DisplayName("get sub-array with progression")
    inner class GetProgression {
      @Test
      @DisplayName("List<T>")
      fun array() {
        val array: List<Int> = listOf(1..10)[0..9 step 2]
        assertThat(array.size).isEqualTo(5)
        assertThat(array).isInstanceOf(List::class.java)
        assertThat(array).isEqualTo(listOf(1..10 step 2))
      }
    }

    @Nested
    @DisplayName("getOrNull sub-array with range")
    inner class GetOrNullRange {
      @Test
      @DisplayName("List<T>")
      fun array() {
        val array: List<Int> = listOf(1..10)
        assertThat(array.getOrNull(0..4)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..4)!!).isInstanceOf(List::class.java)
        assertThat(array.getOrNull(0..4)!!).isEqualTo((1..5).toList())
        assertThrows<IndexOutOfBoundsException> { array[0..10] }
        assertThat(array.getOrNull(0..10)).isNull()
      }
    }

    @Nested
    @DisplayName("getOrNull sub-array with progression")
    inner class GetOrNullProgression {
      @Test
      @DisplayName("List<T>")
      fun array() {
        val array: List<Int> = listOf(1..10)
        assertThat(array.getOrNull(0..9 step 2)!!.size).isEqualTo(5)
        assertThat(array.getOrNull(0..9 step 2)!!).isInstanceOf(List::class.java)
        assertThat(array.getOrNull(0..9 step 2)!!).isEqualTo(listOf(1..10 step 2))
        assertThat(array.getOrNull(0..10 step 2)).isNull()
      }
    }

    @Nested
    @DisplayName("getOrElse sub-array with range")
    inner class GetOrElseRange {
      @Test
      @DisplayName("List<T>")
      fun array() {
        val array: List<Int> = listOf(1..10)
        assertThat(array.getOrElse(0..4) { emptyList() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..4) { emptyList() })
          .isInstanceOf(List::class.java)
        assertThat(array.getOrElse(0..4) { emptyList() })
          .isEqualTo((1..5).toList())
        assertThat(array.getOrElse(0..10) { emptyList() }).isEmpty()
      }
    }

    @Nested
    @DisplayName("getOrElse sub-array with progression")
    inner class GetOrElseProgression {
      @Test
      @DisplayName("List<T>")
      fun array() {
        val array: List<Int> = listOf(1..10)
        assertThat(array.getOrElse(0..9 step 2) { emptyList() }.size).isEqualTo(5)
        assertThat(array.getOrElse(0..9 step 2) { emptyList() })
          .isInstanceOf(List::class.java)
        assertThat(array.getOrElse(0..9 step 2) { emptyList() })
          .isEqualTo(listOf(1..10 step 2))
        assertThat(array.getOrElse(0..10 step 2) { emptyList() }).isEmpty()
      }
    }
  }

  @Nested
  @DisplayName("Head")
  inner class Head {
    @Test
    @DisplayName("List<T>")
    fun array() {
      val list = listOf(1..10).head(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(1..5))
      assertThat(emptyList<Int>().head(10)).isEmpty()
      assertThat(listOf(1, 2, 3).head(0)).isEmpty()
    }
  }

  @Nested
  @DisplayName("Tail")
  inner class Tail {
    @Test
    @DisplayName("List<T>")
    fun array() {
      val list = listOf(1..10).tail(5)
      assertThat(list.size).isEqualTo(5)
      assertThat(list).isEqualTo(listOf(6..10))
      assertThat(emptyList<Int>().tail(10)).isEmpty()
      assertThat(listOf(1, 2, 3).tail(0)).isEmpty()
    }
  }

  @Nested
  @DisplayName("find sum of")
  inner class FindSum {
    @Nested
    @DisplayName("Pair")
    inner class Pair {
      @Test
      @DisplayName("List<T>")
      fun array() {
        val pair = listOf(1..10).findPairOfSum(4)
        pair?.let { (x, y) -> assertThat(x + y).isEqualTo(4) }

        val floatPair = listOf(1F, 2F, 3F, 4F).findPairOfSum(4F)
        floatPair?.let { (x, y) -> assertThat(x + y).isEqualTo(4F) }

        val doublePair = listOf(1.0, 2.0, 3.0, 4.0).findPairOfSum(4.0)
        doublePair?.let { (x, y) -> assertThat(x + y).isEqualTo(4.0) }

        val nullPair = listOf(1..5L).findPairOfSum(20)
        assertThat(nullPair).isNull()
      }
    }

    @Nested
    @DisplayName("Triple")
    inner class Triple {
      @Test
      @DisplayName("List<T>")
      fun array() {
        val triple = listOf(1..10).findTripleOfSum(4)
        triple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4) }

        val floatTriple = listOf(1F, 2F, 3F, 4F).findTripleOfSum(4F)
        floatTriple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4F) }

        val doubleTriple = listOf(1.0, 2.0, 3.0, 4.0).findTripleOfSum(4.0)
        doubleTriple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4.0) }

        val nullTriple = listOf(1..5L).findTripleOfSum(20)
        assertThat(nullTriple).isNull()
      }
    }
  }

  @Nested
  @DisplayName("rotate")
  inner class Rotate {
    @Nested
    @DisplayName("left")
    inner class Left {
      @Test
      @DisplayName("array")
      fun array() {
        assertThat(listOf(1..10).rotateLeft(3)).isEqualTo(listOf(8..10) + listOf(1..7))
        assertThat(listOf(1..10).rotateLeft()).isEqualTo(listOf(10) + listOf(1..9))
      }
    }

    @Nested
    @DisplayName("right")
    inner class Right {
      @Test
      @DisplayName("array")
      fun array() {
        assertThat(listOf(1..10).rotateRight(3)).isEqualTo(listOf(4..10) + listOf(1..3))
        assertThat(listOf(1..10).rotateRight()).isEqualTo(listOf(2..10) + listOf(1))
      }
    }
  }
}
