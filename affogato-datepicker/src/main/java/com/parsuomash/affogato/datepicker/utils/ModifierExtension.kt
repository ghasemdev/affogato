package com.parsuomash.affogato.datepicker.utils

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput

internal fun Modifier.disabledLongPress() = this.pointerInput(Unit) {
  detectTapGestures(onLongPress = emptyLambda)
}

internal fun Modifier.fadingEdge(brush: Brush) = this
  .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
  .drawWithContent {
    drawContent()
    drawRect(brush = brush, blendMode = BlendMode.DstIn)
  }

private val emptyLambda: ((Offset) -> Unit) = {}
