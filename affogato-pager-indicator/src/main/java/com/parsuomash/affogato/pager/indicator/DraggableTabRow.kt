@file:Suppress("ConstPropertyName")

package com.parsuomash.affogato.pager.indicator

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.pager.indicator.saver.rememberAnchoredDraggableState
import com.parsuomash.affogato.pager.indicator.saver.saver

/**
 * A TabRow contains a row of [Tab]s, and displays an indicator underneath the currently
 * selected tab. A TabRow places its tabs evenly spaced along the entire row, with each tab
 * taking up an equal amount of space.
 *
 * ```kotlin
 * DraggableTabRow(
 *   modifier = Modifier.fillMaxWidth(),
 *   backgroundColor = Color(0xFF21354F),
 *   indicatorColor = Color(0xFF40BED0),
 *   state = pagerState
 * ) {
 *   tabItems.mapIndexed { index, text ->
 *      Tab(
 *        selected = index == pagerState.currentPage,
 *        text = { Text(text = text) },
 *        onClick = {
 *          coroutineScope.launch {
 *            pagerState.animateScrollToPage(index)
 *          }
 *        }
 *      )
 *   }
 * }
 * ```
 *
 * @param state The state to control this pager
 * @param modifier optional Modifier for this indicator
 * @param backgroundColor The background color for the DraggableTabRow. Use Color.
 * Transparent to have no color.
 * @param indicatorColor  The color for the draggable indicator.
 * @param shapeRadius Defines the tab's shape.
 * @param content the content of this tab row
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableTabRow(
  state: PagerState,
  modifier: Modifier = Modifier,
  backgroundColor: Color = MaterialTheme.colors.primarySurface,
  indicatorColor: Color = MaterialTheme.colors.primary,
  shapeRadius: Dp = 16.dp,
  content: @Composable RowScope.() -> Unit
) {
  val density = LocalDensity.current

  var size by rememberSaveable(stateSaver = IntSize.saver) { mutableStateOf(IntSize.Zero) }
  val tabWidth by remember(size, state.pageCount) {
    derivedStateOf { with(density) { size.width.toDp() } / state.pageCount }
  }

  val anchoredDraggableState = rememberAnchoredDraggableState(
    initialValue = state.currentPage,
    animationSpec = tween(durationMillis = DraggableAnimationDuration, easing = LinearEasing),
    positionalThreshold = { distance: Float -> distance * POSITIONAL_THRESHOLD },
    velocityThreshold = { with(density) { (tabWidth / 2).toPx() } },
  )

  // Sync draggable state with pager
  LaunchedEffect(state.targetPage) {
    anchoredDraggableState.animateTo(state.targetPage)
  }

  // Sync pager with draggable state
  LaunchedEffect(anchoredDraggableState.targetValue) {
    state.animateScrollToPage(anchoredDraggableState.targetValue)
  }

  Box(
    modifier = modifier
      .requiredHeight(SmallTabHeight)
      .onSizeChanged { size = it }
      .background(color = backgroundColor, shape = RoundedCornerShape(shapeRadius)),
    contentAlignment = Alignment.CenterStart
  ) {
    Box(
      modifier = modifier
        .anchoredDraggable(anchoredDraggableState, Orientation.Horizontal)
        .onSizeChanged { layoutSize ->
          anchoredDraggableState.updateAnchors(
            DraggableAnchors {
              val fraction = 1f / state.pageCount
              repeat(state.pageCount) { index ->
                index at (layoutSize.width) * (index * fraction)
              }
            }
          )
        }
        .drawBehind {
          drawRoundRect(
            color = indicatorColor,
            topLeft = Offset(
              y = 0f,
              x = anchoredDraggableState.requireOffset()
            ),
            size = Size(
              width = with(density) { tabWidth.toPx() },
              height = size.height.toFloat()
            ),
            cornerRadius = CornerRadius(
              x = with(density) { shapeRadius.toPx() },
              y = with(density) { shapeRadius.toPx() }
            )
          )
        },
      contentAlignment = Alignment.TopStart,
      content = { Row(content = content) }
    )
  }
}

private const val DraggableAnimationDuration = 100
private const val POSITIONAL_THRESHOLD = 0.5f
