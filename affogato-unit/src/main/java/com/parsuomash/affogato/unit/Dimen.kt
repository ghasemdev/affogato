package com.parsuomash.affogato.unit

/**
 * Dimen tag used for generation dimensions.
 *
 * Example:
 * ```Kotlin
 * @Dimen(type = "dp", values = ["320:24", "480:26", "600:28", "720:30"])
 * val topPadding = 24.dp
 *
 * @Dimen(type = "sp", values = ["320=24", "480=26", "600=28", "720=30"])
 * val buttonFontSize = 24.sp
 * ```
 * @property type - dp or sp
 * @property values - a string array of value in different screen size (screen_size:value)
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class Dimen(
    val type: String,
    val values: Array<String>,
)
