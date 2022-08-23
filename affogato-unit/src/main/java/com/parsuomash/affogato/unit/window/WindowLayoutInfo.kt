package com.parsuomash.affogato.unit.window

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowLayoutInfo
import kotlinx.coroutines.flow.Flow

/**
 * Returns a [State] of the [WindowLayoutInfo].
 * @since 1.0.0
 */
@ExperimentalLifecycleComposeApi
inline val Activity.windowLayoutInfoState: State<WindowLayoutInfo?>
  @JvmSynthetic @Composable get() =
    windowLayoutInfo.collectAsStateWithLifecycle(initialValue = null)

/**
 * Returns a [Flow] of the [WindowLayoutInfo].
 * @since 1.0.0
 */
inline val Activity.windowLayoutInfo: Flow<WindowLayoutInfo>
  @JvmSynthetic get() = WindowInfoTracker.getOrCreate(this).windowLayoutInfo(this)

/**
 * Calculates if a [FoldingFeature] should be thought of as splitting the window into
 * multiple physical areas that can be seen by users as logically separate. Display panels
 * connected by a hinge are always separated. Folds on flexible screens should be treated as
 * separating when they are not [FoldingFeature.State.FLAT].
 * @since 1.0.0
 */
inline val WindowLayoutInfo.isSeparating: Boolean
  @JvmSynthetic get() = findFoldingFeature()?.isSeparating ?: false

/**
 * Calculates the occlusion mode to determine if a FoldingFeature occludes a part of the window.
 * This flag is useful for determining if UI elements need to be moved around so that the user can access them.
 * For some devices occluded elements can not be accessed by the user at all.
 * @since 1.0.0
 */
inline val WindowLayoutInfo.occlusionType: FoldingFeature.OcclusionType
  @JvmSynthetic get() = findFoldingFeature()?.occlusionType
    ?: FoldingFeature.OcclusionType.NONE

/**
 * Returns [FoldingFeature.Orientation.HORIZONTAL] if the width is greater than the height,
 * [FoldingFeature.Orientation.VERTICAL] otherwise.
 * @since 1.0.0
 */
inline val WindowLayoutInfo.orientation: FoldingFeature.Orientation
  @JvmSynthetic get() = findFoldingFeature()?.orientation
    ?: FoldingFeature.Orientation.HORIZONTAL

/**
 * Returns the [FoldingFeature.State] for the [FoldingFeature].
 * @since 1.0.0
 */
inline val WindowLayoutInfo.state: FoldingFeature.State
  @JvmSynthetic get() = findFoldingFeature()?.state
    ?: FoldingFeature.State.FLAT

/**
 * Returns a [State] of the [WindowLayoutInfo].
 * @since 1.0.0
 */
@ExperimentalLifecycleComposeApi
@JvmSynthetic
@Composable
fun WindowInfoTracker.windowLayoutInfoState(activity: Activity): State<WindowLayoutInfo?> =
  windowLayoutInfo(activity).collectAsStateWithLifecycle(initialValue = null)

/**
 * Finds a [FoldingFeature] from a [WindowLayoutInfo].
 * @since 1.0.0
 */
@JvmSynthetic
fun WindowLayoutInfo.findFoldingFeature(): FoldingFeature? =
  displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()
