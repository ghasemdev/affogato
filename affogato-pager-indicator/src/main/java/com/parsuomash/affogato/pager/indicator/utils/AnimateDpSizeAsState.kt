@file:Suppress("ConstPropertyName", "PrivatePropertyName")

package com.parsuomash.affogato.pager.indicator.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

/**
 * Fire-and-forget animation function for [DpSize]. This Composable function is overloaded for
 * different parameter types such as [Float], [Color][androidx.compose.ui.graphics.Color], [Offset],
 * etc. When the provided [targetValue] is changed, the animation will run automatically. If there
 * is already an animation in-flight when [targetValue] changes, the on-going animation will adjust
 * course to animate towards the new target value.
 *
 * [animateDpSizeAsState] returns a [State] object. The value of the state object will continuously be
 * updated by the animation until the animation finishes.
 *
 * Note, [animateDpSizeAsState] cannot be canceled/stopped without removing this composable function
 * from the tree. See [Animatable] for cancelable animations.
 *
 * @param targetValue Target value of the animation
 * @param animationSpec The animation that will be used to change the value through time. Physics
 *                    animation will be used by default.
 * @param label An optional label to differentiate from other animations in Android Studio.
 * @param finishedListener An optional end listener to get notified when the animation is finished.
 * @return A [State] object, the value of which is updated by animation.
 */
@Composable
fun animateDpSizeAsState(
  targetValue: DpSize,
  animationSpec: AnimationSpec<DpSize> = dpSizeDefaultSpring,
  label: String = "DpSizeAnimation",
  finishedListener: ((DpSize) -> Unit)? = null
): State<DpSize> {
  return animateValueAsState(
    targetValue,
    DpSize.VectorConverter,
    animationSpec,
    label = label,
    finishedListener = finishedListener
  )
}

/**
 * A type converter that converts a [DpSize] to a [AnimationVector2D], and vice versa.
 */
val DpSize.Companion.VectorConverter: TwoWayConverter<DpSize, AnimationVector2D>
  get() = DpSizeToVector

/**
 * A type converter that converts a [DpSize] to a [AnimationVector2D], and vice versa.
 */
private val DpSizeToVector: TwoWayConverter<DpSize, AnimationVector2D> = TwoWayConverter(
  convertToVector = { size ->
    AnimationVector2D(size.width.value, size.height.value)
  },
  convertFromVector = { vector ->
    DpSize(vector.v1.dp, vector.v2.dp)
  }
)

private val dpSizeDefaultSpring = spring(visibilityThreshold = DpSize.VisibilityThreshold)

/**
 * Visibility threshold for [DpSize]. This defines the amount of value change that is
 * considered to be no longer visible. The animation system uses this to signal to some default
 * [spring] animations to stop when the value is close enough to the target.
 */
val DpSize.Companion.VisibilityThreshold: DpSize
  get() = DpSize(width = DpVisibilityThreshold.dp, height = DpVisibilityThreshold.dp)

private const val DpVisibilityThreshold = 0.1f
