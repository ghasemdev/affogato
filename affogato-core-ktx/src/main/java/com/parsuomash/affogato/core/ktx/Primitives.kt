package com.parsuomash.affogato.core.ktx

/**
 * Convert [Int] color to [String] hex color.
 *
 * Example:
 * ```Kotlin
 * 0.rgbToHex() // #000000
 * ```
 * @since 1.1.0
 */
fun Int.rgbToHex(): String = "#%06X".format(-0x1 and this)

/**
 * Convert [Triple] color to [String] hex color.
 *
 * Example:
 * ```Kotlin
 * "#FFFFFF".hexToRgb().rgbToHex() // #FFFFFF
 * ```
 * @since 1.1.0
 */
fun Triple<UByte, UByte, UByte>.rgbToHex(): String {
  val r = "%02X".format(-0x1 and first.toInt())
  val g = "%02X".format(-0x1 and second.toInt())
  val b = "%02X".format(-0x1 and third.toInt())
  return "#$r$g$b"
}

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
