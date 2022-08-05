package com.parsuomash.affogato.core.ktx.math

import kotlin.math.pow

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
inline infix fun <reified T : Number> T.pow(number: T): Double = toDouble().pow(number.toDouble())

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
