package com.parsuomash.affogato.core.ktx.color

import com.parsuomash.affogato.core.ktx.tryCatchNull
import java.awt.Color

/**
 * Convert [Int] color to [String] hex color.
 *
 * Example:
 * ```Kotlin
 * 0.rgbToHex() // #000000
 * ```
 * @since 1.1.0
 */
inline val Int.rgbToHex: String
  get() = "#%06X".format(-0x1 and this)

/**
 * Convert [Triple] color to [String] hex color.
 *
 * Example:
 * ```Kotlin
 * "#FFFFFF".hexToRgb().rgbToHex() // #FFFFFF
 * ```
 * @since 1.1.0
 */
inline val Triple<UByte, UByte, UByte>.rgbToHex: String
  get() {
    val r = "%02X".format(-0x1 and first.toInt())
    val g = "%02X".format(-0x1 and second.toInt())
    val b = "%02X".format(-0x1 and third.toInt())
    return "#$r$g$b"
  }

/**
 * Convert [String] HEX color to RGB color.
 *
 * Example:
 * ```Kotlin
 * "#000000".hexToRgb() // (0, 0, 0)
 * "#FFFFFF".hexToRgb() // (255, 255 255)
 * ```
 * @since 1.1.0
 * @return [Triple] of red, green and blue values.
 */
inline val String.hexToRgb: Triple<UByte, UByte, UByte>?
  get() = tryCatchNull {
    var name = this
    if (!name.startsWith("#")) {
      name = "#$this"
    }
    val color = Color.decode(name)
    Triple(color.red.toUByte(), color.green.toUByte(), color.blue.toUByte())
  }
