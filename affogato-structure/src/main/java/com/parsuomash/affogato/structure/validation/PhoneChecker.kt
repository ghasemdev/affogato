package com.parsuomash.affogato.structure.validation

import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL
import com.parsuomash.affogato.core.ktx.tryCatchBoolean
import com.parsuomash.affogato.core.ktx.tryCatchNull
import kotlinx.serialization.Serializable

/**
 * # Phone Checker
 *
 * Example:
 * ```kotlin
 * val checker = PhoneChecker("+989123456789")
 * checker.isValid() // true
 * ```
 * @since 1.4.0
 */
@JvmInline
@Serializable
value class PhoneChecker(val value: String) : Emptiness {
  /**
   * Check phone number is valid.
   * @since 1.4.0
   * @param defaultRegion region that we are expecting the number to be from. This is only used if
   * the number being parsed is not written in international format. The country_code for the
   * number in this case would be stored as that of the default region supplied. If the number
   * is guaranteed to start with a '+' followed by the country calling code, then RegionCode. ZZ
   * or null can be supplied.
   * @return a boolean that indicates whether the number is of a valid pattern.
   */
  fun isValid(defaultRegion: String? = null): Boolean {
    return tryCatchBoolean {
      val number = phoneNumberKit.parse(value, defaultRegion)
      phoneNumberKit.isValidNumber(number)
    }
  }

  /**
   * Gets the type of valid phone number.
   * @since 1.4.0
   * @param defaultRegion region that we are expecting the number to be from. This is only used if
   * the number being parsed is not written in international format. The country_code for the
   * number in this case would be stored as that of the default region supplied. If the number
   * is guaranteed to start with a '+' followed by the country calling code, then RegionCode. ZZ
   * or null can be supplied.
   * @return the type of the phone number, or UNKNOWN if it is invalid.
   */
  fun type(defaultRegion: String? = null): PhoneNumberType? {
    return tryCatchNull {
      val number = phoneNumberKit.parse(value, defaultRegion)
      phoneNumberKit.getNumberType(number)
    }
  }

  /**
   * Formats a phone number in the specified format using default rules.
   * @since 1.4.0
   * @param defaultRegion region that we are expecting the number to be from. This is only used if
   * the number being parsed is not written in international format. The country_code for the
   * number in this case would be stored as that of the default region supplied. If the number
   * is guaranteed to start with a '+' followed by the country calling code, then RegionCode. ZZ
   * or null can be supplied.
   * @param numberFormat the format the phone number should be formatted into. default value is
   * [INTERNATIONAL]
   * @return the formatted phone number.
   */
  fun format(
    defaultRegion: String? = null,
    numberFormat: PhoneNumberFormat = INTERNATIONAL
  ): String? {
    return tryCatchNull<String> {
      val number = phoneNumberKit.parse(value, defaultRegion)
      return phoneNumberKit.format(number, numberFormat)
    }
  }

  /**
   * Check phone is empty.
   * @since 1.4.0
   * @return a boolean that indicates whether the number is empty.
   */
  override fun isEmpty(): Boolean = value.isEmpty()

  override fun toString(): String = "PhoneChecker(value=$value)"
}

/**
 * INTERNATIONAL and NATIONAL formats are consistent with the definition in ITU-T Recommendation
 * E.123. However, we follow local conventions such as using '-' instead of whitespace as
 * separators. For example, the number of the Google Switzerland office will be written as
 * "+41 44 668 1800" in INTERNATIONAL format, and as "044 668 1800" in NATIONAL format. E164
 * format is as per INTERNATIONAL format but with no formatting applied, e.g. "+41446681800".
 * RFC3966 is as per INTERNATIONAL format, but with all spaces and other separating symbols
 * replaced with a hyphen, and with any phone number extension appended with ";ext=". It also
 * will have a prefix of "tel:" added, e.g. "tel:+41-44-668-1800".
 *
 * Note: If you are considering storing the number in a neutral format, you are highly advised to
 * use the PhoneNumber class.
 * @since 1.4.0
 */
typealias PhoneNumberFormat = PhoneNumberUtil.PhoneNumberFormat

/**
 * Type of phone numbers.
 * @since 1.4.0
 */
typealias PhoneNumberType = PhoneNumberUtil.PhoneNumberType

private val phoneNumberKit: PhoneNumberUtil by lazy { PhoneNumberUtil.getInstance() }
