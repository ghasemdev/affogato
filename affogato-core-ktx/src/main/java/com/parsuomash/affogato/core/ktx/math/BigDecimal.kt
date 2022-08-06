package com.parsuomash.affogato.core.ktx.math

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Returns the value of this [Int] number as a [BigDecimal].
 * @since 1.1.0
 */
inline val Int.BD: BigDecimal
  get() = BigDecimal.valueOf(this.toLong())

/**
 * Returns the value of this [Long] number as a [BigDecimal].
 * @since 1.1.0
 */
inline val Long.BD: BigDecimal
  get() = BigDecimal.valueOf(this)

/**
 * Returns the value of this [Float] number as a [BigDecimal].
 * @since 1.1.0
 */
inline val Float.BD: BigDecimal
  get() = BigDecimal.valueOf(this.toDouble())

/**
 * Returns the value of this [Double] number as a [BigDecimal].
 * @since 1.1.0
 */
inline val Double.BD: BigDecimal
  get() = BigDecimal.valueOf(this)

/**
 * Returns the value of this [BigInteger] number as a [BigDecimal].
 * @since 1.1.0
 */
inline val BigInteger.BD: BigDecimal
  get() = BigDecimal(this)
