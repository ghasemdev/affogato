package com.parsuomash.affogato.unit.window

import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Rect
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.window.layout.DisplayFeature
import androidx.window.layout.FoldingFeature

/**
 * Returns a height dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingeWidthDp: Dp
  get() = hingeWidthDpSize.dp

/**
 * Returns a height dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingeHeightDp: Dp
  get() = hingeHeightDpSize.dp

/**
 * Returns a dp size of the hinge according to the window orientation from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingeDp: Dp
  @Composable get() = when (windowOrientation) {
    WindowOrientation.ORIENTATION_LANDSCAPE -> hingeWidthDp
    WindowOrientation.ORIENTATION_PORTRAIT -> hingeHeightDp
  }

/**
 * Returns a dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingeDpSize: DpSize
  get() = DpSize(width = hingeWidthDpSize.dp, height = hingeWidthDpSize.dp)

/**
 * Returns a width pixel size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingeWidthPxSize: Float
  get() = toSize().width

/**
 * Returns a width pixel size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingeHeightPxSize: Float
  get() = toSize().height

/**
 * Returns a pixel size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingePxSize: Float
  get() =
    if (Resources.getSystem().configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
      hingeWidthPxSize
    } else {
      hingeHeightPxSize
    }

/**
 * Returns a width Dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingeWidthDpSize: Float
  get() = toSize().width

/**
 * Returns a width Dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.hingeHeightDpSize: Float
  get() = toSize().height

/**
 * Returns whether a [FoldingFeature] is the table-top mode.
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.isTableTopPosture: Boolean
  get() {
    return state == FoldingFeature.State.HALF_OPENED &&
      orientation == FoldingFeature.Orientation.HORIZONTAL
  }

/**
 * Returns whether a [FoldingFeature] is the book mode.
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.isBookPosture: Boolean
  get() {
    return state == FoldingFeature.State.HALF_OPENED &&
      orientation == FoldingFeature.Orientation.VERTICAL
  }

/**
 * Returns whether the state of a [FoldingFeature] is half-opened.
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.isHalfOpened: Boolean
  get() = state == FoldingFeature.State.HALF_OPENED

/**
 * Returns whether the state of a [FoldingFeature] is flat.
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.isFlat: Boolean
  get() = state == FoldingFeature.State.FLAT

/**
 * Returns whether the orientation of a [FoldingFeature] is vertical.
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.isVertical: Boolean
  get() = orientation == FoldingFeature.Orientation.HORIZONTAL

/**
 * Returns whether the orientation of a [FoldingFeature] is horizontal.
 * @since 1.0.0
 */
@get:JvmSynthetic
inline val FoldingFeature.isHorizontal: Boolean
  get() = orientation == FoldingFeature.Orientation.HORIZONTAL

/**
 * Finds a [FoldingFeature] from a list of [DisplayFeature].
 * @since 1.0.0
 */
@JvmSynthetic
fun List<DisplayFeature>.findFoldingFeature(): FoldingFeature? =
  filterIsInstance<FoldingFeature>().firstOrNull()

/**
 * Returns a [Posture] which represent the current posture of the foldable device.
 * @since 1.0.0
 */
@JvmSynthetic
fun FoldingFeature.toPosture(): Posture = when {
  isTableTopPosture -> Posture.TableTop(bounds.toSize())
  isBookPosture -> Posture.Book(bounds.toSize())
  else -> Posture.Normal
}

/**
 * Returns a [Size] spec from a [FoldingFeature].
 * @since 1.0.0
 */
@JvmSynthetic
fun DisplayFeature.toSize(): Size =
  Size((bounds.right - bounds.left).toFloat(), (bounds.bottom - bounds.top).toFloat())

/**
 * Returns [Size] class from a [Rect] class.
 * @since 1.0.0
 */
private fun Rect.toSize(): Size = Size((right - left).toFloat(), (bottom - top).toFloat())
