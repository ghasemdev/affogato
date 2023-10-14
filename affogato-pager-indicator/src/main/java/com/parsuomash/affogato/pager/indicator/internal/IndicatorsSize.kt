package com.parsuomash.affogato.pager.indicator.internal

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection

internal fun calculateIndicatorsWidth(
  indicatorSize: DpSize,
  spacing: PaddingValues,
  layoutDirection: LayoutDirection,
  isScrollable: Boolean
): Dp {
  val normalIndicator = indicatorSize.width
  val smallIndicator = normalIndicator - (normalIndicator * SMALL_INDICATOR_WEIGHT)
  val left = spacing.calculateLeftPadding(layoutDirection)
  val right = spacing.calculateRightPadding(layoutDirection)
  val horizontalPadding = left + right

  return if (isScrollable) {
    (smallIndicator * 2) + (normalIndicator * 3) + (horizontalPadding * 5)
  } else {
    (normalIndicator * 5) + (horizontalPadding * 5)
  }
}

internal fun calculateIndicatorsHeight(
  indicatorSize: DpSize,
  spacing: PaddingValues,
  isScrollable: Boolean
): Dp {
  val normalIndicator = indicatorSize.height
  val smallIndicator = normalIndicator - (normalIndicator * SMALL_INDICATOR_WEIGHT)
  val top = spacing.calculateTopPadding()
  val bottom = spacing.calculateBottomPadding()
  val verticalPadding = top + bottom

  return if (isScrollable) {
    (smallIndicator * 2) + (normalIndicator * 3) + (verticalPadding * 5)
  } else {
    (normalIndicator * 5) + (verticalPadding * 5)
  }
}

internal const val MINIMUM_PAGE_COUNT_FOR_SCROLLING = 5
internal const val SMALL_INDICATOR_WEIGHT = .3f
internal const val LARGE_INDICATOR_WEIGHT = .15f
