package com.parsuomash.affogato.pager.indicator.utils

import android.os.Build
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.OverscrollConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

/**
 * Disable scroll effect for the lazy lists.
 *
 * Example:
 * ```Kotlin
 * DisableScrollEffect {
 *   // Other containers
 * }
 * ```
 * @since 2.0.0
 * @see LocalOverscrollConfiguration
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
internal inline fun DisableScrollEffect(crossinline content: @Composable () -> Unit) {
  CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
    content()
  }
}

/**
 * Configure scroll effect colors for scroll components.
 *
 * Example:
 * ```Kotlin
 * ScrollEffect(Color.Red) {
 *   // Other containers
 * }
 * ```
 * @since 2.0.0
 * @see LocalOverscrollConfiguration
 * @param glowColor color for the glow effect, if the platform effect is a
 * glow effect, otherwise ignored. Default glow color is [Color.LightGray].
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
internal inline fun ScrollEffect(
  glowColor: Color = Color(0xff666666), // taken from EdgeEffect.java defaults
  crossinline content: @Composable () -> Unit
) {
  CompositionLocalProvider(
    LocalOverscrollConfiguration provides OverscrollConfiguration(glowColor)
  ) {
    content()
  }
}

/**
 * Enables the stretch effect on Android 12 and above
 * and disables the scroll effect for Android below 12.
 *
 * Example:
 * ```Kotlin
 * StretchEffectOnly {
 *   // Other containers
 * }
 * ```
 * @since 2.0.0
 * @see ScrollEffect
 * @see DisableScrollEffect
 */
@Composable
internal inline fun StretchEffectOnly(crossinline content: @Composable () -> Unit) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
    ScrollEffect(content = content)
  } else {
    DisableScrollEffect(content = content)
  }
}
