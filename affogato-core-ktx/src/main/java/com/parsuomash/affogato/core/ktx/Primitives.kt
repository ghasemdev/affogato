package com.parsuomash.affogato.core.ktx

/**
 * Checking positivity.
 *
 * Example:
 * ```Kotlin
 * 10.isPositive() // true
 * -10.isPositive() // false
 * ```
 * @since 1.5.1
 */
@get:JvmSynthetic
inline val Int.isPositive: Boolean
  get() = this > 0

/**
 * Checking positivity.
 *
 * Example:
 * ```Kotlin
 * 10L.isPositive() // true
 * -10L.isPositive() // false
 * ```
 * @since 1.5.1
 */
@get:JvmSynthetic
inline val Long.isPositive: Boolean
  get() = this > 0

/**
 * Checking positivity.
 *
 * Example:
 * ```Kotlin
 * 10F.isPositive() // true
 * -10F.isPositive() // false
 * ```
 * @since 1.5.1
 */
@get:JvmSynthetic
inline val Float.isPositive: Boolean
  get() = this > 0

/**
 * Checking positivity.
 *
 * Example:
 * ```Kotlin
 * 10.0.isPositive() // true
 * -10.0.isPositive() // false
 * ```
 * @since 1.5.1
 */
@get:JvmSynthetic
inline val Double.isPositive: Boolean
  get() = this > 0

/**
 * Checking negativity.
 *
 * Example:
 * ```Kotlin
 * 10.isNegative() // false
 * -10.isNegative() // true
 * ```
 * @since 1.1.0
 */
@get:JvmSynthetic
inline val Int.isNegative: Boolean
  get() = this < 0

/**
 * Checking negativity.
 *
 * Example:
 * ```Kotlin
 * 10L.isNegative() // false
 * -10L.isNegative() // true
 * ```
 * @since 1.1.0
 */
@get:JvmSynthetic
inline val Long.isNegative: Boolean
  get() = this < 0

/**
 * Checking negativity.
 *
 * Example:
 * ```Kotlin
 * 10F.isNegative() // false
 * -10F.isNegative() // true
 * ```
 * @since 1.1.0
 */
@get:JvmSynthetic
inline val Float.isNegative: Boolean
  get() = this < 0

/**
 * Checking negativity.
 *
 * Example:
 * ```Kotlin
 * 10.0.isNegative() // false
 * -10.0.isNegative() // true
 * ```
 * @since 1.1.0
 */
@get:JvmSynthetic
inline val Double.isNegative: Boolean
  get() = this < 0

/**
 * Return zero when number is null.
 *
 * Example:
 * ```Kotlin
 * val int: Int? = null
 * int.orZero() // 0
 * ```
 * @since 1.1.0
 * @return [Int] value or **Zero**
 */
@JvmSynthetic
fun Int?.orZero(): Int =
  this ?: 0

/**
 * Return zero when number is null.
 *
 * Example:
 * ```Kotlin
 * val long: Long? = null
 * long.orZero() // 0L
 * ```
 * @since 1.1.0
 * @return [Long] value or **Zero**
 */
@JvmSynthetic
fun Long?.orZero(): Long =
  this ?: 0L

/**
 * Return zero when number is null.
 *
 * Example:
 * ```Kotlin
 * val float: Float? = null
 * float.orZero() // 0F
 * ```
 * @since 1.1.0
 * @return [Float] value or **Zero**
 */
@JvmSynthetic
fun Float?.orZero(): Float =
  this ?: 0F

/**
 * Return zero when number is null.
 *
 * Example:
 * ```Kotlin
 * val double: Double? = null
 * double.orZero() // 0.0
 * ```
 * @since 1.1.0
 * @return [Double] value or **Zero**
 */
@JvmSynthetic
fun Double?.orZero(): Double =
  this ?: 0.0
