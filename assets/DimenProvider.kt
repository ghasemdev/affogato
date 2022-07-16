package com.parsuomash.affogato

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Provide dimens for multiscreen support.
 * in Theme.kt add this function
 * ```Kotlin
 * ProvideDimens {
 *   MaterialTheme(
 *     colors = colors,
 *     typography = Typography,
 *     shapes = Shapes,
 *     content = content
 *   )
 * }
 * ```
 *
 * @param dimensions
 * @param content
 */
@Composable
public fun ProvideDimens(
    dimensions: Dimensions = defaultDimens(),
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

private val LocalAppDimens = staticCompositionLocalOf {
    Dimensions()
}

public val dimen: Dimensions
    @Composable
    get() = LocalAppDimens.current

@Composable
private fun defaultDimens(): Dimensions {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    return when {
        screenWidth < 320 -> sw320Dimensions
        screenWidth in 320..480 -> sw320Dimensions
        screenWidth in 480..600 -> sw480Dimensions
        screenWidth in 600..720 -> sw600Dimensions
        else -> sw720Dimensions
    }
}

public data class Dimensions(
     val icon: Dp = com.parsuomash.affogato.icon,
     val padding: Dp = com.parsuomash.affogato.padding,
     val space: Dp = com.parsuomash.affogato.space,
     val heightButton: Dp = com.parsuomash.affogato.heightButton,
     val fontSize: TextUnit = com.parsuomash.affogato.fontSize,
)

private val sw320Dimensions = Dimensions(
     icon = 70.dp,
     padding = 14.dp,
     space = 26.dp,
     heightButton = 50.dp,
     fontSize = 14.sp,
)

private val sw480Dimensions = Dimensions(
     icon = 80.dp,
     padding = 16.dp,
     space = 32.dp,
     heightButton = 50.dp,
     fontSize = 20.sp,
)

private val sw600Dimensions = Dimensions(
     icon = 180.dp,
     padding = 18.dp,
     space = 34.dp,
     heightButton = 70.dp,
     fontSize = 30.sp,
)

private val sw720Dimensions = Dimensions(
     icon = 180.dp,
     padding = 20.dp,
     space = 36.dp,
     heightButton = 80.dp,
     fontSize = 32.sp,
)
