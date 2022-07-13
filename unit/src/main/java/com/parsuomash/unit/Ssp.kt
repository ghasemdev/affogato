package com.parsuomash.unit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.intuit.ssp.R

typealias Ssp = R.dimen

/**
 * Creates a Scalable SP unit [TextUnit]:
 *
 * Example:
 * ```Kotlin
 * val textSize = 24.ssp
 * ```
 */
@Stable
val Int.ssp: TextUnit
    @Composable
    get() = getSsp()

@JvmName("_getSsp")
@Composable
private fun Int.getSsp(): TextUnit {
    val id = when (this) {
        in 1..MAX_DP -> "_${this}ssp"
        in (-MAX_NEGATIVE_DP..-1) -> "_minus${this}ssp"
        else -> return this.sp
    }

    val resourceField = getFieldId(id)
    return if (resourceField != 0) {
        with(LocalDensity.current) {
            dimensionResource(resourceField).toSp()
        }
    } else this.sp
}
