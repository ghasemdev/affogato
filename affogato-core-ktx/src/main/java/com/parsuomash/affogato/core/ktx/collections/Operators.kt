package com.parsuomash.affogato.core.ktx.collections

/**
 * Adds the [Array] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10 sum arrayOf(1, 2, 3) // [11, 12, 13]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.sum(array: Array<T>): Array<Int> =
  array.map { this + it.toInt() }.toTypedArray()

/**
 * Adds the [Iterable] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10 sum listOf(1, 2, 3) // [11, 12, 13]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.sum(iterable: Iterable<T>): Iterable<Int> =
  iterable.map { this + it.toInt() }

/**
 * Adds the [number] value to this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3) sum 10 // [11, 12, 13]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.sum(number: Int): Array<Int> =
  map { it.toInt() + number }.toTypedArray()

/**
 * Adds the [number] value to this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3) sum 10 // [11, 12, 13]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.sum(number: Int): Iterable<Int> =
  map { it.toInt() + number }

/**
 * Adds the [Array] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10F sum arrayOf(1F, 2F, 3F) // [11F, 12F, 13F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.sum(array: Array<T>): Array<Float> =
  array.map { this + it.toFloat() }.toTypedArray()

/**
 * Adds the [Iterable] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10F sum listOf(1F, 2F, 3F) // [11F, 12F, 13F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.sum(iterable: Iterable<T>): Iterable<Float> =
  iterable.map { this + it.toFloat() }

/**
 * Adds the [number] value to this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F) sum 10F // [11F, 12F, 13F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.sum(number: Float): Array<Float> =
  map { it.toFloat() + number }.toTypedArray()

/**
 * Adds the [number] value to this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F) sum 10F // [11F, 12F, 13F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.sum(number: Float): Iterable<Float> =
  map { it.toFloat() + number }

/**
 * Adds the [Array] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10.0 sum arrayOf(1.0, 2.0, 3.0) // [11.0, 12.0, 13.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.sum(array: Array<T>): Array<Double> =
  array.map { this + it.toDouble() }.toTypedArray()

/**
 * Adds the [Iterable] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10.0 sum listOf(1.0, 2.0, 3.0) // [11.0, 12.0, 13.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.sum(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this + it.toDouble() }

/**
 * Adds the [number] value to this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0) sum 10.0 // [11.0, 12.0, 13.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.sum(number: Double): Array<Double> =
  map { it.toDouble() + number }.toTypedArray()

/**
 * Adds the [number] value to this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0) sum 10.0 // [11.0, 12.0, 13.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.sum(number: Double): Iterable<Double> =
  map { it.toDouble() + number }

/**
 * Adds the [Array] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10L sum arrayOf(1L, 2L, 3L) // [11L, 12L, 13L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.sum(array: Array<T>): Array<Long> =
  array.map { this + it.toLong() }.toTypedArray()

/**
 * Adds the [Iterable] value to this value.
 *
 * Example:
 * ```Kotlin
 * 10L sum listOf(1L, 2L, 3L) // [11L, 12L, 13L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.sum(iterable: Iterable<T>): Iterable<Long> =
  iterable.map { this + it.toLong() }

/**
 * Adds the [number] value to this [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1L, 2L, 3L) sum 10L // [11L, 12L, 13L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.sum(number: Long): Array<Long> =
  map { it.toLong() + number }.toTypedArray()

/**
 * Adds the [number] value to this [Iterable].
 *
 * Example:
 * ```Kotlin
 * listOf(1L, 2L, 3L) sum 10L // [11L, 12L, 13L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.sum(number: Long): Iterable<Long> =
  map { it.toLong() + number }

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
 * Calculates the remainder of truncating division of this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10 mod arrayOf(1, 2, 3) // [0, 0, 1]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.mod(array: Array<T>): Array<Int> =
  array.map { this % it.toInt() }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10 mod listOf(1, 2, 3) // [0, 0, 1]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Int.mod(iterable: Iterable<T>): Iterable<Int> =
  iterable.map { this % it.toInt() }

/**
 * Calculates the remainder of truncating division of this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3) mod 10 // [1, 2, 3]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.mod(number: Int): Array<Int> =
  map { it.toInt() % number }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3) mod 10 // [1, 2, 3]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.mod(number: Int): Iterable<Int> =
  map { it.toInt() % number }

/**
 * Calculates the remainder of truncating division of this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10F mod arrayOf(1F, 2F, 3F) // [0F, 0F, 1F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.mod(array: Array<T>): Array<Float> =
  array.map { this % it.toFloat() }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10F mod listOf(1F, 2F, 3F) // [0F, 0F, 1F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Float.mod(iterable: Iterable<T>): Iterable<Float> =
  iterable.map { this % it.toFloat() }

/**
 * Calculates the remainder of truncating division of this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1F, 2F, 3F) mod 10F // [1F, 2F, 3F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.mod(number: Float): Array<Float> =
  map { it.toFloat() % number }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1F, 2F, 3F) mod 10F // [1F, 2F, 3F]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.mod(number: Float): Iterable<Float> =
  map { it.toFloat() % number }

/**
 * Calculates the remainder of truncating division of this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10.0 mod arrayOf(1.0, 2.0, 3.0) // [0.0, 0.0, 1.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.mod(array: Array<T>): Array<Double> =
  array.map { this % it.toDouble() }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10.0 mod listOf(1.0, 2.0, 3.0) // [0.0, 0.0, 1.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Double.mod(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this % it.toDouble() }

/**
 * Calculates the remainder of truncating division of this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 2.0, 3.0) mod 10.0 // [1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.mod(number: Double): Array<Double> =
  map { it.toDouble() % number }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1.0, 2.0, 3.0) mod 10.0 // [1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.mod(number: Double): Iterable<Double> =
  map { it.toDouble() % number }

/**
 * Calculates the remainder of truncating division of this value by the [array].
 *
 * Example:
 * ```Kotlin
 * 10L mod arrayOf(1L, 2L, 3L) // [0L, 0L, 1L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.mod(array: Array<T>): Array<Long> =
  array.map { this % it.toLong() }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this value by the [iterable].
 *
 * Example:
 * ```Kotlin
 * 10L mod listOf(1L, 2L, 3L) // [0L, 0L, 1L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Long.mod(iterable: Iterable<T>): Iterable<Long> =
  iterable.map { this % it.toLong() }

/**
 * Calculates the remainder of truncating division of this [Array] by the [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1L, 2L, 3L) mod 10L // [1L, 2L, 3L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Array<T>.mod(number: Long): Array<Long> =
  map { it.toLong() % number }.toTypedArray()

/**
 * Calculates the remainder of truncating division of this [Iterable] by the [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1L, 2L, 3L) mod 10L // [1L, 2L, 3L]
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> Iterable<T>.mod(number: Long): Iterable<Long> =
  map { it.toLong() % number }
