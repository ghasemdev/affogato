package com.parsuomash.affogato.core.ktx.math

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
 * Raises this value to the power [iterable].
 *
 * Example:
 * ```Kotlin
 * 2 pow listOf(1, 2, 3) // [2.0, 4.0, 8.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.pow
 */
inline infix fun <reified T : Number> T.pow(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this pow it }

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
 * Raises this [Iterable] to the power [number].
 *
 * Example:
 * ```Kotlin
 * listOf(1, 2, 3) pow 2 // [1.0, 4.0, 9.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.pow
 */
inline infix fun <reified T : Number> Iterable<T>.pow(number: T): Iterable<Double> =
  map { it pow number }

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
 * Computes the logarithm of the value x to the given [Iterable] bases.
 *
 * Example:
 * ```Kotlin
 * 1000 log listOf(1000, 100, 10, 1) // [1.0, 2.0 , 3.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.log
 */
inline infix fun <reified T : Number> T.log(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { this log it }

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
 * Computes the logarithm of the [Iterable] values to the given base.
 *
 * Example:
 * ```Kotlin
 * listOf(1000, 100, 10) log 10 // [3.0, 2.0 , 1.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.log
 */
inline infix fun <reified T : Number> Iterable<T>.log(number: T): Iterable<Double> =
  map { it log number }

/**
 * Computes the positive square root of the value [iterable].
 *
 * Example:
 * ```Kotlin
 * sqrt(listOf(1.0, 4.0, 9.0)) // [1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.sqrt
 */
inline fun <reified T : Number> sqrt(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { kotlin.math.sqrt(it.toDouble()) }

/**
 * Computes the positive square root of the value [array].
 *
 * Example:
 * ```Kotlin
 * sqrt(arrayOf(1.0, 4.0, 9.0)) // [1.0, 2.0, 3.0]
 * ```
 * @since 1.1.0
 * @see kotlin.math.sqrt
 */
inline fun <reified T : Number> sqrt(array: Array<T>): Array<Double> =
  array.map { kotlin.math.sqrt(it.toDouble()) }.toTypedArray()

/**
 * Computes the natural logarithm (base E) of the value [iterable].
 *
 * Example:
 * ```Kotlin
 * ln(listOf(1.0, 4.0, 9.0)) // [0.0, 1.38, 2.19]
 * ```
 * @since 1.1.0
 * @see kotlin.math.ln
 */
inline fun <reified T : Number> ln(iterable: Iterable<T>): Iterable<Double> =
  iterable.map { kotlin.math.ln(it.toDouble()) }

/**
 * Computes the natural logarithm (base E) of the value [array].
 *
 * Example:
 * ```Kotlin
 * ln(arrayOf(1.0, 4.0, 9.0)) // [0.0, 1.38, 2.19]
 * ```
 * @since 1.1.0
 * @see kotlin.math.ln
 */
inline fun <reified T : Number> ln(array: Array<T>): Array<Double> =
  array.map { kotlin.math.ln(it.toDouble()) }.toTypedArray()
