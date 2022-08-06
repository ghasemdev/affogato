@file:Suppress("TooManyFunctions")

package com.parsuomash.affogato.core.ktx.collections

/**
 * Adds the [Iterable] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10 add listOf(1, 2, 3) // [11, 12, 13]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.add(iterable: Iterable<T>): Iterable<Int> =
  iterable.map { this + it.toInt() }

/**
 * Adds the [number] value to this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3) add 10 // [11, 12, 13]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.add(number: Int): Iterable<Int> =
  map { it.toInt() + number }

/**
 * Adds the [Iterable] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10F add listOf(1F, 2F, 3F) // [11F, 12F, 13F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.add(iterable: Iterable<T>): Iterable<Float> =
  iterable.map { this + it.toFloat() }

/**
 * Adds the [number] value to this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F) add 10F // [11F, 12F, 13F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.add(number: Float): Iterable<Float> =
  map { it.toFloat() + number }

/**
 * Adds the [Iterable] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10.0 add listOf(1.0, 2.0, 3.0) // [11.0, 12.0, 13.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.add(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this + it.toDouble() }

/**
 * Adds the [number] value to this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0) add 10.0 // [11.0, 12.0, 13.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.add(number: Double): Iterable<Double> =
  map { it.toDouble() + number }

/**
 * Adds the [Iterable] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10L add listOf(1L, 2L, 3L) // [11L, 12L, 13L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.add(iterable: Iterable<T>): Iterable<Long> =
  iterable.map { this + it.toLong() }

/**
 * Adds the [number] value to this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1L, 2L, 3L) add 10L // [11L, 12L, 13L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.add(number: Long): Iterable<Long> =
  map { it.toLong() + number }

/**
 * Subtracts the [iterable] from this value.
 *
 * Example:
 * ```Kotlin
 * 10 sub listOf(1, 2, 3) // [9, 8, 7]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.sub(iterable: Iterable<T>): Iterable<Int> =
  iterable.map { this - it.toInt() }

/**
 * Subtracts the [number] from this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3) sub 10 // [-9, -8, -7]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.sub(number: Int): Iterable<Int> =
  map { it.toInt() - number }

/**
 * Subtracts the [iterable] from this value.
 *
 * Example:
 * ```Kotlin
 * 10F sub listOf(1F, 2F, 3F) // [9F, 8F, 7F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.sub(iterable: Iterable<T>): Iterable<Float> =
  iterable.map { this - it.toFloat() }

/**
 * Subtracts the [number] from this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F) sub 10F // [-9F, -8F, -7F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.sub(number: Float): Iterable<Float> =
  map { it.toFloat() - number }

/**
 * Subtracts the [iterable] from this value.
 *
 * Example:
 * ```Kotlin
 * 10.0 sub listOf(1.0, 2.0, 3.0) // [9.0, 8.0, 7.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.sub(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this - it.toDouble() }

/**
 * Subtracts the [number] from this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0) sub 10.0 // [-9.0, -8.0, -7.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.sub(number: Double): Iterable<Double> =
  map { it.toDouble() - number }

/**
 * Subtracts the [iterable] from this value.
 *
 * Example:
 * ```Kotlin
 * 10L sub listOf(1L, 2L, 3L) // [9L, 8L, 7L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.sub(iterable: Iterable<T>): Iterable<Long> =
  iterable.map { this - it.toLong() }

/**
 * Subtracts the [number] from this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1L, 2L, 3L) sub 10L // [-9L, -8L, -7L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.sub(number: Long): Iterable<Long> =
  map { it.toLong() - number }

/**
 * Multiplies this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10 mul listOf(1, 2, 3) // [10, 20, 30]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.mul(iterable: Iterable<T>): Iterable<Int> =
  iterable.map { this * it.toInt() }

/**
 * Multiplies this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3) mul 10 // [10, 20, 30]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.mul(number: Int): Iterable<Int> =
  map { it.toInt() * number }

/**
 * Multiplies this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10F mul listOf(1F, 2F, 3F) // [10F, 20F, 30F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.mul(iterable: Iterable<T>): Iterable<Float> =
  iterable.map { this * it.toFloat() }

/**
 * Multiplies this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F) mul 10F // [10F, 20F, 30F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.mul(number: Float): Iterable<Float> =
  map { it.toFloat() * number }

/**
 * Multiplies this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10.0 mul listOf(1.0, 2.0, 3.0) // [10.0, 20.0, 30.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.mul(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this * it.toDouble() }

/**
 * Multiplies this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0) mul 10.0 // [10.0, 20.0, 30.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.mul(number: Double): Iterable<Double> =
  map { it.toDouble() * number }

/**
 * Multiplies this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10L mul listOf(1L, 2L, 3L) // [10L, 20L, 30L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.mul(iterable: Iterable<T>): Iterable<Long> =
  iterable.map { this * it.toLong() }

/**
 * Multiplies this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1L, 2L, 3L) mul 10L // [10L, 20L, 30L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.mul(number: Long): Iterable<Long> =
  map { it.toLong() * number }

/**
 * Divides this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10 div listOf(1, 2, 3) // [10, 5, 3]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.div(iterable: Iterable<T>): Iterable<Int> =
  iterable.map { this / it.toInt() }

/**
 * Divides this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3) div 10 // [0, 0, 0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.div(number: Int): Iterable<Int> =
  map { it.toInt() / number }

/**
 * Divides this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10F div listOf(1F, 2F, 3F) // [10F, 5F, 3.33F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.div(iterable: Iterable<T>): Iterable<Float> =
  iterable.map { this / it.toFloat() }

/**
 * Divides this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F) div 10F // [0.1F, 0.2F, 0.3F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.div(number: Float): Iterable<Float> =
  map { it.toFloat() / number }

/**
 * Divides this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10.0 div listOf(1.0, 2.0, 3.0) // [10.0, 5.0, 3.33]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.div(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this / it.toDouble() }

/**
 * Divides this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0) div 10.0 // [0.1, 0.2, 0.3]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.div(number: Double): Iterable<Double> =
  map { it.toDouble() / number }

/**
 * Divides this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10L div listOf(1L, 2L, 3L) // [10L, 5L, 3L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.div(iterable: Iterable<T>): Iterable<Long> =
  iterable.map { this / it.toLong() }

/**
 * Divides this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1L, 2L, 3L) div 10L // [0L, 0L, 0L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.div(number: Long): Iterable<Long> =
  map { it.toLong() / number }

/**
 * Calculates the remainder of truncating division of this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10 rem listOf(1, 2, 3) // [0, 0, 1]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.rem(iterable: Iterable<T>): Iterable<Int> =
  iterable.map { this % it.toInt() }

/**
 * Calculates the remainder of truncating division of this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3) rem 10 // [1, 2, 3]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.rem(number: Int): Iterable<Int> =
  map { it.toInt() % number }

/**
 * Calculates the remainder of truncating division of this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10F rem listOf(1F, 2F, 3F) // [0F, 0F, 1F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.rem(iterable: Iterable<T>): Iterable<Float> =
  iterable.map { this % it.toFloat() }

/**
 * Calculates the remainder of truncating division of this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F) rem 10F // [1F, 2F, 3F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.rem(number: Float): Iterable<Float> =
  map { it.toFloat() % number }

/**
 * Calculates the remainder of truncating division of this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10.0 rem listOf(1.0, 2.0, 3.0) // [0.0, 0.0, 1.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.rem(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this % it.toDouble() }

/**
 * Calculates the remainder of truncating division of this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0) rem 10.0 // [1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.rem(number: Double): Iterable<Double> =
  map { it.toDouble() % number }

/**
 * Calculates the remainder of truncating division of this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10L rem listOf(1L, 2L, 3L) // [0L, 0L, 1L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.rem(iterable: Iterable<T>): Iterable<Long> =
  iterable.map { this % it.toLong() }

/**
 * Calculates the remainder of truncating division of this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1L, 2L, 3L) rem 10L // [1L, 2L, 3L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.rem(number: Long): Iterable<Long> =
  map { it.toLong() % number }
