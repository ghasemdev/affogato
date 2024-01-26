// TODO v2.0.0 remove deprecated functions ---------------------------------------------------------
@file:Suppress("DEPRECATION")

package com.parsuomash.affogato.unit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
 * @property width width-based window size class ([WindowType])
 * @property height height-based window size class ([WindowType])
 */
@Immutable
@Deprecated(
  message = "This class moved into different directory",
  replaceWith = ReplaceWith(
    expression = "WindowSize",
    imports = ["com.parsuomash.affogato.unit.window"]
  ),
  level = DeprecationLevel.WARNING
)
data class WindowSize(
  val width: WindowType,
  val height: WindowType
)

@Deprecated(
  message = "This class moved into different directory",
  replaceWith = ReplaceWith(
    expression = "WindowType",
    imports = ["com.parsuomash.affogato.unit.window"]
  ),
  level = DeprecationLevel.WARNING
)
enum class WindowType { Compact, Medium, Expanded }

/**
 * Calculates [WindowSize].
 * @return [WindowSize] corresponding to the given width and height
 */
@Deprecated(
  message = "This function moved into different directory",
  replaceWith = ReplaceWith(
    expression = "rememberWindowSize()",
    imports = ["com.parsuomash.affogato.unit.window"]
  ),
  level = DeprecationLevel.WARNING
)
@Composable
fun rememberWindowSize(): WindowSize {
  val configuration = LocalConfiguration.current
  val screenWidth by remember(configuration) {
    mutableIntStateOf(configuration.screenWidthDp)
  }
  val screenHeight by remember(configuration) {
    mutableIntStateOf(configuration.screenHeightDp)
  }

  return WindowSize(
    width = getScreenWidth(screenWidth),
    height = getScreenHeight(screenHeight)
  )
}

private fun getScreenWidth(width: Int): WindowType = when {
  width < SIZE_COMPACT_WIDTH -> WindowType.Compact
  width < SIZE_MEDIUM_WIDTH -> WindowType.Medium
  else -> WindowType.Expanded
}

private fun getScreenHeight(height: Int): WindowType = when {
  height < SIZE_COMPACT_HEIGHT -> WindowType.Compact
  height < SIZE_MEDIUM_HEIGHT -> WindowType.Medium
  else -> WindowType.Expanded
}

private const val SIZE_COMPACT_WIDTH = 600
private const val SIZE_MEDIUM_WIDTH = 840
private const val SIZE_COMPACT_HEIGHT = 480
private const val SIZE_MEDIUM_HEIGHT = 900
