@file:Suppress("unused")

package com.parsuomash.affogato.unit.window

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

/**
 * Defines the current orientation of the window.
 * @since 1.0.0
 */
enum class WindowOrientation {
  ORIENTATION_LANDSCAPE,
  ORIENTATION_PORTRAIT,
}

/**
 * Returns [WindowOrientation] according to the current window orientation.
 *
 * Example:
 * ```Kotlin
 * if (windowOrientation == WindowOrientation.ORIENTATION_LANDSCAPE) {
 * ...
 * } else {
 * ...
 * }
 * ```
 * @since 1.0.0
 * @see android.content.res.Configuration
 */
@get:JvmSynthetic
inline val windowOrientation: WindowOrientation
  @Composable get() =
    if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
      WindowOrientation.ORIENTATION_LANDSCAPE
    } else {
      WindowOrientation.ORIENTATION_PORTRAIT
    }

/**
 * Is landscape mode enabled.
 * @since 1.0.0
 * @see android.content.res.Configuration
 */
@get:JvmSynthetic
inline val Configuration.isLandscape: Boolean
  @Composable get() = windowOrientation == WindowOrientation.ORIENTATION_LANDSCAPE
