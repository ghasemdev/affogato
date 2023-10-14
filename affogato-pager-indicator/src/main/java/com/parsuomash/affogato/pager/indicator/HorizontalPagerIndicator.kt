package com.parsuomash.affogato.pager.indicator

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.pager.indicator.internal.DotIndicator
import com.parsuomash.affogato.pager.indicator.internal.LARGE_INDICATOR_WEIGHT
import com.parsuomash.affogato.pager.indicator.internal.MINIMUM_PAGE_COUNT_FOR_SCROLLING
import com.parsuomash.affogato.pager.indicator.internal.SMALL_INDICATOR_WEIGHT
import com.parsuomash.affogato.pager.indicator.internal.calculateIndicatorsWidth
import com.parsuomash.affogato.pager.indicator.utils.StretchEffectOnly
import com.parsuomash.affogato.pager.indicator.utils.animateDpSizeAsState

/**
 * A horizontally laid out indicator for a [androidx.compose.foundation.pager.HorizontalPager] or
 * [androidx.compose.foundation.pager.VerticalPager], representing
 * the currently active page and total pages drawn using a [Shape].
 *
 * This element allows the setting of the [indicatorShape], which defines how the
 * indicator is visually represented.
 *
 * @param pagerState A [androidx.compose.foundation.pager.PagerState] object of your
 * [androidx.compose.foundation.pager.VerticalPager] or
 * [androidx.compose.foundation.pager.HorizontalPager]to be used to observe the list's state.
 * @param modifier the modifier to apply to this layout.
 * @param activeColor the color of the active Page indicator
 * @param inactiveColor the color of page indicators that are inactive. This defaults to
 * [activeColor] with the alpha component set to the [ContentAlpha.disabled].
 * @param indicatorSize the size of each indicator in [DpSize].
 * @param spacing the **horizontal** spacing between each indicator in [PaddingValues].
 * @param indicatorShape the shape representing each indicator. This defaults to [CircleShape].
 * @param onIndicatorClick will be called when user clicks on the indicator. Default value is null.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(
  pagerState: PagerState,
  modifier: Modifier = Modifier,
  activeColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
  inactiveColor: Color = activeColor.copy(ContentAlpha.disabled),
  indicatorSize: DpSize = DpSize(width = 8.dp, height = 8.dp),
  spacing: PaddingValues = PaddingValues(horizontal = 4.dp),
  indicatorShape: Shape = CircleShape,
  onIndicatorClick: ((Int) -> Unit)? = null
) {
  val indicatorScrollState = rememberLazyListState()

  LaunchedEffect(pagerState.currentPage) {
    val currentPage = pagerState.currentPage
    val size = indicatorScrollState.layoutInfo.visibleItemsInfo.size
    val lastVisibleIndex = indicatorScrollState.layoutInfo.visibleItemsInfo.last().index
    val firstVisibleItemIndex = indicatorScrollState.firstVisibleItemIndex

    if (currentPage > lastVisibleIndex - 1) {
      indicatorScrollState.animateScrollToItem(currentPage - size + 2)
    } else if (currentPage <= firstVisibleItemIndex + 1) {
      indicatorScrollState.animateScrollToItem((currentPage - 1).coerceAtLeast(0))
    }
  }

  HorizontalPagerIndicator(
    pagerState = pagerState,
    indicatorScrollState = indicatorScrollState,
    modifier = modifier,
    activeColor = activeColor,
    inactiveColor = inactiveColor,
    indicatorSize = indicatorSize,
    spacing = spacing,
    indicatorShape = indicatorShape,
    onIndicatorClick = onIndicatorClick
  )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HorizontalPagerIndicator(
  pagerState: PagerState,
  indicatorScrollState: LazyListState,
  modifier: Modifier,
  activeColor: Color,
  inactiveColor: Color,
  indicatorSize: DpSize,
  spacing: PaddingValues,
  indicatorShape: Shape,
  onIndicatorClick: ((Int) -> Unit)?
) {
  val layoutDirection = LocalLayoutDirection.current
  val currentOnIndicatorClick by rememberUpdatedState(onIndicatorClick)
  val isScrollable by remember {
    derivedStateOf {
      pagerState.pageCount > MINIMUM_PAGE_COUNT_FOR_SCROLLING
    }
  }

  val currentPage by remember {
    derivedStateOf {
      pagerState.currentPage
    }
  }
  val firstVisibleIndex by remember {
    derivedStateOf {
      indicatorScrollState.firstVisibleItemIndex
    }
  }
  val lastVisibleIndex by remember {
    derivedStateOf {
      indicatorScrollState
        .layoutInfo
        .visibleItemsInfo
        .lastOrNull()
        ?.index ?: 0
    }
  }

  StretchEffectOnly {
    LazyRow(
      state = indicatorScrollState,
      modifier = modifier
        .width(
          width = calculateIndicatorsWidth(
            indicatorSize = indicatorSize,
            spacing = spacing,
            layoutDirection = layoutDirection,
            isScrollable = isScrollable,
          )
        ),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically,
      userScrollEnabled = false
    ) {
      items(count = pagerState.pageCount, key = { it }) { page ->
        val size by animateDpSizeAsState(
          targetValue = when (page) {
            currentPage -> {
              val width = indicatorSize.width + (indicatorSize.width * LARGE_INDICATOR_WEIGHT)
              val height = indicatorSize.height + (indicatorSize.height * LARGE_INDICATOR_WEIGHT)
              DpSize(width = width, height = height)
            }

            in (firstVisibleIndex + 1)..<lastVisibleIndex -> {
              DpSize(width = indicatorSize.width, height = indicatorSize.height)
            }

            else -> {
              val width = if (pagerState.pageCount <= MINIMUM_PAGE_COUNT_FOR_SCROLLING) {
                indicatorSize.width
              } else {
                indicatorSize.width - (indicatorSize.width * SMALL_INDICATOR_WEIGHT)
              }
              val height = if (pagerState.pageCount <= MINIMUM_PAGE_COUNT_FOR_SCROLLING) {
                indicatorSize.height
              } else {
                indicatorSize.height - (indicatorSize.height * SMALL_INDICATOR_WEIGHT)
              }
              DpSize(width = width, height = height)
            }
          },
          animationSpec = tween(durationMillis = 200, easing = LinearEasing)
        )

        val color = if (currentPage == page) {
          activeColor
        } else {
          inactiveColor
        }

        DotIndicator(
          size = size,
          padding = spacing,
          color = color,
          shape = indicatorShape,
          onClickEnabled = currentOnIndicatorClick != null
        ) {
          currentOnIndicatorClick?.let { it(page) }
        }
      }
    }
  }
}
