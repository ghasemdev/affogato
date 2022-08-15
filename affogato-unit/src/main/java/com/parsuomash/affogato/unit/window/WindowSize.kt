@file:Suppress("MemberVisibilityCanBePrivate")

package com.parsuomash.affogato.unit.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

/**
 * Window size are a set of opinionated viewport breakpoints to design, develop, and test
 * responsive application layouts against.
 * For more details check <a href="https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes" class="external" target="_blank">Support different screen sizes</a> documentation.
 *
 * WindowSize contains a [WindowType], representing the
 * window size for this window's width and height respectively.
 *
 * See [rememberWindowSize] to calculate the WindowSizeClass for an Activity's current window
 *
 * @since 1.0.0
 * @property width width-based window size class ([WindowType])
 * @property height height-based window size class ([WindowType])
 */
@Immutable
data class WindowSize(
  val width: WindowType,
  val height: WindowType
)

/**
 * Breakpoints defines the screen type at which a layout will adapt to best fit content and conform
 * to responsive layout requirements. A breakpoint range informs how a screen adjusts to fit its
 * size and orientation.
 *
 * [Design for large screens](https://m3.material.io/foundations/adaptive-design/large-screens/overview)
 *
 * * Compact: Most phones in portrait mode
 * * Medium: Most foldables and tablets in portrait mode
 * * Expanded: Most tablets in landscape mode
 *
 * @since 1.0.0
 * @see WindowSize
 * @property dpSize window size
 */
@Immutable
sealed class WindowType(val dpSize: Int) {
  @Immutable
  class Medium(dpSize: Int) : WindowType(dpSize)

  @Immutable
  class Compact(dpSize: Int) : WindowType(dpSize)

  @Immutable
  class Expanded(dpSize: Int) : WindowType(dpSize)
}

/**
 * Remembers the [WindowSize] class for the window corresponding to the current window metrics.
 *
 * [References](https://github.com/android/compose-samples/blob/d38047520c00d5eed71eb731b1fa5ecd99f59a32/JetNews/app/src/main/java/com/example/jetnews/utils/WindowSize.kt)
 *
 * Example:
 * ```Kotlin
 * val window: WindowSize = rememberWindowSize()
 * when(window.width) {
 *   is WindowType.Compact -> "Compact"
 *   is WindowType.Medium -> "Medium"
 *   is WindowType.Expanded -> "Expanded"
 * }
 * ```
 * @since 1.0.0
 * @return [WindowSize] corresponding to the given width and height
 */
@Composable
fun rememberWindowSize(): WindowSize {
  val configuration = LocalConfiguration.current
  val screenWidth by remember(configuration) {
    mutableStateOf(configuration.screenWidthDp)
  }
  val screenHeight by remember(configuration) {
    mutableStateOf(configuration.screenHeightDp)
  }

  return WindowSize(
    GlobalWindowSize.Factory.fromWidth?.invoke(screenWidth) ?: getScreenWidth(screenWidth),
    GlobalWindowSize.Factory.fromHeight?.invoke(screenHeight) ?: getScreenHeight(screenHeight)
  )
}

private fun getScreenWidth(width: Int): WindowType = when {
  width < 0 -> throw IllegalArgumentException("value cannot be negative")
  width < GlobalWindowSize.compactWidth -> WindowType.Compact(width)
  width < GlobalWindowSize.mediumWidth -> WindowType.Medium(width)
  else -> WindowType.Expanded(width)
}

private fun getScreenHeight(height: Int): WindowType = when {
  height < 0 -> throw IllegalArgumentException("value cannot be negative")
  height < GlobalWindowSize.compactHeight -> WindowType.Compact(height)
  height < GlobalWindowSize.mediumHeight -> WindowType.Medium(height)
  else -> WindowType.Expanded(height)
}
