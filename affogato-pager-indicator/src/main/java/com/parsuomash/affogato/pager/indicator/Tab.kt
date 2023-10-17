@file:Suppress("ConstPropertyName", "PrivatePropertyName")

package com.parsuomash.affogato.pager.indicator

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.parsuomash.affogato.pager.indicator.internal.applyIf

/**
 * ## Tab without ripple
 *
 * Tabs organize content across different screens, data sets, and other interactions.
 *
 * A Tab represents a single page of content using a text label and/or icon. It represents its
 * selected state by tinting the text label and/or image with [selectedContentColor].
 *
 * This should typically be used inside a [TabRow], see the corresponding documentation for
 * example usage.
 *
 * This Tab has slots for [text] and/or [icon] - see the other Tab overload for a generic Tab
 * that is not opinionated about its content.
 *
 * ```kotlin
 * Tab(
 *   selected = index == pagerState.currentPage,
 *   text = {
 *     Text(text = text, color = tabTextColor)
 *   },
 *   onClick = {
 *     coroutineScope.launch {
 *       pagerState.animateScrollToPage(index)
 *     }
 *   }
 * )
 * ```
 *
 * @param selected whether this tab is selected or not
 * @param modifier optional [Modifier] for this tab
 * @param enabled controls the enabled state of this tab. When `false`, this tab will not
 * be clickable and will appear disabled to accessibility services.
 * @param onClick the callback to be invoked when this tab is selected
 * @param text the text label displayed in this tab
 * @param icon the icon displayed in this tab
 * @param shape Defines the tab's shape.
 * @param selectedContentColor the color for the content of this tab when selected, and the color
 * of the ripple.
 * @param unselectedContentColor the color for the content of this tab when not selected
 *
 * @see LeadingIconTab
 */
@Composable
fun RowScope.Tab(
  selected: Boolean,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  onClick: () -> Unit,
  text: @Composable (() -> Unit)? = null,
  icon: @Composable (() -> Unit)? = null,
  shape: Shape = RoundedCornerShape(16.dp),
  selectedContentColor: Color = LocalContentColor.current,
  unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium)
) {
  Tab(
    selected = selected,
    onClick = onClick,
    modifier = modifier,
    shape = shape,
    enabled = enabled,
    selectedContentColor = selectedContentColor,
    unselectedContentColor = unselectedContentColor
  ) {
    icon?.invoke()
    if (icon != null && text != null) {
      Spacer(Modifier.requiredWidth(TextDistanceFromLeadingIcon))
    }
    text?.let {
      val style = MaterialTheme.typography.button.copy(textAlign = TextAlign.Center)
      ProvideTextStyle(style, content = it)
    }
  }
}

/**
 * ## LeadingIconTab without ripple
 *
 * Tabs organize content across different screens, data sets, and other interactions.
 *
 * A LeadingIconTab represents a single page of content using a text label, and an icon in
 * front of the label.
 * It represents its selected state by tinting the text label and icon with [selectedContentColor].
 *
 * This should typically be used inside a [TabRow].
 *
 * ```kotlin
 * LeadingIconTab(
 *   selected = index == pagerState.currentPage,
 *   text = {
 *     Text(text = text, color = tabTextColor)
 *   },
 *   icon = {
 *     Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = null)
 *   },
 *   onClick = {
 *     coroutineScope.launch {
 *       pagerState.animateScrollToPage(index)
 *     }
 *   }
 * )
 * ```
 *
 * @param selected whether this tab is selected or not
 * @param onClick the callback to be invoked when this tab is selected
 * @param text the text label displayed in this tab
 * @param icon the icon displayed in this tab
 * @param modifier optional [Modifier] for this tab
 * @param shape Defines the tab's shape.
 * @param enabled controls the enabled state of this tab. When `false`, this tab will not
 * be clickable and will appear disabled to accessibility services.
 * @param selectedContentColor the color for the content of this tab when selected, and the color
 * of the ripple.
 * @param unselectedContentColor the color for the content of this tab when not selected
 *
 * @see Tab
 */
@Composable
fun RowScope.LeadingIconTab(
  selected: Boolean,
  onClick: () -> Unit,
  text: @Composable (() -> Unit),
  icon: @Composable (() -> Unit),
  modifier: Modifier = Modifier,
  shape: Shape = RoundedCornerShape(16.dp),
  enabled: Boolean = true,
  selectedContentColor: Color = LocalContentColor.current,
  unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium)
) {
  TabTransition(selectedContentColor, unselectedContentColor, selected) {
    Row(
      modifier = modifier
        .height(SmallTabHeight)
        .padding(horizontal = HorizontalTextPadding)
        .weight(1f)
        .clip(shape)
        .applyIf(enabled) {
          pointerInput(Unit) {
            detectTapGestures(
              onTap = { onClick.invoke() },
              onDoubleTap = { onClick.invoke() }
            )
          }
        },
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {
      icon()
      Spacer(Modifier.requiredWidth(TextDistanceFromLeadingIcon))
      val style = MaterialTheme.typography.button.copy(textAlign = TextAlign.Center)
      ProvideTextStyle(style, content = text)
    }
  }
}

/**
 * ## Tab without ripple
 * Tabs organize content across different screens, data sets, and other interactions.
 *
 * Generic [Tab] overload that is not opinionated about content / color. See the other overload
 * for a Tab that has specific slots for text and / or an icon, as well as providing the correct
 * colors for selected / unselected states.
 *
 * A custom tab using this API may look like:
 *
 * ```kotlin
 * Tab(
 *  selected = index == pagerState.currentPage,
 *  onClick = {
 *    // on click
 *  }
 * ) {
 *   // Content
 * }
 * ```
 *
 * @param selected whether this tab is selected or not
 * @param onClick the callback to be invoked when this tab is selected
 * @param modifier optional [Modifier] for this tab
 * @param shape Defines the tab's shape.
 * @param enabled controls the enabled state of this tab. When `false`, this tab will not.
 * @param selectedContentColor the color for the content of this tab when selected, and the color
 * of the ripple.
 * @param unselectedContentColor the color for the content of this tab when not selected.
 * @param content the content of this tab
 */
@Composable
fun RowScope.Tab(
  selected: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  shape: Shape = RoundedCornerShape(16.dp),
  enabled: Boolean = true,
  selectedContentColor: Color = LocalContentColor.current,
  unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium),
  content: @Composable ColumnScope.() -> Unit
) {
  TabTransition(selectedContentColor, unselectedContentColor, selected) {
    Column(
      modifier = modifier
        .fillMaxHeight()
        .weight(1f)
        .clip(shape)
        .applyIf(enabled) {
          pointerInput(Unit) {
            detectTapGestures(
              onTap = { onClick.invoke() },
              onDoubleTap = { onClick.invoke() }
            )
          }
        },
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      content = content
    )
  }
}

/**
 * Transition defining how the tint color for a tab animates, when a new tab is selected. This
 * component uses [LocalContentColor] to provide an interpolated value between [activeColor]
 * and [inactiveColor] depending on the animation status.
 */
@Composable
private fun TabTransition(
  activeColor: Color,
  inactiveColor: Color,
  selected: Boolean,
  content: @Composable () -> Unit
) {
  val transition = updateTransition(selected, label = "TabTransition")
  val color by transition.animateColor(
    transitionSpec = {
      if (false isTransitioningTo true) {
        tween(
          durationMillis = TabFadeInAnimationDuration,
          delayMillis = TabFadeInAnimationDelay,
          easing = LinearEasing
        )
      } else {
        tween(
          durationMillis = TabFadeOutAnimationDuration,
          easing = LinearEasing
        )
      }
    },
    label = "TabTransitionColor"
  ) {
    if (it) activeColor else inactiveColor
  }
  CompositionLocalProvider(
    LocalContentColor provides color.copy(alpha = 1f),
    LocalContentAlpha provides color.alpha,
    content = content
  )
}

// Tab specifications
internal val SmallTabHeight = 48.dp

// Tab transition specifications
private const val TabFadeInAnimationDuration = 150
private const val TabFadeInAnimationDelay = 100
private const val TabFadeOutAnimationDuration = 100

// The horizontal padding on the left and right of text
private val HorizontalTextPadding = 16.dp

// Distance from the end of the leading icon to the start of the text
private val TextDistanceFromLeadingIcon = 8.dp
