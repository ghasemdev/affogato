package com.parsuomash.affogato.datepicker.picker

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NumberPicker(
  modifier: Modifier = Modifier,
  state: PickerState = rememberPickerState(),
  items: PersistentList<String>,
  startIndex: Int = 0,
  visibleItemsCount: Int = 3,
  textModifier: Modifier = Modifier,
  textStyle: TextStyle = LocalTextStyle.current,
  dividerColor: Color = LocalContentColor.current
) {
  val visibleItemsMiddle = visibleItemsCount / 2
  val listState = rememberLazyListState(initialFirstVisibleItemIndex = startIndex)
  val flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)

  var itemHeightPixels by remember { mutableIntStateOf(0) }
  val itemHeightDp = pixelsToDp(itemHeightPixels)

  val fadingEdgeGradient = remember {
    Brush.verticalGradient(
      0f to Color.Transparent,
      0.5f to Color.Black,
      1f to Color.Transparent
    )
  }

  LaunchedEffect(listState) {
    snapshotFlow { listState.firstVisibleItemIndex }
      .map { index -> items.getOrElse(index + 1) { "" } }
      .distinctUntilChanged()
      .collect { item -> state.item = item }
  }

  Box(modifier = modifier) {
    LazyColumn(
      state = listState,
      flingBehavior = flingBehavior,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .height(itemHeightDp * visibleItemsCount)
        .fadingEdge(fadingEdgeGradient)
    ) {
      items(items.size) { index ->
        Text(
          text = items.getOrElse(index) { "" },
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          style = textStyle,
          modifier = Modifier
            .onSizeChanged { size -> itemHeightPixels = size.height }
            .then(textModifier)
        )
      }
    }
    Divider(
      color = dividerColor,
      modifier = Modifier.offset(y = itemHeightDp * visibleItemsMiddle)
    )
    Divider(
      color = dividerColor,
      modifier = Modifier.offset(y = itemHeightDp * (visibleItemsMiddle + 1))
    )
  }
}

private fun Modifier.fadingEdge(brush: Brush) = this
  .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
  .drawWithContent {
    drawContent()
    drawRect(brush = brush, blendMode = BlendMode.DstIn)
  }

@Composable
private fun pixelsToDp(pixels: Int) = with(LocalDensity.current) { pixels.toDp() }

@Preview(showBackground = true)
@Composable
private fun PickerPreview() {
  Column {
    NumberPicker(
      modifier = Modifier.fillMaxWidth(),
      state = rememberPickerState(),
      items = (1300..1402).toList().map(Int::toString).toPersistentList(),
      startIndex = 79,
      textModifier = Modifier.padding(8.dp),
      textStyle = TextStyle(fontSize = 24.sp)
    )
  }
}
