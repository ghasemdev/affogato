@file:Suppress("unused")

package com.parsuomash.affogato.core.ktx

import java.net.URLDecoder
import java.net.URLEncoder
import java.util.*

/**
 * Return a [Boolean] if the string is alphanumeric.
 *
 * Example:
 * ```Kotlin
 * "YES".isAlphanumeric // true
 * "1234".isAlphanumeric // true
 * ```
 * @since 1.1.0
 */
inline val String.isAlphanumeric: Boolean
  get() = matches(Regex("\\w*"))

/**
 * Return a [Boolean] if the string is digit.
 *
 * Example:
 * ```Kotlin
 * "0123".isDigit // true
 * "h34".isDigit // false
 * ```
 * @since 1.1.0
 */
inline val String.isDigit: Boolean
  get() = matches(Regex("\\d*"))

/**
 * Return a [Boolean] if the string is a persian digit.
 *
 * Example:
 * ```Kotlin
 * "۱۵".isPersianDigit // true
 * "15".isPersianDigit // false
 * ```
 * @since 1.1.0
 */
inline val String.isPersianDigit: Boolean
  get() = matches(Regex("[۰-۹]*"))

/**
 * Return a [Boolean] if the string contains latin letter.
 *
 * Example:
 * ```Kotlin
 * "Hello".containsLatinLetter // true
 * "Hello 1".containsLatinLetter // true
 * "0 0".containsLatinLetter // false
 * ```
 * @since 1.1.0
 */
inline val String.containsLatinLetter: Boolean
  get() = matches(Regex(".*[A-Za-z].*"))

/**
 * Return a [Boolean] if the string contains digit.
 *
 * Example:
 * ```Kotlin
 * "Hello".containsDigit // false
 * "Hello 1".containsDigit // true
 * "123".containsDigit // true
 * ```
 * @since 1.1.0
 */
inline val String.containsDigit: Boolean
  get() = matches(Regex(".*[0-9].*"))

/**
 * Return a [Boolean] if the string contains persian digit.
 *
 * Example:
 * ```Kotlin
 * "Hello۲۱".containsPersianDigit // true
 * "۲۱".containsPersianDigit // true
 * "123".containsPersianDigit // false
 * "hello".containsPersianDigit // false
 * ```
 * @since 1.1.0
 */
inline val String.containsPersianDigit: Boolean
  get() = matches(Regex(".*[۰-۹].*"))

/**
 * Return a [Boolean] if the string contains both letter and digit.
 *
 * Example:
 * ```Kotlin
 * "Hello55".hasLettersAndDigits // true
 * "123".hasLettersAndDigits // false
 * "hello".hasLettersAndDigits // false
 * ```
 * @since 1.1.0
 */
inline val String.hasLettersAndDigits: Boolean
  get() = containsLatinLetter && containsDigit

/**
 * Return a [Boolean] if the string is integer number.
 *
 * Example:
 * ```Kotlin
 * "123".isIntegerNumber // true
 * "012".isIntegerNumber // true
 * "12.5".isIntegerNumber // false
 * "q".isIntegerNumber // false
 * ```
 * @since 1.1.0
 */
inline val String.isIntegerNumber: Boolean
  get() = toIntOrNull() != null

/**
 * Return a [Boolean] if the string is decimal number.
 *
 * Example:
 * ```Kotlin
 * "123".isDecimalNumber // true
 * "012".isDecimalNumber // true
 * "12.5".isDecimalNumber // true
 * "q".isDecimalNumber // false
 * ```
 * @since 1.1.0
 */
inline val String.isDecimalNumber: Boolean
  get() = toDoubleOrNull() != null

/**
 * If the string is an HTTP URL (ie Starts with http:// or https://)
 *
 * Example:
 * ```Kotlin
 * "http://www.affogato.com".isHttp // true
 * "http://www.affogato.com".isHttp // true
 * "htt://www//".isHttp // false
 * ```
 * @since 1.1.0
 */
inline val String.isHttp: Boolean
  get() = matches(Regex("(http|https)://[^\\s]*"))

/**
 * Translates a string into application/x-www-form-urlencoded format using a specific encoding
 * scheme.
 *
 * Example:
 * ```Kotlin
 * "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java".urlEncode
 * // https%3A%2F%2Fwww.google.co.nz%2F%3Fgfe_rd%3Dcr%26ei%3DdzbFV%26gws_rd%3Dssl%23q%3Djava
 * ```
 * @since 1.1.0
 * @see URLEncoder
 */
inline val String.urlEncode: String get() = encodeToUrl()

/**
 * Decodes an application/x-www-form-urlencoded string using a specific encoding scheme.
 *
 * Example:
 * ```Kotlin
 * val s = "https%3A%2F%2Fwww.google.co.nz%2F%3Fgfe_rd%3Dcr%26ei%3DdzbFV%26gws_rd%3Dssl%23q%3Djava"
 * s.urlDecode // https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java
 * ```
 * @since 1.1.0
 * @see URLDecoder
 */
inline val String.urlDecode: String get() = decodeToUrl()

/**
 * Get last path segment of the string.
 *
 * Example:
 * ```Kotlin
 * "https://google.com/chrome/".lastPathComponent // chrome
 * "C:\\Windows\\Fonts\\font.ttf".lastPathComponent // font.ttf
 * "/dev/null".lastPathComponent // null
 * ```
 * @since 1.1.0
 */
inline val String.lastPathComponent: String
  get() {
    var path = this
    if (path.endsWith("/")) {
      path = path.substring(0, path.lastIndex)
    }
    var index = path.lastIndexOf('/')
    if (index < 0) {
      if (path.endsWith("\\")) {
        path = path.substring(0, path.lastIndex)
      }
      index = path.lastIndexOf('\\')
      if (index < 0) {
        return path
      }
    }
    return path.substring(index + 1)
  }

/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix]
 * and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case
 * only the first [limit] elements will be appended, followed by the [truncated] string
 * (which defaults to "...").
 *
 * Example:
 * ```Kotlin
 * joinWith("H", "e", "l", "l", "o", separator = "") // Hello
 * joinWith(1, 2, 3, 4, separator = ", ") // 1, 2, 3, 4
 * ```
 * @since 1.1.0
 * @see joinToString
 */
fun <T> joinWith(
  vararg params: T,
  separator: CharSequence = " ",
  prefix: CharSequence = "",
  postfix: CharSequence = "",
  limit: Int = -1,
  truncated: CharSequence = "...",
  transform: ((T) -> CharSequence)? = null
): String = params.joinToString(
  separator = separator,
  prefix = prefix,
  postfix = postfix,
  limit = limit,
  truncated = truncated,
  transform = transform
)

/**
 * Translates a string into application/x-www-form-urlencoded format using a specific encoding
 * scheme.
 *
 * Example:
 * ```Kotlin
 * "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java".encodeToUrl()
 * // https%3A%2F%2Fwww.google.co.nz%2F%3Fgfe_rd%3Dcr%26ei%3DdzbFV%26gws_rd%3Dssl%23q%3Djava
 * ```
 * @since 1.1.0
 * @see URLEncoder
 */
fun String.encodeToUrl(charSet: String = "UTF-8"): String = URLEncoder.encode(this, charSet)

/**
 * Decodes an application/x-www-form-urlencoded string using a specific encoding scheme.
 *
 * Example:
 * ```Kotlin
 * val s = "https%3A%2F%2Fwww.google.co.nz%2F%3Fgfe_rd%3Dcr%26ei%3DdzbFV%26gws_rd%3Dssl%23q%3Djava"
 * s.decodeToUrl() // https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java
 * ```
 * @since 1.1.0
 * @see URLDecoder
 */
fun String.decodeToUrl(charSet: String = "UTF-8"): String = URLDecoder.decode(this, charSet)

/**
 * append space in string builders
 *
 * Example:
 * ```Kotlin
 * val str = buildString {
 *   append("Hello")
 *   appendSpace()
 *   append("World")
 * } // "Hello World"
 * ```
 * @since 1.1.0
 * @see StringBuilder
 */
fun StringBuilder.appendSpace(): StringBuilder = append(" ")

/**
 * Checks that the length of a string is valid for block execution
 *
 * Example:
 * ```Kotlin
 * var result: Boolean? = null
 * "12345678".hasValidLength(8) { result = true }
 * result // true
 * ```
 * @since 1.1.0
 */
inline fun String.hasValidLength(length: Int, block: () -> Unit) {
  if (this.length <= length) block()
}

/**
 * Returns a copy of this string having it's first letter title cased using the rules of the
 * default locale, or the original string if it's empty or already starts with a title case letter.
 *
 * The title case of a character is usually the same as its upper case with several exceptions.
 * The particular list of characters with the special title case form depends on the underlying
 * platform.
 *
 * Example:
 * ```Kotlin
 * val name = "john"
 * name.capitalize() // John
 * ```
 * @since 1.1.0
 * @see kotlin.text.capitalize
 */
fun String.capitalize() = replaceFirstChar {
  if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
}

/**
 * Returns the substring from the given range.
 *
 * Example:
 * ```Kotlin
 * val mainStr = "Interesting"
 * val str = mainStr[2..8] // "teresti"
 * ```
 * @since 1.1.0
 * @see substring
 */
operator fun String.get(range: IntRange): String = substring(range.first, range.last + 1)

/**
 * Returns the substring from the given range if exist otherwise return a null.
 *
 * Example:
 * ```Kotlin
 * "Hello".getOrNull(1..3) // ell
 * "Hello".getOrNull(1..5) // null
 * ```
 * @since 1.1.0
 * @see substring
 */
fun String.getOrNull(range: IntRange): String? = tryCatchNull { get(range) }

/**
 * Returns the substring from the given range if exist otherwise return else block.
 *
 * Example:
 * ```Kotlin
 * "Hello".getOrElse(1..3) { "Hi" } // ell
 * "Hello".getOrElse(1..5) { "Hi" } // Hi
 * ```
 * @since 1.1.0
 * @see substring
 */
fun String.getOrElse(range: IntRange, defaultValue: (range: IntRange) -> String): String =
  tryCatchElse(elseBlock = { defaultValue(range) }) { get(range) }
