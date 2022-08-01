@file:Suppress("unused")

package com.parsuomash.affogato.core.ktx

/**
 * Return zero when number is null.
 *
 * Example:
 * ```Kotlin
 * val num: Number? = null
 * num.orZero() // 0
 * ```
 * @since 1.1.0
 * @return [Number] value or **Zero**
 */
fun Number?.orZero(): Number = this ?: 0
