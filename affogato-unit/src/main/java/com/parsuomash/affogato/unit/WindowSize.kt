package com.parsuomash.affogato.unit

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
 * @property width width-based window size class ([WindowType])
 * @property height height-based window size class ([WindowType])
 */
@Immutable
data class WindowSize(
    val width: WindowType,
    val height: WindowType
)

enum class WindowType { Compact, Medium, Expanded }

/**
 * Calculates [WindowSize].
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
        width = getScreenWidth(screenWidth),
        height = getScreenHeight(screenHeight)
    )
}

private fun getScreenWidth(width: Int): WindowType = when {
    width < COMPACT_WIDTH -> WindowType.Compact
    width < MEDIUM_WIDTH -> WindowType.Medium
    else -> WindowType.Expanded
}

private fun getScreenHeight(height: Int): WindowType = when {
    height < COMPACT_HEIGHT -> WindowType.Compact
    height < MEDIUM_HEIGHT -> WindowType.Medium
    else -> WindowType.Expanded
}

private const val COMPACT_WIDTH = 600
private const val MEDIUM_WIDTH = 840
private const val COMPACT_HEIGHT = 480
private const val MEDIUM_HEIGHT = 900
