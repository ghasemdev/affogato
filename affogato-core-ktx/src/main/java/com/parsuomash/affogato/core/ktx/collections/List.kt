@file:Suppress("MethodOverloading", "TooManyFunctions")

package com.parsuomash.affogato.core.ktx.collections

/**
 * Return an integer [List] from int range.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(range: IntRange): List<Int> = range.toList()

/**
 * Return an un-sign integer [List] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * listOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(range: UIntRange): List<UInt> = range.toList()

/**
 * Return a long [List] from long range.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(range: LongRange): List<Long> = range.toList()

/**
 * Return an un-sign long [List] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * listOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(range: ULongRange): List<ULong> = range.toList()

/**
 * Return an integer [List] from int progression.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(progression: IntProgression): List<Int> = progression.toList()

/**
 * Return an un-sign integer [List] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * listOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(progression: UIntProgression): List<UInt> = progression.toList()

/**
 * Return a long [List] from long progression.
 *
 * Example:
 * ```Kotlin
 * listOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(progression: LongProgression): List<Long> = progression.toList()

/**
 * Return an un-sign long [List] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * listOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(progression: ULongProgression): List<ULong> = progression.toList()

/**
 * Return a char [List] from char range.
 *
 * Example:
 * ```Kotlin
 * listOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(range: CharRange): List<Char> = range.toList()

/**
 * Return a char [List] from char progression.
 *
 * Example:
 * ```Kotlin
 * listOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 * @see listOf
 */
@JvmSynthetic
fun listOf(progression: CharProgression): List<Char> = progression.toList()

/**
 * Return an integer [MutableList] from int range.
 *
 * Example:
 * ```Kotlin
 * mutableListOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(range: IntRange): MutableList<Int> = range.toMutableList()

/**
 * Return an un-sign integer [MutableList] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * mutableListOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(range: UIntRange): MutableList<UInt> = range.toMutableList()

/**
 * Return a long [MutableList] from long range.
 *
 * Example:
 * ```Kotlin
 * mutableListOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(range: LongRange): MutableList<Long> = range.toMutableList()

/**
 * Return an un-sign long [MutableList] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * mutableListOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(range: ULongRange): MutableList<ULong> = range.toMutableList()

/**
 * Return an integer [MutableList] from int progression.
 *
 * Example:
 * ```Kotlin
 * mutableListOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(progression: IntProgression): MutableList<Int> = progression.toMutableList()

/**
 * Return an un-sign integer [MutableList] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * mutableListOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(progression: UIntProgression): MutableList<UInt> = progression.toMutableList()

/**
 * Return a long [MutableList] from long progression.
 *
 * Example:
 * ```Kotlin
 * mutableListOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(progression: LongProgression): MutableList<Long> = progression.toMutableList()

/**
 * Return an un-sign long [MutableList] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * mutableListOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(progression: ULongProgression): MutableList<ULong> = progression.toMutableList()

/**
 * Return a char [MutableList] from char range.
 *
 * Example:
 * ```Kotlin
 * mutableListOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(range: CharRange): MutableList<Char> = range.toMutableList()

/**
 * Return a char [MutableList] from char progression.
 *
 * Example:
 * ```Kotlin
 * mutableListOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
@JvmSynthetic
fun mutableListOf(progression: CharProgression): MutableList<Char> = progression.toMutableList()

/**
 * Return an integer [ArrayList] from int range.
 *
 * Example:
 * ```Kotlin
 * arrayListOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(range: IntRange): ArrayList<Int> = ArrayList(range.toList())

/**
 * Return an un-sign integer [ArrayList] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * arrayListOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(range: UIntRange): ArrayList<UInt> = ArrayList(range.toList())

/**
 * Return a long [ArrayList] from long range.
 *
 * Example:
 * ```Kotlin
 * arrayListOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(range: LongRange): ArrayList<Long> = ArrayList(range.toList())

/**
 * Return an un-sign long [ArrayList] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * arrayListOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(range: ULongRange): ArrayList<ULong> = ArrayList(range.toList())

/**
 * Return an integer [ArrayList] from int progression.
 *
 * Example:
 * ```Kotlin
 * arrayListOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(progression: IntProgression): ArrayList<Int> = ArrayList(progression.toList())

/**
 * Return an un-sign integer [ArrayList] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * arrayListOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(progression: UIntProgression): ArrayList<UInt> = ArrayList(progression.toList())

/**
 * Return a long [ArrayList] from long progression.
 *
 * Example:
 * ```Kotlin
 * arrayListOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(progression: LongProgression): ArrayList<Long> = ArrayList(progression.toList())

/**
 * Return an un-sign long [ArrayList] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * arrayListOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(progression: ULongProgression): ArrayList<ULong> = ArrayList(progression.toList())

/**
 * Return a char [ArrayList] from char range.
 *
 * Example:
 * ```Kotlin
 * arrayListOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(range: CharRange): ArrayList<Char> = ArrayList(range.toList())

/**
 * Return a char [ArrayList] from char progression.
 *
 * Example:
 * ```Kotlin
 * arrayListOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
@JvmSynthetic
fun arrayListOf(progression: CharProgression): ArrayList<Char> = ArrayList(progression.toList())

/**
 * Return an empty new [LinkedList].
 * @since 1.1.0
 */
inline fun <reified T> linkedListOf(): LinkedList<T> = LinkedList()

/**
 * Returns a [LinkedList] of given elements.
 * @since 1.1.0
 */
inline fun <reified T> linkedListOf(vararg elements: T): LinkedList<T> =
  LinkedList(elements.toList())

/**
 * Return an integer [LinkedList] from int range.
 *
 * Example:
 * ```Kotlin
 * linkedListOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(range: IntRange): LinkedList<Int> = LinkedList(range.toList())

/**
 * Return an un-sign integer [LinkedList] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * linkedListOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(range: UIntRange): LinkedList<UInt> = LinkedList(range.toList())

/**
 * Return a long [LinkedList] from long range.
 *
 * Example:
 * ```Kotlin
 * linkedListOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(range: LongRange): LinkedList<Long> = LinkedList(range.toList())

/**
 * Return an un-sign long [LinkedList] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * linkedListOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(range: ULongRange): LinkedList<ULong> = LinkedList(range.toList())

/**
 * Return an integer [LinkedList] from int progression.
 *
 * Example:
 * ```Kotlin
 * linkedListOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(progression: IntProgression): LinkedList<Int> = LinkedList(progression.toList())

/**
 * Return an un-sign integer [LinkedList] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * linkedListOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(progression: UIntProgression): LinkedList<UInt> = LinkedList(progression.toList())

/**
 * Return a long [LinkedList] from long progression.
 *
 * Example:
 * ```Kotlin
 * linkedListOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(progression: LongProgression): LinkedList<Long> = LinkedList(progression.toList())

/**
 * Return an un-sign long [LinkedList] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * linkedListOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(progression: ULongProgression): LinkedList<ULong> =
  LinkedList(progression.toList())

/**
 * Return a char [LinkedList] from char range.
 *
 * Example:
 * ```Kotlin
 * linkedListOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(range: CharRange): LinkedList<Char> = LinkedList(range.toList())

/**
 * Return a char [LinkedList] from char progression.
 *
 * Example:
 * ```Kotlin
 * linkedListOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 * @see linkedListOf
 */
@JvmSynthetic
fun linkedListOf(progression: CharProgression): LinkedList<Char> = LinkedList(progression.toList())

/**
 * Return an empty new [LinkedList].
 * @since 1.1.0
 */
inline fun <reified T> emptyLinkedList(): LinkedList<T> = LinkedList()

/**
 * Return an empty new [MutableList].
 * @since 1.1.0
 */
inline fun <reified T> emptyMutableList(): MutableList<T> = ArrayList()

/**
 * Clear the [MutableList] and the add new items.
 *
 * Example:
 * ```Kotlin
 * val list = mutableListOf(1, 2, 3)
 * list.refresh(4..6) // [4, 5, 6]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
inline fun <reified T> MutableList<T>.refreshList(items: Iterable<T>): MutableList<T> {
  clear()
  addAll(items)
  return this
}

/**
 * Clear the [ArrayList] and the add new items.
 *
 * Example:
 * ```Kotlin
 * val list = arrayListOf(1, 2, 3)
 * list.refresh(4..6) // [4, 5, 6]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
inline fun <reified T> ArrayList<T>.refreshList(items: Iterable<T>): ArrayList<T> {
  clear()
  addAll(items)
  return this
}

/**
 * Add only new items to [MutableList].
 *
 * Example:
 * ```Kotlin
 * val list = mutableListOf(1..5)
 * list.addNewItems(3..8) // [1, 2, 3, 4, 5, 6, 7, 8]
 * ```
 * @since 1.1.0
 * @see mutableListOf
 */
inline fun <reified T> MutableList<T>.addNewItems(items: Iterable<T>): MutableList<T> {
  items.forEach { if (!contains(it)) add(it) }
  return this
}

/**
 * Add only new items to [ArrayList].
 *
 * Example:
 * ```Kotlin
 * val list = arrayListOf(1..5)
 * list.addNewItems(3..8) // [1, 2, 3, 4, 5, 6, 7, 8]
 * ```
 * @since 1.1.0
 * @see arrayListOf
 */
inline fun <reified T> ArrayList<T>.addNewItems(items: Iterable<T>): ArrayList<T> {
  items.forEach { if (!contains(it)) add(it) }
  return this
}
