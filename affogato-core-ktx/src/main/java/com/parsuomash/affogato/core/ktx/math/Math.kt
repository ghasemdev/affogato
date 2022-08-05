package com.parsuomash.affogato.core.ktx.math

import kotlin.math.pow
import kotlin.math.round

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
  kotlin.math.log(toDouble(), base.toDouble())
