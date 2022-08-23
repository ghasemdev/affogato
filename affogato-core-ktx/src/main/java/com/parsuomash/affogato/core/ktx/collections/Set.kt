@file:Suppress("MethodOverloading", "TooManyFunctions")

package com.parsuomash.affogato.core.ktx.collections

/**
 * Returns a [LinkedHashSet] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toLinkedSet() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toLinkedSet(): LinkedHashSet<T> = LinkedHashSet(toList())

/**
 * Returns a [Hashtable] containing all elements.
 *
 * Example:
 * ```Kotlin
 * mapOf(1 to 2, 2 to 3).toHashTable() // {1=2, 2=3}
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Map<K, V>.toHashTable(): Hashtable<K, V> = Hashtable(this)

/**
 * Returns a [Hashtable] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1 to 2).toHashTable() // {1=2}
 * ```
 * @since 1.1.0
 */
inline fun <reified K, V> Pair<K, V>.toHashTable(): Hashtable<K, V> = Hashtable(mapOf(this))

/**
 * Return an integer [Set] from int range.
 *
 * Example:
 * ```Kotlin
 * setOf(1..10) // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(range: IntRange): Set<Int> = range.toSet()

/**
 * Return an un-sign integer [Set] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * setOf(1u..10u) // {1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(range: UIntRange): Set<UInt> = range.toSet()

/**
 * Return a long [Set] from long range.
 *
 * Example:
 * ```Kotlin
 * setOf(1..10L) // {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(range: LongRange): Set<Long> = range.toSet()

/**
 * Return an un-sign long [Set] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * setOf(1uL..10uL) // {1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(range: ULongRange): Set<ULong> = range.toSet()

/**
 * Return an integer [Set] from int progression.
 *
 * Example:
 * ```Kotlin
 * setOf(1..10 step 2) // {1, 3, 5, 7, 9}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(progression: IntProgression): Set<Int> = progression.toSet()

/**
 * Return an un-sign integer [Set] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * setOf(1u..10u step 2) // {1u, 3u, 5u, 7u, 9u}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(progression: UIntProgression): Set<UInt> = progression.toSet()

/**
 * Return a long [Set] from long progression.
 *
 * Example:
 * ```Kotlin
 * setOf(1..10L step 2) // {1L, 3L, 5L, 7L, 9L}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(progression: LongProgression): Set<Long> = progression.toSet()

/**
 * Return an un-sign long [Set] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * setOf(1uL..10uL step 2) // {1ul, 3uL, 5uL, 7uL, 9uL}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(progression: ULongProgression): Set<ULong> =
  progression.toSet()

/**
 * Return a char [Set] from char range.
 *
 * Example:
 * ```Kotlin
 * setOf('a'..'f') // {'a', 'b', 'c', 'd', 'e', 'f'}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(range: CharRange): Set<Char> = range.toSet()

/**
 * Return a char [Set] from char progression.
 *
 * Example:
 * ```Kotlin
 * setOf('a'..'f' step 2) // {'a', 'c', 'e'}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun setOf(progression: CharProgression): Set<Char> = progression.toSet()

/**
 * Return an integer [MutableSet] from int range.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf(1..10) // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(range: IntRange): MutableSet<Int> = range.toMutableSet()

/**
 * Return an un-sign integer [MutableSet] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf(1u..10u) // {1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(range: UIntRange): MutableSet<UInt> = range.toMutableSet()

/**
 * Return a long [MutableSet] from long range.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf(1..10L) // {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(range: LongRange): MutableSet<Long> = range.toMutableSet()

/**
 * Return an un-sign long [MutableSet] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf(1uL..10uL) // {1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(range: ULongRange): MutableSet<ULong> = range.toMutableSet()

/**
 * Return an integer [MutableSet] from int progression.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf(1..10 step 2) // {1, 3, 5, 7, 9}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(progression: IntProgression): MutableSet<Int> = progression.toMutableSet()

/**
 * Return an un-sign integer [MutableSet] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf(1u..10u step 2) // {1u, 3u, 5u, 7u, 9u}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(progression: UIntProgression): MutableSet<UInt> = progression.toMutableSet()

/**
 * Return a long [MutableSet] from long progression.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf(1..10L step 2) // {1L, 3L, 5L, 7L, 9L}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(progression: LongProgression): MutableSet<Long> = progression.toMutableSet()

/**
 * Return an un-sign long [MutableSet] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf(1uL..10uL step 2) // {1ul, 3uL, 5uL, 7uL, 9uL}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(progression: ULongProgression): MutableSet<ULong> =
  progression.toMutableSet()

/**
 * Return a char [MutableSet] from char range.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf('a'..'f') // {'a', 'b', 'c', 'd', 'e', 'f'}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(range: CharRange): MutableSet<Char> = range.toMutableSet()

/**
 * Return a char [MutableSet] from char progression.
 *
 * Example:
 * ```Kotlin
 * mutableSetOf('a'..'f' step 2) // {'a', 'c', 'e'}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun mutableSetOf(progression: CharProgression): MutableSet<Char> = progression.toMutableSet()

/**
 * Return an integer [HashSet] from int range.
 *
 * Example:
 * ```Kotlin
 * hashSetOf(1..10) // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(range: IntRange): HashSet<Int> = range.toHashSet()

/**
 * Return an un-sign integer [HashSet] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * hashSetOf(1u..10u) // {1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(range: UIntRange): HashSet<UInt> = range.toHashSet()

/**
 * Return a long [HashSet] from long range.
 *
 * Example:
 * ```Kotlin
 * hashSetOf(1..10L) // {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(range: LongRange): HashSet<Long> = range.toHashSet()

/**
 * Return an un-sign long [HashSet] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * hashSetOf(1uL..10uL) // {1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(range: ULongRange): HashSet<ULong> = range.toHashSet()

/**
 * Return an integer [HashSet] from int progression.
 *
 * Example:
 * ```Kotlin
 * hashSetOf(1..10 step 2) // {1, 3, 5, 7, 9}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(progression: IntProgression): HashSet<Int> = progression.toHashSet()

/**
 * Return an un-sign integer [HashSet] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * hashSetOf(1u..10u step 2) // {1u, 3u, 5u, 7u, 9u}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(progression: UIntProgression): HashSet<UInt> = progression.toHashSet()

/**
 * Return a long [HashSet] from long progression.
 *
 * Example:
 * ```Kotlin
 * hashSetOf(1..10L step 2) // {1L, 3L, 5L, 7L, 9L}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(progression: LongProgression): HashSet<Long> = progression.toHashSet()

/**
 * Return an un-sign long [HashSet] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * hashSetOf(1uL..10uL step 2) // {1ul, 3uL, 5uL, 7uL, 9uL}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(progression: ULongProgression): HashSet<ULong> =
  progression.toHashSet()

/**
 * Return a char [HashSet] from char range.
 *
 * Example:
 * ```Kotlin
 * hashSetOf('a'..'f') // {'a', 'b', 'c', 'd', 'e', 'f'}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(range: CharRange): HashSet<Char> = range.toHashSet()

/**
 * Return a char [HashSet] from char progression.
 *
 * Example:
 * ```Kotlin
 * hashSetOf('a'..'f' step 2) // {'a', 'c', 'e'}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun hashSetOf(progression: CharProgression): HashSet<Char> = progression.toHashSet()

/**
 * Return an integer [LinkedHashSet] from int range.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf(1..10) // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(range: IntRange): LinkedHashSet<Int> = LinkedHashSet(range.toList())

/**
 * Return an un-sign integer [LinkedHashSet] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf(1u..10u) // {1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(range: UIntRange): LinkedHashSet<UInt> = LinkedHashSet(range.toList())

/**
 * Return a long [LinkedHashSet] from long range.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf(1..10L) // {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(range: LongRange): LinkedHashSet<Long> = LinkedHashSet(range.toList())

/**
 * Return an un-sign long [LinkedHashSet] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf(1uL..10uL) // {1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(range: ULongRange): LinkedHashSet<ULong> = LinkedHashSet(range.toList())

/**
 * Return an integer [LinkedHashSet] from int progression.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf(1..10 step 2) // {1, 3, 5, 7, 9}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(progression: IntProgression): LinkedHashSet<Int> =
  LinkedHashSet(progression.toList())

/**
 * Return an un-sign integer [LinkedHashSet] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf(1u..10u step 2) // {1u, 3u, 5u, 7u, 9u}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(progression: UIntProgression): LinkedHashSet<UInt> =
  LinkedHashSet(progression.toList())

/**
 * Return a long [LinkedHashSet] from long progression.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf(1..10L step 2) // {1L, 3L, 5L, 7L, 9L}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(progression: LongProgression): LinkedHashSet<Long> =
  LinkedHashSet(progression.toList())

/**
 * Return an un-sign long [LinkedHashSet] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf(1uL..10uL step 2) // {1ul, 3uL, 5uL, 7uL, 9uL}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(progression: ULongProgression): LinkedHashSet<ULong> =
  LinkedHashSet(progression.toList())

/**
 * Return a char [LinkedHashSet] from char range.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf('a'..'f') // {'a', 'b', 'c', 'd', 'e', 'f'}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(range: CharRange): LinkedHashSet<Char> = LinkedHashSet(range.toList())

/**
 * Return a char [LinkedHashSet] from char progression.
 *
 * Example:
 * ```Kotlin
 * linkedSetOf('a'..'f' step 2) // {'a', 'c', 'e'}
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun linkedSetOf(progression: CharProgression): LinkedHashSet<Char> =
  LinkedHashSet(progression.toList())

/**
 * Return an integer [TreeSet] from int range.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf(1..10) // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(range: IntRange): TreeSet<Int> = TreeSet(range.toList())

/**
 * Return an un-sign integer [TreeSet] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf(1u..10u) // {1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(range: UIntRange): TreeSet<UInt> = TreeSet(range.toList())

/**
 * Return a long [TreeSet] from long range.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf(1..10L) // {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(range: LongRange): TreeSet<Long> = TreeSet(range.toList())

/**
 * Return an un-sign long [TreeSet] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf(1uL..10uL) // {1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(range: ULongRange): TreeSet<ULong> = TreeSet(range.toList())

/**
 * Return an integer [TreeSet] from int progression.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf(1..10 step 2) // {1, 3, 5, 7, 9}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(progression: IntProgression): TreeSet<Int> = TreeSet(progression.toList())

/**
 * Return an un-sign integer [TreeSet] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf(1u..10u step 2) // {1u, 3u, 5u, 7u, 9u}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(progression: UIntProgression): TreeSet<UInt> = TreeSet(progression.toList())

/**
 * Return a long [TreeSet] from long progression.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf(1..10L step 2) // {1L, 3L, 5L, 7L, 9L}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(progression: LongProgression): TreeSet<Long> = TreeSet(progression.toList())

/**
 * Return an un-sign long [TreeSet] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf(1uL..10uL step 2) // {1ul, 3uL, 5uL, 7uL, 9uL}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(progression: ULongProgression): TreeSet<ULong> = TreeSet(progression.toList())

/**
 * Return a char [TreeSet] from char range.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf('a'..'f') // {'a', 'b', 'c', 'd', 'e', 'f'}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(range: CharRange): TreeSet<Char> = TreeSet(range.toList())

/**
 * Return a char [TreeSet] from char progression.
 *
 * Example:
 * ```Kotlin
 * sortedSetOf('a'..'f' step 2) // {'a', 'c', 'e'}
 * ```
 * @since 1.1.0
 * @see SortedSet
 */
@JvmSynthetic
fun sortedSetOf(progression: CharProgression): TreeSet<Char> = TreeSet(progression.toList())

/**
 * Return an empty new [Hashtable].
 * @since 1.1.0
 */
inline fun <reified K, V> hashTableOf(): Hashtable<K, V> = Hashtable()

/**
 * Returns a [Hashtable] of given elements.
 * @since 1.1.0
 */
inline fun <reified K, V> hashTableOf(vararg elements: Pair<K, V>): Hashtable<K, V> =
  Hashtable(elements.toMap())

/**
 * Return an empty new [MutableSet].
 * @since 1.1.0
 */
inline fun <reified T> emptyMutableSet(): MutableSet<T> = LinkedHashSet()

/**
 * Return an empty new [HashSet].
 * @since 1.1.0
 */
inline fun <reified T> emptyHashSet(): HashSet<T> = HashSet()

/**
 * Return an empty new [LinkedHashSet].
 * @since 1.1.0
 */
inline fun <reified T> emptyLinkedSet(): LinkedHashSet<T> = LinkedHashSet()

/**
 * Return an empty new [TreeSet].
 * @since 1.1.0
 * @see SortedSet
 */
inline fun <reified T> emptySortedSet(): TreeSet<T> = TreeSet()

/**
 * Return an empty new [Hashtable].
 * @since 1.1.0
 */
inline fun <reified K, V> emptyHashTable(): Hashtable<K, V> = Hashtable()
