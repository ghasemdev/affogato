@file:JvmName("_Duration")

package com.parsuomash.affogato.core.ktx.time

import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Returns a [Duration] equal to this [Int] number of weeks.
 *
 * Example:
 * ```Kotlin
 * 2.weeks // 14.days
 * ```
 * @since 1.1.2
 */
@get:JvmSynthetic
inline val Int.weeks: Duration
  get() = toDuration(DurationUnit.DAYS) * 7

/**
 * Returns a [Duration] equal to this [Long] number of weeks.
 *
 * Example:
 * ```Kotlin
 * 2L.weeks // 14.days
 * ```
 * @since 1.1.2
 */
@get:JvmSynthetic
inline val Long.weeks: Duration
  get() = toDuration(DurationUnit.DAYS) * 7

/**
 * Returns a [Duration] equal to this [Double] number of weeks.
 *
 * Depending on its magnitude, the value is rounded to an integer number of
 * nanoseconds or milliseconds.
 *
 * Example:
 * ```Kotlin
 * 2.0.weeks // 14.days
 * ```
 * @since 1.1.2
 * @throws IllegalArgumentException if this [Double] value is `NaN`.
 */
@get:JvmSynthetic
inline val Double.weeks: Duration
  get() = toDuration(DurationUnit.DAYS) * 7

/**
 * Returns a [Duration] equal to this [Int] number of months.
 *
 * Example:
 * ```Kotlin
 * 2.months // 60.days
 * ```
 * @since 1.1.0
 */
@get:JvmSynthetic
inline val Int.months: Duration
  get() = toDuration(DurationUnit.DAYS) * 30

/**
 * Returns a [Duration] equal to this [Long] number of months.
 *
 * Example:
 * ```Kotlin
 * 2L.months // 60.days
 * ```
 * @since 1.1.0
 */
@get:JvmSynthetic
inline val Long.months: Duration
  get() = toDuration(DurationUnit.DAYS) * 30

/**
 * Returns a [Duration] equal to this [Double] number of months.
 *
 * Depending on its magnitude, the value is rounded to an integer number of
 * nanoseconds or milliseconds.
 *
 * Example:
 * ```Kotlin
 * 2.0.months // 60.days
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if this [Double] value is `NaN`.
 */
@get:JvmSynthetic
inline val Double.months: Duration
  get() = toDuration(DurationUnit.DAYS) * 30

/**
 * Returns a [Duration] equal to this [Int] number of years.
 *
 * Example:
 * ```Kotlin
 * 2.years // 730.days
 * ```
 * @since 1.1.0
 */
@get:JvmSynthetic
inline val Int.years: Duration
  get() = toDuration(DurationUnit.DAYS) * 365

/**
 * Returns a [Duration] equal to this [Long] number of years.
 *
 * Example:
 * ```Kotlin
 * 2L.years // 730.days
 * ```
 * @since 1.1.0
 */
@get:JvmSynthetic
inline val Long.years: Duration
  get() = toDuration(DurationUnit.DAYS) * 365

/**
 * Returns a [Duration] equal to this [Double] number of years.
 *
 * Depending on its magnitude, the value is rounded to an integer number of
 * nanoseconds or milliseconds.
 *
 * Example:
 * ```Kotlin
 * 2.0.years // 730.days
 * ```
 * @since 1.1.0
 * @throws IllegalArgumentException if this [Double] value is `NaN`.
 */
@get:JvmSynthetic
inline val Double.years: Duration
  get() = toDuration(DurationUnit.DAYS) * 365
