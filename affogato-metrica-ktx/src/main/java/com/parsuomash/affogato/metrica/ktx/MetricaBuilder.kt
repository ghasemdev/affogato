@file:JvmName("MetricaBuilder")
@file:JvmMultifileClass

package com.parsuomash.affogato.metrica.ktx

import android.content.Context
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import com.yandex.metrica.YandexMetricaDefaultValues
import kotlin.time.Duration

/**
 * # YandexMetricaConfig
 * Creates the new instance of [YandexMetricaConfig.Builder] with api key.
 *
 * Example:
 * ```kotlin
 * yandexMetricaConfig("api-key") {
 *   ...
 * }
 * ```
 * @since 1.4.0
 * @param apiKey api key for YandexMetrica.
 * @param init initializer block.
 * @return new instance of YandexMetricaConfig.
 * @see YandexMetricaConfig.Builder
 * @see YandexMetricaConfig
 */
inline fun yandexMetricaConfig(
  apiKey: String,
  init: YandexMetricaConfig.Builder.() -> YandexMetricaConfig.Builder
): YandexMetricaConfig {
  val builder = YandexMetricaConfig.newConfigBuilder(apiKey).also { init(it) }
  return builder.build()
}

/**
 * # YandexMetrica
 * Initializing the AppMetrica SDK with activating.
 *
 * Example:
 * ```kotlin
 * yandexMetrica("api-key") {
 *   ...
 * }
 * ```
 * @since 1.4.0
 * @param apiKey api key for YandexMetrica.
 * @param init initializer block.
 * @see YandexMetricaConfig.Builder
 * @see YandexMetricaConfig
 * @see YandexMetrica.activate
 */
inline fun Context.yandexMetrica(
  apiKey: String,
  init: YandexMetricaConfig.Builder.() -> YandexMetricaConfig.Builder
) {
  val builder = YandexMetricaConfig.newConfigBuilder(apiKey).also { init(it) }
  YandexMetrica.activate(this, builder.build())
}

/**
 * Enable AppMetrica logging in debug mode. Should be called before activation.
 * @since 1.4.0
 * @return the same YandexMetricaConfig.Builder object.
 * @see YandexMetricaConfig.Builder.withLogs
 */
@JvmSynthetic
fun YandexMetricaConfig.Builder.withLogs(isDebugMode: Boolean = true): YandexMetricaConfig.Builder =
  if (isDebugMode) withLogs() else this

/**
 * By default, the session times out if the app is inactive for
 * [YandexMetricaDefaultValues.DEFAULT_SESSION_TIMEOUT_SECONDS] seconds. To change this time limit,
 * pass the [Builder.withSessionTimeout](int sessionTimeoutSeconds) method your time limit in seconds.
 *
 * The minimum acceptable value for the sessionTimeoutSeconds parameter is 10 seconds.
 * If a value less than 10 is set, the value will automatically be 10 seconds.
 * @since 1.4.0
 * @param duration the time limit in kotlinx duration.
 * @return the same YandexMetricaConfig.Builder object.
 * @see YandexMetricaConfig.Builder.withSessionTimeout
 */
@JvmSynthetic
fun YandexMetricaConfig.Builder.withSessionTimeout(
  duration: Duration
): YandexMetricaConfig.Builder = withSessionTimeout(duration.inWholeSeconds.toInt())
