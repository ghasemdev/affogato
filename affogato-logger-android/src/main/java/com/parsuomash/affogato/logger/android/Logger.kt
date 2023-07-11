package com.parsuomash.affogato.logger.android

import com.parsuomash.affogato.logger.android.logcat.ex.logcat
import timber.log.Timber

/**
 * Logging class for manage logcat in a debug/release mode.
 * Under the hood we used [Timber].
 *
 * Example:
 * ```kotlin
 * Logger.apply {
 *   tag = "Tick"
 *   isDebug = BuildConfig.DEBUG
 *   onFilter { tag, message, throwable, level ->
 *     if (level == LogLevel.ERROR) {
 *       if (tag != null) {
 *         YandexMetrica.reportError(tag, message, throwable)
 *       } else {
 *         YandexMetrica.reportError(message, throwable)
 *       }
 *     }
 *   }
 * }
 * Logger.info(message = "Hello Affogato!")
 * ```
 * @since 1.5.0
 * @see logcat
 */
object Logger {
  /**
   * Logging tag help for better filter and search.
   * @since 1.5.0
   */
  @JvmField
  var tag: String = "Logger"

  /**
   * When is true printing logs, otherwise run onRelease block.
   * @since 1.5.0
   */
  @JvmField
  var isDebug: Boolean = true

  private var onFilter: (
    (tag: String?, message: String, throwable: Throwable?, level: LogLevel) -> Unit)? = null

  init {
    Timber.plant(Timber.DebugTree())
  }

  /**
   * With onRelease block, we define our api for logging in release mode like use crash service.
   * @since 1.7.0
   */
  fun onFilter(
    block: (tag: String?, message: String, throwable: Throwable?, level: LogLevel) -> Unit
  ) {
    onFilter = block
  }

  /**
   * Send a VERBOSE log message and log the exception.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  @JvmStatic
  fun verbose(tag: String?, message: String, throwable: Throwable?) {
    Timber.tag(tag ?: Logger.tag).v(throwable, message)
    if (onFilter != null) {
      onFilter!!.invoke(tag, message, throwable, LogLevel.VERBOSE)
    }
  }

  /**
   * Send a DEBUG log message and log the exception.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  @JvmStatic
  fun debug(tag: String?, message: String, throwable: Throwable?) {
    Timber.tag(tag ?: Logger.tag).d(throwable, message)
    if (onFilter != null) {
      onFilter!!.invoke(tag, message, throwable, LogLevel.DEBUG)
    }
  }

  /**
   * Send an INFO log message and log the exception.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  @JvmStatic
  fun info(tag: String?, message: String, throwable: Throwable?) {
    Timber.tag(tag ?: Logger.tag).i(throwable, message)
    if (onFilter != null) {
      onFilter!!.invoke(tag, message, throwable, LogLevel.INFO)
    }
  }

  /**
   * Send a WARN log message and log the exception.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  @JvmStatic
  fun warn(tag: String?, message: String, throwable: Throwable?) {
    Timber.tag(tag ?: Logger.tag).w(throwable, message)
    if (onFilter != null) {
      onFilter!!.invoke(tag, message, throwable, LogLevel.WARN)
    }
  }

  /**
   * Send an ERROR log message and log the exception.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  @JvmStatic
  fun error(tag: String?, message: String, throwable: Throwable?) {
    Timber.tag(tag ?: Logger.tag).e(throwable, message)
    if (onFilter != null) {
      onFilter!!.invoke(tag, message, throwable, LogLevel.ERROR)
    }
  }

  /**
   * What a Terrible Failure: Report an exception that should never happen.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  @JvmStatic
  @JvmName("wtf")
  fun assert(tag: String?, message: String, throwable: Throwable?) {
    Timber.tag(tag ?: Logger.tag).wtf(throwable, message)
    if (onFilter != null) {
      onFilter!!.invoke(tag, message, throwable, LogLevel.ASSERT)
    }
  }
}
