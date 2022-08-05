package com.parsuomash.affogato.core.ktx

import java.math.BigInteger

/**
 * Returns the value of this [Int] number as a [BigInteger].
 * @since 1.1.0
 */
inline val Int.BI: BigInteger
  get() = BigInteger.valueOf(this.toLong())

/**
 * Returns the value of this [Long] number as a [BigInteger].
 * @since 1.1.0
 */
inline val Long.BI: BigInteger
  get() = BigInteger.valueOf(this)
