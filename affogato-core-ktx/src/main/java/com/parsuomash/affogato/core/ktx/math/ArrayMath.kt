@file:Suppress("TooManyFunctions", "ArrayPrimitive")

package com.parsuomash.affogato.core.ktx.math

import com.parsuomash.affogato.core.ktx.collections.sortedByValueDescending
import com.parsuomash.affogato.core.ktx.counter
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.exp
import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.log2
import kotlin.math.round
import kotlin.math.sign
import kotlin.math.sqrt
import kotlin.math.truncate

// TODO v2.2.0 add trigonometric functions (sin, sinh, asin, asinh, cos, cosh,
//  acos, acosh, tan, tanh, atan, atanh).

// TODO 2.6.0 add math function for IntArray , FloatArray, DoubleArray and Long Array.

/**
 * Computes the median of the value [Array].
 *
 * Notice -> In pair list of values, the median is the two middle value.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1 , 5 , 3 , 9 , 0 , 4).median() // (3, 4)
 * arrayOf(1 , 5 , 3 , 0 , 4).median() // (3 , null)
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if the [Array] is empty.
 */
inline fun <reified T> Array<T>.median(): Pair<T, T?> {
  require(isNotEmpty()) { "The array must have at least one element!!" }
  val sortedArray = sortedBy { it.hashCode() }
  return if (sortedArray.size % 2 == 0) {
    Pair(sortedArray[size / 2 - 1], sortedArray[size / 2])
  } else {
    Pair(sortedArray[size / 2], null)
  }
}

/**
 * Computes the mode of the value [Array].
 *
 * Notice -> If all element repetition is equals all of them return as mode.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 1, 1, 2, 3, 4, 5, 5, 2).mode() // [1]
 * arrayOf(1, 2, 3, 4, 5, 6, 7).mode() // [1, 2, 3, 4, 5, 6, 7]
 * ```
 * @since 1.1.0
 */
inline fun <reified T> Array<T>.mode(): List<T> {
  val map = counter(this).sortedByValueDescending()
  var repeat = -1
  return buildList {
    for ((key, value) in map) {
      if (repeat == -1 || repeat == value) {
        repeat = value
        add(key)
      }
    }
  }
}

/**
 * Computes the standard division of the value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3, 4, 5, 6, 7).std() // 2.0
 * arrayOf().std() // NAN
 * ```
 * @since 1.1.0
 */
inline fun <reified T : Number> Array<T>.std(): Double {
  val numbers = map { it.toDouble() }
  val mean = numbers.average()
  var standardDeviation = 0.0

  for (num in numbers) {
    standardDeviation += (num - mean) pow 2
  }
  return sqrt(standardDeviation / size)
}

/**
 * Computes the variance of the value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3, 4, 5, 6, 7).variance() // 4.666666666666667
 * arrayOf().variance() // NAN
 * ```
 * @since 1.1.0
 */
inline fun <reified T : Number> Array<T>.variance(): Double {
  if (isEmpty()) return Double.NaN

  val numbers = map { it.toDouble() }
  val mean = numbers.average()
  var standardDeviation = 0.0

  for (num in numbers) {
    standardDeviation += (num - mean) pow 2
  }
  return standardDeviation / (size - 1)
}

/**
 * Raises this value to the power [array].
 *
 * Example:
 * ```Kotlin
 * 2 pow arrayOf(1, 2, 3) // [2.0, 4.0, 8.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.pow
 */
inline infix fun <reified T : Number> T.pow(array: Array<T>): Array<Double> =
  array.map { this pow it }.toTypedArray()

/**
 * Raises this [Array] to the power [number].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3) pow 2 // [1.0, 4.0, 9.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.pow
 */
inline infix fun <reified T : Number> Array<T>.pow(number: T): Array<Double> =
  map { it pow number }.toTypedArray()

/**
 * Computes the logarithm of the value x to the given [Array] bases.
 *
 * Example:
 * ```Kotlin
 * 1000 log arrayOf(1000, 100, 10, 1) // [1.0, 2.0 , 3.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.log
 */
inline infix fun <reified T : Number> T.log(array: Array<T>): Array<Double> =
  array.map { this log it }.toTypedArray()

/**
 * Computes the logarithm of the [Array] values to the given base.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1000, 100, 10) log 10 // [3.0, 2.0 , 1.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.log
 */
inline infix fun <reified T : Number> Array<T>.log(number: T): Array<Double> =
  map { it log number }.toTypedArray()

/**
 * Computes the common logarithm (base 10) of the value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 4.0, 9.0).log10() // [1.0, 2.0, 3.0, 4.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.log10
 * @see kotlin.math.ln
 */
inline fun <reified T : Number> Array<T>.log10(): Array<Double> =
  map { log10(it.toDouble()) }.toTypedArray()

/**
 * Computes the binary logarithm (base 2) of the value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(2, 4, 8, 16).log2() // [1.0, 2.0, 3.0, 4.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.log2
 * @see kotlin.math.ln
 */
inline fun <reified T : Number> Array<T>.log2(): Array<Double> =
  map { log2(it.toDouble()) }.toTypedArray()

/**
 * Computes the natural logarithm (base E) of the value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 4.0, 9.0).ln() // [0.0, 1.38, 2.19]
 * ```
 * @since 1.1.0
 * @see kotlin.math.ln
 */
inline fun <reified T : Number> Array<T>.ln(): Array<Double> =
  map { ln(it.toDouble()) }.toTypedArray()

/**
 * Rounds the given value [Array] towards the closest integer with ties
 * rounded towards even integer.
 *
 * Example:
 * ```Kotlin
 * arrayOf(31.62F, 10F, 3.16F).round() // [32F, 10F, 3F]
 * ```
 * @since 1.1.0
 * @see kotlin.math.round
 */
fun Array<Float>.round(): Array<Float> = map { round(it) }.toTypedArray()

/**
 * Rounds the given value [Array] towards the closest integer with ties
 * rounded towards even integer.
 *
 * Example:
 * ```Kotlin
 * arrayOf(31.622776601683793, 10.0, 3.1622776601683795).round() // [32.0, 10.0, 3.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.round
 */
fun Array<Double>.round(): Array<Double> = map { round(it) }.toTypedArray()

/**
 * Computes the positive square root of the value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.0, 4.0, 9.0).sqrt() // [1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.sqrt
 */
inline fun <reified T : Number> Array<T>.sqrt(): Array<Double> =
  map { sqrt(it.toDouble()) }.toTypedArray()

/**
 * Returns the absolute value of the given value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(-1, 2, 0, -6).abs() // [1, 2, 0, 6]
 * ```
 * @since 1.1.0
 * @see kotlin.math.abs
 */
@JvmName("absInt")
fun Array<Int>.abs(): Array<Int> = map { abs(it) }.toTypedArray()

/**
 * Returns the absolute value of the given value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(-1F, 2F, 0F, -6F).abs() // [1F, 2F, 0F, 6F]
 * ```
 * @since 1.1.0
 * @see kotlin.math.abs
 */
@JvmName("absFloat")
fun Array<Float>.abs(): Array<Float> = map { abs(it) }.toTypedArray()

/**
 * Returns the absolute value of the given value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(-1.0, 2.0, 0.0, -6.0).abs() // [1.0, 2.0, 0.0, 6.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.abs
 */
@JvmName("absDouble")
fun Array<Double>.abs(): Array<Double> = map { abs(it) }.toTypedArray()

/**
 * Returns the absolute value of the given value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(-1L, 2L, 0L, -6L).abs() // [1L, 2L, 0L, 6L]
 * ```
 * @since 1.1.0
 * @see kotlin.math.abs
 */
@JvmName("absLong")
fun Array<Long>.abs(): Array<Long> = map { abs(it) }.toTypedArray()

/**
 * Rounds the given value [Array] to an integer towards positive infinity.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.1, 1.4999999999999998, 2.9999999999999996, 2.6).ceil() // [2.0, 2.0, 3.0, 3.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.ceil
 */
inline fun <reified T : Number> Array<T>.ceil(): Array<Double> =
  map { ceil(it.toDouble()) }.toTypedArray()

/**
 * Rounds the given value [Array] to an integer towards negative infinity.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.1, 1.4999999999999998, 2.9999999999999996, 2.6).floor() // [1.0, 1.0, 2.0, 2.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.floor
 */
inline fun <reified T : Number> Array<T>.floor(): Array<Double> =
  map { floor(it.toDouble()) }.toTypedArray()

/**
 * Returns the sign of the given value [Array]:
 * - -1.0 if the value is negative,
 * - zero if the value is zero,
 * - 1.0 if the value is positive
 *
 * Example:
 * ```Kotlin
 * arrayOf(-1.0, 2.0, 0.0, -6.0).sign() // [-1.0, 1.0, 0.0, -1.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.sign
 */
inline fun <reified T : Number> Array<T>.sign(): Array<Double> =
  map { sign(it.toDouble()) }.toTypedArray()

/**
 * Computes Euler's number e raised to the power of the value [Array].
 *
 * Example:
 * ```Kotlin
 * arrayOf(1, 2, 3, 4).exp()
 * // [2.718281828459045, 7.38905609893065, 20.085536923187668, 54.598150033144236]
 * ```
 * @since 1.1.0
 * @see kotlin.math.exp
 */
inline fun <reified T : Number> Array<T>.exp(): Array<Double> =
  map { exp(it.toDouble()) }.toTypedArray()

/**
 * Rounds the given value [Array] to an integer towards zero.
 *
 * Example:
 * ```Kotlin
 * arrayOf(1.1, 1.49998, 2.99996, 2.6).truncate() // [1.0, 1.0, 2.0, 2.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.truncate
 */
inline fun <reified T : Number> Array<T>.truncate(): Array<Double> =
  map { truncate(it.toDouble()) }.toTypedArray()
