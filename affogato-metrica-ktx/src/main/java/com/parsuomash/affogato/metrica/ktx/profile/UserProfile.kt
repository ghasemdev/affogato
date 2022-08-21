@file:Suppress("unused")

package com.parsuomash.affogato.metrica.ktx.profile

import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetrica.reportUserProfile
import com.yandex.metrica.impl.ob.Kf
import com.yandex.metrica.profile.CounterAttribute
import com.yandex.metrica.profile.NumberAttribute
import com.yandex.metrica.profile.UserProfile
import com.yandex.metrica.profile.UserProfileUpdate

/**
 * This method store a user profile.
 * User profile is a set of user attributes. [UserProfile] details are displayed in the AppMetrica
 * User profiles report. The [UserProfile] object should be passed to the AppMetrica server by using
 * the [YandexMetrica]. [reportUserProfile] method.
 * AppMetrica has some predefined attributes. You can use them or create own custom attributes.
 * User profiles are stored on the AppMetrica server.
 *
 * Example:
 * ```kotlin
 * val userProfile = metricaProfile {
 *   apply(Attribute.customString("foo_attribute").withValue("baz_value"))
 *   apply(Attribute.name().withName("John"))
 *   apply(Attribute.gender().withValue(GenderAttribute.Gender.MALE))
 *   apply(Attribute.notificationEnabled().withValue(false))
 * }
 * YandexMetrica.reportUserProfile(userProfile)
 * YandexMetrica.setProfileId("id_1")
 * ```
 * @since 1.4.0
 * @param init initializer block.
 * @return new instance of UserProfile
 * @see UserProfile.Builder
 * @see UserProfile
 */
inline fun metricaProfile(init: UserProfile.Builder.() -> Unit): UserProfile {
  val builder: UserProfile.Builder = UserProfile.newBuilder().also { init(it) }
  return builder.build()
}

/**
 * Updates the attribute with the specified [value].
 * @since 1.4.0
 * @param value Number value
 * @return The UserProfileUpdate object.
 * @see NumberAttribute.withValue
 */
fun NumberAttribute.withValue(value: Int): UserProfileUpdate<out Kf> =
  withValue(value.toDouble())

/**
 * Updates the counter attribute value with the specified delta [value].
 * @since 1.4.0
 * @param value Delta value to change the counter attribute value
 * @return The UserProfileUpdate object.
 * @see CounterAttribute.withDelta
 */
fun CounterAttribute.withDelta(value: Int): UserProfileUpdate<out Kf> =
  withDelta(value.toDouble())
