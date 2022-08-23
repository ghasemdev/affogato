@file:JvmName("_TimeAgoExtension")

package com.parsuomash.affogato.logger.android

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
 * @param message Lambda: The message you would like logged. This value cannot be null.
 * @see Logger
 */
@JvmSynthetic
inline fun logcat(
  priority: LogLevel = LogLevel.DEBUG,
  throwable: Throwable? = null,
  tag: String? = null,
  message: () -> Any?,
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
