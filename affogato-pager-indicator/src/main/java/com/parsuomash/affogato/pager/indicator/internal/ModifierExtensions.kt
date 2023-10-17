package com.parsuomash.affogato.pager.indicator.internal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role

/**
 * Configure component to receive clicks via input or accessibility “click” event.
 *
 * Add this modifier to the element to make it clickable within its bounds and ripple effect
 * well be disabled.
 *
 * Example:
 * ```Kotlin
 * Box(
 *   modifier = Modifier
 *     .size(100.dp)
 *     .background(Color.Red)
 *     .clickableWithoutRipple {
 *       // onClick
 *     }
 * )
 * ```
 * @since 2.0.0
 * @see clickable
 * @param enabled Controls the enabled state.
 * When `false`, [onClick], and this modifier will appear to disable for accessibility services.
 * @param onClickLabel semantic / accessibility label for the [onClick] action
 * @param role the type of user interface element.
 * Accessibility services might use this to describe the element or do customizations.
 * @param onClick will be called when user clicks on the element
 */
internal fun Modifier.clickableWithoutRipple(
  enabled: Boolean = true,
  onClickLabel: String? = null,
  role: Role? = null,
  onClick: () -> Unit
) = composed(
  inspectorInfo = debugInspectorInfo {
    name = "clickable"
    properties["enabled"] = enabled
    properties["onClickLabel"] = onClickLabel
    properties["role"] = role
    properties["onClick"] = onClick
  }
) {
  Modifier.clickable(
    enabled = enabled,
    onClickLabel = onClickLabel,
    onClick = onClick,
    role = role,
    indication = null,
    interactionSource = remember { MutableInteractionSource() }
  )
}

/**
 * Combine modifiers with condition.
 *
 * Example:
 * ```kotlin
 * Modifier.applyIf("".length >= 1) {
 *   Modifier.background(Color.Red)
 * }
 * ```
 * @since 2.0.0
 */
internal fun Modifier.applyIf(
  condition: Boolean,
  modifierFunction: Modifier.() -> Modifier
): Modifier = if (condition) {
  modifierFunction()
} else {
  this
}
