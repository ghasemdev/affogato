@file:Suppress("unused")

package com.parsuomash.affogato.logger.android.logcat

import com.parsuomash.affogato.logger.android.LogLevel
import com.parsuomash.affogato.logger.android.Logger

/**
 * ### Top-level logging.
 *
 * Example :
 * ```kotlin
 * logcat("Hello, Affogato")
 * logcat("Hello, Affogato", tag = "your tag")
 * ```
 * @since 1.7.0
 * @param priority enum: The priority/type of this log message Value is ASSERT,
 * ERROR, WARN, INFO, DEBUG, or VERBOSE
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
fun logcat(
  message: Any?,
  throwable: Throwable? = null,
  priority: LogLevel = LogLevel.DEBUG,
  tag: String? = null
) {
  when (priority) {
    LogLevel.ASSERT -> Logger.assert(tag, message.toString(), throwable)
    LogLevel.VERBOSE -> Logger.verbose(tag, message.toString(), throwable)
    LogLevel.DEBUG -> Logger.debug(tag, message.toString(), throwable)
    LogLevel.INFO -> Logger.info(tag, message.toString(), throwable)
    LogLevel.WARN -> Logger.warn(tag, message.toString(), throwable)
    LogLevel.ERROR -> Logger.error(tag, message.toString(), throwable)
  }
}

/**
 * ### ASSERT logger.
 *
 * Example :
 * ```kotlin
 * loga("Hello, Affogato")
 * loga("Hello, Affogato", tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
fun loga(
  message: Any?,
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.assert(tag, message.toString(), throwable)
}

/**
 * ### VERBOSE logger.
 *
 * Example :
 * ```kotlin
 * logv("Hello, Affogato")
 * logv("Hello, Affogato", tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
fun logv(
  message: Any?,
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.verbose(tag, message.toString(), throwable)
}


/**
 * ### DEBUG logger.
 *
 * Example :
 * ```kotlin
 * logd("Hello, Affogato")
 * logd("Hello, Affogato", tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
fun logd(
  message: Any?,
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.debug(tag, message.toString(), throwable)
}

/**
 * ### INFO logger.
 *
 * Example :
 * ```kotlin
 * logi("Hello, Affogato")
 * logi("Hello, Affogato", tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
fun logi(
  message: Any?,
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.info(tag, message.toString(), throwable)
}

/**
 * ### WARN logger.
 *
 * Example :
 * ```kotlin
 * logw("Hello, Affogato")
 * logw("Hello, Affogato", tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
fun logw(
  message: Any?,
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.warn(tag, message.toString(), throwable)
}

/**
 * ### ERROR logger.
 *
 * Example :
 * ```kotlin
 * loge(message = "Hello, Affogato")
 * loge(error("test"), tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log message.
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @param message The message you would like logged.
 * @see Logger
 */
@JvmSynthetic
fun loge(
  throwable: Throwable? = null,
  message: Any? = null,
  tag: String? = null
) {
  Logger.error(tag, message.toString(), throwable)
}
