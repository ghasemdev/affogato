package com.parsuomash.affogato.structure.validation

import kotlinx.serialization.Serializable

/**
 * # Iranian Phone Checker
 *
 * Example:
 * ```kotlin
 * val checker = IRPhoneChecker("09151234567")
 * checker.isValid() // true
 * ```
 * @since 1.4.0
 */
@JvmInline
@Serializable
value class IRPhoneChecker(val value: String) : Validation, Emptiness {
  /**
   * check phone number is valid.
   * @since 1.4.0
   */
  override fun isValid(): Boolean =
    value.matches(PHONE_REGEX.toRegex())

  /**
   * Check phone is empty.
   * @since 1.4.0
   */
  override fun isEmpty(): Boolean =
    value.isEmpty()

  override fun toString(): String = "IRPhoneChecker(value=$value)"

  companion object {
    private const val PHONE_REGEX = "^(\\+98[\\-\\s]?)?[0]?(91)?[789]\\d{9}${'$'}"
  }
}
