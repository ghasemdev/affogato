@file:Suppress("TooManyFunctions", "ArrayPrimitive")

package com.parsuomash.affogato.core.ktx.operations

// TODO v3.2.0 add operators for IntArray , FloatArray , DoubleArray and LongArray.

/**
 * Adds the [Array] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10 add arrayOf(1, 2, 3) // [11, 12, 13]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.add(array: Array<T>): Array<Int> =
  array.map { this + it.toInt() }.toTypedArray()

/**
 * Adds the [number] value to this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3) add 10 // [11, 12, 13]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.add(number: Int): Array<Int> =
  map { it.toInt() + number }.toTypedArray()

/**
 * Adds the [Array] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10F add arrayOf(1F, 2F, 3F) // [11F, 12F, 13F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.add(array: Array<T>): Array<Float> =
  array.map { this + it.toFloat() }.toTypedArray()

/**
 * Adds the [number] value to this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F) add 10F // [11F, 12F, 13F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.add(number: Float): Array<Float> =
  map { it.toFloat() + number }.toTypedArray()

/**
 * Adds the [Array] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10.0 add arrayOf(1.0, 2.0, 3.0) // [11.0, 12.0, 13.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.add(array: Array<T>): Array<Double> =
  array.map { this + it.toDouble() }.toTypedArray()

/**
 * Adds the [number] value to this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0) add 10.0 // [11.0, 12.0, 13.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.add(number: Double): Array<Double> =
  map { it.toDouble() + number }.toTypedArray()

/**
 * Adds the [Array] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10L add arrayOf(1L, 2L, 3L) // [11L, 12L, 13L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.add(array: Array<T>): Array<Long> =
  array.map { this + it.toLong() }.toTypedArray()

/**
 * Adds the [number] value to this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1L, 2L, 3L) add 10L // [11L, 12L, 13L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.add(number: Long): Array<Long> =
  map { it.toLong() + number }.toTypedArray()

/**
 * Subtracts the [array] from this value.
 *
 * Example:
 * ```Kotlin
 * 10 sub arrayOf(1, 2, 3) // [9, 8, 7]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.sub(array: Array<T>): Array<Int> =
  array.map { this - it.toInt() }.toTypedArray()

/**
 * Subtracts the [number] from this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3) sub 10 // [-9, -8, -7]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.sub(number: Int): Array<Int> =
  map { it.toInt() - number }.toTypedArray()

/**
 * Subtracts the [array] from this value.
 *
 * Example:
 * ```Kotlin
 * 10F sub arrayOf(1F, 2F, 3F) // [9F, 8F, 7F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.sub(array: Array<T>): Array<Float> =
  array.map { this - it.toFloat() }.toTypedArray()

/**
 * Subtracts the [number] from this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F) sub 10F // [-9F, -8F, -7F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.sub(number: Float): Array<Float> =
  map { it.toFloat() - number }.toTypedArray()

/**
 * Subtracts the [array] from this value.
 *
 * Example:
 * ```Kotlin
 * 10.0 sub arrayOf(1.0, 2.0, 3.0) // [9.0, 8.0, 7.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.sub(array: Array<T>): Array<Double> =
  array.map { this - it.toDouble() }.toTypedArray()

/**
 * Subtracts the [number] from this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0) sub 10.0 // [-9.0, -8.0, -7.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.sub(number: Double): Array<Double> =
  map { it.toDouble() - number }.toTypedArray()

/**
 * Subtracts the [array] from this value.
 *
 * Example:
 * ```Kotlin
 * 10L sub arrayOf(1L, 2L, 3L) // [9L, 8L, 7L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.sub(array: Array<T>): Array<Long> =
  array.map { this - it.toLong() }.toTypedArray()

/**
 * Subtracts the [number] from this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1L, 2L, 3L) sub 10L // [-9L, -8L, -7L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.sub(number: Long): Array<Long> =
  map { it.toLong() - number }.toTypedArray()

/**
 * Multiplies this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10 mul arrayOf(1, 2, 3) // [10, 20, 30]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.mul(array: Array<T>): Array<Int> =
  array.map { this * it.toInt() }.toTypedArray()

/**
 * Multiplies this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3) mul 10 // [10, 20, 30]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.mul(number: Int): Array<Int> =
  map { it.toInt() * number }.toTypedArray()

/**
 * Multiplies this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10F mul arrayOf(1F, 2F, 3F) // [10F, 20F, 30F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.mul(array: Array<T>): Array<Float> =
  array.map { this * it.toFloat() }.toTypedArray()

/**
 * Multiplies this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F) mul 10F // [10F, 20F, 30F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.mul(number: Float): Array<Float> =
  map { it.toFloat() * number }.toTypedArray()

/**
 * Multiplies this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10.0 mul arrayOf(1.0, 2.0, 3.0) // [10.0, 20.0, 30.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.mul(array: Array<T>): Array<Double> =
  array.map { this * it.toDouble() }.toTypedArray()

/**
 * Multiplies this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0) mul 10.0 // [10.0, 20.0, 30.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.mul(number: Double): Array<Double> =
  map { it.toDouble() * number }.toTypedArray()

/**
 * Multiplies this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10L mul arrayOf(1L, 2L, 3L) // [10L, 20L, 30L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.mul(array: Array<T>): Array<Long> =
  array.map { this * it.toLong() }.toTypedArray()

/**
 * Multiplies this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1L, 2L, 3L) mul 10L // [10L, 20L, 30L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.mul(number: Long): Array<Long> =
  map { it.toLong() * number }.toTypedArray()

/**
 * Divides this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10 div arrayOf(1, 2, 3) // [10, 5, 3]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.div(array: Array<T>): Array<Int> =
  array.map { this / it.toInt() }.toTypedArray()

/**
 * Divides this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3) div 10 // [0, 0, 0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.div(number: Int): Array<Int> =
  map { it.toInt() / number }.toTypedArray()

/**
 * Divides this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10F div arrayOf(1F, 2F, 3F) // [10F, 5F, 3.33F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.div(array: Array<T>): Array<Float> =
  array.map { this / it.toFloat() }.toTypedArray()

/**
 * Divides this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F) div 10F // [0.1F, 0.2F, 0.3F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.div(number: Float): Array<Float> =
  map { it.toFloat() / number }.toTypedArray()

/**
 * Divides this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10.0 div arrayOf(1.0, 2.0, 3.0) // [10.0, 5.0, 3.33]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.div(array: Array<T>): Array<Double> =
  array.map { this / it.toDouble() }.toTypedArray()

/**
 * Divides this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0) div 10.0 // [0.1, 0.2, 0.3]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.div(number: Double): Array<Double> =
  map { it.toDouble() / number }.toTypedArray()

/**
 * Divides this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10L div arrayOf(1L, 2L, 3L) // [10L, 5L, 3L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.div(array: Array<T>): Array<Long> =
  array.map { this / it.toLong() }.toTypedArray()

/**
 * Divides this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1L, 2L, 3L) div 10L // [0L, 0L, 0L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.div(number: Long): Array<Long> =
  map { it.toLong() / number }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10 rem arrayOf(1, 2, 3) // [0, 0, 1]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.rem(array: Array<T>): Array<Int> =
  array.map { this % it.toInt() }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3) rem 10 // [1, 2, 3]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.rem(number: Int): Array<Int> =
  map { it.toInt() % number }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10F rem arrayOf(1F, 2F, 3F) // [0F, 0F, 1F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.rem(array: Array<T>): Array<Float> =
  array.map { this % it.toFloat() }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F) rem 10F // [1F, 2F, 3F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.rem(number: Float): Array<Float> =
  map { it.toFloat() % number }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10.0 rem arrayOf(1.0, 2.0, 3.0) // [0.0, 0.0, 1.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.rem(array: Array<T>): Array<Double> =
  array.map { this % it.toDouble() }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0) rem 10.0 // [1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.rem(number: Double): Array<Double> =
  map { it.toDouble() % number }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10L rem arrayOf(1L, 2L, 3L) // [0L, 0L, 1L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.rem(array: Array<T>): Array<Long> =
  array.map { this % it.toLong() }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1L, 2L, 3L) rem 10L // [1L, 2L, 3L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.rem(number: Long): Array<Long> =
  map { it.toLong() % number }.toTypedArray()
