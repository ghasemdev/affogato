@file:Suppress("unused")

package com.parsuomash.affogato.unit.window

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.geometry.Size
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowLayoutInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

/**
 * Represent the posture of the foldable device.
 *
 * * Posture.TableTop - Device posture is in tabletop mode (half open with the hinge horizontal).
 * * Posture.Book - Device posture is in book mode (half open with the hinge vertical).
 * * Posture.Normal - Device posture is in normal mode.
 *
 * @since 1.0.0
 * @see postureState
 * @See postureFlow
 **/
sealed class Posture(val size: Size) {
  /** Device posture is in tabletop mode (half open with the hinge horizontal). */
  class TableTop(windowSize: Size) : Posture(windowSize)

  /** Device posture is in book mode (half open with the hinge vertical). */
  class Book(windowSize: Size) : Posture(windowSize)

  /** Device posture is in normal mode. */
  object Normal : Posture(Size(0F, 0F))
}

/**
 * Returns a [State] of the [Posture] by tracking the [WindowLayoutInfo].
 * @since 1.0.0
 */
@ExperimentalLifecycleComposeApi
inline val Activity.postureState: State<Posture>
  @Composable get() = postureFlow.collectAsStateWithLifecycle(initialValue = Posture.Normal)

/**
 * Returns a [Flow] of the [Posture] by tracking the [WindowLayoutInfo].
 * @since 1.0.0
 */
inline val Activity.postureFlow: Flow<Posture>
  @JvmSynthetic get() = WindowInfoTracker.getOrCreate(this).postureFlow(this)

/**
 * Returns a [Flow] of the [Posture] by tracking the [WindowLayoutInfo].
 * @since 1.0.0
 */
fun WindowInfoTracker.postureFlow(activity: Activity): Flow<Posture> {
  return activity.windowLayoutInfo.map { layoutInfo ->
    layoutInfo.findFoldingFeature()?.toPosture()
  }.filterNotNull()
}
