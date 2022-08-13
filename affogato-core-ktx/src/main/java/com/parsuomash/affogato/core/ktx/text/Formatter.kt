package com.parsuomash.affogato.core.ktx.text

import com.parsuomash.affogato.core.ktx.math.pow
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10

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
fun Float.removeDecimalPart(): String {
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
fun Double.removeDecimalPart(): String {
  val numberToInt = toInt()
  return if (this == numberToInt.toDouble()) numberToInt.toString() else toString()
}

/**
 * Format numbers with given pattern.
 *
 * Example:
 * ```Kotlin
 * 123456789.format() // 1,234,567,890
 * ```
 * @since 1.1.0
 * @see DecimalFormat
 * @param pattern default pattern is comma separator.
 * @return format number.
 */
fun Number.format(pattern: String = "#,###.##"): String {
  decimalFormat.applyPattern(pattern)
  return decimalFormat.format(this)
}

/**
 * Compact format numbers.
 *
 * Example:
 * ```Kotlin
 * 1200.compactFormat() // 1.2k
 * ```
 * @since 1.1.0
 * @see DecimalFormat
 * @return compact format number.
 */
fun Number.compactFormat(): String {
  val numValue = toLong()
  val value = floor(log10(numValue.toDouble())).toInt()
  val base = value / 3

  return if (value >= 3 && base < suffix.size) {
    DecimalFormat("#0.0")
      .format(numValue / 10.0.pow((base * 3).toDouble()))
      .toDouble()
      .removeDecimalPart() + suffix[base]
  } else {
    DecimalFormat("#,##0").format(numValue).toDouble().removeDecimalPart()
  }
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
private val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
