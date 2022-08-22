package com.parsuomash.affogato.logger.android

import android.util.Log

/**
 * Logging class for manage logcat in debug/release mode.
 *
 * Example:
 * ```kotlin
 * with(Logger) {
 *   tag = "Tick"
 *   isDebug = BuildConfig.DEBUG
 *   onRelease = { tag, message, throwable ->
 *     if (tag != null) {
 *       YandexMetrica.reportError(tag, message, throwable)
 *     } else {
 *       YandexMetrica.reportError(message, throwable)
 *     }
 * }
 * Logger.info(message = "Hello world!")
 * ```
 * @since 1.5.0
 * @see logcat
 */
object Logger {
  /**
   * Logging tag help for beter filter and search.
   * @since 1.5.0
   */
  var tag: String = "Logger"

  /**
   * When is true printing logs, otherwise run onRelease block.
   * @since 1.5.0
   */
  var isDebug: Boolean = true

  /**
   * With onRelease block we define our api for logging in release mode like use crash service.
   * @since 1.5.0
   */
  var onRelease: ((tag: String?, message: String, throwable: Throwable) -> Unit)? = null

  /**
   * Send a VERBOSE log message and log the exception.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  fun verbose(tag: String?, message: String, throwable: Throwable?) {
    if (isDebug) {
      if (throwable != null) {
        Log.v(tag ?: Logger.tag, message, throwable)
      } else {
        Log.v(tag ?: Logger.tag, message)
      }
    } else if (throwable != null && onRelease != null) {
      onRelease!!.invoke(tag, message, throwable)
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
  fun debug(tag: String?, message: String, throwable: Throwable?) {
    if (isDebug) {
      if (throwable != null) {
        Log.d(tag ?: Logger.tag, message, throwable)
      } else {
        Log.d(tag ?: Logger.tag, message)
      }
    } else if (throwable != null && onRelease != null) {
      onRelease!!.invoke(tag, message, throwable)
    }
  }

  /**
   * Send a INFO log message and log the exception.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  fun info(tag: String?, message: String, throwable: Throwable?) {
    if (isDebug) {
      if (throwable != null) {
        Log.i(tag ?: Logger.tag, message, throwable)
      } else {
        Log.i(tag ?: Logger.tag, message)
      }
    } else if (throwable != null && onRelease != null) {
      onRelease!!.invoke(tag, message, throwable)
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
  fun warn(tag: String?, message: String, throwable: Throwable?) {
    if (isDebug) {
      if (throwable != null) {
        Log.w(tag ?: Logger.tag, message, throwable)
      } else {
        Log.w(tag ?: Logger.tag, message)
      }
    } else if (throwable != null && onRelease != null) {
      onRelease!!.invoke(tag, message, throwable)
    }
  }

  /**
   * Send a ERROR log message and log the exception.
   * @since 1.5.0
   * @param message String: The message you would like logged. This value cannot be null.
   * @param throwable Throwable: An exception to log This value may be null.
   * @param tag String: Used to identify the source of a log message. It usually
   * identifies the class or activity where the log call occurs. This value may be null.
   */
  fun error(tag: String?, message: String, throwable: Throwable?) {
    if (isDebug) {
      if (throwable != null) {
        Log.e(tag ?: Logger.tag, message, throwable)
      } else {
        Log.e(tag ?: Logger.tag, message)
      }
    } else if (throwable != null && onRelease != null) {
      onRelease!!.invoke(tag, message, throwable)
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
  fun assert(tag: String?, message: String, throwable: Throwable?) {
    if (isDebug) {
      if (throwable != null) {
        Log.wtf(tag ?: Logger.tag, message, throwable)
      } else {
        Log.wtf(tag ?: Logger.tag, message)
      }
    } else if (throwable != null && onRelease != null) {
      onRelease!!.invoke(tag, message, throwable)
    }
  }
}
