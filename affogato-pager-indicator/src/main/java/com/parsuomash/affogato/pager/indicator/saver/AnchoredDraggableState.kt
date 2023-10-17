package com.parsuomash.affogato.pager.indicator.saver

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun <T : Any> rememberAnchoredDraggableState(
  initialValue: T,
  animationSpec: AnimationSpec<Float>,
  positionalThreshold: (distance: Float) -> Float,
  velocityThreshold: () -> Float,
  confirmValueChange: (T) -> Boolean = { true },
): AnchoredDraggableState<T> {
  val positionalThresholdState by rememberUpdatedState(positionalThreshold)
  val velocityThresholdState by rememberUpdatedState(velocityThreshold)
  val confirmValueChangeState by rememberUpdatedState(confirmValueChange)

  return rememberSaveable(
    saver = AnchoredDraggableState.Saver(
      animationSpec = animationSpec,
      positionalThreshold = positionalThresholdState,
      velocityThreshold = velocityThresholdState,
      confirmValueChange = confirmValueChangeState
    )
  ) {
    AnchoredDraggableState(
      initialValue = initialValue,
      animationSpec = animationSpec,
      positionalThreshold = positionalThresholdState,
      velocityThreshold = velocityThresholdState,
      confirmValueChange = confirmValueChangeState
    )
  }
}
