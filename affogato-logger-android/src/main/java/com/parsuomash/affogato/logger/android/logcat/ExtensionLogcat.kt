@file:Suppress("unused")

package com.parsuomash.affogato.logger.android.logcat

import com.parsuomash.affogato.logger.android.LogLevel
import com.parsuomash.affogato.logger.android.Logger

/**
 * ### Top-level logging.
 *
 * Example :
 * ```kotlin
 * function().logcat()
 * function().logcat(tag = "your tag")
 * ```
 * @since 1.7.0
 * @param priority enum: The priority/type of this log message Value is ASSERT,
 * ERROR, WARN, INFO, DEBUG, or VERBOSE
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log,
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @see Logger
 */
@JvmSynthetic
fun Any?.logcat(
  throwable: Throwable? = null,
  priority: LogLevel = LogLevel.DEBUG,
  tag: String? = null
) {
  when (priority) {
    LogLevel.ASSERT -> Logger.assert(tag, toString(), throwable)
    LogLevel.VERBOSE -> Logger.verbose(tag, toString(), throwable)
    LogLevel.DEBUG -> Logger.debug(tag, toString(), throwable)
    LogLevel.INFO -> Logger.info(tag, toString(), throwable)
    LogLevel.WARN -> Logger.warn(tag, toString(), throwable)
    LogLevel.ERROR -> Logger.error(tag, toString(), throwable)
  }
}

/**
 * ### ASSERT logger.
 *
 * Example :
 * ```kotlin
 * function().loga()
 * function().loga(tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log,
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @see Logger
 */
@JvmSynthetic
fun Any?.loga(
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.assert(tag, toString(), throwable)
}

/**
 * ### VERBOSE logger.
 *
 * Example :
 * ```kotlin
 * function().logv()
 * function().logv(tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log,
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @see Logger
 */
@JvmSynthetic
fun Any?.logv(
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.verbose(tag, toString(), throwable)
}


/**
 * ### DEBUG logger.
 *
 * Example :
 * ```kotlin
 * function().logd()
 * function().logd(tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log,
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @see Logger
 */
@JvmSynthetic
fun Any?.logd(
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.debug(tag, toString(), throwable)
}

/**
 * ### INFO logger.
 *
 * Example :
 * ```kotlin
 * function().logi()
 * function().logi(tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log,
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @see Logger
 */
@JvmSynthetic
fun Any?.logi(
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.info(tag, toString(), throwable)
}

/**
 * ### WARN logger.
 *
 * Example :
 * ```kotlin
 * function().logw()
 * function().logw(tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log,
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @see Logger
 */
@JvmSynthetic
fun Any?.logw(
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.warn(tag, toString(), throwable)
}

/**
 * ### ERROR logger.
 *
 * Example :
 * ```kotlin
 * function().loge()
 * function().loge(tag = "your tag")
 * ```
 * @since 1.7.0
 * @param throwable Throwable: An exception to log This value may be null.
 * @param tag String: Used to identify the source of a log,
 * It usually identifies the class or activity where the log call occurs.
 * This value may be null.
 * @see Logger
 */
@JvmSynthetic
fun Any?.loge(
  throwable: Throwable? = null,
  tag: String? = null
) {
  Logger.error(tag, toString(), throwable)
}
