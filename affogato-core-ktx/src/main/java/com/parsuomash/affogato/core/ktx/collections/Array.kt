@file:Suppress("MethodOverloading", "TooManyFunctions", "ArrayPrimitive")

package com.parsuomash.affogato.core.ktx.collections

import com.parsuomash.affogato.core.ktx.tryCatchElse
import com.parsuomash.affogato.core.ktx.tryCatchNull

/**
 * Convert [ByteArray] to [String] HEX.
 *
 * @since 1.1.0
 * @see asReversedHex
 * @see asDecimal
 * @see asReversedDecimal
 */
@get:JvmName("asHex")
inline val ByteArray.asHex: String
  get() = joinToString(" ") { "%02X".format(it) }

/**
 * Convert [ByteArray] to [String] reversed HEX.
 *
 * @since 1.1.0
 * @see asHex
 * @see asDecimal
 * @see asReversedDecimal
 */
@get:JvmName("asReversedHex")
inline val ByteArray.asReversedHex: String
  get() = reversedArray().joinToString(" ") { "%02X".format(it) }

/**
 * Convert [ByteArray] to [String] decimal.
 *
 * @since 1.1.0
 * @see asHex
 * @see asReversedHex
 * @see asReversedDecimal
 */
@get:JvmName("asDecimal")
inline val ByteArray.asDecimal: String
  get() = buildString { this@asDecimal.forEach { append("%02X".format(it).toLong(16)) } }

/**
 * Convert [ByteArray] to [String] reversed decimal.
 *
 * @since 1.1.0
 * @see asHex
 * @see asReversedHex
 * @see asDecimal
 */
@get:JvmName("asReversedDecimal")
inline val ByteArray.asReversedDecimal: String
  get() = buildString {
    this@asReversedDecimal.reversedArray().forEach { append("%02X".format(it).toLong(16)) }
  }

/**
 * Return an integer Array from int range.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 * @see Array
 * @see Int
 * @see IntRange
 */
@JvmSynthetic
fun arrayOf(range: IntRange): Array<Int> = range.toList().toTypedArray()

/**
 * Return an un-sign integer Array from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 * @see Array
 * @see UInt
 * @see UIntRange
 */
@JvmSynthetic
fun arrayOf(range: UIntRange): Array<UInt> = range.toList().toTypedArray()

/**
 * Return a long Array from long range.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @see Array
 * @see Long
 * @see LongRange
 */
@JvmSynthetic
fun arrayOf(range: LongRange): Array<Long> = range.toList().toTypedArray()

/**
 * Return an un-sign long Array from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 * @see Array
 * @see ULong
 * @see ULongRange
 */
@JvmSynthetic
fun arrayOf(range: ULongRange): Array<ULong> = range.toList().toTypedArray()

/**
 * Return an integer Array from int progression.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @see Array
 * @see Int
 * @see IntProgression
 */
@JvmSynthetic
fun arrayOf(progression: IntProgression): Array<Int> = progression.toList().toTypedArray()

/**
 * Return an un-sign integer Array from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 * @see Array
 * @see UInt
 * @see UIntProgression
 */
@JvmSynthetic
fun arrayOf(progression: UIntProgression): Array<UInt> = progression.toList().toTypedArray()

/**
 * Return a long Array from long progression.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @see Array
 * @see Long
 * @see LongProgression
 */
@JvmSynthetic
fun arrayOf(progression: LongProgression): Array<Long> = progression.toList().toTypedArray()

/**
 * Return an un-sign long Array from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 * @see Array
 * @see ULong
 * @see ULongProgression
 */
@JvmSynthetic
fun arrayOf(progression: ULongProgression): Array<ULong> = progression.toList().toTypedArray()

/**
 * Return a char Array from char range.
 *
 * Example:
 * ```Kotlin
 * arrayOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 * @see Array
 * @see Char
 * @see CharRange
 */
@JvmSynthetic
fun arrayOf(range: CharRange): Array<Char> = range.toList().toTypedArray()

/**
 * Return a char Array from char progression.
 *
 * Example:
 * ```Kotlin
 * arrayOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 * @see Array
 * @see Char
 * @see CharProgression
 */
@JvmSynthetic
fun arrayOf(progression: CharProgression): Array<Char> = progression.toList().toTypedArray()

/**
 * Return an integer Array from int range.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * ```
 * @since 1.1.0
 * @see IntArray
 * @see IntRange
 */
@JvmSynthetic
fun intArrayOf(range: IntRange): IntArray = range.toList().toIntArray()

/**
 * Return an integer Array from int progression.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10 step 2) // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @see IntArray
 * @see IntProgression
 */
@JvmSynthetic
fun intArrayOf(progression: IntProgression): IntArray = progression.toList().toIntArray()

/**
 * Return an un-sign integer Array from un-sign int range.
 *
 * Example:
 * ```Kotlin
 * uIntArrayOf(1u..10u) // [1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u]
 * ```
 * @since 1.1.0
 * @see UIntArray
 * @see UIntRange
 */
@ExperimentalUnsignedTypes
@JvmSynthetic
fun uintArrayOf(range: UIntRange): UIntArray = range.toList().toUIntArray()

/**
 * Return an un-sign integer Array from un-sign int progression.
 *
 * Example:
 * ```Kotlin
 * uIntArrayOf(1u..10u step 2) // [1u, 3u, 5u, 7u, 9u]
 * ```
 * @since 1.1.0
 * @see UIntArray
 * @see UIntProgression
 */
@ExperimentalUnsignedTypes
@JvmSynthetic
fun uintArrayOf(progression: UIntProgression): UIntArray = progression.toList().toUIntArray()

/**
 * Return a long Array from long range.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L) // [1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @see LongArray
 * @see LongRange
 */
@JvmSynthetic
fun longArrayOf(range: LongRange): LongArray = range.toList().toLongArray()

/**
 * Return a long Array from long progression.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L step 2) // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @see LongArray
 * @see LongProgression
 */
@JvmSynthetic
fun longArrayOf(progression: LongProgression): LongArray = progression.toList().toLongArray()

/**
 * Return an un-sign long Array from un-sign long range.
 *
 * Example:
 * ```Kotlin
 * uLongArrayOf(1uL..10uL) // [1ul, 2uL, 3uL, 4uL, 5uL, 6uL, 7uL, 8uL, 9uL, 10uL]
 * ```
 * @since 1.1.0
 * @see ULongArray
 * @see ULongRange
 */
@ExperimentalUnsignedTypes
@JvmSynthetic
fun ulongArrayOf(range: ULongRange): ULongArray = range.toList().toULongArray()

/**
 * Return an un-sign long Array from un-sign long progression.
 *
 * Example:
 * ```Kotlin
 * uLongArrayOf(1uL..10uL step 2) // [1ul, 3uL, 5uL, 7uL, 9uL]
 * ```
 * @since 1.1.0
 * @see ULongArray
 * @see ULongProgression
 */
@ExperimentalUnsignedTypes
@JvmSynthetic
fun ulongArrayOf(progression: ULongProgression): ULongArray = progression.toList().toULongArray()

/**
 * Return a char Array from char range.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'f') // ['a', 'b', 'c', 'd', 'e', 'f']
 * ```
 * @since 1.1.0
 * @see CharArray
 * @see CharRange
 */
@JvmSynthetic
fun charArrayOf(range: CharRange): CharArray = range.toList().toCharArray()

/**
 * Return a char Array from char progression.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'f' step 2) // ['a', 'c', 'e']
 * ```
 * @since 1.1.0
 * @see CharArray
 * @see CharProgression
 */
@JvmSynthetic
fun charArrayOf(progression: CharProgression): CharArray = progression.toList().toCharArray()

/**
 * Returns an element at the given index or empty
 * if the index is out of bounds of this string [Array].
 *
 * Example:
 * ```Kotlin
 * val list = arrayOf(1..5)
 * list.getOrEmpty(8) // ""
 * list[2] // 3
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
@JvmSynthetic
fun Array<String>.getOrEmpty(index: Int): String =
  if (index in 0..lastIndex) toList()[index] else ""

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10)[0..4] // [1, 2, 3, 4, 5]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see arrayOf
 * @see Array
 */
inline operator fun <reified T> Array<T>.get(indices: IntRange): Array<T> = sliceArray(indices)

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..4] // [1, 2, 3, 4, 5]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see byteArrayOf
 */
@JvmSynthetic
operator fun ByteArray.get(indices: IntRange): ByteArray = sliceArray(indices)

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'z')[0..4] // ['a', 'b', 'c', 'd', 'e']
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see charArrayOf
 */
@JvmSynthetic
operator fun CharArray.get(indices: IntRange): CharArray = sliceArray(indices)

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..4] // [1, 2, 3, 4, 5]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see shortArrayOf
 */
@JvmSynthetic
operator fun ShortArray.get(indices: IntRange): ShortArray = sliceArray(indices)

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10)[0..4] // [1, 2, 3, 4, 5]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see intArrayOf
 */
@JvmSynthetic
operator fun IntArray.get(indices: IntRange): IntArray = sliceArray(indices)

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L)[0..4] // [1L, 2L, 3L, 4L, 5L]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see longArrayOf
 */
@JvmSynthetic
operator fun LongArray.get(indices: IntRange): LongArray = sliceArray(indices)

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f)[0..4]
 * // [1.0f, 2.0f, 3.0f, 4.0f, 5.0f]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see floatArrayOf
 */
@JvmSynthetic
operator fun FloatArray.get(indices: IntRange): FloatArray = sliceArray(indices)

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)[0..4]
 * // [1.0, 2.0, 3.0, 4.0, 5.0]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see doubleArrayOf
 */
@JvmSynthetic
operator fun DoubleArray.get(indices: IntRange): DoubleArray = sliceArray(indices)

/**
 * Returns the sub-array from the given range.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)[0..4]
 * // [true, false, true, false, true]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see booleanArrayOf
 */
@JvmSynthetic
operator fun BooleanArray.get(indices: IntRange): BooleanArray = sliceArray(indices)

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10)[0..9 step 2] // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see arrayOf
 * @see Array
 */
inline operator fun <reified T> Array<T>.get(indices: IntProgression): Array<T> =
  sliceArray(indices.toList())

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..9 step 2] // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see byteArrayOf
 */
@JvmSynthetic
operator fun ByteArray.get(indices: IntProgression): ByteArray = sliceArray(indices.toList())

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'z')[0..9 step 2] // ['a', 'c', 'e', 'g', 'i']
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see charArrayOf
 */
@JvmSynthetic
operator fun CharArray.get(indices: IntProgression): CharArray = sliceArray(indices.toList())

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)[0..9 step 2] // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see shortArrayOf
 */
@JvmSynthetic
operator fun ShortArray.get(indices: IntProgression): ShortArray = sliceArray(indices.toList())

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10)[0..9 step 2] // [1, 3, 5, 7, 9]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see intArrayOf
 */
@JvmSynthetic
operator fun IntArray.get(indices: IntProgression): IntArray = sliceArray(indices.toList())

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L)[0..9 step 2] // [1L, 3L, 5L, 7L, 9L]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see longArrayOf
 */
@JvmSynthetic
operator fun LongArray.get(indices: IntProgression): LongArray = sliceArray(indices.toList())

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f)[0..9 step 2]
 * // [1.0f, 3.0f, 5.0f, 7.0f, 9.0f]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see floatArrayOf
 */
@JvmSynthetic
operator fun FloatArray.get(indices: IntProgression): FloatArray = sliceArray(indices.toList())

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)[0..9 step 2]
 * // [1.0, 3.0, 5.0, 7.0, 9.0]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see sliceArray
 * @see doubleArrayOf
 */
@JvmSynthetic
operator fun DoubleArray.get(indices: IntProgression): DoubleArray = sliceArray(indices.toList())

/**
 * Returns the sub-array from the given progression.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)[0..9 step 2]
 * // [true, true, true, true, true]
 * ```
 * @since 1.1.0
 * @throws IndexOutOfBoundsException if the range is out of bounds of the array.
 * @see booleanArrayOf
 */
@JvmSynthetic
operator fun BooleanArray.get(indices: IntProgression): BooleanArray = sliceArray(indices.toList())

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10).getOrNull(0..4)!! // [1, 2, 3, 4, 5]
 * arrayOf(1..10).getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see arrayOf
 * @see Array
 */
inline fun <reified T> Array<T>.getOrNull(indices: IntRange): Array<T>? =
  tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).getOrNull(0..4)!! // [1, 2, 3, 4, 5]
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see byteArrayOf
 */
@JvmSynthetic
fun ByteArray.getOrNull(indices: IntRange): ByteArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'z').getOrNull(0..4)!! // ['a', 'b', 'c', 'd', 'e']
 * charArrayOf('a'..'c').getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see charArrayOf
 */
@JvmSynthetic
fun CharArray.getOrNull(indices: IntRange): CharArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).getOrNull(0..4)!! // [1, 2, 3, 4, 5]
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see shortArrayOf
 */
@JvmSynthetic
fun ShortArray.getOrNull(indices: IntRange): ShortArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10).getOrNull(0..4)!! // [1, 2, 3, 4, 5]
 * intArrayOf(1..10).getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see intArrayOf
 */
@JvmSynthetic
fun IntArray.getOrNull(indices: IntRange): IntArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L).getOrNull(0..4)!! // [1L, 2L, 3L, 4L, 5L]
 * longArrayOf(1..10L).getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see longArrayOf
 */
@JvmSynthetic
fun LongArray.getOrNull(indices: IntRange): LongArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f)
 *   .getOrNull(0..4)!! // [1.0f, 2.0f, 3.0f, 4.0f, 5.0f]
 * floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f)
 *   .getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see floatArrayOf
 */
@JvmSynthetic
fun FloatArray.getOrNull(indices: IntRange): FloatArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).getOrNull(0..4)!!
 * // [1.0, 2.0, 3.0, 4.0, 5.0]
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see doubleArrayOf
 */
@JvmSynthetic
fun DoubleArray.getOrNull(indices: IntRange): DoubleArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)
 *   .getOrNull(0..4)!! // [true, false, true, false, true]
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)
 *   .getOrNull(10..14) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see booleanArrayOf
 */
@JvmSynthetic
fun BooleanArray.getOrNull(indices: IntRange): BooleanArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10).getOrNull(0..9 step 2)!! // [1, 3, 5, 7, 9]
 * arrayOf(1..10).getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see arrayOf
 * @see Array
 */
inline fun <reified T> Array<T>.getOrNull(indices: IntProgression): Array<T>? =
  tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).getOrNull(0..9 step 2)!! // [1, 3, 5, 7, 9]
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see byteArrayOf
 */
@JvmSynthetic
fun ByteArray.getOrNull(indices: IntProgression): ByteArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'z').getOrNull(0..9 step 2)!! // ['a', 'c', 'e', 'g', 'i']
 * charArrayOf('a'..'c').getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see charArrayOf
 */
@JvmSynthetic
fun CharArray.getOrNull(indices: IntProgression): CharArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).getOrNull(0..9 step 2)!! // [1, 3, 5, 7, 9]
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see shortArrayOf
 */
@JvmSynthetic
fun ShortArray.getOrNull(indices: IntProgression): ShortArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10).getOrNull(0..9 step 2)!! // [1, 3, 5, 7, 9]
 * intArrayOf(1..10).getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see intArrayOf
 */
@JvmSynthetic
fun IntArray.getOrNull(indices: IntProgression): IntArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L).getOrNull(0..9 step 2)!! // [1L, 3L, 5L, 7L, 9L]
 * longArrayOf(1..10L).getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see longArrayOf
 */
@JvmSynthetic
fun LongArray.getOrNull(indices: IntProgression): LongArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f)
 *   .getOrNull(0..9 step 2)!! // [1.0f, 3.0f, 5.0f, 7.0f, 9.0f]
 * floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f)
 *   .getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see floatArrayOf
 */
@JvmSynthetic
fun FloatArray.getOrNull(indices: IntProgression): FloatArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
 *   .getOrNull(0..9 step 2)!! // [1.0, 3.0, 5.0, 7.0, 9.0]
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
 *   .getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see doubleArrayOf
 */
@JvmSynthetic
fun DoubleArray.getOrNull(indices: IntProgression): DoubleArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)
 *   .getOrNull(0..9 step 2)!! // [true, true, true, true, true]
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)
 *   .getOrNull(10..14 step 2) // null
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see booleanArrayOf
 */
@JvmSynthetic
fun BooleanArray.getOrNull(indices: IntProgression): BooleanArray? = tryCatchNull { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10).getOrElse(0..4) { arrayOf(1) } // [1, 2, 3, 4, 5]
 * arrayOf(1..10).getOrElse(10..14) { arrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see arrayOf
 * @see Array
 */
inline fun <reified T> Array<T>.getOrElse(
  indices: IntRange,
  defaultValue: () -> Array<T>
): Array<T> = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 9, 10).getOrElse(0..4) { byteArrayOf(1) } // [1, 2, 3, 4, 5]
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 9, 10).getOrElse(10..14) { byteArrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see byteArrayOf
 */
@JvmSynthetic
inline fun ByteArray.getOrElse(
  indices: IntRange,
  defaultValue: () -> ByteArray
): ByteArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'z').getOrElse(0..4) { charArrayOf('a') } // ['a', 'b', 'c', 'd', 'e']
 * charArrayOf('a'..'z').getOrElse(10..14) { charArrayOf('a') } // ['a']
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see charArrayOf
 */
@JvmSynthetic
inline fun CharArray.getOrElse(
  indices: IntRange,
  defaultValue: () -> CharArray
): CharArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 9, 10).getOrElse(0..4) { shortArrayOf(1) } // [1, 2, 3, 4, 5]
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 9, 10).getOrElse(10..14) { shortArrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see shortArrayOf
 */
@JvmSynthetic
inline fun ShortArray.getOrElse(
  indices: IntRange,
  defaultValue: () -> ShortArray
): ShortArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10).getOrElse(0..4) { intArrayOf(1) } // [1, 2, 3, 4, 5]
 * intArrayOf(1..10).getOrElse(10..14) { intArrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see intArrayOf
 */
@JvmSynthetic
inline fun IntArray.getOrElse(
  indices: IntRange,
  defaultValue: () -> IntArray
): IntArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L).getOrElse(0..4) { longArrayOf(1) } // [1L, 2L, 3L, 4L, 5L]
 * longArrayOf(1..10L).getOrElse(10..14) { longArrayOf(1) } // [1L]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see longArrayOf
 */
@JvmSynthetic
inline fun LongArray.getOrElse(
  indices: IntRange,
  defaultValue: () -> LongArray
): LongArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f)
 *   .getOrElse(0..4) { floatArrayOf(1.0f) } // [1.0f, 2.0f, 3.0f, 4.0f, 5.0f]
 * floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f)
 *   .getOrElse(10..14) { floatArrayOf(1.0f) } // [1.0f]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see floatArrayOf
 */
@JvmSynthetic
inline fun FloatArray.getOrElse(
  indices: IntRange,
  defaultValue: () -> FloatArray
): FloatArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
 *   .getOrElse(0..4) { doubleArrayOf(1.0) } // [1.0, 2.0, 3.0, 4.0, 5.0]
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
 *   .getOrElse(10..14) { doubleArrayOf(1.0) } // [1.0]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see doubleArrayOf
 */
@JvmSynthetic
inline fun DoubleArray.getOrElse(
  indices: IntRange,
  defaultValue: () -> DoubleArray
): DoubleArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)
 *   .getOrElse(0..4) { booleanArrayOf(true) } // [true, false, true, false, true]
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)
 *   .getOrElse(10..14) { booleanArrayOf(true) } // [true]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see booleanArrayOf
 */
@JvmSynthetic
inline fun BooleanArray.getOrElse(
  indices: IntRange,
  defaultValue: () -> BooleanArray
): BooleanArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10).getOrElse(0..9 step 2) { arrayOf(1) } // [1, 3, 5, 7, 9]
 * arrayOf(1..10).getOrElse(10..14 step 2) { arrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see arrayOf
 * @see Array
 */
inline fun <reified T> Array<T>.getOrElse(
  indices: IntProgression,
  defaultValue: () -> Array<T>
): Array<T> = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 *   .getOrElse(0..9 step 2) { byteArrayOf(1) } // [1, 3, 5, 7, 9]
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 *   .getOrElse(10..14 step 2) { byteArrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see byteArrayOf
 */
@JvmSynthetic
inline fun ByteArray.getOrElse(
  indices: IntProgression,
  defaultValue: () -> ByteArray
): ByteArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'z').getOrElse(0..9 step 2) { charArrayOf('a') } // ['a', 'c', 'e', 'g', 'i']
 * charArrayOf('a'..'c').getOrElse(10..14 step 2) { charArrayOf('a') } // ['a']
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see charArrayOf
 */
@JvmSynthetic
inline fun CharArray.getOrElse(
  indices: IntProgression,
  defaultValue: () -> CharArray
): CharArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 *   .getOrElse(0..9 step 2) { shortArrayOf(1) } // [1, 3, 5, 7, 9]
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 *   .getOrElse(10..14 step 2) { shortArrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see shortArrayOf
 */
@JvmSynthetic
inline fun ShortArray.getOrElse(
  indices: IntProgression,
  defaultValue: () -> ShortArray
): ShortArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10).getOrElse(0..9 step 2) { intArrayOf(1) } // [1, 3, 5, 7, 9]
 * intArrayOf(1..10).getOrElse(10..14 step 2) { intArrayOf(1) } // [1]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see intArrayOf
 */
@JvmSynthetic
inline fun IntArray.getOrElse(
  indices: IntProgression,
  defaultValue: () -> IntArray
): IntArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L).getOrElse(0..9 step 2) { longArrayOf(1) } // [1L, 3L, 5L, 7L, 9L]
 * longArrayOf(1..10L).getOrElse(10..14 step 2) { longArrayOf(1) } // [1L]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see longArrayOf
 */
@JvmSynthetic
inline fun LongArray.getOrElse(
  indices: IntProgression,
  defaultValue: () -> LongArray
): LongArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F)
 *   .getOrElse(0..9 step 2) { floatArrayOf(1F) } // [1F, 3F, 5F, 7F, 9F]
 * floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F)
 *   .getOrElse(10..14 step 2) { floatArrayOf(1F) } // [1F]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see floatArrayOf
 */
@JvmSynthetic
inline fun FloatArray.getOrElse(
  indices: IntProgression,
  defaultValue: () -> FloatArray
): FloatArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
 *   .getOrElse(0..9 step 2) { doubleArrayOf(1.0) } // [1.0, 3.0, 5.0, 7.0, 9.0]
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
 *   .getOrElse(10..14 step 2) { doubleArrayOf(1.0) } // [1.0]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see doubleArrayOf
 */
@JvmSynthetic
inline fun DoubleArray.getOrElse(
  indices: IntProgression,
  defaultValue: () -> DoubleArray
): DoubleArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns the sub-array from the given progression if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)
 *   .getOrElse(0..9 step 2) { booleanArrayOf(true) } // [true, true, true, true, true]
 * booleanArrayOf(true, false, true, false, true, false, true, false, true, false)
 *   .getOrElse(10..14 step 2) { booleanArrayOf(true) } // [true]
 * ```
 * @since 1.1.0
 * @see sliceArray
 * @see booleanArrayOf
 */
@JvmSynthetic
inline fun BooleanArray.getOrElse(
  indices: IntProgression,
  defaultValue: () -> BooleanArray
): BooleanArray = tryCatchElse({ defaultValue() }) { get(indices) }

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10).head(3) // [1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see arrayOf
 * @see Array
 */
inline fun <reified T> Array<T>.head(n: Int = 10): List<T> = take(n)

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).head(3) // [1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see byteArrayOf
 */
@JvmOverloads
fun ByteArray.head(n: Int = 10): List<Byte> = take(n)

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'z').head(3) // ['a', 'b', 'c']
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see charArrayOf
 */
@JvmOverloads
fun CharArray.head(n: Int = 10): List<Char> = take(n)

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).head(3) // [1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see shortArrayOf
 */
@JvmOverloads
fun ShortArray.head(n: Int = 10): List<Short> = take(n)

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10).head(3) // [1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see intArrayOf
 */
@JvmOverloads
fun IntArray.head(n: Int = 10): List<Int> = take(n)

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L).head(3) // [1L, 2L, 3L]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see longArrayOf
 */
@JvmOverloads
fun LongArray.head(n: Int = 10): List<Long> = take(n)

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).head(3) // [1F, 2F, 3F]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see floatArrayOf
 */
@JvmOverloads
fun FloatArray.head(n: Int = 10): List<Float> = take(n)

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).head(3) // [1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see doubleArrayOf
 */
@JvmOverloads
fun DoubleArray.head(n: Int = 10): List<Double> = take(n)

/**
 * Returns a list containing first [n] elements.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true).head(3) // [true, false, true]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see take
 * @see booleanArrayOf
 */
@JvmOverloads
fun BooleanArray.head(n: Int = 10): List<Boolean> = take(n)

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10).tail(3) // [8, 9, 10]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see arrayOf
 * @see Array
 */
inline fun <reified T> Array<T>.tail(n: Int = 10): List<T> = (size - n).let {
  drop(if (it < 0) 0 else it)
}

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).tail(3) // [8, 9, 10]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see byteArrayOf
 */
@JvmOverloads
fun ByteArray.tail(n: Int = 10): List<Byte> = (size - n).let { drop(if (it < 0) 0 else it) }

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a'..'z').tail(3) // [x, y, z]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see charArrayOf
 */
@JvmOverloads
fun CharArray.tail(n: Int = 10): List<Char> = (size - n).let { drop(if (it < 0) 0 else it) }

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).tail(3) // [8, 9, 10]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see shortArrayOf
 */
@JvmOverloads
fun ShortArray.tail(n: Int = 10): List<Short> = (size - n).let { drop(if (it < 0) 0 else it) }

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10).tail(3) // [8, 9, 10]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see intArrayOf
 */
@JvmOverloads
fun IntArray.tail(n: Int = 10): List<Int> = (size - n).let { drop(if (it < 0) 0 else it) }

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L).tail(3) // [8L, 9L, 10L]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see longArrayOf
 */
@JvmOverloads
fun LongArray.tail(n: Int = 10): List<Long> = (size - n).let { drop(if (it < 0) 0 else it) }

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F).tail(3) // [8F, 9F, 10F]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see floatArrayOf
 */
@JvmOverloads
fun FloatArray.tail(n: Int = 10): List<Float> = (size - n).let { drop(if (it < 0) 0 else it) }

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).tail(3) // [8.0, 9.0, 10.0]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see doubleArrayOf
 */
@JvmOverloads
fun DoubleArray.tail(n: Int = 10): List<Double> = (size - n).let { drop(if (it < 0) 0 else it) }

/**
 * Returns a list containing last [n] elements.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true).tail(3) // [true, false, true]
 * ```
 * @since 1.1.0
 * @param n number of elements return
 * @throws IllegalArgumentException if n is negative.
 * @return sublist
 * @see drop
 * @see booleanArrayOf
 */
@JvmOverloads
fun BooleanArray.tail(n: Int = 10): List<Boolean> = (size - n).let { drop(if (it < 0) 0 else it) }

/**
 * finds two numbers inside the [Array] from the given sum.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10).findPairOfSum(10) // (1, 9)
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
fun Array<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [Array] from the given sum.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10L).findPairOfSum(10L) // (1L, 9L)
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
fun Array<Long>.findPairOfSum(sum: Long): Pair<Long, Long>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [Array] from the given sum.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F, 4F, 5F).findPairOfSum(3F) // (1F, 2F)
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
fun Array<Float>.findPairOfSum(sum: Float): Pair<Float, Float>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [Array] from the given sum.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0, 4.0, 5.0).findPairOfSum(3.0) // (1.0, 2.0)
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
fun Array<Double>.findPairOfSum(sum: Double): Pair<Double, Double>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [IntArray] from the given sum.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10).findPairOfSum(10) // (1, 9)
 * ```
 * @since 1.1.0
 * @see intArrayOf
 */
fun IntArray.findPairOfSum(sum: Int): Pair<Int, Int>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [LongArray] from the given sum.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L).findPairOfSum(10L) // (1L, 9L)
 * ```
 * @since 1.1.0
 * @see longArrayOf
 */
fun LongArray.findPairOfSum(sum: Long): Pair<Long, Long>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [FloatArray] from the given sum.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1F, 2F, 3F, 4F, 5F).findPairOfSum(3F) // (1F, 2F)
 * ```
 * @since 1.1.0
 * @see floatArrayOf
 */
fun FloatArray.findPairOfSum(sum: Float): Pair<Float, Float>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds two numbers inside the [DoubleArray] from the given sum.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0).findPairOfSum(3.0) // (1.0, 2.0)
 * ```
 * @since 1.1.0
 * @see doubleArrayOf
 */
fun DoubleArray.findPairOfSum(sum: Double): Pair<Double, Double>? {
  val complements = associateBy { sum - it }
  for (element in this) {
    val complement = complements[element]
    val result = complement?.let { Pair(element, complement) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [Array] from the given sum.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10).findTripleOfSum(6) // (1, 2, 3)
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
fun Array<Int>.findTripleOfSum(sum: Int): Triple<Int, Int, Int>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [Array] from the given sum.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1..10L).findTripleOfSum(6L) // (1L, 2L, 3L)
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
fun Array<Long>.findTripleOfSum(sum: Long): Triple<Long, Long, Long>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [Array] from the given sum.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F, 4F, 5F, 6F).findTripleOfSum(6F) // (1F, 2F, 3F)
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
fun Array<Float>.findTripleOfSum(sum: Float): Triple<Float, Float, Float>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [Array] from the given sum.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0).findTripleOfSum(6.0) // (1.0, 2.0, 3.0)
 * ```
 * @since 1.1.0
 * @see arrayOf
 */
fun Array<Double>.findTripleOfSum(sum: Double): Triple<Double, Double, Double>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [IntArray] from the given sum.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1..10).findTripleOfSum(6) // (1, 2, 3)
 * ```
 * @since 1.1.0
 * @see intArrayOf
 */
fun IntArray.findTripleOfSum(sum: Int): Triple<Int, Int, Int>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [LongArray] from the given sum.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1..10L).findTripleOfSum(6L) // (1L, 2L, 3L)
 * ```
 * @since 1.1.0
 * @see longArrayOf
 */
fun LongArray.findTripleOfSum(sum: Long): Triple<Long, Long, Long>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [FloatArray] from the given sum.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1F, 2F, 3F, 4F, 5F, 6F).findTripleOfSum(6F) // (1F, 2F, 3F)
 * ```
 * @since 1.1.0
 * @see floatArrayOf
 */
fun FloatArray.findTripleOfSum(sum: Float): Triple<Float, Float, Float>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * finds three numbers inside the [DoubleArray] from the given sum.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0).findTripleOfSum(6.0) // (1.0, 2.0, 3.0)
 * ```
 * @since 1.1.0
 * @see doubleArrayOf
 */
fun DoubleArray.findTripleOfSum(sum: Double): Triple<Double, Double, Double>? {
  for (x in this) {
    // x -> (y, z) where y + z = sum - x
    val pair = findPairOfSum(sum - x)
    val result = pair?.let { Triple(x, pair.first, pair.second) }
    if (result != null) {
      return result
    }
  }
  return null
}

/**
 * Rotates the [Array] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3, 4, 5).rotateLeft(2) // [4, 5, 1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see arrayOf
 */
inline fun <reified T> Array<T>.rotateLeft(n: Int = 1): Array<T> {
  require(n >= 1) { "n must be >= 1" }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toTypedArray()
}

/**
 * Rotates the [ByteArray] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5).rotateLeft(2) // [4, 5, 1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see byteArrayOf
 */
@JvmOverloads
fun ByteArray.rotateLeft(n: Int = 1): ByteArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toByteArray()
}

/**
 * Rotates the [ShortArray] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5).rotateLeft(2) // [4, 5, 1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see shortArrayOf
 */
@JvmOverloads
fun ShortArray.rotateLeft(n: Int = 1): ShortArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toShortArray()
}

/**
 * Rotates the [CharArray] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a', 'b', 'c', 'd', 'e').rotateLeft(2) // ['d', 'e', 'a', 'b', 'c']
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see charArrayOf
 */
@JvmOverloads
fun CharArray.rotateLeft(n: Int = 1): CharArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toCharArray()
}

/**
 * Rotates the [IntArray] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1, 2, 3, 4, 5).rotateLeft(2) // [4, 5, 1, 2, 3]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see intArrayOf
 */
@JvmOverloads
fun IntArray.rotateLeft(n: Int = 1): IntArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toIntArray()
}

/**
 * Rotates the [LongArray] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1L, 2L, 3L, 4L, 5L).rotateLeft(2) // [4L, 5L, 1L, 2L, 3L]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see longArrayOf
 */
@JvmOverloads
fun LongArray.rotateLeft(n: Int = 1): LongArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toLongArray()
}

/**
 * Rotates the [FloatArray] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1F, 2F, 3F, 4F, 5F).rotateLeft(2) // [4F, 5F, 1F, 2F, 3F]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see floatArrayOf
 */
@JvmOverloads
fun FloatArray.rotateLeft(n: Int = 1): FloatArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toFloatArray()
}

/**
 * Rotates the [DoubleArray] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0).rotateLeft(2) // [4.0, 5.0, 1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see doubleArrayOf
 */
@JvmOverloads
fun DoubleArray.rotateLeft(n: Int = 1): DoubleArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toDoubleArray()
}

/**
 * Rotates the [BooleanArray] to the left by specified distance.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true).rotateLeft(2) // [false, true, true, false, true]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see booleanArrayOf
 */
@JvmOverloads
fun BooleanArray.rotateLeft(n: Int = 1): BooleanArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, n)
  return list.toBooleanArray()
}

/**
 * Rotates the [Array] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3, 4, 5).rotateRight(2) // [3, 4, 5, 1, 2]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see arrayOf
 */
inline fun <reified T> Array<T>.rotateRight(n: Int = 1): Array<T> {
  require(n >= 1) { "n must be >= 1" }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toTypedArray()
}

/**
 * Rotates the [ByteArray] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * byteArrayOf(1, 2, 3, 4, 5).rotateRight(2) // [3, 4, 5, 1, 2]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see byteArrayOf
 */
@JvmOverloads
fun ByteArray.rotateRight(n: Int = 1): ByteArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toByteArray()
}

/**
 * Rotates the [ShortArray] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * shortArrayOf(1, 2, 3, 4, 5).rotateRight(2) // [3, 4, 5, 1, 2]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see shortArrayOf
 */
@JvmOverloads
fun ShortArray.rotateRight(n: Int = 1): ShortArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toShortArray()
}

/**
 * Rotates the [CharArray] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * charArrayOf('a', 'b', 'c', 'd', 'e').rotateRight(2) // ['c', 'd', 'e', 'a', 'b']
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see charArrayOf
 */
@JvmOverloads
fun CharArray.rotateRight(n: Int = 1): CharArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toCharArray()
}

/**
 * Rotates the [IntArray] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * intArrayOf(1, 2, 3, 4, 5).rotateRight(2) // [3, 4, 5, 1, 2]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see intArrayOf
 */
@JvmOverloads
fun IntArray.rotateRight(n: Int = 1): IntArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toIntArray()
}

/**
 * Rotates the [LongArray] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * longArrayOf(1L, 2L, 3L, 4L, 5L).rotateRight(2) // [3L, 4L, 5L, 1L, 2L]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see longArrayOf
 */
@JvmOverloads
fun LongArray.rotateRight(n: Int = 1): LongArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toLongArray()
}

/**
 * Rotates the [FloatArray] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * floatArrayOf(1F, 2F, 3F, 4F, 5F).rotateRight(2) // [3F, 4F, 5F, 1F, 2F]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see floatArrayOf
 */
@JvmOverloads
fun FloatArray.rotateRight(n: Int = 1): FloatArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toFloatArray()
}

/**
 * Rotates the [DoubleArray] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0).rotateRight(2) // [3.0, 4.0, 5.0, 1.0, 2.0]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see doubleArrayOf
 */
@JvmOverloads
fun DoubleArray.rotateRight(n: Int = 1): DoubleArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toDoubleArray()
}

/**
 * Rotates the [BooleanArray] to the right by specified distance.
 *
 * Example:
 * ```Kotlin
 * booleanArrayOf(true, false, true, false, true).rotateRight(2) // [true, false, true, true, false]
 * ```
 * @since 1.1.0
 * @param n number of elements rotate
 * @throws IllegalArgumentException if n is **negative** or **zero**.
 * @see java.util.Collections.rotate
 * @see booleanArrayOf
 */
@JvmOverloads
fun BooleanArray.rotateRight(n: Int = 1): BooleanArray {
  require(n >= 1) { ROTATE_N_SIZE }
  val list = this.toMutableList()
  Collections.rotate(list, -n)
  return list.toBooleanArray()
}

private const val ROTATE_N_SIZE = "n must be >= 1"
