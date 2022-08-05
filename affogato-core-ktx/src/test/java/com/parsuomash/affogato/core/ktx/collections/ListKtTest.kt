package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import io.kotlintest.matchers.instanceOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ListKtTest {
  @Nested
  @DisplayName("List Builders")
  inner class Builder {
    @Nested
    @DisplayName("empty")
    inner class Empty {
      @Test
      @DisplayName("build list")
      fun list() {
        with(assertThat(mutableListOf<Int>())) {
          isEmpty()
          instanceOf(MutableList::class)
        }
        with(assertThat(emptyMutableList<Int>())) {
          instanceOf(MutableList::class)
          isEmpty()
        }
        with(assertThat(linkedListOf<Int>())) {
          instanceOf(LinkedList::class)
          isEmpty()
        }
        with(assertThat(emptyLinkedList<Int>())) {
          instanceOf(LinkedList::class)
          isEmpty()
        }
      }
    }

    @Nested
    @DisplayName("from vararg")
    inner class VarArgs {
      @Test
      @DisplayName("build linked list")
      fun linkedList() {
        val linkedList = linkedListOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(linkedList.size).isEqualTo(7)
        assertThat(linkedList).isInstanceOf(LinkedList::class.java)
        assertThat(linkedList).isEqualTo((1..7).toList())
      }
    }

    @Nested
    @DisplayName("from Range")
    inner class Range {
      @Test
      @DisplayName("build integer list")
      fun integer() {
        val intList: List<Int> = listOf(1..10)
        assertThat(intList.size).isEqualTo(10)
        assertThat(intList).isInstanceOf(List::class.java)
        assertThat(intList).isEqualTo((1..10).toList())

        val intMutableList: MutableList<Int> = mutableListOf(1..10)
        assertThat(intMutableList.size).isEqualTo(10)
        assertThat(intMutableList).isInstanceOf(MutableList::class.java)
        assertThat(intMutableList).isEqualTo((1..10).toMutableList())

        val intArrayList: ArrayList<Int> = arrayListOf(1..10)
        assertThat(intArrayList.size).isEqualTo(10)
        assertThat(intArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(intArrayList).isEqualTo((1..10).toList())

        val intLinkedList: LinkedList<Int> = linkedListOf(1..10)
        assertThat(intLinkedList.size).isEqualTo(10)
        assertThat(intLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(intLinkedList).isEqualTo((1..10).toList())
      }

      @Test
      @DisplayName("build long list")
      fun long() {
        val longList: List<Long> = listOf(1..10L)
        assertThat(longList.size).isEqualTo(10)
        assertThat(longList).isInstanceOf(List::class.java)
        assertThat(longList).isEqualTo((1..10L).toList())

        val longMutableList: MutableList<Long> = mutableListOf(1..10L)
        assertThat(longMutableList.size).isEqualTo(10)
        assertThat(longMutableList).isInstanceOf(MutableList::class.java)
        assertThat(longMutableList).isEqualTo((1..10L).toMutableList())

        val longArrayList: ArrayList<Long> = arrayListOf(1..10L)
        assertThat(longArrayList.size).isEqualTo(10)
        assertThat(longArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(longArrayList).isEqualTo((1..10L).toList())

        val longLinkedList: LinkedList<Long> = linkedListOf(1..10L)
        assertThat(longLinkedList.size).isEqualTo(10)
        assertThat(longLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(longLinkedList).isEqualTo((1..10L).toList())
      }

      @Test
      @DisplayName("build char list")
      fun char() {
        val charList: List<Char> = listOf('a'..'z')
        assertThat(charList.size).isEqualTo(26)
        assertThat(charList).isInstanceOf(List::class.java)
        assertThat(charList).isEqualTo(('a'..'z').toList())

        val charMutableList: MutableList<Char> = mutableListOf('a'..'z')
        assertThat(charMutableList.size).isEqualTo(26)
        assertThat(charMutableList).isInstanceOf(MutableList::class.java)
        assertThat(charMutableList).isEqualTo(('a'..'z').toMutableList())

        val charArrayList: ArrayList<Char> = arrayListOf('a'..'z')
        assertThat(charArrayList.size).isEqualTo(26)
        assertThat(charArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(charArrayList).isEqualTo(('a'..'z').toList())

        val charLinkedList: LinkedList<Char> = linkedListOf('a'..'z')
        assertThat(charLinkedList.size).isEqualTo(26)
        assertThat(charLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(charLinkedList).isEqualTo(('a'..'z').toList())
      }

      @Test
      @DisplayName("build un sign integer")
      fun uInteger() {
        val uIntList: List<UInt> = listOf(1u..10u)
        assertThat(uIntList.size).isEqualTo(10)
        assertThat(uIntList).isInstanceOf(List::class.java)
        assertThat(uIntList).isEqualTo((1u..10u).toList())

        val uIntMutableList: MutableList<UInt> = mutableListOf(1u..10u)
        assertThat(uIntMutableList.size).isEqualTo(10)
        assertThat(uIntMutableList).isInstanceOf(MutableList::class.java)
        assertThat(uIntMutableList).isEqualTo((1u..10u).toMutableList())

        val uIntArrayList: ArrayList<UInt> = arrayListOf(1u..10u)
        assertThat(uIntArrayList.size).isEqualTo(10)
        assertThat(uIntArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(uIntArrayList).isEqualTo((1u..10u).toList())

        val uIntLinkedList: LinkedList<UInt> = linkedListOf(1u..10u)
        assertThat(uIntLinkedList.size).isEqualTo(10)
        assertThat(uIntLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(uIntLinkedList).isEqualTo((1u..10u).toList())
      }

      @Test
      @DisplayName("build un sign long list")
      fun uLong() {
        val uLongList: List<ULong> = listOf(1uL..10uL)
        assertThat(uLongList.size).isEqualTo(10)
        assertThat(uLongList).isInstanceOf(List::class.java)
        assertThat(uLongList).isEqualTo((1uL..10uL).toList())

        val uLongMutableList: MutableList<ULong> = mutableListOf(1uL..10uL)
        assertThat(uLongMutableList.size).isEqualTo(10)
        assertThat(uLongMutableList).isInstanceOf(MutableList::class.java)
        assertThat(uLongMutableList).isEqualTo((1uL..10uL).toMutableList())

        val uLongArrayList: ArrayList<ULong> = arrayListOf(1uL..10uL)
        assertThat(uLongArrayList.size).isEqualTo(10)
        assertThat(uLongArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(uLongArrayList).isEqualTo((1uL..10uL).toList())

        val uLongLinkedList: LinkedList<ULong> = linkedListOf(1uL..10uL)
        assertThat(uLongLinkedList.size).isEqualTo(10)
        assertThat(uLongLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(uLongLinkedList).isEqualTo((1uL..10uL).toList())
      }
    }

    @Nested
    @DisplayName("from Progression")
    inner class Progression {
      @Test
      @DisplayName("build integer list")
      fun integer() {
        val intList: List<Int> = listOf(1..10 step 2)
        assertThat(intList.size).isEqualTo(5)
        assertThat(intList).isInstanceOf(List::class.java)
        assertThat(intList).isEqualTo((1..10 step 2).toList())

        val intMutableList: MutableList<Int> = mutableListOf(1..10 step 2)
        assertThat(intMutableList.size).isEqualTo(5)
        assertThat(intMutableList).isInstanceOf(MutableList::class.java)
        assertThat(intMutableList).isEqualTo((1..10 step 2).toMutableList())

        val intArrayList: ArrayList<Int> = arrayListOf(1..10 step 2)
        assertThat(intArrayList.size).isEqualTo(5)
        assertThat(intArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(intArrayList).isEqualTo((1..10 step 2).toList())

        val intLinkedList: LinkedList<Int> = linkedListOf(1..10 step 2)
        assertThat(intLinkedList.size).isEqualTo(5)
        assertThat(intLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(intLinkedList).isEqualTo((1..10 step 2).toList())
      }

      @Test
      @DisplayName("build long list")
      fun long() {
        val longList: List<Long> = listOf(1..10L step 2)
        assertThat(longList.size).isEqualTo(5)
        assertThat(longList).isInstanceOf(List::class.java)
        assertThat(longList).isEqualTo((1..10L step 2).toList())

        val longMutableList: MutableList<Long> = mutableListOf(1..10L step 2)
        assertThat(longMutableList.size).isEqualTo(5)
        assertThat(longMutableList).isInstanceOf(MutableList::class.java)
        assertThat(longMutableList).isEqualTo((1..10L step 2).toMutableList())

        val longArrayList: ArrayList<Long> = arrayListOf(1..10L step 2)
        assertThat(longArrayList.size).isEqualTo(5)
        assertThat(longArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(longArrayList).isEqualTo((1..10L step 2).toList())

        val longLinkedList: LinkedList<Long> = linkedListOf(1..10L step 2)
        assertThat(longLinkedList.size).isEqualTo(5)
        assertThat(longLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(longLinkedList).isEqualTo((1..10L step 2).toList())
      }

      @Test
      @DisplayName("build char list")
      fun char() {
        val charList: List<Char> = listOf('a'..'z' step 2)
        assertThat(charList.size).isEqualTo(13)
        assertThat(charList).isInstanceOf(List::class.java)
        assertThat(charList).isEqualTo(('a'..'z' step 2).toList())

        val charMutableList: MutableList<Char> = mutableListOf('a'..'z' step 2)
        assertThat(charMutableList.size).isEqualTo(13)
        assertThat(charMutableList).isInstanceOf(MutableList::class.java)
        assertThat(charMutableList).isEqualTo(('a'..'z' step 2).toMutableList())

        val charArrayList: ArrayList<Char> = arrayListOf('a'..'z' step 2)
        assertThat(charArrayList.size).isEqualTo(13)
        assertThat(charArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(charArrayList).isEqualTo(('a'..'z' step 2).toList())

        val charLinkedList: LinkedList<Char> = linkedListOf('a'..'z' step 2)
        assertThat(charLinkedList.size).isEqualTo(13)
        assertThat(charLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(charLinkedList).isEqualTo(('a'..'z' step 2).toList())
      }

      @Test
      @DisplayName("build un sign integer list")
      fun uInteger() {
        val uIntList: List<UInt> = listOf(1u..10u step 2)
        assertThat(uIntList.size).isEqualTo(5)
        assertThat(uIntList).isInstanceOf(List::class.java)
        assertThat(uIntList).isEqualTo((1u..10u step 2).toList())

        val uIntMutableList: MutableList<UInt> = mutableListOf(1u..10u step 2)
        assertThat(uIntMutableList.size).isEqualTo(5)
        assertThat(uIntMutableList).isInstanceOf(MutableList::class.java)
        assertThat(uIntMutableList).isEqualTo((1u..10u step 2).toMutableList())

        val uIntArrayList: ArrayList<UInt> = arrayListOf(1u..10u step 2)
        assertThat(uIntArrayList.size).isEqualTo(5)
        assertThat(uIntArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(uIntArrayList).isEqualTo((1u..10u step 2).toList())

        val uIntLinkedList: LinkedList<UInt> = linkedListOf(1u..10u step 2)
        assertThat(uIntLinkedList.size).isEqualTo(5)
        assertThat(uIntLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(uIntLinkedList).isEqualTo((1u..10u step 2).toList())
      }

      @Test
      @DisplayName("build un sign long list")
      fun uLong() {
        val uLongList: List<ULong> = listOf(1uL..10uL step 2)
        assertThat(uLongList.size).isEqualTo(5)
        assertThat(uLongList).isInstanceOf(List::class.java)
        assertThat(uLongList).isEqualTo((1uL..10uL step 2).toList())

        val uLongMutableList: MutableList<ULong> = mutableListOf(1uL..10uL step 2)
        assertThat(uLongMutableList.size).isEqualTo(5)
        assertThat(uLongMutableList).isInstanceOf(MutableList::class.java)
        assertThat(uLongMutableList).isEqualTo((1uL..10uL step 2).toMutableList())

        val uLongArrayList: ArrayList<ULong> = arrayListOf(1uL..10uL step 2)
        assertThat(uLongArrayList.size).isEqualTo(5)
        assertThat(uLongArrayList).isInstanceOf(ArrayList::class.java)
        assertThat(uLongArrayList).isEqualTo((1uL..10uL step 2).toList())

        val uLongLinkedList: LinkedList<ULong> = linkedListOf(1uL..10uL step 2)
        assertThat(uLongLinkedList.size).isEqualTo(5)
        assertThat(uLongLinkedList).isInstanceOf(LinkedList::class.java)
        assertThat(uLongLinkedList).isEqualTo((1uL..10uL step 2).toList())
      }
    }

    @Test
    @DisplayName("refresh")
    fun refresh() {
      val list = mutableListOf(1..10)
      list.refreshList(4..6)
      assertThat(list).isEqualTo(listOf(4, 5, 6))
      assertThat(list.size).isEqualTo(3)

      val list2 = arrayListOf(1..10)
      list2.refreshList(listOf(4, 5))
      assertThat(list2).isEqualTo(listOf(4, 5))
      assertThat(list2.size).isEqualTo(2)
    }

    @Test
    @DisplayName("add new items")
    fun addNewItems() {
      val list = mutableListOf(1..10)
      list.addNewItems(10..15)
      assertThat(list).isEqualTo(listOf(1..15))
      assertThat(list.size).isEqualTo(15)

      val list2 = arrayListOf(1..10)
      list2.addNewItems(listOf(10..15))
      assertThat(list2).isEqualTo(listOf(1..15))
      assertThat(list2.size).isEqualTo(15)
    }
  }

  @Test
  @DisplayName("linked list functionality")
  fun testLinkedListOf() {
    val linkedList = linkedListOf(1, 2, 3, 4, 5, 6)
    assertThat(linkedList.size).isEqualTo(6)
    assertThat(linkedList).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    assertThat(linkedList.pop()).isEqualTo(1)
    assertThat(linkedList.peek()).isEqualTo(2)
    linkedList.push(4)
    assertThat(linkedList.peek()).isEqualTo(4)
    assertThat(linkedList.poll()).isEqualTo(4)
    assertThat(linkedList[0]).isEqualTo(2)
    linkedList.add(2, 20)
    assertThat(linkedList[2]).isEqualTo(20)
    assertThat(linkedList[0]).isEqualTo(2)
  }
}
