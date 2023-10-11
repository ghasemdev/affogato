package com.parsuomash.affogato.datepicker.utils

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput

internal fun Modifier.disabledLongPress() = pointerInput(Unit) {
  detectTapGestures(onLongPress = emptyLambda)
}

private val emptyLambda: ((Offset) -> Unit) = {}
