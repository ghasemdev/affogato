@file:Suppress("LongMethod")

package com.parsuomash.affogato.datepicker.picker

import androidx.annotation.FloatRange
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationResult
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.calculateTargetValue
import androidx.compose.animation.core.exponentialDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.datepicker.utils.disabledLongPress
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlinx.collections.immutable.PersistentList
import kotlinx.coroutines.launch

private fun <T> getItemIndexForOffset(
  range: PersistentList<T>,
  value: T,
  offset: Float,
  halfNumbersColumnHeightPx: Float
): Int {
  val indexOf = range.indexOf(value) - (offset / halfNumbersColumnHeightPx).toInt()
  return maxOf(0, minOf(indexOf, range.count() - 1))
}

@Composable
fun <T> ListItemPicker(
  modifier: Modifier = Modifier,
  label: (T) -> String = { it.toString() },
  provideValue: () -> T,
  onValueChange: (T) -> Unit,
  dividersColor: Color = MaterialTheme.colors.primary,
  list: PersistentList<T>,
  textStyle: TextStyle = LocalTextStyle.current,
  @FloatRange(from = 1.0, to = 2.0) selectedTextScale: Float = 1f
) {
  val verticalMargin = 8.dp
  val numbersColumnHeight = 80.dp
  val halfNumbersColumnHeight = numbersColumnHeight / 2
  val halfNumbersColumnHeightPx = with(LocalDensity.current) { halfNumbersColumnHeight.toPx() }

  val coroutineScope = rememberCoroutineScope()

  val animatedOffset = remember { Animatable(0f) }
    .apply {
      val index = list.indexOf(provideValue.invoke())
      val offsetRange = remember(provideValue.invoke(), list) {
        -((list.count() - 1) - index) * halfNumbersColumnHeightPx to
          index * halfNumbersColumnHeightPx
      }
      updateBounds(offsetRange.first, offsetRange.second)
    }

  val coercedAnimatedOffset by remember(animatedOffset.value) {
    derivedStateOf {
      animatedOffset.value % halfNumbersColumnHeightPx
    }
  }

  val indexOfElement = remember(
    list,
    provideValue.invoke(),
    animatedOffset.value,
  ) {
    getItemIndexForOffset(
      list,
      provideValue.invoke(),
      animatedOffset.value,
      halfNumbersColumnHeightPx
    )
  }

  var dividersWidth by remember { mutableStateOf(0.dp) }

  Layout(
    modifier = modifier
      .draggable(
        orientation = Orientation.Vertical,
        state = rememberDraggableState { deltaY ->
          coroutineScope.launch {
            animatedOffset.snapTo(animatedOffset.value + deltaY)
          }
        },
        onDragStopped = { velocity ->
          coroutineScope.launch {
            val endValue = animatedOffset.fling(
              initialVelocity = velocity,
              animationSpec = exponentialDecay(frictionMultiplier = 15f),
              adjustTarget = { target ->
                val coercedTarget = target % halfNumbersColumnHeightPx
                val coercedAnchors =
                  listOf(-halfNumbersColumnHeightPx, 0f, halfNumbersColumnHeightPx)
                val coercedPoint = coercedAnchors.minByOrNull { abs(it - coercedTarget) }!!
                val base = halfNumbersColumnHeightPx * (target / halfNumbersColumnHeightPx).toInt()
                coercedPoint + base
              }
            ).endState.value

            val result = list.elementAt(
              getItemIndexForOffset(
                list,
                provideValue.invoke(),
                endValue,
                halfNumbersColumnHeightPx
              )
            )
            onValueChange(result)
            animatedOffset.snapTo(0f)
          }
        }
      )
      .clip(RectangleShape)
      .padding(vertical = numbersColumnHeight / 3 + verticalMargin * 2),
    content = {
      Box(
        modifier
          .width(dividersWidth)
          .height(1.dp)
          .background(color = dividersColor)
      )
      Box(
        modifier = Modifier
          .padding(vertical = verticalMargin, horizontal = 20.dp)
          .offset { IntOffset(x = 0, y = coercedAnimatedOffset.roundToInt()) }
      ) {
        val baseLabelModifier = Modifier.align(Alignment.Center)

        ProvideTextStyle(textStyle) {
          if (indexOfElement >= 2) {
            Label(
              text = label(list.elementAt(indexOfElement - 2)),
              modifier = baseLabelModifier
                .offset { IntOffset(x = 0, y = -halfNumbersColumnHeight.roundToPx() * 2) }
                .alpha(MINIMUM_ALPHA)
            )
          }
          if (indexOfElement >= 1) {
            Label(
              text = label(list.elementAt(indexOfElement - 1)),
              modifier = baseLabelModifier
                .offset { IntOffset(x = 0, y = -halfNumbersColumnHeight.roundToPx()) }
                .alpha(maxOf(MINIMUM_ALPHA, coercedAnimatedOffset / halfNumbersColumnHeightPx))
            )
          }
          Label(
            text = label(list.elementAt(indexOfElement)),
            modifier = baseLabelModifier
              .scale(selectedTextScale)
              .alpha(
                maxOf(MINIMUM_ALPHA, 1 - abs(coercedAnimatedOffset) / halfNumbersColumnHeightPx)
              )
          )
          if (indexOfElement < list.size - 1) {
            Label(
              text = label(list.elementAt(indexOfElement + 1)),
              modifier = baseLabelModifier
                .offset { IntOffset(x = 0, y = halfNumbersColumnHeight.roundToPx()) }
                .alpha(maxOf(MINIMUM_ALPHA, -coercedAnimatedOffset / halfNumbersColumnHeightPx))
            )
          }
          if (indexOfElement < list.size - 2) {
            Label(
              text = label(list.elementAt(indexOfElement + 2)),
              modifier = baseLabelModifier
                .offset { IntOffset(x = 0, y = halfNumbersColumnHeight.roundToPx() * 2) }
                .alpha(MINIMUM_ALPHA)
            )
          }
        }
      }
      Box(
        modifier
          .width(dividersWidth)
          .height(1.dp)
          .background(color = dividersColor)
      )
    }
  ) { measurables, constraints ->
    // Don't constrain child views further, measure them with given constraints
    // List of measured children
    val placeables = measurables.map { measurable ->
      // Measure each child
      measurable.measure(constraints)
    }

    dividersWidth = placeables
      .drop(1)
      .first()
      .width
      .toDp()

    // Set the size of the layout as big as it can
    layout(
      width = dividersWidth.toPx().toInt(),
      height = placeables.sumOf { it.height }
    ) {
      // Track the y co-ord we have placed children up to
      var yPosition = 0

      // Place children in the parent layout
      placeables.forEach { placeable ->

        // Position item on the screen
        placeable.placeRelative(x = 0, y = yPosition)

        // Record the y co-ord placed up to
        yPosition += placeable.height
      }
    }
  }
}

@Composable
@NonRestartableComposable
private fun Label(
  modifier: Modifier = Modifier,
  text: String
) {
  Text(
    modifier = modifier.disabledLongPress(),
    text = text,
    textAlign = TextAlign.Center
  )
}

private suspend fun Animatable<Float, AnimationVector1D>.fling(
  initialVelocity: Float,
  animationSpec: DecayAnimationSpec<Float>,
  adjustTarget: ((Float) -> Float)?,
  block: (Animatable<Float, AnimationVector1D>.() -> Unit)? = null
): AnimationResult<Float, AnimationVector1D> {
  val targetValue = animationSpec.calculateTargetValue(value, initialVelocity)
  val adjustedTarget = adjustTarget?.invoke(targetValue)
  return if (adjustedTarget != null) {
    animateTo(
      targetValue = adjustedTarget,
      initialVelocity = initialVelocity,
      block = block
    )
  } else {
    animateDecay(
      initialVelocity = initialVelocity,
      animationSpec = animationSpec,
      block = block
    )
  }
}

private const val MINIMUM_ALPHA = 0.3f
