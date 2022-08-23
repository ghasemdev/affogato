@file:Suppress("MethodOverloading")
@file:JvmName("_Vector")

package com.parsuomash.affogato.core.ktx.collections

/**
 * Returns a [Vector] containing all elements.
 *
 * Example:
 * ```Kotlin
 * (1..10).toVector() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Iterable<T>.toVector(): Vector<T> = Vector(toList())

/**
 * Return an empty new [Vector].
 * @since 1.1.0
 * @param size default size is 10
 * @param incrementStep default step to increment size is zero
 */
inline fun <reified T> vectorOf(size: Int = 10, incrementStep: Int = 0): Vector<T> =
  Vector(size, incrementStep)

/**
 * Returns a [Vector] of given elements.
 * @since 1.1.0
 */
inline fun <reified T> vectorOf(vararg elements: T): Vector<T> = Vector(elements.toList())

/**
 * Return an integer [Vector] from int range.
 *
 * Example:
 * ```Kotlin
 * vectorOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(range: IntRange): Vector<Int> = Vector(range.toList())

/**
 * Return an un-sign integer [Vector] from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * vectorOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(range: UIntRange): Vector<UInt> = Vector(range.toList())

/**
 * Return a long [Vector] from long range.
 *
 * Example:
 * ```Kotlin
 * vectorOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(range: LongRange): Vector<Long> = Vector(range.toList())

/**
 * Return an un-sign long [Vector] from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * vectorOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(range: ULongRange): Vector<ULong> = Vector(range.toList())

/**
 * Return an integer [Vector] from int progression.
 *
 * Example:
 * ```Kotlin
 * vectorOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(progression: IntProgression): Vector<Int> = Vector(progression.toList())

/**
 * Return an un-sign integer [Vector] from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * vectorOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(progression: UIntProgression): Vector<UInt> = Vector(progression.toList())

/**
 * Return a long [Vector] from long progression.
 *
 * Example:
 * ```Kotlin
 * vectorOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(progression: LongProgression): Vector<Long> = Vector(progression.toList())

/**
 * Return an un-sign long [Vector] from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * vectorOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(progression: ULongProgression): Vector<ULong> = Vector(progression.toList())

/**
 * Return a char [Vector] from char range.
 *
 * Example:
 * ```Kotlin
 * vectorOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(range: CharRange): Vector<Char> = Vector(range.toList())

/**
 * Return a char [Vector] from char progression.
 *
 * Example:
 * ```Kotlin
 * vectorOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun vectorOf(progression: CharProgression): Vector<Char> = Vector(progression.toList())

/**
 * Return an empty new [Vector].
 * @since 1.1.0
 */
inline fun <reified T> emptyVector(): Vector<T> = Vector()
