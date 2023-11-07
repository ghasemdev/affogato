package com.parsuomash.affogato.pdfviewerandroid.zoomable

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitTouchSlopOrCancellation
import androidx.compose.foundation.gestures.awaitVerticalTouchSlopOrCancellation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.drag
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.toSize
import kotlin.math.roundToInt
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * A zoomable layout that supports zooming in and out, dragging, double tap and dismiss gesture.
 *
 * @param modifier The modifier to apply to this layout.
 * @param zoomableState The state object to be used to control or observe the state.
 * @param enabled Controls the enabled state. When false, all gestures will be ignored.
 * indicating whether the dismiss request is handled.
 * @param content a block, which describes the content.
 */
@Composable
internal fun Zoomable(
  modifier: Modifier = Modifier,
  zoomableState: ZoomableState = rememberZoomableState(),
  enabled: Boolean = true,
  content: @Composable () -> Unit
) {
  val coroutineScope = rememberCoroutineScope()
  val transformableState = rememberTransformableState { zoomChange, panChange, _ ->
    coroutineScope.launch {
      zoomableState.onDrag(panChange)
      zoomableState.onZoomChange(zoomChange)
    }
  }
  val gesturesModifier = if (!enabled) Modifier else Modifier
    .pointerInput(zoomableState) {
      detectTapAndDragGestures(zoomableState)
    }
    .transformable(state = transformableState)

  Box(
    modifier = modifier
      .then(gesturesModifier)
      .layout { measurable, constraints ->
        val width = constraints.maxWidth
        val height = constraints.maxHeight
        val placeable = measurable.measure(
          Constraints(
            maxWidth = (width * zoomableState.scale).roundToInt(),
            maxHeight = (height * zoomableState.scale).roundToInt()
          )
        )
        zoomableState.size = IntSize(width, height)
        zoomableState.childSize = Size(
          placeable.width / zoomableState.scale,
          placeable.height / zoomableState.scale
        )
        layout(width, height) {
          placeable.placeWithLayer(
            zoomableState.translationX.roundToInt() - zoomableState.boundOffset.x,
            zoomableState.translationY.roundToInt() - zoomableState.boundOffset.y
          )
        }
      }
  ) {
    content()
  }
}

internal suspend fun PointerInputScope.detectTapAndDragGestures(
  state: ZoomableState
) = coroutineScope {
  launch {
    detectTapGestures(
      onDoubleTap = { offset ->
        launch {
          val isZooming = state.isZooming
          val targetScale =
            if (isZooming) state.minScale else state.doubleTapScale
          state.animateScaleTo(
            targetScale = targetScale,
            targetTranslation = if (isZooming) {
              Offset.Zero
            } else {
              state.calculateTargetTranslation(offset) * targetScale
            }
          )
        }
      }
    )
  }
  launch {
    detectDragGestures(
      state = state,
      startDragImmediately = { state.isDragInProgress },
      onDragStart = {
        state.onDragStart()
        state.addPosition(it.uptimeMillis, it.position)
      },
      onDrag = { change, dragAmount ->
        if (state.isZooming) {
          launch {
            state.onDrag(dragAmount)
            state.addPosition(change.uptimeMillis, change.position)
          }
        }
      },
      onDragCancel = {
        if (state.isZooming) {
          state.resetTracking()
        }
      },
      onDragEnd = {
        launch {
          if (state.isZooming) {
            state.onDragEnd()
          }
        }
      }
    )
  }
}

private suspend fun PointerInputScope.detectDragGestures(
  state: ZoomableState,
  startDragImmediately: () -> Boolean,
  onDragStart: (PointerInputChange) -> Unit = {},
  onDragEnd: () -> Unit = {},
  onDragCancel: () -> Unit = {},
  onDrag: (change: PointerInputChange, dragAmount: Offset) -> Unit
) {
  awaitEachGesture {
    // We have to always call this, or we'll get a crash if we do nothing.
    val down = awaitFirstDown(requireUnconsumed = false)
    if (state.isZooming) {
      var overSlop = Offset.Zero
      val drag = if (state.isZooming) {
        if (startDragImmediately()) down else {
          awaitTouchSlopOrCancellation(down.id) { change, over ->
            if (change.positionChange() != Offset.Zero) change.consume()
            overSlop = over
          }
        }
      } else {
        awaitVerticalTouchSlopOrCancellation(down.id) { change, over ->
          if (change.positionChange() != Offset.Zero) change.consume()
          overSlop = Offset(0f, over)
        }
      }
      if (drag != null) {
        onDragStart(down)
        if (overSlop != Offset.Zero) onDrag(drag, overSlop)
        if (
          !drag(drag.id) {
            onDrag(it, it.positionChange())
            if (it.positionChange() != Offset.Zero) it.consume()
          }
        ) {
          onDragCancel()
        } else {
          onDragEnd()
        }
      }
    }
  }
}

private fun ZoomableState.calculateTargetTranslation(doubleTapPoint: Offset): Offset =
  (size.toSize().center + Offset(translationX, translationY) - doubleTapPoint) / scale
