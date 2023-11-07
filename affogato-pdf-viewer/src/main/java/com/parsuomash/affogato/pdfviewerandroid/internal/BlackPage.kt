package com.parsuomash.affogato.pdfviewerandroid.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun BlackPage(
  width: Int,
  height: Int
) {
  Box(
    modifier = Modifier
      .size(
        width = width.dp(),
        height = height.dp()
      )
      .background(color = Color.White)
  )
}

@Composable
private fun Int.dp(): Dp {
  val density = LocalDensity.current.density
  return (this / density).dp
}
