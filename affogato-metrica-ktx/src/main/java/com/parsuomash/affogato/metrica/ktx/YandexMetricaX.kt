@file:Suppress("unused")

package com.parsuomash.affogato.metrica.ktx

import com.yandex.metrica.YandexMetrica
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * # YandexMetricaX
 * Assistant class for analytic processing in Kotlin.
 * @since 1.4.0
 * @see YandexMetrica
 */
object YandexMetricaX {
  /**
   * Sends report by event name and event value.
   *
   * Example:
   * ```kotlin
   * @Serializable
   * data class Foo(val bar: String)
   * YandexMetricaX.reportEvent("event_name", Foo("bar"))
   * ```
   * @since 1.4.0
   * @throws SerializationException in case of any encoding-specific error
   * @throws IllegalArgumentException if the eventValue input does not comply format's specification
   */
  inline fun <reified T> reportEvent(name: String, value: T) {
    val jsonValue = Json.encodeToString(value)
    YandexMetrica.reportEvent(name, jsonValue)
  }
}
