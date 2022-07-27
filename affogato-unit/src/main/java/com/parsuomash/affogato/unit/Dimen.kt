package com.parsuomash.affogato.unit

/**
 * Dimen tag used for generation dimensions.
 * [Resource](https://github.com/ghasemdev/affogato/wiki/Unit-Size#also-you-can-create-custom-dimension-with-dimen-tag)
 *
 * Example:
 * ```Kotlin
 * @Dimen(type = "dp", values = ["320:24", "480:26", "600:28", "720:30"])
 * val topPadding = 24.dp
 *
 * @Dimen(type = "sp", values = ["320=24", "480=26", "600=28", "720=30"])
 * val buttonFontSize = 24.sp
 * ```
 * @since 1.0.0-beta01
 * @property type - dp or sp
 * @property values - a string array of value in different screen size (screen_size:value)
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class Dimen(
  val type: String,
  val values: Array<String>,
)

const val COMPACT_WIDTH = 0
const val MEDIUM_WIDTH = 600
const val EXPANDED_WIDTH = 840
