package com.parsuomash.affogato.core.ktx.math

import com.parsuomash.affogato.core.ktx.times
import java.text.DecimalFormat
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.log
import kotlin.math.round

/**
 * Is this number odd.
 *
 * Example:
 * ```Kotlin
 * 5.isOdd // true
 * 5.isEven // false
 * ```
 * @since 1.1.0
 */
inline val Number.isOdd: Boolean
  get() = this.toDouble() % 2 != 0.0

/**
 * Is this number even.
 *
 * Example:
 * ```Kotlin
 * 6.isEven // true
 * 6.isOdd // false
 * ```
 * @since 1.1.0
 */
inline val Number.isEven: Boolean
  get() = this.toDouble() % 2 == 0.0

/**
 * Convert this radian number to degree.
 *
 * Example:
 * ```Kotlin
 * 1.asRadian.toDegree // 57.30F
 * ```
 * @since 1.1.0
 */
inline val Number.asDegrees: Float
  get() = toFloat() * (180F / PI).toFloat()

/**
 * Convert this degree number to radian.
 *
 * Example:
 * ```Kotlin
 * 90.asRadian // 1.57F
 * ```
 * @since 1.1.0
 */
inline val Number.asRadians: Float
  get() = toFloat() * (PI / 180F).toFloat()

/**
 * Rounds the given value [number] towards the closest integer with [digits] of rounding.
 *
 * Example:
 * ```Kotlin
 * round(1.999F) // 2.0F
 * round(1.856F, 1) // 1.9F
 * round(1.856F, 2) // 1.86FF
 * ```
 * @since 1.1.0
 * @see kotlin.math.round
 */
fun round(number: Float, digits: Int = 0): Float {
  return if (digits == 0) {
    round(number)
  } else {
    DecimalFormat("###.${"#" * digits}").format(number).toFloat()
  }
}

/**
 * Rounds the given value [number] towards the closest integer with [digits] of rounding.
 *
 * Example:
 * ```Kotlin
 * round(1.999) // 2.0
 * round(1.856, 1) // 1.9
 * round(1.856, 2) // 1.86F
 * ```
 * @since 1.1.0
 * @see kotlin.math.round
 */
fun round(number: Double, digits: Int = 0): Double {
  return if (digits == 0) {
    round(number)
  } else {
    DecimalFormat("###.${"#" * digits}").format(number).toDouble()
  }
}

/**
 * Rounds the given value this towards the closest integer with [digits] of rounding.
 *
 * Example:
 * ```Kotlin
 * 1.999F.round() // 2.0F
 * 1.856F.round(1) // 1.9F
 * 1.856F.round(2) // 1.86F
 * ```
 * @since 1.1.0
 * @see kotlin.math.round
 */
@JvmName("roundEx")
fun Float.round(digits: Int = 0): Float {
  return if (digits == 0) {
    round(this)
  } else {
    DecimalFormat("###.${"#" * digits}").format(this).toFloat()
  }
}

/**
 * Rounds the given value this towards the closest integer with [digits] of rounding.
 *
 * Example:
 * ```Kotlin
 * 1.999.round() // 2.0
 * 1.856.round(1) // 1.9
 * 1.856.round(2) // 1.86
 * ```
 * @since 1.1.0
 * @see kotlin.math.round
 */
@JvmName("roundEx")
fun Double.round(digits: Int = 0): Double {
  return if (digits == 0) {
    round(this)
  } else {
    DecimalFormat("###.${"#" * digits}").format(this).toDouble()
  }
}

/**
 * Calculate factorial of [n].
 *
 * Example:
 * ```Kotlin
 * fact(5) // 120L
 * ```
 * @since 1.1.0
 */
tailrec fun fact(n: Long, run: Long = 1): Long =
  if (n == 1L) run else fact(n - 1, run * n)

/**
 * Calculate fibonacci of [n].
 *
 * Example:
 * ```Kotlin
 * fib(5) // 120L
 * ```
 * @since 1.1.0
 */
tailrec fun fib(n: Long, first: Long = 0, second: Long = 1): Long =
  if (n == 0L) first else fib(n - 1, second, first + second)

/**
 * Calculate percentage of this value.
 *
 * Example:
 * ```Kotlin
 * 199 perc 24 // (24 * 199) / 100 = 47.76
 * ```
 * @since 1.1.0
 */
inline infix fun <reified T : Number> T.perc(percentage: T): Double =
  (percentage.toDouble() * toDouble()) / 100

/**
 * Returns a [Boolean] if this value almost equals the other value (**not equals**).
 *
 * Example:
 * ```Kotlin
 * 2 almostEq 1.99999 // true
 * 1.99999 almostEq 2 // true
 * 2 almostEq 2 // false
 * ```
 * @since 1.1.0
 * @see round
 */
inline infix fun <reified T : Number> T.almostEq(other: T): Boolean {
  if (this == other) return false
  return round(toDouble()) == round(other.toDouble())
}

/**
 * Raises this value to the power [number].
 *
 * Example:
 * ```Kotlin
 * 2 pow 3 // 8
 * 2.3 pow 3 // 12.167
 * ```
 * @since 1.1.0
 * @see pow
 */
inline infix fun <reified T : Number> T.pow(number: T): Double =
  toDouble().pow(number.toDouble())

/**
 * Computes the logarithm of the value x to the given [base].
 *
 * Example:
 * ```Kotlin
 * 100 log 10 // 2
 * ```
 * @since 1.1.0
 * @see kotlin.math.log
 */
inline infix fun <reified T : Number> T.log(base: T): Double =
  log(toDouble(), base.toDouble())
