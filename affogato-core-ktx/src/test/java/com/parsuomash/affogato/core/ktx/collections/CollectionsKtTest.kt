package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CollectionsKtTest {
  @Test
  @DisplayName("lastIndex")
  fun array() {
    val myList = listOf(1..10)
    assertThat(myList.lastIndex).isEqualTo(9)

    val myMutableList = mutableListOf(1..10)
    assertThat(myMutableList.lastIndex).isEqualTo(9)

    val mySet = setOf(1..10)
    assertThat(mySet.lastIndex).isEqualTo(9)

    val myArrayList = arrayListOf(1..10)
    assertThat(myArrayList.lastIndex).isEqualTo(9)

    val myStack = stackOf(1..10)
    assertThat(myStack.lastIndex).isEqualTo(9)

    val myLinkedList = linkedListOf(1..10)
    assertThat(myLinkedList.lastIndex).isEqualTo(9)

    val myVector = vectorOf(1..10)
    assertThat(myVector.lastIndex).isEqualTo(9)

    val myQueue = queueOf(1..10)
    assertThat(myQueue.lastIndex).isEqualTo(9)
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

    @Test
    @DisplayName("get or empty")
    fun getOrEmpty() {
      assertThat(listOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(mutableListOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(arrayListOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(linkedListOf("a", "b", "c").getOrEmpty(3)).isEmpty()

      assertThat(setOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(hashSetOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(linkedSetOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(sortedSetOf("a", "b", "c").getOrEmpty(3)).isEmpty()

      assertThat(stackOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(vectorOf("a", "b", "c").getOrEmpty(3)).isEmpty()

      assertThat(queueOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(priorityQueueOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(dequeOf("a", "b", "c").getOrEmpty(3)).isEmpty()
      assertThat(arrayDequeOf("a", "b", "c").getOrEmpty(3)).isEmpty()
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
      fun list() {
        val pair = listOf(1..10).findPairOfSum(4)
        pair?.let { (x, y) -> assertThat(x + y).isEqualTo(4) }

        val floatPair = listOf(1F, 2F, 3F, 4F).findPairOfSum(4F)
        floatPair?.let { (x, y) -> assertThat(x + y).isEqualTo(4F) }

        val doublePair = listOf(1.0, 2.0, 3.0, 4.0).findPairOfSum(4.0)
        doublePair?.let { (x, y) -> assertThat(x + y).isEqualTo(4.0) }

        val longPair = listOf(1..10L).findPairOfSum(4L)
        longPair?.let { (x, y) -> assertThat(x + y).isEqualTo(4L) }
      }

      @Test
      @DisplayName("null Pair")
      fun nullList() {
        val pair = listOf(1..5).findPairOfSum(20)
        assertThat(pair).isNull()
        val floatPair = listOf(1F, 2F, 3F, 4F).findPairOfSum(20F)
        assertThat(floatPair).isNull()
        val doublePair = listOf(1.0, 2.0, 3.0, 4.0).findPairOfSum(20.0)
        assertThat(doublePair).isNull()
        val longPair = listOf(1..5L).findPairOfSum(20L)
        assertThat(longPair).isNull()
      }
    }

    @Nested
    @DisplayName("Triple")
    inner class Triple {
      @Test
      @DisplayName("List<T>")
      fun list() {
        val triple = listOf(1..10).findTripleOfSum(4)
        triple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4) }

        val floatTriple = listOf(1F, 2F, 3F, 4F).findTripleOfSum(4F)
        floatTriple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4F) }

        val doubleTriple = listOf(1.0, 2.0, 3.0, 4.0).findTripleOfSum(4.0)
        doubleTriple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4.0) }

        val longTriple = listOf(1..10L).findTripleOfSum(4L)
        longTriple?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(4L) }
      }

      @Test
      @DisplayName("null Pair")
      fun nullList() {
        val triple = listOf(1..5).findTripleOfSum(20)
        assertThat(triple).isNull()
        val floatTriple = listOf(1F, 2F, 3F, 4F).findTripleOfSum(20F)
        assertThat(floatTriple).isNull()
        val doubleTriple = listOf(1.0, 2.0, 3.0, 4.0).findTripleOfSum(20.0)
        assertThat(doubleTriple).isNull()
        val longTriple = listOf(1..5L).findTripleOfSum(20L)
        assertThat(longTriple).isNull()
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

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("toArrayList")
    fun toArrayList() {
      assertThat((1..10).toArrayList()).isEqualTo(arrayListOf(1..10))
    }

    @Test
    @DisplayName("toLinkedList")
    fun toLinkedList() {
      assertThat((1..10).toLinkedList()).isEqualTo(linkedListOf(1..10))
    }
  }
}
