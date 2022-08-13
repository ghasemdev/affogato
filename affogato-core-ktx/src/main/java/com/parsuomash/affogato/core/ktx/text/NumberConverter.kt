package com.parsuomash.affogato.core.ktx.text

private val englishNumbers = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

/**
 * Convert numbers from english to other languages.
 *
 * Example:
 * ```
 * NumberConverter.toArabic("1") // "۱"
 * ```
 * @since 1.1.0
 */
object NumberConverter {
  private val arabicNumbers = charArrayOf('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩')
  private val farsiNumbers = charArrayOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')
  private val mongolianNumbers = charArrayOf('᠐', '᠑', '᠒', '᠓', '᠔', '᠕', '᠖', '᠗', '᠘', '᠙')
  private val myanmarNumbers = charArrayOf('၀', '၁', '၂', '၃', '၄', '၅', '၆', '၇', '၈', '၉')
  private val tamilNumbers = charArrayOf('௦', '௧', '௨', '௩', '௪', '௫', '௬', '௭', '௮', '௯')
  private val thaiNumbers = charArrayOf('๐', '๑', '๒', '๓', '๔', '๕', '๖', '๗', '๘', '๙')
  private val urduNumbers = charArrayOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')

  /** @since 1.1.0 */
  fun toArabic(value: String): String = numberConverter(value, arabicNumbers)

  /** @since 1.1.0 */
  fun toFarsi(value: String): String = numberConverter(value, farsiNumbers)

  /** @since 1.1.0 */
  fun toMongolian(value: String): String = numberConverter(value, mongolianNumbers)

  /** @since 1.1.0 */
  fun toMyanmar(value: String): String = numberConverter(value, myanmarNumbers)

  /** @since 1.1.0 */
  fun toTamil(value: String): String = numberConverter(value, tamilNumbers)

  /** @since 1.1.0 */
  fun toThai(value: String): String = numberConverter(value, thaiNumbers)

  /** @since 1.1.0 */
  fun toUrdu(value: String): String = numberConverter(value, urduNumbers)
}

private fun numberConverter(value: String, distensionNumbers: CharArray): String = buildString {
  for (char in value) {
    val index = englishNumbers.indexOf(char)
    if (index != -1) append(distensionNumbers[index]) else append(char)
  }
}
