@file:Suppress("MethodOverloading")
@file:JvmName("_Stack")

package com.parsuomash.affogato.core.ktx.collections

/**
 * Returns a [Stack] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toStack() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toStack(): Stack<T> = Stack<T>().apply { addAll(this@toStack) }

/**
 * Return an empty new [Stack].
 * @since 1.1.0
 */
inline fun <reified T> stackOf(): Stack<T> = Stack()

/**
 * Returns a [Stack] of given elements.
 * @since 1.1.0
 */
inline fun <reified T> stackOf(vararg elements: T): Stack<T> = Stack<T>().apply { addAll(elements) }

/**
 * Return an integer [Stack] from int range.
 *
 * Example:
 * ```Kotlin
 * stackOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(range: IntRange): Stack<Int> = Stack<Int>().apply { addAll(range) }

/**
 * Return an un-sign integer [Stack] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * stackOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(range: UIntRange): Stack<UInt> = Stack<UInt>().apply { addAll(range) }

/**
 * Return a long [Stack] from long range.
 *
 * Example:
 * ```Kotlin
 * stackOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(range: LongRange): Stack<Long> = Stack<Long>().apply { addAll(range) }

/**
 * Return an un-sign long [Stack] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * stackOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(range: ULongRange): Stack<ULong> = Stack<ULong>().apply { addAll(range) }

/**
 * Return an integer [Stack] from int progression.
 *
 * Example:
 * ```Kotlin
 * stackOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(progression: IntProgression): Stack<Int> = Stack<Int>().apply { addAll(progression) }

/**
 * Return an un-sign integer [Stack] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * stackOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(progression: UIntProgression): Stack<UInt> = Stack<UInt>().apply { addAll(progression) }

/**
 * Return a long [Stack] from long progression.
 *
 * Example:
 * ```Kotlin
 * stackOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(progression: LongProgression): Stack<Long> = Stack<Long>().apply { addAll(progression) }

/**
 * Return an un-sign long [Stack] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * stackOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(progression: ULongProgression): Stack<ULong> =
  Stack<ULong>().apply { addAll(progression) }

/**
 * Return a char [Stack] from char range.
 *
 * Example:
 * ```Kotlin
 * stackOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(range: CharRange): Stack<Char> = Stack<Char>().apply { addAll(range) }

/**
 * Return a char [Stack] from char progression.
 *
 * Example:
 * ```Kotlin
 * stackOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun stackOf(progression: CharProgression): Stack<Char> = Stack<Char>().apply { addAll(progression) }

/**
 * Return an empty new [Stack].
 * @since 1.1.0
 */
inline fun <reified T> emptyStack(): Stack<T> = Stack()
