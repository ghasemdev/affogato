@file:Suppress("MethodOverloading", "TooManyFunctions")
@file:JvmName("_Queue")

package com.parsuomash.affogato.core.ktx.collections

/**
 * Returns a [Queue] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toQueue() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toQueue(): Queue<T> = LinkedList(toList())

/**
 * Returns a [PriorityQueue] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toPriorityQueue() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toPriorityQueue(): PriorityQueue<T> = PriorityQueue(toList())

/**
 * Returns a [Deque] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toDeque() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toDeque(): Deque<T> = LinkedList(toList())

/**
 * Returns a [ArrayDeque] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toArrayDeque() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toArrayDeque(): ArrayDeque<T> = ArrayDeque(toList())

/**
 * Return an empty new [Queue].
 * @since 1.1.0
 * @see LinkedList
 */
inline fun <reified T> queueOf(): Queue<T> = LinkedList()

/**
 * Returns a [Queue] of given elements.
 * @since 1.1.0
 * @see LinkedList
 */
inline fun <reified T> queueOf(vararg elements: T): Queue<T> = LinkedList(elements.toList())

/**
 * Return an integer [Queue] from int range.
 *
 * Example:
 * ```Kotlin
 * queueOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(range: IntRange): Queue<Int> = LinkedList(range.toList())

/**
 * Return an un-sign integer [Queue] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * queueOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(range: UIntRange): Queue<UInt> = LinkedList(range.toList())

/**
 * Return a long [Queue] from long range.
 *
 * Example:
 * ```Kotlin
 * queueOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(range: LongRange): Queue<Long> = LinkedList(range.toList())

/**
 * Return an un-sign long [Queue] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * queueOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(range: ULongRange): Queue<ULong> = LinkedList(range.toList())

/**
 * Return an integer [Queue] from int progression.
 *
 * Example:
 * ```Kotlin
 * queueOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(progression: IntProgression): Queue<Int> = LinkedList(progression.toList())

/**
 * Return an un-sign integer [Queue] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * queueOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(progression: UIntProgression): Queue<UInt> = LinkedList(progression.toList())

/**
 * Return a long [Queue] from long progression.
 *
 * Example:
 * ```Kotlin
 * queueOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(progression: LongProgression): Queue<Long> = LinkedList(progression.toList())

/**
 * Return an un-sign long [Queue] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * queueOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(progression: ULongProgression): Queue<ULong> =
  LinkedList(progression.toList())

/**
 * Return a char [Queue] from char range.
 *
 * Example:
 * ```Kotlin
 * queueOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(range: CharRange): Queue<Char> = LinkedList(range.toList())

/**
 * Return a char [Queue] from char progression.
 *
 * Example:
 * ```Kotlin
 * queueOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun queueOf(progression: CharProgression): Queue<Char> = LinkedList(progression.toList())

/**
 * Return an empty new [PriorityQueue].
 * @since 1.1.0
 */
inline fun <reified T> priorityQueueOf(): PriorityQueue<T> = PriorityQueue()

/**
 * Returns a [PriorityQueue] of given elements.
 * @since 1.1.0
 */
inline fun <reified T> priorityQueueOf(vararg elements: T): PriorityQueue<T> =
  PriorityQueue(elements.toList())

/**
 * Return an integer [PriorityQueue] from int range.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(range: IntRange): PriorityQueue<Int> = PriorityQueue(range.toList())

/**
 * Return an un-sign integer [PriorityQueue] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(range: UIntRange): PriorityQueue<UInt> = PriorityQueue(range.toList())

/**
 * Return a long [PriorityQueue] from long range.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(range: LongRange): PriorityQueue<Long> = PriorityQueue(range.toList())

/**
 * Return an un-sign long [PriorityQueue] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(range: ULongRange): PriorityQueue<ULong> = PriorityQueue(range.toList())

/**
 * Return an integer [PriorityQueue] from int progression.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(progression: IntProgression): PriorityQueue<Int> =
  PriorityQueue(progression.toList())

/**
 * Return an un-sign integer [PriorityQueue] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(progression: UIntProgression): PriorityQueue<UInt> =
  PriorityQueue(progression.toList())

/**
 * Return a long [PriorityQueue] from long progression.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(progression: LongProgression): PriorityQueue<Long> =
  PriorityQueue(progression.toList())

/**
 * Return an un-sign long [PriorityQueue] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(progression: ULongProgression): PriorityQueue<ULong> =
  PriorityQueue(progression.toList())

/**
 * Return a char [PriorityQueue] from char range.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(range: CharRange): PriorityQueue<Char> = PriorityQueue(range.toList())

/**
 * Return a char [PriorityQueue] from char progression.
 *
 * Example:
 * ```Kotlin
 * priorityQueueOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun priorityQueueOf(progression: CharProgression): PriorityQueue<Char> =
  PriorityQueue(progression.toList())

/**
 * Return an empty new [Deque].
 * @since 1.1.0
 */
inline fun <reified T> dequeOf(): Deque<T> = LinkedList()

/**
 * Returns a [Deque] of given elements.
 * @since 1.1.0
 */
inline fun <reified T> dequeOf(vararg elements: T): Deque<T> = LinkedList(elements.toList())

/**
 * Return an integer [Deque] from int range.
 *
 * Example:
 * ```Kotlin
 * dequeOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(range: IntRange): Deque<Int> = LinkedList(range.toList())

/**
 * Return an un-sign integer [Deque] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * dequeOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(range: UIntRange): Deque<UInt> = LinkedList(range.toList())

/**
 * Return a long [Deque] from long range.
 *
 * Example:
 * ```Kotlin
 * dequeOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(range: LongRange): Deque<Long> = LinkedList(range.toList())

/**
 * Return an un-sign long [Deque] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * dequeOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(range: ULongRange): Deque<ULong> = LinkedList(range.toList())

/**
 * Return an integer [Deque] from int progression.
 *
 * Example:
 * ```Kotlin
 * dequeOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(progression: IntProgression): Deque<Int> = LinkedList(progression.toList())

/**
 * Return an un-sign integer [Deque] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * dequeOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(progression: UIntProgression): Deque<UInt> = LinkedList(progression.toList())

/**
 * Return a long [Deque] from long progression.
 *
 * Example:
 * ```Kotlin
 * dequeOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(progression: LongProgression): Deque<Long> = LinkedList(progression.toList())

/**
 * Return an un-sign long [Deque] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * dequeOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(progression: ULongProgression): Deque<ULong> = LinkedList(progression.toList())

/**
 * Return a char [Deque] from char range.
 *
 * Example:
 * ```Kotlin
 * dequeOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(range: CharRange): Deque<Char> = LinkedList(range.toList())

/**
 * Return a char [Deque] from char progression.
 *
 * Example:
 * ```Kotlin
 * dequeOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 * @see LinkedList
 */
@JvmSynthetic
fun dequeOf(progression: CharProgression): Deque<Char> = LinkedList(progression.toList())

/**
 * Return an empty new [ArrayDeque].
 * @since 1.1.0
 */
inline fun <reified T> arrayDequeOf(): ArrayDeque<T> = ArrayDeque()

/**
 * Returns a [ArrayDeque] of given elements.
 * @since 1.1.0
 */
inline fun <reified T> arrayDequeOf(vararg elements: T): ArrayDeque<T> =
  ArrayDeque(elements.toList())

/**
 * Return an integer [ArrayDeque] from int range.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(range: IntRange): ArrayDeque<Int> = ArrayDeque(range.toList())

/**
 * Return an un-sign integer [ArrayDeque] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(range: UIntRange): ArrayDeque<UInt> = ArrayDeque(range.toList())

/**
 * Return a long [ArrayDeque] from long range.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(range: LongRange): ArrayDeque<Long> = ArrayDeque(range.toList())

/**
 * Return an un-sign long [ArrayDeque] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(range: ULongRange): ArrayDeque<ULong> = ArrayDeque(range.toList())

/**
 * Return an integer [ArrayDeque] from int progression.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(progression: IntProgression): ArrayDeque<Int> = ArrayDeque(progression.toList())

/**
 * Return an un-sign integer [ArrayDeque] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(progression: UIntProgression): ArrayDeque<UInt> = ArrayDeque(progression.toList())

/**
 * Return a long [ArrayDeque] from long progression.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(progression: LongProgression): ArrayDeque<Long> = ArrayDeque(progression.toList())

/**
 * Return an un-sign long [ArrayDeque] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(progression: ULongProgression): ArrayDeque<ULong> =
  ArrayDeque(progression.toList())

/**
 * Return a char [ArrayDeque] from char range.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(range: CharRange): ArrayDeque<Char> = ArrayDeque(range.toList())

/**
 * Return a char [ArrayDeque] from char progression.
 *
 * Example:
 * ```Kotlin
 * arrayDequeOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun arrayDequeOf(progression: CharProgression): ArrayDeque<Char> = ArrayDeque(progression.toList())

/**
 * Return an empty new [Queue].
 * @since 1.1.0
 */
inline fun <reified T> emptyQueue(): Queue<T> = LinkedList()

/**
 * Return an empty new [PriorityQueue].
 * @since 1.1.0
 */
inline fun <reified T> emptyPriorityQueue(): PriorityQueue<T> = PriorityQueue()

/**
 * Return an empty new [Deque].
 * @since 1.1.0
 */
inline fun <reified T> emptyDeque(): Deque<T> = LinkedList()

/**
 * Return an empty new [ArrayDeque].
 * @since 1.1.0
 */
inline fun <reified T> emptyArrayDeque(): ArrayDeque<T> = ArrayDeque()
