package com.parsuomash.affogato.core.ktx.text

import java.text.DecimalFormat

/**
 * Remove decimal part when [Float] number has decimal part.
 *
 * Example:
 * ```Kotlin
 * 1.56F.removeDecimalPart() // 1.56
 * 1.0F.removeDecimalPart() // 1
 * ```
 * @since 1.1.0
 * @see Double.removeDecimalPart
 */
inline val Float.removeDecimalPart: String
  get() {
    val numberToInt = toInt()
    return if (this == numberToInt.toFloat()) numberToInt.toString() else toString()
  }

/**
 * Remove decimal part when [Double] number has decimal part.
 *
 * Example:
 * ```Kotlin
 * 1.56.removeDecimalPart() // 1.56
 * 1.0.removeDecimalPart() // 1
 * ```
 * @since 1.1.0
 * @see Float.removeDecimalPart
 */
inline val Double.removeDecimalPart: String
  get() {
    val numberToInt = toInt()
    return if (this == numberToInt.toDouble()) numberToInt.toString() else toString()
  }

/**
 * Separate number with given pattern.
 *
 * Example:
 * ```Kotlin
 * 123456789.separate() // 1,234,567,890
 * ```
 * @since 1.1.0
 * @see DecimalFormat
 * @param pattern default pattern is comma separator.
 * @return separated number.
 */
fun Number.separate(pattern: String = "#,###.##"): String {
  decimalFormat.applyPattern(pattern)
  return decimalFormat.format(this)
}

/**
 * Format string as credit card number.
 *
 * Example:
 * ```Kotlin
 * "1234567890123456".formatCreditCard(separator = "-") // 1234-5678-9012-3456
 * "1234567890123456".formatCreditCard() // 1234 5678 9012 3456
 * ```
 * @since 1.1.0
 * @return formatted credit card number.
 */
fun String.formatCreditCard(separator: String = " ", separatorDigit: Int = 4): String {
  val preparedString = replace(" ", "").trim()
  return buildString {
    for (i in preparedString.indices) {
      if (i % separatorDigit == 0 && i != 0) {
        append(separator)
      }
      append(preparedString[i])
    }
  }
}

internal val decimalFormat: DecimalFormat by lazy { DecimalFormat() }
