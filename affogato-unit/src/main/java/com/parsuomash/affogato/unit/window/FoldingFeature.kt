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
inline val FoldingFeature.hingeWidthDp: Dp
  @JvmSynthetic get() = hingeWidthDpSize.dp

/**
 * Returns a height dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
inline val FoldingFeature.hingeHeightDp: Dp
  @JvmSynthetic get() = hingeHeightDpSize.dp

/**
 * Returns a dp size of the hinge according to the window orientation from a [FoldingFeature].
 * @since 1.0.0
 */
inline val FoldingFeature.hingeDp: Dp
  @Composable @JvmSynthetic get() = when (windowOrientation) {
    WindowOrientation.ORIENTATION_LANDSCAPE -> hingeWidthDp
    WindowOrientation.ORIENTATION_PORTRAIT -> hingeHeightDp
  }

/**
 * Returns a dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
inline val FoldingFeature.hingeDpSize: DpSize
  @JvmSynthetic get() = DpSize(width = hingeWidthDpSize.dp, height = hingeWidthDpSize.dp)

/**
 * Returns a width pixel size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
inline val FoldingFeature.hingeWidthPxSize: Float
  @JvmSynthetic get() = toSize().width

/**
 * Returns a width pixel size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
inline val FoldingFeature.hingeHeightPxSize: Float
  @JvmSynthetic get() = toSize().height

/**
 * Returns a pixel size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
inline val FoldingFeature.hingePxSize: Float
  @JvmSynthetic get() =
    if (Resources.getSystem().configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
      hingeWidthPxSize
    } else {
      hingeHeightPxSize
    }

/**
 * Returns a width Dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
inline val FoldingFeature.hingeWidthDpSize: Float
  @JvmSynthetic get() = toSize().width

/**
 * Returns a width Dp size of the hinge from a [FoldingFeature].
 * @since 1.0.0
 */
inline val FoldingFeature.hingeHeightDpSize: Float
  @JvmSynthetic get() = toSize().height

/**
 * Returns whether a [FoldingFeature] is the table-top mode.
 * @since 1.0.0
 */
inline val FoldingFeature.isTableTopPosture: Boolean
  @JvmSynthetic get() {
    return state == FoldingFeature.State.HALF_OPENED &&
      orientation == FoldingFeature.Orientation.HORIZONTAL
  }

/**
 * Returns whether a [FoldingFeature] is the book mode.
 * @since 1.0.0
 */
inline val FoldingFeature.isBookPosture: Boolean
  @JvmSynthetic get() {
    return state == FoldingFeature.State.HALF_OPENED &&
      orientation == FoldingFeature.Orientation.VERTICAL
  }

/**
 * Returns whether the state of a [FoldingFeature] is half-opened.
 * @since 1.0.0
 */
inline val FoldingFeature.isHalfOpened: Boolean
  @JvmSynthetic get() = state == FoldingFeature.State.HALF_OPENED

/**
 * Returns whether the state of a [FoldingFeature] is flat.
 * @since 1.0.0
 */
inline val FoldingFeature.isFlat: Boolean
  @JvmSynthetic get() = state == FoldingFeature.State.FLAT

/**
 * Returns whether the orientation of a [FoldingFeature] is vertical.
 * @since 1.0.0
 */
inline val FoldingFeature.isVertical: Boolean
  @JvmSynthetic get() = orientation == FoldingFeature.Orientation.HORIZONTAL

/**
 * Returns whether the orientation of a [FoldingFeature] is horizontal.
 * @since 1.0.0
 */
inline val FoldingFeature.isHorizontal: Boolean
  @JvmSynthetic get() = orientation == FoldingFeature.Orientation.HORIZONTAL

/**
 * Finds a [FoldingFeature] from a list of [DisplayFeature].
 * @since 1.0.0
 */
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
