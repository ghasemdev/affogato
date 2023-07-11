@file:Suppress("unused")

package com.parsuomash.affogato.logger.android.logcat

import com.parsuomash.affogato.logger.android.LogLevel
import com.parsuomash.affogato.logger.android.Logger

/**
 * ### Top-level logging.
 *
 * Example :
 * ```kotlin
 * logcat { "Hello, Affogato" }
 * logcat(tag = "your tag") { "Hello, Affogato" }
 * ```
 * @since 1.5.0
 * @param priority enum: The priority/type of this log message Value is ASSERT,
 * ERROR, WARN, INFO, DEBUG, or VERBOSE
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message. It usually
 * identifies the class or activity where the log call occurs. This value may be null.
 * @param message Lambda: The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
inline fun logcat(
  priority: LogLevel = LogLevel.DEBUG,
  throwable: Throwable? = null,
  tag: String? = null,
  message: () -> Any?
) {
  when (priority) {
    LogLevel.ASSERT -> Logger.assert(tag, message().toString(), throwable)
    LogLevel.VERBOSE -> Logger.verbose(tag, message().toString(), throwable)
    LogLevel.DEBUG -> Logger.debug(tag, message().toString(), throwable)
    LogLevel.INFO -> Logger.info(tag, message().toString(), throwable)
    LogLevel.WARN -> Logger.warn(tag, message().toString(), throwable)
    LogLevel.ERROR -> Logger.error(tag, message().toString(), throwable)
  }
}

/**
 * ### ASSERT logger.
 *
 * Example :
 * ```kotlin
 * loga { "Hello, Affogato" }
 * loga(tag = "your tag") { "Hello, Affogato" }
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message Lambda: The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
inline fun loga(
  throwable: Throwable? = null,
  tag: String? = null,
  message: () -> Any?
) {
  Logger.assert(tag, message().toString(), throwable)
}

/**
 * ### VERBOSE logger.
 *
 * Example :
 * ```kotlin
 * logv { "Hello, Affogato" }
 * logv(tag = "your tag") { "Hello, Affogato" }
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message Lambda: The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
inline fun logv(
  throwable: Throwable? = null,
  tag: String? = null,
  message: () -> Any?
) {
  Logger.verbose(tag, message().toString(), throwable)
}


/**
 * ### DEBUG logger.
 *
 * Example :
 * ```kotlin
 * logd { "Hello, Affogato" }
 * logd(tag = "your tag") { "Hello, Affogato" }
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message Lambda: The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
inline fun logd(
  throwable: Throwable? = null,
  tag: String? = null,
  message: () -> Any?
) {
  Logger.debug(tag, message().toString(), throwable)
}

/**
 * ### INFO logger.
 *
 * Example :
 * ```kotlin
 * logi { "Hello, Affogato" }
 * logi(tag = "your tag") { "Hello, Affogato" }
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message Lambda: The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
inline fun logi(
  throwable: Throwable? = null,
  tag: String? = null,
  message: () -> Any?
) {
  Logger.info(tag, message().toString(), throwable)
}

/**
 * ### WARN logger.
 *
 * Example :
 * ```kotlin
 * logw { "Hello, Affogato" }
 * logw(tag = "your tag") { "Hello, Affogato" }
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message Lambda: The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
inline fun logw(
  throwable: Throwable? = null,
  tag: String? = null,
  message: () -> Any?
) {
  Logger.warn(tag, message().toString(), throwable)
}

/**
 * ### ERROR logger.
 *
 * Example :
 * ```kotlin
 * loge { "Hello, Affogato" }
 * loge(tag = "your tag") { "Hello, Affogato" }
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message Lambda: The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
inline fun loge(
  throwable: Throwable? = null,
  tag: String? = null,
  message: () -> Any?
) {
  Logger.error(tag, message().toString(), throwable)
}
