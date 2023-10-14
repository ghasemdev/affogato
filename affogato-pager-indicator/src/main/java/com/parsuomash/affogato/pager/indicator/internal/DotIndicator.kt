package com.parsuomash.affogato.pager.indicator.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.DpSize

@Composable
internal fun DotIndicator(
  size: DpSize,
  padding: PaddingValues,
  color: Color,
  shape: Shape,
  onClickEnabled: Boolean,
  onClick: () -> Unit
) {
  Box(
    modifier = Modifier
      .padding(padding)
      .background(color, shape)
      .size(size)
      .clickableWithoutRipple(enabled = onClickEnabled, onClick = onClick)
  )
}
