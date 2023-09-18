package com.parsuomash.affogato.pdfviewer.internal

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Constraints
import com.parsuomash.affogato.pdfviewer.state.HorizontalPdfReaderState
import com.parsuomash.affogato.pdfviewer.state.VerticalPdfReaderState
import kotlinx.coroutines.launch

internal fun Modifier.tapToZoomVertical(
  state: VerticalPdfReaderState,
  constraints: Constraints
): Modifier = composed(
  inspectorInfo = debugInspectorInfo {
    name = "verticalTapToZoom"
    properties["state"] = state
  }
) {
  val coroutineScope = rememberCoroutineScope()
  this
    .pointerInput(Unit) {
      detectTapGestures(
        onDoubleTap = { tapCenter ->
          if (!state.isZoomEnable) return@detectTapGestures
          if (state.mScale > 1.0f) {
            state.mScale = 1.0f
            state.offset = Offset(0f, 0f)
          } else {
            state.mScale = 3.0f
            val center = Pair(constraints.maxWidth / 2, constraints.maxHeight / 2)
            val xDiff = (tapCenter.x - center.first) * state.scale
            val yDiff = ((tapCenter.y - center.second) * state.scale).coerceIn(
              minimumValue = -(center.second * 2f),
              maximumValue = (center.second * 2f)
            )
            state.offset = Offset(-xDiff, -yDiff)
          }
        }
      )
    }
    .pointerInput(Unit) {
      detectTransformGestures(true) { _, pan, _, _ ->
        val pair = if (pan.y > 0) {
          if (state.lazyState.canScrollBackward) {
            Pair(0f, pan.y)
          } else {
            Pair(pan.y, 0f)
          }
        } else {
          if (state.lazyState.canScrollForward) {
            Pair(0f, pan.y)
          } else {
            Pair(pan.y, 0f)
          }
        }
        val nOffset = if (state.scale > 1f) {
          val maxT = (constraints.maxWidth * state.scale) - constraints.maxWidth
          val maxY = (constraints.maxHeight * state.scale) - constraints.maxHeight
          Offset(
            x = (state.offset.x + pan.x).coerceIn(
              minimumValue = (-maxT / 2) * 1.3f,
              maximumValue = (maxT / 2) * 1.3f
            ),
            y = (state.offset.y + pair.first).coerceIn(
              minimumValue = (-maxY / 2),
              maximumValue = (maxY / 2)
            )
          )
        } else {
          Offset(0f, 0f)
        }
        state.offset = nOffset
        coroutineScope.launch {
          state.lazyState.scrollBy((-pair.second / state.scale))
        }
      }
    }
    .graphicsLayer {
      scaleX = state.scale
      scaleY = state.scale
      translationX = state.offset.x
      translationY = state.offset.y
    }
}

@SuppressLint("UnnecessaryComposedModifier")
internal fun Modifier.tapToZoomHorizontal(
  state: HorizontalPdfReaderState,
  constraints: Constraints
): Modifier = composed(
  inspectorInfo = debugInspectorInfo {
    name = "horizontalTapToZoom"
    properties["state"] = state
  }
) {
  this
    .pointerInput(Unit) {
      detectTapGestures(
        onDoubleTap = { tapCenter ->
          if (!state.isZoomEnable) return@detectTapGestures
          if (state.mScale > 1.0f) {
            state.mScale = 1.0f
            state.offset = Offset(0f, 0f)
          } else {
            state.mScale = 3.0f
            val center = Pair(constraints.maxWidth / 2, constraints.maxHeight / 2)
            val xDiff = (tapCenter.x - center.first) * state.scale
            val yDiff = ((tapCenter.y - center.second) * state.scale).coerceIn(
              minimumValue = -(center.second * 2f),
              maximumValue = (center.second * 2f)
            )
            state.offset = Offset(-xDiff, -yDiff)
          }
        }
      )
    }
    .pointerInput(Unit) {
      detectTransformGestures(true) { _, pan, _, _ ->
        val nOffset = if (state.scale > 1f) {
          val maxT = (constraints.maxWidth * state.scale) - constraints.maxWidth
          val maxY = (constraints.maxHeight * state.scale) - constraints.maxHeight
          Offset(
            x = (state.offset.x + pan.x).coerceIn(
              minimumValue = (-maxT / 2) * 1.3f,
              maximumValue = (maxT / 2) * 1.3f
            ),
            y = (state.offset.y + pan.y).coerceIn(
              minimumValue = (-maxY / 2) * 1.3f,
              maximumValue = (maxY / 2) * 1.3f
            )
          )
        } else {
          Offset(0f, 0f)
        }
        state.offset = nOffset
      }
    }
    .graphicsLayer {
      scaleX = state.scale
      scaleY = state.scale
      translationX = state.offset.x
      translationY = state.offset.y
    }
}
