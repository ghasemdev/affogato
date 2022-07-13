package com.parsuomash.unit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.intuit.sdp.R

typealias Sdp = R.dimen

/**
 * Create a Scalable [Dp] using an [Int]:
 *
 * Example:
 * ```Kotlin
 * val dimen = 24.sdp
 * ```
 */
@Stable
val Int.sdp: Dp
    @Composable
    get() = getSdp()

@JvmName("_getSdp")
@Composable
private fun Int.getSdp(): Dp {
    val id = when (this) {
        in 1..MAX_DP -> "_${this}sdp"
        in (-MAX_NEGATIVE_DP..-1) -> "_minus${this}sdp"
        else -> return this.dp
    }

    val resourceField = getFieldId(id)
    return if (resourceField != 0) dimensionResource(resourceField) else this.dp
}

@Composable
internal fun getFieldId(id: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(id, "dimen", context.packageName)
}

internal const val MAX_DP = 600
internal const val MAX_NEGATIVE_DP = 60
