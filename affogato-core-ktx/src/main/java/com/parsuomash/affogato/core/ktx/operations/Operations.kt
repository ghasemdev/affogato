@file:JvmName("_Operations")

package com.parsuomash.affogato.core.ktx.operations

import com.parsuomash.affogato.core.ktx.tryCatchNull

/**
 * Returns a string containing this char sequence repeated [n] times.
 *
 * Example:
 * ```Kotlin
 * "^" * 5 // "^^^^^"
 * "hi" * 0 // ""
 * "error" * -1 // IllegalArgumentException
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException when n < 0.
 * @see String.repeat
 */
@JvmSynthetic
operator fun String.times(n: Int): String = repeat(n)

/**
 * Returns a string containing this char repeated [n] times.
 *
 * Example:
 * ```Kotlin
 * 'a' * 5 // "aaaaa"
 * 'a' * 0 // ""
 * 'a' * -1 // IllegalArgumentException
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException when n < 0.
 * @see times
 */
@JvmSynthetic
operator fun Char.times(n: Int): String = toString() * n

/**
 * Performs a logical nor operation between this Boolean and the other one.
 *
 * Example:
 * ```Kotlin
 * false nor false // true
 * false nor true // false
 * true nor false // false
 * true nor true // false
 * ```
 * @since 1.1.0
 * @see Boolean.not
 * @see Boolean.or
 */
@JvmSynthetic
infix fun Boolean.nor(other: Boolean): Boolean = (this or other).not()

/**
 * Performs a logical nand operation between this Boolean and the other one.
 *
 * Example:
 * ```Kotlin
 * false nand false // true
 * false nand true // true
 * true nand false // true
 * true nand true // false
 * ```
 * @since 1.1.0
 * @see Boolean.not
 * @see Boolean.and
 */
@JvmSynthetic
infix fun Boolean.nand(other: Boolean): Boolean = (this and other).not()

/**
 * Performs a logical xnor operation between this Boolean and the other one.
 *
 * Example:
 * ```Kotlin
 * false xnor false // true
 * false xnor true // false
 * true xnor false // false
 * true xnor true // true
 * ```
 * @since 1.1.0
 * @see Boolean.not
 * @see Boolean.xor
 */
@JvmSynthetic
infix fun Boolean.xnor(other: Boolean): Boolean = (this xor other).not()

/**
 * Inverts the bits in this value.
 *
 * Example:
 * ```Kotlin
 * 0.not() // -1
 * 1.not() // -2
 * ```
 * @since 1.1.0
 * @see inv
 */
@JvmSynthetic
operator fun Int.not(): Int = inv()

/**
 * Performs a bitwise NOR operation between the two values.
 *
 * Example:
 * ```Kotlin
 * 0 nor 0 // -1
 * 0 nor 1 // -2
 * 1 nor 0 // -2
 * 1 nor 1 // -2
 * ```
 * @since 1.1.0
 * @see Int.or
 */
@JvmSynthetic
infix fun Int.nor(other: Int): Int = (this or other).not()

/**
 * Performs a bitwise NAND operation between the two values.
 *
 * Example:
 * ```Kotlin
 * 0 nand 0 // -1
 * 0 nand 1 // -1
 * 1 nand 0 // -1
 * 1 nand 1 // -2
 * ```
 * @since 1.1.0
 * @see Int.and
 */
@JvmSynthetic
infix fun Int.nand(other: Int): Int = (this and other).not()

/**
 * Performs a bitwise XNOR operation between the two values.
 *
 * Example:
 * ```Kotlin
 * 0 xnor 0 // -1
 * 0 xnor 1 // -2
 * 1 xnor 0 // -2
 * 1 xnor 1 // -1
 * ```
 * @since 1.1.0
 * @see Int.xor
 */
@JvmSynthetic
infix fun Int.xnor(other: Int): Int = (this xor other).not()

/**
 * Convert [Int] to [Boolean].
 *
 * Example:
 * ```Kotlin
 * 0.toBoolean() // false
 * 1.toBoolean() // true
 * -1.toBoolean() // IllegalArgumentException
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException when n != 0 or n != 1.
 */
@JvmSynthetic
fun Int.toBoolean(): Boolean = when (this) {
  1 -> true
  0 -> false
  else -> throw IllegalArgumentException("Int value must be 0 or 1")
}

/**
 * Convert [Int] to [Boolean] if possible.
 *
 * Example:
 * ```Kotlin
 * 0.toBoolean() // false
 * 1.toBoolean() // true
 * -1.toBoolean() // null
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun Int.toBooleanOrNull(): Boolean? = tryCatchNull { toBoolean() }

/**
 * Convert [Boolean] to [Int].
 *
 * Example:
 * ```Kotlin
 * true.toInt() // 1
 * false.toInt() // 0
 * ```
 * @since 1.1.0
 */
@JvmSynthetic
fun Boolean.toInt(): Int = if (this) 1 else 0
