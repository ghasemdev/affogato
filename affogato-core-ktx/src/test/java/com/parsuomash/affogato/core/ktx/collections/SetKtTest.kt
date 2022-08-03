package com.parsuomash.affogato.core.ktx.collections

import com.google.common.truth.Truth.assertThat
import io.kotlintest.matchers.instanceOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class SetKtTest {
  @Nested
  @DisplayName("Set Builders")
  inner class Builder {
    @Nested
    @DisplayName("empty")
    inner class Empty {
      @Test
      @DisplayName("set")
      fun set() {
        with(assertThat(setOf<Int>())) {
          isEmpty()
          instanceOf(Set::class)
        }
        with(assertThat(emptySet<Int>())) {
          instanceOf(Set::class)
          isEmpty()
        }
      }

      @Test
      @DisplayName("mutable set")
      fun mutableSet() {
        with(assertThat(mutableSetOf<Int>())) {
          instanceOf(MutableSet::class)
          isEmpty()
        }
        with(assertThat(emptyMutableSet<Int>())) {
          instanceOf(MutableSet::class)
          isEmpty()
        }
      }

      @Test
      @DisplayName("hash set")
      fun hashSet() {
        with(assertThat(hashSetOf<Int>())) {
          instanceOf(HashSet::class)
          isEmpty()
        }
        with(assertThat(emptyHashSet<Int>())) {
          instanceOf(HashSet::class)
          isEmpty()
        }
      }

      @Test
      @DisplayName("linked set")
      fun linkedSet() {
        with(assertThat(linkedSetOf<Int>())) {
          instanceOf(LinkedHashSet::class)
          isEmpty()
        }
        with(assertThat(emptyLinkedSet<Int>())) {
          instanceOf(LinkedHashSet::class)
          isEmpty()
        }
      }

      @Test
      @DisplayName("sorted set")
      fun sortedSet() {
        with(assertThat(sortedSetOf<Int>())) {
          instanceOf(TreeSet::class)
          isEmpty()
        }
        with(assertThat(emptySortedSet<Int>())) {
          instanceOf(TreeSet::class)
          isEmpty()
        }
      }

      @Test
      @DisplayName("hash table")
      fun hashTable() {
        with(assertThat(hashTableOf<Int, Int>())) {
          instanceOf(Hashtable::class)
          isEmpty()
        }
        with(assertThat(emptyHashTable<Int, Int>())) {
          instanceOf(Hashtable::class)
          isEmpty()
        }
      }
    }

    @Nested
    @DisplayName("from vararg")
    inner class VarArgs {
      @Test
      @DisplayName("set")
      fun set() {
        val set = setOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(set.size).isEqualTo(7)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1..7).toSet())
      }

      @Test
      @DisplayName("mutable set")
      fun mutableSet() {
        val set = mutableSetOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(set.size).isEqualTo(7)
        assertThat(set).isInstanceOf(MutableSet::class.java)
        assertThat(set.containsAll((1..7).toList())).isTrue()
      }

      @Test
      @DisplayName("hash set")
      fun hashSet() {
        val set = hashSetOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(set.size).isEqualTo(7)
        assertThat(set).isInstanceOf(HashSet::class.java)
        assertThat(set.containsAll((1..7).toList())).isTrue()
      }

      @Test
      @DisplayName("linked set")
      fun linkedSet() {
        val set = linkedSetOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(set.size).isEqualTo(7)
        assertThat(set).isInstanceOf(LinkedHashSet::class.java)
        assertThat(set.containsAll((1..7).toList())).isTrue()
      }

      @Test
      @DisplayName("sorted set")
      fun sortedSet() {
        val set = sortedSetOf(1, 2, 3, 4, 5, 6, 7)
        assertThat(set.size).isEqualTo(7)
        assertThat(set).isInstanceOf(TreeSet::class.java)
        assertThat(set.containsAll((1..7).toList())).isTrue()
      }

      @Test
      @DisplayName("hash table")
      fun hashTable() {
        val hashtable = hashTableOf(1 to 1, 2 to 1, 3 to 1)
        assertThat(hashtable.size).isEqualTo(3)
        assertThat(hashtable).isInstanceOf(Hashtable::class.java)
      }
    }

    @Nested
    @DisplayName("from Range")
    inner class Range {
      @Test
      @DisplayName("build integer set")
      fun integer() {
        val set: Set<Int> = setOf(1..10)
        assertThat(set.size).isEqualTo(10)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1..10).toSet())

        val hashSet: HashSet<Int> = hashSetOf(1..10)
        assertThat(hashSet.size).isEqualTo(10)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo((1..10).toHashSet())

        val mutableSet: MutableSet<Int> = mutableSetOf(1..10)
        assertThat(mutableSet.size).isEqualTo(10)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo((1..10).toMutableSet())

        val linkedSet: LinkedHashSet<Int> = linkedSetOf(1..10)
        assertThat(linkedSet.size).isEqualTo(10)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo((1..10).toSet())

        val sortedSet: TreeSet<Int> = sortedSetOf(1..10)
        assertThat(sortedSet.size).isEqualTo(10)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo((1..10).toSortedSet())
      }

      @Test
      @DisplayName("build long set")
      fun long() {
        val set: Set<Long> = setOf(1..10L)
        assertThat(set.size).isEqualTo(10)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1..10L).toSet())

        val hashSet: HashSet<Long> = hashSetOf(1..10L)
        assertThat(hashSet.size).isEqualTo(10)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo((1..10L).toHashSet())

        val mutableSet: MutableSet<Long> = mutableSetOf(1..10L)
        assertThat(mutableSet.size).isEqualTo(10)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo((1..10L).toMutableSet())

        val linkedSet: LinkedHashSet<Long> = linkedSetOf(1..10L)
        assertThat(linkedSet.size).isEqualTo(10)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo((1..10L).toSet())

        val sortedSet: TreeSet<Long> = sortedSetOf(1..10L)
        assertThat(sortedSet.size).isEqualTo(10)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo((1..10L).toSortedSet())
      }

      @Test
      @DisplayName("build char set")
      fun char() {
        val set: Set<Char> = setOf('a'..'z')
        assertThat(set.size).isEqualTo(26)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo(('a'..'z').toSet())

        val hashSet: HashSet<Char> = hashSetOf('a'..'z')
        assertThat(hashSet.size).isEqualTo(26)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo(('a'..'z').toHashSet())

        val mutableSet: MutableSet<Char> = mutableSetOf('a'..'z')
        assertThat(mutableSet.size).isEqualTo(26)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo(('a'..'z').toMutableSet())

        val linkedSet: LinkedHashSet<Char> = linkedSetOf('a'..'z')
        assertThat(linkedSet.size).isEqualTo(26)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo(('a'..'z').toSet())

        val sortedSet: TreeSet<Char> = sortedSetOf('a'..'z')
        assertThat(sortedSet.size).isEqualTo(26)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo(('a'..'z').toSortedSet())
      }

      @Test
      @DisplayName("build un sign integer set")
      fun uInteger() {
        val set: Set<UInt> = setOf(1u..10u)
        assertThat(set.size).isEqualTo(10)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1u..10u).toSet())

        val hashSet: HashSet<UInt> = hashSetOf(1u..10u)
        assertThat(hashSet.size).isEqualTo(10)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo((1u..10u).toHashSet())

        val mutableSet: MutableSet<UInt> = mutableSetOf(1u..10u)
        assertThat(mutableSet.size).isEqualTo(10)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo((1u..10u).toMutableSet())

        val linkedSet: LinkedHashSet<UInt> = linkedSetOf(1u..10u)
        assertThat(linkedSet.size).isEqualTo(10)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo((1u..10u).toSet())

        val sortedSet: TreeSet<UInt> = sortedSetOf(1u..10u)
        assertThat(sortedSet.size).isEqualTo(10)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo((1u..10u).toSortedSet())
      }

      @Test
      @DisplayName("build un sign long set")
      fun uLong() {
        val set: Set<ULong> = setOf(1uL..10uL)
        assertThat(set.size).isEqualTo(10)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1uL..10uL).toSet())

        val hashSet: HashSet<ULong> = hashSetOf(1uL..10uL)
        assertThat(hashSet.size).isEqualTo(10)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo((1uL..10uL).toHashSet())

        val mutableSet: MutableSet<ULong> = mutableSetOf(1uL..10uL)
        assertThat(mutableSet.size).isEqualTo(10)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo((1uL..10uL).toMutableSet())

        val linkedSet: LinkedHashSet<ULong> = linkedSetOf(1uL..10uL)
        assertThat(linkedSet.size).isEqualTo(10)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo((1uL..10uL).toSet())

        val sortedSet: TreeSet<ULong> = sortedSetOf(1uL..10uL)
        assertThat(sortedSet.size).isEqualTo(10)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo((1uL..10uL).toSortedSet())
      }
    }

    @Nested
    @DisplayName("from Progression")
    inner class Progression {
      @Test
      @DisplayName("build integer set")
      fun integer() {
        val set: Set<Int> = setOf(1..10 step 2)
        assertThat(set.size).isEqualTo(5)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1..10 step 2).toSet())

        val hashSet: HashSet<Int> = hashSetOf(1..10 step 2)
        assertThat(hashSet.size).isEqualTo(5)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo((1..10 step 2).toHashSet())

        val mutableSet: MutableSet<Int> = mutableSetOf(1..10 step 2)
        assertThat(mutableSet.size).isEqualTo(5)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo((1..10 step 2).toMutableSet())

        val linkedSet: LinkedHashSet<Int> = linkedSetOf(1..10 step 2)
        assertThat(linkedSet.size).isEqualTo(5)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo((1..10 step 2).toSet())

        val sortedSet: TreeSet<Int> = sortedSetOf(1..10 step 2)
        assertThat(sortedSet.size).isEqualTo(5)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo((1..10 step 2).toSortedSet())
      }

      @Test
      @DisplayName("build long set")
      fun long() {
        val set: Set<Long> = setOf(1..10L step 2)
        assertThat(set.size).isEqualTo(5)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1..10L step 2).toSet())

        val hashSet: HashSet<Long> = hashSetOf(1..10L step 2)
        assertThat(hashSet.size).isEqualTo(5)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo((1..10L step 2).toHashSet())

        val mutableSet: MutableSet<Long> = mutableSetOf(1..10L step 2)
        assertThat(mutableSet.size).isEqualTo(5)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo((1..10L step 2).toMutableSet())

        val linkedSet: LinkedHashSet<Long> = linkedSetOf(1..10L step 2)
        assertThat(linkedSet.size).isEqualTo(5)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo((1..10L step 2).toSet())

        val sortedSet: TreeSet<Long> = sortedSetOf(1..10L step 2)
        assertThat(sortedSet.size).isEqualTo(5)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo((1..10L step 2).toSortedSet())
      }

      @Test
      @DisplayName("build char set")
      fun char() {
        val set: Set<Char> = setOf('a'..'z' step 2)
        assertThat(set.size).isEqualTo(13)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo(('a'..'z' step 2).toSet())

        val hashSet: HashSet<Char> = hashSetOf('a'..'z' step 2)
        assertThat(hashSet.size).isEqualTo(13)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo(('a'..'z' step 2).toHashSet())

        val mutableSet: MutableSet<Char> = mutableSetOf('a'..'z' step 2)
        assertThat(mutableSet.size).isEqualTo(13)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo(('a'..'z' step 2).toMutableSet())

        val linkedSet: LinkedHashSet<Char> = linkedSetOf('a'..'z' step 2)
        assertThat(linkedSet.size).isEqualTo(13)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo(('a'..'z' step 2).toSet())

        val sortedSet: TreeSet<Char> = sortedSetOf('a'..'z' step 2)
        assertThat(sortedSet.size).isEqualTo(13)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo(('a'..'z' step 2).toSortedSet())
      }

      @Test
      @DisplayName("build un sign integer set")
      fun uInteger() {
        val set: Set<UInt> = setOf(1u..10u step 2)
        assertThat(set.size).isEqualTo(5)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1u..10u step 2).toSet())

        val hashSet: HashSet<UInt> = hashSetOf(1u..10u step 2)
        assertThat(hashSet.size).isEqualTo(5)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo((1u..10u step 2).toHashSet())

        val mutableSet: MutableSet<UInt> = mutableSetOf(1u..10u step 2)
        assertThat(mutableSet.size).isEqualTo(5)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo((1u..10u step 2).toMutableSet())

        val linkedSet: LinkedHashSet<UInt> = linkedSetOf(1u..10u step 2)
        assertThat(linkedSet.size).isEqualTo(5)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo((1u..10u step 2).toSet())

        val sortedSet: TreeSet<UInt> = sortedSetOf(1u..10u step 2)
        assertThat(sortedSet.size).isEqualTo(5)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo((1u..10u step 2).toSortedSet())
      }

      @Test
      @DisplayName("build un sign long set")
      fun uLong() {
        val set: Set<ULong> = setOf(1uL..10uL step 2)
        assertThat(set.size).isEqualTo(5)
        assertThat(set).isInstanceOf(Set::class.java)
        assertThat(set).isEqualTo((1uL..10uL step 2).toSet())

        val hashSet: HashSet<ULong> = hashSetOf(1uL..10uL step 2)
        assertThat(hashSet.size).isEqualTo(5)
        assertThat(hashSet).isInstanceOf(HashSet::class.java)
        assertThat(hashSet).isEqualTo((1uL..10uL step 2).toHashSet())

        val mutableSet: MutableSet<ULong> = mutableSetOf(1uL..10uL step 2)
        assertThat(mutableSet.size).isEqualTo(5)
        assertThat(mutableSet).isInstanceOf(MutableSet::class.java)
        assertThat(mutableSet).isEqualTo((1uL..10uL step 2).toMutableSet())

        val linkedSet: LinkedHashSet<ULong> = linkedSetOf(1uL..10uL step 2)
        assertThat(linkedSet.size).isEqualTo(5)
        assertThat(linkedSet).isInstanceOf(LinkedHashSet::class.java)
        assertThat(linkedSet).isEqualTo((1uL..10uL step 2).toSet())

        val sortedSet: TreeSet<ULong> = sortedSetOf(1uL..10uL step 2)
        assertThat(sortedSet.size).isEqualTo(5)
        assertThat(sortedSet).isInstanceOf(TreeSet::class.java)
        assertThat(sortedSet).isEqualTo((1uL..10uL step 2).toSortedSet())
      }
    }
  }

  @Nested
  @DisplayName("Converter")
  inner class Converter {
    @Test
    @DisplayName("toLinkedSet")
    fun toLinkedSet() {
      assertThat((1..10).toLinkedSet()).isEqualTo(linkedSetOf(1..10))
    }

    @Test
    @DisplayName("toHashTable")
    fun toHashTable() {
      assertThat(mapOf(1 to 1, 2 to 2).toHashTable()).isEqualTo(hashTableOf(1 to 1, 2 to 2))
      assertThat((1 to 1).toHashTable()).isEqualTo(hashTableOf(1 to 1))
    }
  }
}
