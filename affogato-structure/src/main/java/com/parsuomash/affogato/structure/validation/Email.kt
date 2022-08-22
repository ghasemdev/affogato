@file:Suppress(
  "RegExpRedundantEscape",
  "RegExpDuplicateCharacterInClass",
)

package com.parsuomash.affogato.structure.validation

import kotlinx.serialization.Serializable

/**
 * # Email
 *
 * Example:
 * ```kotlin
 * val checker = Email("test@gmail.com")
 * checker.isValid() // true
 * ```
 * @since 1.4.0
 */
@JvmInline
@Serializable
value class Email(val value: String) : Validation, Emptiness {
  /**
   * check is a valid email
   * @since 1.4.0
   */
  override fun isValid(): Boolean = value.matches(EMAIL_REGEX.toRegex())

  /**
   * Check email is empty
   * @since 1.4.0
   */
  override fun isEmpty(): Boolean = value.isEmpty()

  override fun toString(): String = "Email(value=$value)"

  companion object {
    private const val EMAIL_REGEX = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
      "\\@" +
      "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
      "(" +
      "\\." +
      "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
      ")+"
  }
}
