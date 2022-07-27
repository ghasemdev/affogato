package com.parsuomash.affogato.unit.window

/**
 * Definition of the window size to be on the global scope.
 *
 * Example:
 * ```Kotlin
 * GlobalWindowSize.compactWidth = 480
 * GlobalWindowSize.Factory.fromWidth { screenWidth ->
 *   screenWidth < 0 -> throw IllegalArgumentException("value cannot be negative")
 *   screenWidth < 500 -> WindowType.Compact(width)
 *   screenWidth < 700 -> WindowType.Medium(width)
 *   else -> WindowType.Expanded(width)
 * }
 * ```
 * @since 1.0.0
 * @see rememberWindowSize
 */
object GlobalWindowSize {
  /** Defines most phones in portrait mode */
  var compactWidth: Int = 600

  /** Defines most foldables and tablets in portrait mode */
  var mediumWidth: Int = 840

  /** Defines most phones in portrait mode */
  var compactHeight: Int = 480

  /** Defines most foldables and tablets in portrait mode */
  var mediumHeight: Int = 900

  /** A global factory class of the [WindowType]. */
  object Factory {
    var fromWidth: ((screenWidth: Int) -> WindowType)? = null
    var fromHeight: ((screenHeight: Int) -> WindowType)? = null
  }
}
