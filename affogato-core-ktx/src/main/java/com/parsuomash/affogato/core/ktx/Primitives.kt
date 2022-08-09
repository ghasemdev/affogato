package com.parsuomash.affogato.core.ktx

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
inline val Int.isNegative: Boolean get() = this < 0

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
inline val Long.isNegative: Boolean get() = this < 0

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
inline val Float.isNegative: Boolean get() = this < 0

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
inline val Double.isNegative: Boolean get() = this < 0

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
fun Int?.orZero(): Int = this ?: 0

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
fun Long?.orZero(): Long = this ?: 0L

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
fun Float?.orZero(): Float = this ?: 0F

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
fun Double?.orZero(): Double = this ?: 0.0
