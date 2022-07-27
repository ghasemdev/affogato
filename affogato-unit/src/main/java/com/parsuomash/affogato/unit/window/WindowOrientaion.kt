package com.parsuomash.affogato.unit.window

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

/** Defines the current orientation of the window. */
enum class WindowOrientation {
    ORIENTATION_LANDSCAPE,
    ORIENTATION_PORTRAIT,
}

/** Returns [WindowOrientation] according to the current window orientation. */
inline val windowOrientation: WindowOrientation
    @Composable get() =
        if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            WindowOrientation.ORIENTATION_LANDSCAPE
        } else {
            WindowOrientation.ORIENTATION_PORTRAIT
        }

inline val Configuration.isLandscape: Boolean
    @Composable get() = windowOrientation == WindowOrientation.ORIENTATION_LANDSCAPE
